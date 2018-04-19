package com.goffity.mobile.android.demo.retrofitdemo.activity;

import android.content.Intent;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.goffity.mobile.android.demo.retrofitdemo.R;
import com.goffity.mobile.android.demo.retrofitdemo.network.retrofit.RetrofitImplBuilder;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class, false, false);

    private MockWebServer server;

    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();

        RetrofitImplBuilder.BASE_URL = server.url("/").toString();

    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    public void testLoginShouldBe200() {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{\"member\":{\"address1\":\"\",\"address2\":\"\",\"birthdate\":\"0000-00-00\",\"email\":\"goffity@gmail.com\",\"firstname\":\"Goffity\",\"gender\":\"\",\"lastname\":\"Corleone\",\"memberid\":13,\"nickname\":\"\",\"phone\":\"0865500445\",\"username\":\"goffity@gmail.com\"},\"statuscode\":0,\"statusdesc\":\"Success\"}"));

        rule.launchActivity(new Intent());

        onView(withId(R.id.textview1)).check(matches(isDisplayed()));
        onView(withText("goffity@gmail.com")).check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(withId(R.id.textview1), withText("goffity@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("goffity@gmail.com")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}