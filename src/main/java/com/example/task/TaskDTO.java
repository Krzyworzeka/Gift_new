package com.example.task;

import com.example.action.Action;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TaskDTO {


    private Long id;
    private Long actionId;
    @NotNull
    @Schema(description = "What to buy? What to do?", example = "Pralka")
    private String title;
    @Schema(description = "Details", example = "size: xyz")
    private String description;
    @Schema(description = "is it done?", example ="todo")
    private String status;
}
