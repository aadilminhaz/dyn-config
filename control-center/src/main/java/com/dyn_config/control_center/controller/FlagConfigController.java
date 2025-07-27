package com.dyn_config.control_center.controller;

import com.dyn_config.control_center.models.FlagConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.NotActiveException;
import java.util.List;

@RestController
@RequestMapping("/flag/config")
public class FlagConfigController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<FlagConfig>> getAllConfig() throws NotActiveException {
        throw new NotActiveException("API in Development!");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<FlagConfig> getConfigById(@PathVariable("id") long id) throws NotActiveException {
        throw new NotActiveException("API in Development!");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<FlagConfig> createFlagConfig(@RequestBody FlagConfig flagConfig) throws NotActiveException {
        throw new NotActiveException("API in Development!");
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<FlagConfig> updateFlagConfig(@RequestBody FlagConfig flagConfig) throws NotActiveException {
        throw new NotActiveException("API in Development!");
    }

}
