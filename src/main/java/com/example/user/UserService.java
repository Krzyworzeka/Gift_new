package com.example.user;

import com.example.action.ActionDTO;
import com.example.exception.ResourceNotFoundException;
import com.example.exception.taskHasAssignedUser;
import com.example.task.Task;
import com.example.task.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, TaskRepository taskRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.userMapper = userMapper;
    }


    public UserDto getById(Long id){
        return userMapper.mapToDto(userRepository.findById(id).orElse(null));
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public UserDto addUser(UserDto dto){
        User user = userMapper.mapToEntity(dto);
        Assert.isNull(user.getId(), "Id has not be null");
        Task task = taskRepository.findById(dto.getTaskId()).orElseThrow(() -> new ResourceNotFoundException("Task doesn't exist"));
        long count = userRepository.findAll().stream().filter(a -> a.getTask().equals(task)).count();
        if (count>0) {
            throw new taskHasAssignedUser("This task is taken.");
        }
        user.setTask(task);
        userRepository.save(user);
        return userMapper.mapToDto(user);
    }

}
