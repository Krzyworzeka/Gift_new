package com.example.actionInfo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;

public class ActionInfoDto {
    private Long id;
    @Schema(description = "Action id")
    private Long actionId;
    @Schema(description = "Information for those interested", example = "Mamy magazyn w X. Przywieźcie zakupy w piątek. ")
    @NotBlank
    private String description;

    public ActionInfoDto(Long actionId, String description) {
        this.actionId = actionId;
        this.description = description;
    }
}
