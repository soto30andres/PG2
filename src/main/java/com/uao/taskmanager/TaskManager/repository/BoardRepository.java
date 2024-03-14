package com.uao.taskmanager.TaskManager.repository;

import com.uao.taskmanager.TaskManager.entity.Board;
import com.uao.taskmanager.TaskManager.entity.Task;
import com.uao.taskmanager.TaskManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BoardRepository extends JpaRepository<Board, Long> {

  List<Board> findByUser(User user);

  Optional<Board> findByIdAndUser(Long id, User user);

}
