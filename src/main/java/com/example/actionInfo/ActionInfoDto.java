package com.example.actionInfo;

import com.example.action.Action;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

public class ActionInfoDto {
    private Long id;

    private Long actionId;
    @NotBlank
    private String description;
}
