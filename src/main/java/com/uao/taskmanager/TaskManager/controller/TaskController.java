package com.uao.taskmanager.TaskManager.controller;

import com.uao.taskmanager.TaskManager.domain.task.TaskDTO;
import com.uao.taskmanager.TaskManager.service.TaskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("v1/task")
public class TaskController {

  @Autowired
  private TaskService taskService;

  @GetMapping
  public ResponseEntity<List<TaskDTO>> findTasks() {
    return ResponseEntity.ok(taskService.findTasks());
  }

  @PostMapping
  public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody TaskDTO taskDTO) {
    return ResponseEntity.ok(taskService.createTask(taskDTO));
  }

  @PutMapping("{id}")
  public ResponseEntity<TaskDTO> updateTask(@Valid @RequestBody TaskDTO taskDTO, @Valid @PathVariable @NotEmpty  Long id) {
    return ResponseEntity.ok(taskService.updateTask(id, taskDTO));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<TaskDTO> deleteTask(@Valid @RequestBody TaskDTO taskDTO, @Valid @PathVariable @NotEmpty Long id) {
    return ResponseEntity.ok(taskService.deleteTask(id));
  }

}
