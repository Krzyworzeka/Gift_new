package com.example.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel ="spring")
public interface TaskMapper {

    Task mapToEntity(TaskDTO dto);

    @Mapping(source = "action.id", target = "actionId")
    TaskDTO mapToDto(Task entity);

    List<TaskDTO> mapToDto(List<Task> tasks);

}
