package com.spring_greens.presentation.global.redis.deserializer.deserialized;

import com.spring_greens.presentation.global.redis.dto.information.ProductInformation;
import lombok.Getter;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Getter
public class DeserializedRedisProductInformation extends ProductInformation {
}