package com.example.stockapp;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class SignUpActivityTest {
    @Rule
    public ActivityTestRule<SignUpActivity> mActivityRule = new ActivityTestRule<>(SignUpActivity.class);

    @Test
    public void testHintVisibility(){
        // check hint visibility
        onView(withId(R.id.user_name)).check(matches(withHint("Name")));
        onView(withId(R.id.emailAddress)).check(matches(withHint("Email Address")));
        onView(withId(R.id.phoneNum)).check(matches(withHint("Phone number")));
        onView(withId(R.id.addPassword)).check(matches(withHint("Password")));

    }
    @Test
    public void testButtonClick(){
        // fill fields
        onView(withId(R.id.user_name)).perform(typeText("Oshadha"),closeSoftKeyboard());
        onView(withId(R.id.emailAddress)).perform(typeText("oshadhak@hsenidmobile.com"),closeSoftKeyboard());
        onView(withId(R.id.phoneNum)).perform(typeText("+94722256971"),closeSoftKeyboard());
        onView(withId(R.id.addPassword)).perform(typeText("admin"),closeSoftKeyboard());
        // check signup button
        onView(withId(R.id.btnSignup)).perform(click());
        // check the home page is visible after click
        onView(withId(R.id.productList)).check(matches(isDisplayed()));
    }

}