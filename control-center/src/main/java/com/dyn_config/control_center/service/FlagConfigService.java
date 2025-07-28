package com.dyn_config.control_center.service;

import com.dyn_config.control_center.constants.ErrorMessages;
import com.dyn_config.control_center.models.FlagConfig;
import com.dyn_config.control_center.repo.FlagConfigRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FlagConfigService {

    private final FlagConfigRepo flagConfigRepo;

    public FlagConfigService(FlagConfigRepo flagConfigRepo) {
        this.flagConfigRepo = flagConfigRepo;
    }


    public List<FlagConfig> getFlagConfig() {
        return (List<FlagConfig>) flagConfigRepo.findAll();
    }

    public FlagConfig getFlagConfigById(String name) {
       return flagConfigRepo.findById(name).orElseThrow(() -> new NoSuchElementException(ErrorMessages.NO_CONFIG_FOUND));
    }

    public FlagConfig createFlagConfig(FlagConfig flagConfig) {
        FlagConfig flagConfigToSave = new FlagConfig();
        flagConfigToSave.setFlagName(flagConfig.getFlagName());
        flagConfigToSave.setFlagState(flagConfig.getFlagState());
        flagConfigToSave.setFlagContent(flagConfig.getFlagContent());
        flagConfigToSave.setCreatedAt(LocalDateTime.now());
        flagConfigToSave.setUpdatedAt(LocalDateTime.now());

        return flagConfigRepo.save(flagConfig);
    }

    public FlagConfig updateFlagConfig(FlagConfig flagConfig) {
        FlagConfig flagConfigToSave = getFlagConfigById(flagConfig.getFlagName());
        flagConfigToSave.setFlagName(flagConfig.getFlagName());
        flagConfigToSave.setFlagState(flagConfig.getFlagState());
        flagConfigToSave.setFlagContent(flagConfig.getFlagContent());
        flagConfigToSave.setUpdatedAt(LocalDateTime.now());

        return flagConfigRepo.save(flagConfig);
    }

    public void deleteFlagConfig(String id) {
        flagConfigRepo.deleteById(id);
    }

}
