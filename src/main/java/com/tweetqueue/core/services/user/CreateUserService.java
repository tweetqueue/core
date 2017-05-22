package com.tweetqueue.core.services.user;

import com.tweetqueue.core.model.user.User;
import com.tweetqueue.core.model.user.UserFactory;
import com.tweetqueue.core.model.user.UserRepository;

public class CreateUserService {

  private final UserRepository userRepository;

  private final UserFactory userFactory;

  private final UserResponseFactory userResponseFactory;

  public CreateUserService(
      UserRepository userRepository,
      UserFactory userFactory,
      UserResponseFactory userResponseFactory) {
    this.userRepository = userRepository;
    this.userFactory = userFactory;
    this.userResponseFactory = userResponseFactory;
  }

  public UserResponse createUser(CreateUserRequest createUserRequest) {
    User user = userRepository.save(userFactory.getUser(createUserRequest.getUsername(), createUserRequest.getEmail()));

    return userResponseFactory.getUserResponse(user);
  }
}
