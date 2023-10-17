package com.example.task;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TaskDTO {


    private Long id;
    @Schema(description = "ActionID")
    private Long actionId;
    @NotNull
    @Schema(description = "What to buy? What to do?", example = "Pralka")
    private String title;
    @Schema(description = "Details", example = "size: xyz")
    private String description;
    @Schema(description = "is it done?", example ="False")
    //@AssertFalse
    private Boolean status;
}
