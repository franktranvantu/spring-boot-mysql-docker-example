package com.franktran.springbootmysqldockerexample;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {
  private final UserRepository userRepository;

  @PostMapping("/add")
  public String addNewUser(@RequestParam String name, @RequestParam String email) {
    User user = User.builder()
        .name(name)
        .email(email)
        .build();
    userRepository.save(user);
    return "Saved";
  }

  @GetMapping("/all")
  public Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
}
