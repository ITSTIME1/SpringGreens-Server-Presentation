package com.spring_greens.presentation.global.redis.validation.ifs;
import com.spring_greens.presentation.global.validation.ValidationOperation;


/**
 * RedisValidator will validate related to RedisProductRequest. <br>
 * @author itstime0809
 *
 */
public abstract class RedisValidator implements ValidationOperation {
    protected abstract boolean isNull (String...parameters);
    protected abstract boolean containsDomain(String param);
    protected abstract boolean containsMall(String param);
}
