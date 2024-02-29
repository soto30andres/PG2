package com.uao.taskmanager.TaskManager.controller;

import com.uao.taskmanager.TaskManager.domain.authentication.JwtAuthenticationDTO;
import com.uao.taskmanager.TaskManager.domain.authentication.SigninDTO;
import com.uao.taskmanager.TaskManager.domain.authentication.SignupDTO;
import com.uao.taskmanager.TaskManager.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("v1/authentication")
public class AuthenticationController {

  @Autowired
  private AuthenticationService authenticationService;


  @PostMapping("signin")
  public ResponseEntity<JwtAuthenticationDTO> signin(@Valid  @RequestBody SigninDTO signinRQ) {

    return ResponseEntity.ok(authenticationService.signin(signinRQ));

  }

  @PostMapping("signup")
  public ResponseEntity<JwtAuthenticationDTO> signUp(@Valid @RequestBody SignupDTO signupRQ) {

    return ResponseEntity.ok(authenticationService.signup(signupRQ));
  }
}
