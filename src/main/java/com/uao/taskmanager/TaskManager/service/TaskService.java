package com.uao.taskmanager.TaskManager.service;

import com.uao.taskmanager.TaskManager.domain.task.TaskDTO;
import com.uao.taskmanager.TaskManager.mapper.TaskMapper;
import com.uao.taskmanager.TaskManager.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class TaskService {

  @Autowired
  private TaskMapper taskMapper;

  @Autowired
  private TaskRepository taskRepository;

  public List<TaskDTO> findTasks() {

    return taskRepository.findAll().stream().map(taskMapper::buildDTO).toList();

  }
  public TaskDTO createTask(TaskDTO taskDTO) {

    var task = taskMapper.buildEntity(taskDTO);
    taskRepository.save(task);
    return taskMapper.buildDTO(task);

  }

  public TaskDTO updateTask(Long taskId, TaskDTO taskDTO) {

    var task = taskRepository.findById(taskId).orElseThrow(() -> new InvalidParameterException("Task does not exist"));

    task.setDescription(taskDTO.getDescription());
    task.setState(taskDTO.getState());
    taskRepository.save(task);
    return taskMapper.buildDTO(task);
  }

  public TaskDTO deleteTask(Long taskId) {
    var task = taskRepository.findById(taskId)
            .orElseThrow(() -> new EntityNotFoundException("Task not found."));

    taskRepository.delete(task);

    return taskMapper.buildDTO(task);
  }

}
