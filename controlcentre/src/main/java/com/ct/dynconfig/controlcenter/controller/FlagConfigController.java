package com.ct.dynconfig.controlcenter.controller;

import com.ct.dynconfig.client.DynConfig;
import com.ct.dynconfig.client.models.FlagConfig;
import com.ct.dynconfig.controlcenter.constants.AppConstants;
import com.ct.dynconfig.controlcenter.constants.LogMessages;
import com.ct.dynconfig.controlcenter.service.FlagConfigService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.NotActiveException;
import java.util.Map;

@RestController
@RequestMapping("/flag-config")
@Slf4j
@RequiredArgsConstructor
public class FlagConfigController {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private final FlagConfigService flagConfigService;

    private final DynConfig dynConfig;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Map<Object, Object>> getAllConfig() throws NotActiveException {
        log.info(LogMessages.GET_FLAG_CONFIGS);
        return ResponseEntity.ok().body(flagConfigService.getFlagConfig(AppConstants.CONFIG_DOMAIN));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<FlagConfig> getConfigById(@PathVariable("id") String id) throws NotActiveException {
        //throw new NotActiveException("API in Development!");
        log.info(LogMessages.GET_FLAG_CONFIG_BY_ID, id);
        return ResponseEntity.ok().body(flagConfigService.getFlagConfigById(id, AppConstants.CONFIG_DOMAIN));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<FlagConfig> createFlagConfig(@RequestBody FlagConfig flagConfig) throws NotActiveException {
        log.info(LogMessages.CREATE_FLAG_CONFIG, flagConfig.getFlagName());
        //throw new NotActiveException("API in Development!");

        return ResponseEntity.ok().body(flagConfigService.saveFlagConfig(flagConfig, AppConstants.CONFIG_DOMAIN));
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<FlagConfig> updateFlagConfig(@RequestBody FlagConfig flagConfig) throws NotActiveException {
        log.info(LogMessages.UPDATE_FLAG_CONFIG, flagConfig.getFlagName());
        //throw new NotActiveException("API in Development!");
        return ResponseEntity.ok().body(flagConfigService.udpateFlagConfig(flagConfig, AppConstants.CONFIG_DOMAIN));
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteFlagConfig(@PathVariable("id") String id) {
        log.info(LogMessages.DELETE_FLAG_CONFIG, id);
        flagConfigService.deleteFlagConfig(id, AppConstants.CONFIG_DOMAIN);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @GetMapping("/test/{id}")
    public FlagConfig getFlagTest(@PathVariable("id") String id) {

            return dynConfig.getFlagConfig(id);

    }

    @GetMapping("/test-state/{id}")
    public boolean getFlagStateTest(@PathVariable("id") String id) {

        return dynConfig.state(id);

    }

    @DeleteMapping("/delete")
    public void deleteAll() {
        redisTemplate.opsForHash().delete("*");
    }

}
