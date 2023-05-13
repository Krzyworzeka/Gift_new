package com.example.user;

import com.example.task.Task;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
public class UserDto {

    private Long id;
    private Long taskId;
    @NotBlank
    private String mail;
    @NotBlank
    private String phone;
}
