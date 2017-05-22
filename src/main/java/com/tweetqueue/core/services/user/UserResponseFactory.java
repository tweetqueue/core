package com.tweetqueue.core.services.user;

import com.tweetqueue.core.model.user.User;
import edu.umd.cs.findbugs.annotations.CheckReturnValue;

public class UserResponseFactory {
  @CheckReturnValue
  public UserResponse getUserResponse(User user) {
    return new UserResponse(user.getId().toString(), user.getUsername());
  }
}
