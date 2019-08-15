package com.example.stockapp;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class HomeActivityTest {



    @Rule
    public ActivityTestRule<HomeActivity> mActivityRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void testHomeActivity(){

        onView(ViewMatchers.withId(R.id.productList)).check(matches(isDisplayed()));
    }

    @Test
    public void testItemCount(){

        onView(withId(R.id.productList)).check(new RecyclerViewItemCountAssertion(8));

    }

    @Test
    public void testCart(){

        onView(withId(R.id.productList)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.addToCart)).perform(click());
        onView(withId(R.id.buttonBackHome)).perform(click());
        onView(withId(R.id.productList)).perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));
        onView(withId(R.id.addToCart)).perform(click());
        onView(withId(R.id.buttonBackHome)).perform(click());
        onView(withId(R.id.productList)).perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(R.id.addToCart)).perform(click());
        onView(withId(R.id.buttonBackHome)).perform(click());
        onView(withId(R.id.action_cart)).perform(click());
        onView(withId(R.id.cartList)).check(new RecyclerViewItemCountAssertion(3));
    }

}