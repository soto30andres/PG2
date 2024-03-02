package com.uao.taskmanager.TaskManager.domain.authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupDTO {

  @Length(min = 1, max = 50, message = "length must be 1 to 50 characters")
  @Pattern(regexp = "^[a-zA-Z ]+$", message = "only accepts alphabet characters")
  private String firstName;



  @Length(min = 1, max = 50, message = "length must be 1 to 50 characters")
  @Pattern(regexp = "^[a-zA-Z ]+$",message = "only accepts alphabet characters")
  private String lastName;

  @Email(message = "must be formatted correctly")
  @NotEmpty
  private String email;

  @Pattern(regexp= "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,12}$", message = "must be at least 8 to 12 characters, 1 capital letter and 1 number")
  private String password;
}
