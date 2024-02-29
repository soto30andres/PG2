package com.uao.taskmanager.TaskManager.service;

import com.uao.taskmanager.TaskManager.domain.task.TaskDTO;
import com.uao.taskmanager.TaskManager.mapper.TaskMapper;
import com.uao.taskmanager.TaskManager.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class TaskService {

  @Autowired
  private TaskMapper taskMapper;

  @Autowired
  private TaskRepository taskRepository;

  @Autowired
  private AuthenticationService authenticationService;

  public List<TaskDTO> findTasks() {

    var user = authenticationService.getCurrentuser();

    return taskRepository.findByUser(user).stream().map(taskMapper::buildDTO).toList();

  }
  public TaskDTO createTask(TaskDTO taskDTO) {

    var user = authenticationService.getCurrentuser();

    var task = taskMapper.buildEntity(taskDTO);
    task.setUser(user);
    taskRepository.save(task);
    return taskMapper.buildDTO(task);

  }

  public TaskDTO updateTask(Long taskId, TaskDTO taskDTO) {

    var user = authenticationService.getCurrentuser();

    var task = taskRepository.findByIdAndUser(taskId, user)
        .orElseThrow(() -> new InvalidParameterException("Task not found."));

    task.setName(taskDTO.getName());
    task.setDescription(taskDTO.getDescription());
    task.setState(taskDTO.getState());
    taskRepository.save(task);
    return taskMapper.buildDTO(task);
  }

  public TaskDTO deleteTask(Long taskId) {

    var user = authenticationService.getCurrentuser();

    var task = taskRepository.findByIdAndUser(taskId, user)
            .orElseThrow(() -> new InvalidParameterException("Task not found."));

    taskRepository.delete(task);

    return taskMapper.buildDTO(task);
  }

}
