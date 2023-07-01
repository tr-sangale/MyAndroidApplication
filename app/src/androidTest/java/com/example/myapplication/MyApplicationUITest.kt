package com.example.myapplication

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
//import androidx.test.rule.ActivityTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Before

@RunWith(AndroidJUnit4::class)
@LargeTest
class MyApplicationUITest {
    companion object {
        private const val LAUNCH_TIMEOUT = 5000L
        private const val APP_PACKAGE = "com.example.myapplication"
    }
    private lateinit var device: UiDevice

    @get:Rule
    val mActivityRule = ActivityScenarioRule(MainActivity::class.java)

//    @Before
//    fun setup() {
////        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
////        device.pressHome() // Return to the home screen before starting the test
//        val context = InstrumentationRegistry.getInstrumentation().targetContext
//        val intent = Intent(context, MainActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        context.startActivity(intent)
//
//        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
//        device.wait(Until.hasObject(By.pkg(APP_PACKAGE).depth(0)), LAUNCH_TIMEOUT)
//    }



    @Test
    fun testButtonClicked() {
//        device.pressHome()
//        device.findObject(By.text("My Application")).click()
        ActivityScenario.launch(MainActivity::class.java)
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
            // Perform a click on a button
            Espresso.onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click())

            // Check if a text view displays the expected text
            Espresso.onView(ViewMatchers.withId(R.id.textView))
                .check(ViewAssertions.matches(ViewMatchers.withText("Button Clicked")))

            activityScenario.close()

    }

    @Test
    fun testEditTextInput() {
//        device.pressHome()
//        device.findObject(By.text("My Application")).click()
//        ActivityScenario.launch(MainActivity::class.java)
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

            // Enter text into an edit text
            Espresso.onView(ViewMatchers.withId(R.id.editText))
                .perform(ViewActions.typeText("Hello Espresso"))

            // Close the soft keyboard
            Espresso.closeSoftKeyboard()

            // Perform a click on a button
            Espresso.onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click())

            // Check if a text view displays the expected text
            Espresso.onView(ViewMatchers.withId(R.id.textView))
                .check(ViewAssertions.matches(ViewMatchers.withText("Hello Espresso")))

            activityScenario.close()

    }
}
