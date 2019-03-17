package com.vicky7230.wipro

import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.vicky7230.wipro.ui.home.DataAdapter
import com.vicky7230.wipro.ui.home.HomeActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class RecyclerViewTest {

    @Before
    fun launchActivity() {
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun scrollToItem_checkItsText() {
        // First scroll to the position that needs to be matched and click on it.
        Thread.sleep(4000)
        onView(ViewMatchers.withId(R.id.data_list))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<DataAdapter.DataViewHolder>(
                    2,
                    click()
                )
            )

        // Match the text in an item below the fold and check that it's displayed.
        val itemElementText = getApplicationContext<Context>().resources.getString(
            R.string.transportation
        )

        onView(withText(itemElementText)).check(matches(isDisplayed()))
    }




}