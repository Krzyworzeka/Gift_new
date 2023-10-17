package com.example.user;

import com.example.task.Task;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class UserDto {

    private Long id;
    @Schema(description = "Task id")
    private Long taskId;
    @NotBlank
    @Email
    @Schema(description = "Email", example = "xyz@gmail.com")
    private String mail;
    @NotBlank
    @Pattern(regexp="(^$|[0-9]{9})", message="exp. 501123123")
    @Schema(description = "Phone number", example = "500123123")
    private String phone;
}
