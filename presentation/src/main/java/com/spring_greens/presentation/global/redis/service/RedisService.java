package com.spring_greens.presentation.global.redis.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring_greens.presentation.global.exception.CommonException;
import com.spring_greens.presentation.global.redis.exception.RedisException;
import com.spring_greens.presentation.global.redis.validation.ifs.RedisValidator;
import com.spring_greens.presentation.global.redis.converter.ifs.RedisConverter;
import com.spring_greens.presentation.product.dto.redis.DeserializedRedisProduct;
import com.spring_greens.presentation.product.dto.redis.deserialized.DeserializedRedisProductInformation;
import com.spring_greens.presentation.product.dto.redis.deserialized.DeserializedRedisShopInformation;
import com.spring_greens.presentation.product.dto.redis.request.RedisProductRequest;
import com.spring_greens.presentation.product.dto.redis.response.ifs.RedisProductResponse;
import com.spring_greens.presentation.product.repository.RedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisService {
    private final RedisRepository redisRepository;
    private final RedisConverter redisConverter;
    private final RedisValidator redisValidator;

    /**
     * this variable is temporary variable for test.
     * @author itstime0809
     */
    private static final String IMAGE_DIR = "/images/";

    public RedisProductResponse getProductsFromRedisUsingKey(RedisProductRequest redisProductRequest)  {
        try {
            DeserializedRedisProduct deserializedRedisProduct = null;
            // 1. 파라미터 검증
            if(validateRedisProductRequest(redisProductRequest)) {
                // 2. 상품 URL 가공
                deserializedRedisProduct = modifyImageUrl(getProduct(redisProductRequest.getMallName()));
            }
            // 3. 상품 반환
            return convertToResponse(redisProductRequest.getDomain(), deserializedRedisProduct);

        } catch (NullPointerException e) {
            log.error("Argument is null : {}", e.getMessage(), e);
            throw new CommonException.CustomNullPointerException(e.getMessage());
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException : {}", e.getMessage(), e);
            throw new RedisException.RedisJsonProcessingException(e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("IllegalArgumentException : {}", e.getMessage(), e);
            throw new RedisException.RedisIllegalArgumentException(e.getMessage());
        }
    }

    private RedisProductResponse convertToResponse(String domain, DeserializedRedisProduct redisProductJsonDeserializer) {
        return redisConverter.createResponse(domain, redisProductJsonDeserializer);
    }

    private DeserializedRedisProduct getProduct(String mallName) throws JsonProcessingException {
        return redisRepository.getProductsByMallName(mallName);
    }

    public boolean validateRedisProductRequest(RedisProductRequest redisProductRequest) throws IllegalArgumentException{
        return redisValidator.validate(redisProductRequest);
    }

    private DeserializedRedisProduct modifyImageUrl(DeserializedRedisProduct deserializedRedisProduct) {
        List<DeserializedRedisShopInformation> updatedShopList = deserializedRedisProduct.getShop_list().stream()
                .map(shopInformation -> {
                    List<DeserializedRedisProductInformation> updatedProductList = shopInformation.getProduct().stream()
                            .map(productInformation -> {
                                String updatedImageUrl = IMAGE_DIR.concat(deserializedRedisProduct.getMall_name())
                                        .concat("/")
                                        .concat(productInformation.getProduct_image_url());
                                return productInformation.toBuilder().product_image_url(updatedImageUrl).build();
                            })
                            .collect(Collectors.toList());
                    return shopInformation.toBuilder().product(updatedProductList).build();
                }).collect(Collectors.toList());
        return deserializedRedisProduct.toBuilder().shop_list(updatedShopList).build();
    }
}
