package com.example.action;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class ActionDTO {

    @Schema(description = "Action id")
    private Long id;

    @Schema(description = "Action name", example = "Szlachetna paczka - biuro Lotników")
    @NotBlank
    private String name;
    @Schema(description = "Organization name", example = "Szlachetna paczka")
    @NotBlank
    private String organization;
    @Schema(description = "Action description and details", example = "W biurze na Lotników przygotowujemy wspólnie Paczkę dla rodziny - <<opis>>")
    @NotBlank
    private String description;
    @NotBlank
    @Schema(description = "City or Area", example = "Kraków")
    private String place;
}
