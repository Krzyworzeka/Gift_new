package com.example.actionInfo;

import com.example.action.Action;
import com.example.action.ActionDTO;

import java.util.List;

public interface ActionInfoMapper {

    ActionInfo mapToEntity(ActionInfoDto dto);
    ActionInfoDto mapToDto(ActionInfo action);
    List<ActionInfoDto> mapToDto(List<ActionInfo> actions);
}
