package com.example.task;

import com.example.action.Action;
import com.example.action.ActionRepository;
import com.example.exception.IdMismatchException;
import com.example.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ActionRepository actionRepository;
    private final TaskMapper taskMapper;


    public TaskService(TaskRepository taskRepository, ActionRepository actionRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.actionRepository = actionRepository;
        this.taskMapper = taskMapper;
    }

    public List<TaskDTO> getAll() {
        return taskMapper.mapToDto(taskRepository.findAll());
    }

    public TaskDTO getById(Long id) {
        return taskMapper.mapToDto(taskRepository.findById(id).orElse(null));
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public TaskDTO addTask(TaskDTO dto) {
        Task task = taskMapper.mapToEntity(dto);
        Assert.isNull(task.getId(), "Id has not be null");
        Action action = actionRepository.findById(dto.getActionId()).orElseThrow(() -> new ResourceNotFoundException("Action doesn't exist"));
        task.setAction(action);
        taskRepository.save(task);
        return taskMapper.mapToDto(task);
    }

    public TaskDTO updateTask(Long id, TaskDTO dto) {
        Assert.notNull(dto.getId(), "Id cannot be empty");
        if (!dto.getId().equals(id)) {
            throw new IdMismatchException("Id's mismatch");
        }
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Action display doesn't exist");
        }
        Task entity = taskMapper.mapToEntity(dto);
        Action action = actionRepository.findById(dto.getActionId()).orElseThrow(() -> new ResourceNotFoundException("Action doesn't exist"));
        entity.setAction(action);
        taskRepository.save(entity);
        return taskMapper.mapToDto(entity);
    }
}