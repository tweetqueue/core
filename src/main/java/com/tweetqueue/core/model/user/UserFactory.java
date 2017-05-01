package com.tweetqueue.core.model.user;

import java.util.Collection;

import static java.util.UUID.fromString;

public class UserFactory {
  public User getUser(UserId id, String username) {
    return new User(id, username);
  }

  public User getUser(UserId id, String username, Collection<SocialInformation> loginInformation) {
    return getUser(id, username).setLoginInformation(loginInformation);
  }

  public UserId getUserId(String userId) {
    return new UserId(fromString(userId));
  }
}
