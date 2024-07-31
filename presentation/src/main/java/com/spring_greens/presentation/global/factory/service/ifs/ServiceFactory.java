package com.spring_greens.presentation.global.factory.service.ifs;

import com.spring_greens.presentation.global.redis.service.RedisService;
import com.spring_greens.presentation.mall.service.ifs.MallService;

public interface ServiceFactory {
    RedisService getRedisService();

    MallService getMallService();
}
