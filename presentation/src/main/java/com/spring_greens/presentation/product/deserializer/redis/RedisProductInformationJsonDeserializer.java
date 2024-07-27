package com.spring_greens.presentation.product.deserializer.redis;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring_greens.presentation.product.converter.ifs.RedisConverter;
import com.spring_greens.presentation.product.dto.redis.deserialized.DeserializedRedisProductInformation;
import lombok.RequiredArgsConstructor;

import java.io.IOException;



@RequiredArgsConstructor
public class RedisProductInformationJsonDeserializer extends JsonDeserializer<DeserializedRedisProductInformation> {
    private final ObjectMapper objectMapper;
    private final RedisConverter redisConverter;
    @Override
    public DeserializedRedisProductInformation deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode jsonNode = objectMapper.readTree(jsonParser);
        return redisConverter.convertDeserializedRedisProductInformation(jsonNode);
    }
}
