package com.dyn_config.control_center.repo;

import com.dyn_config.control_center.models.FlagConfig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlagConfigRepo extends CrudRepository<FlagConfig, Long> {

    FlagConfig findByFlagName(String flagName);

}
