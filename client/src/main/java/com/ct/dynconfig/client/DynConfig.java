package com.ct.dynconfig.client;

import com.ct.dynconfig.client.models.FlagConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DynConfig {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private String configDomain = "configFlags";

    public FlagConfig getFlagConfig(String flagName) {
        return (FlagConfig) Optional.ofNullable(redisTemplate.opsForHash().get(configDomain, flagName)).orElseThrow(() -> new NoSuchElementException("No flag configuration found!"));
    }

    public Boolean state(String flagName) {
        boolean state = false;
        Optional<FlagConfig> flagConfig = Optional.ofNullable((FlagConfig) redisTemplate.opsForHash().get(configDomain, flagName));

        if (flagConfig.isPresent()) {
            state = flagConfig.get().getFlagState();
        }
        return state;
    }
}
