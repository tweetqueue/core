package com.tweetqueue.core.services.user;

import com.tweetqueue.core.model.user.User;
import com.tweetqueue.core.model.user.UserFactory;
import com.tweetqueue.core.model.user.UserRepository;
import java.util.Optional;


public class GetUserProfile {

  private final UserRepository userRepository;

  private final UserFactory userFactory;

  private final UserResponseFactory userResponseFactory;


  public GetUserProfile(UserRepository userRepository, UserFactory userFactory,
      UserResponseFactory userResponseFactory) {
    this.userRepository = userRepository;
    this.userFactory = userFactory;
    this.userResponseFactory = userResponseFactory;
  }

  public UserResponse getUserProfileById(GetUserRequest request) {
    Optional<User> user = this.userRepository
        .getById(userFactory.getUserId(request.getId()));

    return userResponseFactory.getUserResponse(user
        .orElseGet(() -> userFactory.getUser(null, null)));
  }
}
