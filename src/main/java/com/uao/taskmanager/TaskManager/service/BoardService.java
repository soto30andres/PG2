package com.uao.taskmanager.TaskManager.service;

import com.uao.taskmanager.TaskManager.domain.board.BoardDTO;
import com.uao.taskmanager.TaskManager.domain.task.TaskDTO;
import com.uao.taskmanager.TaskManager.mapper.BoardMapper;
import com.uao.taskmanager.TaskManager.mapper.TaskMapper;
import com.uao.taskmanager.TaskManager.repository.BoardRepository;
import com.uao.taskmanager.TaskManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class BoardService {

  @Autowired
  private BoardMapper boardMapper;

  @Autowired
  private BoardRepository boardRepository;

  @Autowired
  private AuthenticationService authenticationService;

  public List<BoardDTO> findBoards() {

    var user = authenticationService.getCurrentuser();

    return boardRepository.findByUser(user).stream().map(boardMapper::buildDTO).toList();

  }
  public BoardDTO createBoard(BoardDTO boardDTO) {

    var user = authenticationService.getCurrentuser();

    var board = boardMapper.buildEntity(boardDTO);
    board.setUser(user);
    boardRepository.save(board);
    return boardMapper.buildDTO(board);

  }

  public BoardDTO updateBoard(Long boardId, BoardDTO boardDTO) {

    var user = authenticationService.getCurrentuser();

    var board = boardRepository.findByIdAndUser(boardId, user)
        .orElseThrow(() -> new InvalidParameterException("Board not found."));

    board.setName(boardDTO.getName());
    board.setDescription(boardDTO.getDescription());
    boardRepository.save(board);
    return boardMapper.buildDTO(board);
  }

}
