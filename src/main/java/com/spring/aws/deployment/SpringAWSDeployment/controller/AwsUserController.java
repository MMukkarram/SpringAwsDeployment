package com.spring.aws.deployment.SpringAWSDeployment.controller;

import com.spring.aws.deployment.SpringAWSDeployment.entity.AwsUser;
import com.spring.aws.deployment.SpringAWSDeployment.exception.ResourceNotFoundException;
import com.spring.aws.deployment.SpringAWSDeployment.repository.AwsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/user")
public class AwsUserController {

  @Autowired private AwsUserRepository userRepository;

  @GetMapping
  public List<AwsUser> getAllUser() {
    return userRepository.findAll();
  }

  @GetMapping("/{id}")
  public AwsUser getUserById(@PathVariable(value = "id") Long userId) {
    return userRepository
        .findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User Not Found With Id: " + userId));
  }

  @PostMapping
  public AwsUser createUser(@RequestBody AwsUser user) {
    return userRepository.save(user);
  }
}
