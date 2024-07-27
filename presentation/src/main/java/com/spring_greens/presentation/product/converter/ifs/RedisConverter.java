package com.spring_greens.presentation.product.converter.ifs;

import com.fasterxml.jackson.databind.JsonNode;
import com.spring_greens.presentation.product.dto.redis.DeserializedRedisProduct;
import com.spring_greens.presentation.product.dto.redis.deserialized.DeserializedRedisProductInformation;
import com.spring_greens.presentation.product.dto.redis.deserialized.DeserializedRedisShopInformation;
import com.spring_greens.presentation.product.dto.redis.response.RedisProductResponse;

import java.util.List;

public interface RedisConverter  {

    RedisProductResponse createResponse(String domain, DeserializedRedisProduct deserializedRedisProduct);
    DeserializedRedisProduct convertDeserializedRedisProduct(JsonNode jsonNode, List<DeserializedRedisShopInformation> deserializedRedisShopInformationList);
    DeserializedRedisShopInformation convertDeserializedRedisShopInformation(JsonNode jsonNode, List<DeserializedRedisProductInformation> deserializedRedisProductInformationList);
    DeserializedRedisProductInformation convertDeserializedRedisProductInformation(JsonNode jsonNode);
}
