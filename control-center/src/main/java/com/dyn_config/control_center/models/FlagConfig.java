package com.dyn_config.control_center.models;

import lombok.Data;

@Data
public class FlagConfig {
    private long id;
    private String flagName;
    private boolean flagState;
    private String flagContent;
}
