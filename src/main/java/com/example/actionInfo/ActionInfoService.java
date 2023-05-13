package com.example.actionInfo;

import com.example.action.Action;
import com.example.action.ActionDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.validation.Valid;
import java.util.List;

@Service
public class ActionInfoService {

    private final ActionInfoRepository actionInfoRepository;
    private final ActionInfoMapper actionInfoMapper;

    public ActionInfoService(ActionInfoRepository actionInfoRepository, ActionInfoMapper actionInfoMapper) {
        this.actionInfoRepository = actionInfoRepository;
        this.actionInfoMapper = actionInfoMapper;
    }

    public List<ActionInfoDto> getAll() {
        return actionInfoMapper.mapToDto(actionInfoRepository.findAll());
    }

    public ActionInfoDto addAction(@Valid ActionInfoDto dto){
        ActionInfo actionInfo = actionInfoMapper.mapToEntity(dto);
        Assert.isNull(actionInfo.getId(), "Id has to be null");
        actionInfoRepository.save(actionInfo);
        return actionInfoMapper.mapToDto(actionInfo);
    }

}
