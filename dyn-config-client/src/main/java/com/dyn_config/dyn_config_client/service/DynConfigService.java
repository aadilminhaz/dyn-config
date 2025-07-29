package com.dyn_config.dyn_config_client.service;

import com.dyn_config.dyn_config_client.models.FlagConfig;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class DynConfigService {

    /*private final RedisTemplate<String, FlagConfig> redisTemplate;

    public DynConfigService(RedisTemplate<String, FlagConfig> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }*/


    public boolean getFlagConfigState(String flagName) {
        //return redisTemplate.opsForValue(a)
        return false;

    }

    public FlagConfig getFlagConfig(String flagName) {
        return null;
    }
}
