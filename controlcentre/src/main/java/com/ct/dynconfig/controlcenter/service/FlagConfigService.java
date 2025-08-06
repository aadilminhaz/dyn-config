package com.ct.dynconfig.controlcenter.service;

import com.ct.dynconfig.client.models.FlagConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class FlagConfigService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    public Map<Object, Object> getFlagConfig(String configDomain) {
        return redisTemplate.opsForHash().entries(configDomain);
    }

    public FlagConfig getFlagConfigById(String name, String configDomain) {
       return (FlagConfig) redisTemplate.opsForHash().get(configDomain, name);
    }

    public FlagConfig saveFlagConfig(FlagConfig flagConfig, String configDomain) {
        FlagConfig flagConfigToSave = new FlagConfig();
        flagConfigToSave.setFlagName(flagConfig.getFlagName());
        flagConfigToSave.setFlagState(flagConfig.getFlagState());
        flagConfigToSave.setFlagContent(flagConfig.getFlagContent());
        flagConfigToSave.setCreatedAt(LocalDateTime.now());
        flagConfigToSave.setUpdatedAt(LocalDateTime.now());

        redisTemplate.opsForHash().put(configDomain, flagConfig.getFlagName(), flagConfigToSave);
        return flagConfigToSave;
    }

    public FlagConfig udpateFlagConfig(FlagConfig flagConfig, String configDomain) {
        FlagConfig existingFlagConfig = getFlagConfigById(flagConfig.getFlagName(), configDomain);
        FlagConfig flagConfigToSave = new FlagConfig();
        flagConfigToSave.setFlagName(flagConfig.getFlagName());
        flagConfigToSave.setFlagState(flagConfig.getFlagState());
        flagConfigToSave.setFlagContent(flagConfig.getFlagContent());
        flagConfigToSave.setCreatedAt(existingFlagConfig.getCreatedAt());
        flagConfigToSave.setUpdatedAt(LocalDateTime.now());

        redisTemplate.opsForHash().put(configDomain, flagConfig.getFlagName(), flagConfigToSave);
        return flagConfigToSave;
    }

    public void deleteFlagConfig(String id, String configDomain) {
        redisTemplate.opsForHash().delete(configDomain, id);
    }

}
