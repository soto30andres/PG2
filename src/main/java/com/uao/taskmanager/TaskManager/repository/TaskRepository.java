package com.uao.taskmanager.TaskManager.repository;

import com.uao.taskmanager.TaskManager.entity.Board;
import com.uao.taskmanager.TaskManager.entity.Task;
import com.uao.taskmanager.TaskManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface TaskRepository extends JpaRepository<Task, Long> {

  @Query("select t from Task t where user = :user and board.id = :boardId")
  List<Task> findByUserAndBoard(User user, Long boardId);

  Optional<Task> findByIdAndUser(Long id, User user);

}
