package com.example.action;

import com.example.exception.IdMismatchException;
import com.example.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.validation.Valid;
import java.util.List;

@Service
public class ActionService {

    private final ActionRepository actionRepository;
    private final ActionMapper actionMapper;

    public ActionService(ActionRepository actionRepository, ActionMapper actionMapper) {
        this.actionRepository = actionRepository;
        this.actionMapper = actionMapper;
    }

    public List<ActionDTO> getAll() {
        return actionMapper.mapToDto(actionRepository.findAll());
    }

    //todo
    public List<ActionDTO> getAllWaiting() {
        return actionMapper.mapToDto(actionRepository.findAll());
    }

    public List<ActionDTO> getByPlace(String place){
        return actionMapper.mapToDto(actionRepository.findAll().stream().filter(a -> a.getPlace().equals(place)).toList());
    }

    //todo
    public List<ActionDTO> getAllWaitingByPlace() {
        return actionMapper.mapToDto(actionRepository.findAll());
    }

    public ActionDTO getById(Long id){
        return actionMapper.mapToDto(actionRepository.findById(id).orElse(null));
    }

    public void deleteById(Long id){
        actionRepository.deleteById(id);
    }

    public ActionDTO addAction(@Valid ActionDTO dto){
        Action action = actionMapper.mapToEntity(dto);
        Assert.isNull(action.getId(), "Id has to be null");
        actionRepository.save(action);
        return actionMapper.mapToDto(action);
    }

    public ActionDTO updateAction(Long id, ActionDTO actionDTO){
        Assert.notNull(actionDTO.getId(), "Id cannot be empty");
        if(!actionDTO.getId().equals(id)){
            throw new IdMismatchException("Id's mismatch");
        }
        if(!actionRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }

        Action action = actionMapper.mapToEntity(actionDTO);
        actionRepository.save(action);
        return actionMapper.mapToDto(action);
    }

}
