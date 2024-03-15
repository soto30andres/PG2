package com.uao.taskmanager.TaskManager.mapper;

import com.uao.taskmanager.TaskManager.domain.board.BoardDTO;
import com.uao.taskmanager.TaskManager.domain.task.TaskDTO;
import com.uao.taskmanager.TaskManager.entity.Board;
import com.uao.taskmanager.TaskManager.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    BoardDTO buildDTO(Board board);
    Board buildEntity(BoardDTO boardDTO);

}
