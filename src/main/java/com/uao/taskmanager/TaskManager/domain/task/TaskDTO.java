package com.uao.taskmanager.TaskManager.domain.task;

import com.uao.taskmanager.TaskManager.entity.State;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
public class TaskDTO {


  private Long id;

  @NotBlank
  @Length(min = 1, max = 50)
  private String description;

  @NotNull
  private State state;
}
