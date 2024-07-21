package com.spring_greens.presentation.global.redis.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring_greens.presentation.global.redis.deserializer.deserialized.DeserializedRedisProductInformation;
import lombok.RequiredArgsConstructor;
import java.io.IOException;



@RequiredArgsConstructor
public class RedisProductInformationJsonDeserializer extends JsonDeserializer<DeserializedRedisProductInformation> {
    private final ObjectMapper objectMapper;

    @Override
    public DeserializedRedisProductInformation deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode jsonNode = objectMapper.readTree(jsonParser);
        return DeserializedRedisProductInformation
                .builder()
                .product_id(jsonNode.get("product_id").asLong())
                .product_name(jsonNode.get("product_name").asText())
                .product_price(jsonNode.get("product_price").asInt())
                .product_unit(jsonNode.get("product_unit").asText())
                .product_image_url(jsonNode.get("product_image_url").asText())
                .product_view_count(jsonNode.get("product_view_count").asInt())
                .major_category(jsonNode.get("major_category").asText())
                .sub_category(jsonNode.get("sub_category").asText())
                .build();
    }
}
