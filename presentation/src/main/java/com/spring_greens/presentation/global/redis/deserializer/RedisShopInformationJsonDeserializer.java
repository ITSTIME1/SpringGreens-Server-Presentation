package com.spring_greens.presentation.global.redis.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring_greens.presentation.global.redis.deserializer.deserialized.DeserializedRedisProductInformation;
import com.spring_greens.presentation.global.redis.deserializer.deserialized.DeserializedRedisShopInformation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;
import java.util.stream.StreamSupport;


@RequiredArgsConstructor
public class RedisShopInformationJsonDeserializer extends JsonDeserializer<DeserializedRedisShopInformation> {
    private final ObjectMapper objectMapper;

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

        return DeserializedRedisShopInformation
                .builder()
                .shop_id(jsonNode.get("shop_id").asLong())
                .shop_name(jsonNode.get("shop_name").asText())
                .shop_contact(jsonNode.get("shop_contact").asText())
                .shop_address_details(jsonNode.get("shop_address_details").asText())
                .product(productInfoList)
                .build();
    }
}
