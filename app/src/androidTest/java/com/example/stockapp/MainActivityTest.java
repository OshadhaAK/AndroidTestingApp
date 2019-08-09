package com.example.stockapp;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

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

    @Test
    public void testEmptyUserName(){
        onView(withId(R.id.userName)).perform(typeText(""),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("admin"),closeSoftKeyboard());
        onView(withId(R.id.SignIn)).perform(click());
        onView(withId(R.id.userName)).check(matches(hasErrorText("Cannot be empty!")));
    }

    @Test
    public void testEmptyPassword(){
        onView(withId(R.id.userName)).perform(typeText("admin"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText(""),closeSoftKeyboard());
        onView(withId(R.id.SignIn)).perform(click());
        onView(withId(R.id.password)).check(matches(hasErrorText("Cannot be empty!")));
    }

    @Test
    public void testSignInFlow(){
        // fill fields
        onView(withId(R.id.userName)).perform(typeText("admin"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("admin"),closeSoftKeyboard());
        // click button
        onView(withId(R.id.SignIn)).perform(click());

        // check the home page is visible after click
        onView(withId(R.id.productList)).check(matches(isDisplayed()));

        //check the view buton
        onView(withId(R.id.productList)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        //check addtocart button exists
        onView(withId(R.id.addToCart)).check(matches(isDisplayed()));

        onView(withId(R.id.addToCart)).perform(click());

        //check checkout button exists
        onView(withId(R.id.btnCheckout)).check(matches(isDisplayed()));

        onView(withId(R.id.btnCheckout)).perform(click());

        //check transaction successfull activity
        onView(withId(R.id.successmsg)).check(matches(isDisplayed()));

    }

    @Test
    public void testSignUpFlow(){

        onView(withId(R.id.SignUp)).perform(click());
        // fill fields
        onView(withId(R.id.user_name)).perform(typeText("Oshadha"),closeSoftKeyboard());
        onView(withId(R.id.emailAddress)).perform(typeText("oshadhak@hsenidmobile.com"),closeSoftKeyboard());
        onView(withId(R.id.phoneNum)).perform(typeText("+94722256971"),closeSoftKeyboard());
        onView(withId(R.id.addPassword)).perform(typeText("admin"),closeSoftKeyboard());
        // check signup button
        onView(withId(R.id.btnSignup)).perform(click());

        //test welcome toast message
        onView(withText(R.string.welcomeMessage)).inRoot(new ToastMatcher()).check(matches(isDisplayed()));

        // check the home page is visible after click
        onView(withId(R.id.productList)).check(matches(isDisplayed()));

        //check the view buton
        onView(withId(R.id.productList)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        //check addtocart button exists
        onView(withId(R.id.addToCart)).check(matches(isDisplayed()));

        onView(withId(R.id.addToCart)).perform(click());

        //check checkout button exists
        onView(withId(R.id.btnCheckout)).check(matches(isDisplayed()));

        onView(withId(R.id.btnCheckout)).perform(click());

        //check transaction succesfull activity
        onView(withId(R.id.successmsg)).check(matches(isDisplayed()));

    }

}