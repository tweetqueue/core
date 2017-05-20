package com.tweetqueue.core.model.user;

import static java.util.UUID.fromString;

import java.util.Collection;

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

  public User getUser(String username) {
    return getUser(new UserId(), username);
  }
}
