package com.tweetqueue.core.model.user;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class User {
  private final UserId id;

  private final String username;

  private final String email;

  private Map<SocialProvider, SocialInformation> loginInformation;

  User(UserId id, String username, String email) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.loginInformation = new HashMap<>();
  }

  public UserId getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public Collection<SocialInformation> getLoginInformation() {
    return loginInformation.values();
  }

  public User setLoginInformation(Collection<SocialInformation> loginInformation) {
    this.loginInformation =
        loginInformation.stream().collect(toMap(SocialInformation::getSocialProvider, o -> o));

    return this;
  }

  public User addLoginInformation(SocialInformation loginInformation) {
    this.loginInformation.put(loginInformation.getSocialProvider(), loginInformation);

    return this;
  }

  public String getEmail() {
    return email;
  }
}
