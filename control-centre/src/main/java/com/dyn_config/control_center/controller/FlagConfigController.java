package com.dyn_config.control_center.controller;

import com.dyn_config.control_center.constants.LogMessages;
import com.dyn_config.control_center.models.FlagConfig;
import com.dyn_config.control_center.service.FlagConfigService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.NotActiveException;
import java.util.List;

@RestController
@RequestMapping("/flag/config")
@Slf4j
public class FlagConfigController {

    private final FlagConfigService flagConfigService;

    public FlagConfigController(FlagConfigService flagConfigService) {
        this.flagConfigService = flagConfigService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<FlagConfig>> getAllConfig() throws NotActiveException {
        log.info(LogMessages.GET_FLAG_CONFIGS);
        return ResponseEntity.ok().body(flagConfigService.getFlagConfig());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<FlagConfig> getConfigById(@PathVariable("id") String id) throws NotActiveException {
        //throw new NotActiveException("API in Development!");
        log.info(LogMessages.GET_FLAG_CONFIG_BY_ID, id);
        return ResponseEntity.ok().body(flagConfigService.getFlagConfigById(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<FlagConfig> createFlagConfig(@RequestBody FlagConfig flagConfig) throws NotActiveException {
        log.info(LogMessages.CREATE_FLAG_CONFIG, flagConfig.getFlagName());
        //throw new NotActiveException("API in Development!");

        return ResponseEntity.ok().body(flagConfigService.createFlagConfig(flagConfig));
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<FlagConfig> updateFlagConfig(@RequestBody FlagConfig flagConfig) throws NotActiveException {
        log.info(LogMessages.UPDATE_FLAG_CONFIG, flagConfig.getFlagName());
        //throw new NotActiveException("API in Development!");
        return ResponseEntity.ok().body(flagConfigService.updateFlagConfig(flagConfig));
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteFlagConfig(@PathVariable("id") String id) {
        log.info(LogMessages.DELETE_FLAG_CONFIG, id);
        flagConfigService.deleteFlagConfig(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

}
