package com.spring_greens.presentation.global.redis.converter.ifs;

import com.spring_greens.presentation.global.redis.common.RedisProduct;
import com.spring_greens.presentation.global.redis.dto.deserialize.RedisProductJsonDeserializer;

/**
 * This interface converts RedisProduct type to MainRedisProductResponse and MapRedisProductResponse. <br>
 * MainRedisProductResponse and MapRedisProductResponse extends RedisProduct. <br>
 * I think that this way satisfies the SRP. <br>
 * because only have a task that convert response type to concreteness type by using domain. <br>
 * not only that, but i think it is just by looking at the role of converting response. <br>
 * @author itstime0809
 */
public interface RedisProductResponseConverter {
    RedisProduct<?> convertResponse(String domain, RedisProductJsonDeserializer response);
}
