package com.example.actionInfo;

import javax.validation.constraints.NotBlank;

public class ActionInfoDto {
    private Long id;

    private Long actionId;
    @NotBlank
    private String description;

    public ActionInfoDto(Long actionId, String description) {
        this.actionId = actionId;
        this.description = description;
    }
}
