package com.tweetqueue.core.services.user;

public class CreateUserRequest {
  private final String username;

  public CreateUserRequest(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }
}
