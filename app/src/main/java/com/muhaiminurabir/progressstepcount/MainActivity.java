package com.muhaiminurabir.progressstepcount;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.shuhart.stepview.StepView;

public class MainActivity extends AppCompatActivity {
    private int currentStep = 0;
    StepView stepView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button back = (Button) findViewById(R.id.back);
        Button next = (Button) findViewById(R.id.next);
        stepView = (StepView) findViewById(R.id.step_view);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (currentStep > 0) {
                    currentStep--;
                }
                stepView.done(false);
                stepView.go(currentStep, true);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (currentStep < stepView.getStepCount() - 1) {
                    currentStep++;
                    stepView.go(currentStep, true);
                } else {
                    stepView.done(true);
                }
            }
        });
        //stepView.go(1, true);

    }
}
