package com.dyn_config.dyn_config_client.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Data
@RedisHash("FlagConfig")
public class FlagConfig {

    @Id
    private String flagName;
    private Boolean flagState;
    private String flagContent;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
