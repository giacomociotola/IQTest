package com.example.toki.iqtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

// All classes extend MainActivity to ensure consistency to the mResult variable
public class QuestionTen extends MainActivity {

    Button submitTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_ten);

        RadioGroup group10 = findViewById(R.id.group10);
        group10.setOnCheckedChangeListener(groupListener);

        submitTest = findViewById(R.id.submit);
        submitTest.setOnClickListener(submitListener);
    }

    View.OnClickListener submitListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent results = new Intent(QuestionTen.this,Results.class);
            results.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            results.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            results.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(results);
        }
    };

    RadioGroup.OnCheckedChangeListener groupListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            RadioButton checkedRadioButton = group.findViewById(checkedId);
            boolean isChecked = checkedRadioButton.isChecked();
            int answerCheck;
            // If the radiobutton that has changed in check state is now checked...
            if (isChecked)

                // Check which radio button was clicked
                switch(checkedId) {
                    case R.id.a101:
                        answerCheck = 101;
                        verifyAnswer(answerCheck);
                        checkedRadioButton.setEnabled(false);
                        break;
                    case R.id.a102:
                        answerCheck = 102;
                        verifyAnswer(answerCheck);
                        checkedRadioButton.setEnabled(false);
                        break;
                    case R.id.a103:
                        answerCheck = 103;
                        verifyAnswer(answerCheck);
                        checkedRadioButton.setEnabled(false);
                        break;
                    case R.id.a104:
                        answerCheck = 104;
                        verifyAnswer(answerCheck);
                        checkedRadioButton.setEnabled(false);
                        break;
                }
        }
    };

    /*
    * Verifies if the given answer is the right one. If so, it updates global app variable mResult, in MainActivity
    * param answer
    */
    public void verifyAnswer(int answer) {
        if (answer != 0) {
            if (answer == 104) {
                MainActivity.setmResult(10);
            }
        }
    }
}