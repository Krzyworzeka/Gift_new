package com.example.action;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActionMapper {

    Action mapToEntity(ActionDTO dto);
    ActionDTO mapToDto(Action action);
    List<ActionDTO> mapToDto(List<Action> actions);
}
