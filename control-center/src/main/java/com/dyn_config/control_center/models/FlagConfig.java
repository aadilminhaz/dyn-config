package com.dyn_config.control_center.models;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

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
