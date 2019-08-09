package com.example.stockapp;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class DetailsActivityTest {

    @Rule
    public ActivityTestRule<DetailsActivity> mActivityRule = new ActivityTestRule<>(DetailsActivity.class);

    @Test
    public void testDetailsActivity(){

        onView(ViewMatchers.withId(R.id.addToCart)).check(matches(isDisplayed()));
        onView(withId(R.id.addToCart)).perform(click());
        onView(withText(R.string.addedToCart)).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }
}