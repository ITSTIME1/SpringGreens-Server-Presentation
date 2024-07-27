package com.spring_greens.presentation.product.deserializer.redis;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring_greens.presentation.product.converter.ifs.RedisConverter;
import com.spring_greens.presentation.product.dto.redis.deserialized.DeserializedRedisProductInformation;
import com.spring_greens.presentation.product.dto.redis.deserialized.DeserializedRedisShopInformation;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;
import java.util.stream.StreamSupport;


@RequiredArgsConstructor
public class RedisShopInformationJsonDeserializer extends JsonDeserializer<DeserializedRedisShopInformation> {
    private final ObjectMapper objectMapper;
    private final RedisConverter redisConverter;

    @Override
    public DeserializedRedisShopInformation deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {

        JsonNode jsonNode = objectMapper.readTree(jsonParser);

        List<DeserializedRedisProductInformation> productInfoList = StreamSupport.stream(jsonNode.get("product").spliterator(), false)
                .map(productNode -> {
                    try {
                        return objectMapper.readValue(productNode.traverse(), DeserializedRedisProductInformation.class);
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to deserialize product information", e);
                    }
                })
                .toList();

        return redisConverter.convertDeserializedRedisShopInformation(jsonNode, productInfoList);
    }
}
