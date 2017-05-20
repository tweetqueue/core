package com.tweetqueue.core.model.user;

public class SocialInformation {

  private final String socialId;

  private final String socialToken;

  private final SocialProvider socialProvider;

  public SocialInformation(String socialId, String socialToken, SocialProvider socialProvider) {
    this.socialId = socialId;
    this.socialToken = socialToken;
    this.socialProvider = socialProvider;
  }

  public String getSocialId() {
    return socialId;
  }

  public String getSocialToken() {
    return socialToken;
  }

  public SocialProvider getSocialProvider() {
    return socialProvider;
  }
}
