package com.tweetqueue.core.model.user;

import static java.util.UUID.randomUUID;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.Before;
import org.junit.Test;

public class UserFactoryTest {
  private static final String USER_ID = randomUUID().toString();

  private static final String USER_NAME = "name";

  private UserFactory userFactory;

  @Before
  public void setUp() {
    userFactory = new UserFactory();
  }

  @Test
  public void itIsPossibleToGenerateAnUser() {
    assertThat(userFactory.getUser(USER_ID, USER_NAME), instanceOf(User.class));
  }

  @Test
  public void itIsPossibleToGenerateANewUserId() {
    assertThat(userFactory.getUserId(USER_ID), instanceOf(UserId.class));
  }

  @Test
  public void itIsPossibleToGenerateANewUser() {
    assertThat(userFactory.getUser(USER_NAME), instanceOf(User.class));
  }
}
