package com.spring_greens.presentation.global.validation;
import com.spring_greens.presentation.product.dto.redis.request.RedisProductRequest;

/**
 * ValidationOperation is basic validation operation. <br>
 * so, if you need to validate whatever, you extends below interface.<br>
 * @author itstime0809
 */
public interface ValidationOperation {
    boolean validate (RedisProductRequest redisProductRequest);
}
