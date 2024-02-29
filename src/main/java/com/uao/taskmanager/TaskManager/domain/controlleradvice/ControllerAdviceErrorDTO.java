package com.uao.taskmanager.TaskManager.domain.controlleradvice;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class ControllerAdviceErrorDTO {

  private String message;
  private int code;
  private String url;
}
