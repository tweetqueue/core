package com.tweetqueue.core.model.user;

import static com.tweetqueue.core.model.user.SocialProvider.Twitter;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserTest {
  private static final String SOCIAL_ID_1 = "331b8014-a915-477a-a310-9a8a145ca232";

  private static final String SOCIAL_TOKEN_1 = "token";

  private static final String SOCIAL_ID_2 = "0e13fbf8-38e8-42ee-b1ad-dbb0f8592b2c";

  private static final String SOCIAL_TOKEN_2 = "token2";

  private static final String USER_NAME = "name";

  private User user;

  @Mock private UserId userId;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);

    user = new User(userId, USER_NAME);
  }

  @Test
  public void itIsPossibleToSetLoginInformationForUser() {
    SocialInformation socialInformation =
        new SocialInformation(SOCIAL_ID_1, SOCIAL_TOKEN_1, Twitter);

    assertThat(
        user.setLoginInformation(singletonList(socialInformation)).getLoginInformation(),
        everyItem(is(socialInformation)));
  }

  @Test
  public void itOnlyAddsALoginPerProvider() {
    SocialInformation socialInformation =
        new SocialInformation(SOCIAL_ID_1, SOCIAL_TOKEN_1, Twitter);

    SocialInformation socialInformation2 =
        new SocialInformation(SOCIAL_ID_2, SOCIAL_TOKEN_2, Twitter);

    assertThat(
        user.setLoginInformation(asList(socialInformation, socialInformation2))
            .getLoginInformation(),
        everyItem(is(socialInformation2)));
  }
}
