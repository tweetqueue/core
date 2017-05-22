package com.tweetqueue.core.services.user;

public class CreateUserRequest {
  private final String username;

  private final String email;

  public CreateUserRequest(String username, String email) {
    this.username = username;
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }
}
