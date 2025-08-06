package com.ct.dynconfig.client.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class FlagConfig implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private String flagName;
    private Boolean flagState;
    private String flagContent;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
