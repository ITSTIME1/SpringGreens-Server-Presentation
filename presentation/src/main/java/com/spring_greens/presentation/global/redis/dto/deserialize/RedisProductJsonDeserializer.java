package com.spring_greens.presentation.global.redis.dto.deserialize;

import com.spring_greens.presentation.global.redis.dto.information.MapShopInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RedisProductJsonDeserializer  {
    private Long mall_id;
    private String mall_name;
    private List<MapShopInformation> shop_list;
}
