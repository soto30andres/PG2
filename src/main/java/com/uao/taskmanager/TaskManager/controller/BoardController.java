package com.uao.taskmanager.TaskManager.controller;

import com.uao.taskmanager.TaskManager.domain.board.BoardDTO;
import com.uao.taskmanager.TaskManager.domain.task.TaskDTO;
import com.uao.taskmanager.TaskManager.service.BoardService;
import com.uao.taskmanager.TaskManager.service.TaskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("v1/board")
public class BoardController {

  @Autowired
  private BoardService boardService;

  @GetMapping
  public ResponseEntity<List<BoardDTO>> findBoards() {
    return ResponseEntity.ok(boardService.findBoards());
  }

  @PostMapping
  public ResponseEntity<BoardDTO> createBoard(@Valid @RequestBody BoardDTO boardDTO) {
    return ResponseEntity.ok(boardService.createBoard(boardDTO));
  }

  @PutMapping("{id}")
  public ResponseEntity<BoardDTO> updateBoard(@Valid @RequestBody BoardDTO boardDTO, @Valid @PathVariable @NotEmpty  Long id) {
    return ResponseEntity.ok(boardService.updateBoard(id, boardDTO));
  }

}
