package com.uao.taskmanager.TaskManager.domain.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenericResponseErrorDTO {

  private int code;
  private List<String> errors;
  private String path;
}
