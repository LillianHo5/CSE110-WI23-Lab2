package edu.ucsd.cse110.lab2;

import static org.junit.Assert.assertEquals;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.w3c.dom.Text;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityClass{
    @Test
    public void test_one_plus_one_equals_two() {
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity -> {
            Button oneButton = (Button) activity.findViewById(R.id.btn_one);
            Button plusButton = (Button) activity.findViewById(R.id.btn_plus);
            Button equalButton = (Button) activity.findViewById(R.id.btn_equals);
            TextView display = (TextView) activity.findViewById(R.id.display);
            oneButton.performClick();
            plusButton.performClick();
            oneButton.performClick();
            equalButton.performClick();
            assertEquals("2", display.getText().toString());
        });
    }
}
