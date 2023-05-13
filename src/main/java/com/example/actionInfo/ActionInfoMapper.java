package com.example.actionInfo;

import com.example.action.Action;
import com.example.action.ActionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ActionInfoMapper {

    ActionInfo mapToEntity(ActionInfoDto dto);
    @Mapping(source = "action.id", target = "actionId")
    ActionInfoDto mapToDto(ActionInfo action);
    List<ActionInfoDto> mapToDto(List<ActionInfo> actions);
}
