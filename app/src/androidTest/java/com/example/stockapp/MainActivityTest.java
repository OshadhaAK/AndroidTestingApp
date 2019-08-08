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
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testHintVisibility(){
        // check hint visibility
        onView(withId(R.id.userName)).check(matches(withHint("User Name")));
        onView(withId(R.id.password)).check(matches(withHint("Password")));

    }

    @Test
    public void testSignInButtonClick(){
        // fill fields
        onView(withId(R.id.userName)).perform(typeText("admin"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("admin"),closeSoftKeyboard());
        // click button
        onView(withId(R.id.SignIn)).perform(click());

        // check the home page is visible after click
        onView(withId(R.id.productList)).check(matches(isDisplayed()));
    }

    @Test
    public void testSignUpButtonClick(){

        // click button
        onView(withId(R.id.SignUp)).perform(click());

        // check the home page is visible after click
        onView(withId(R.id.btnSignup)).perform(click());
        onView(withId(R.id.productList)).check(matches(isDisplayed()));
    }

    @Test
    public void testToastMessage(){
        onView(withId(R.id.userName)).perform(typeText("12345"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("admin"),closeSoftKeyboard());
        onView(withId(R.id.SignIn)).perform(click());
        onView(withText(R.string.message)).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }
}