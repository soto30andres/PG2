package com.uao.taskmanager.TaskManager.domain.board;

import com.uao.taskmanager.TaskManager.entity.State;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDTO {

  private Long id;

  @NotBlank
  @Length(min = 1, max = 25)
  private String name;

  @Length(max = 500)
  private String description;

}
