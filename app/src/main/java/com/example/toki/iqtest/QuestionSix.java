package com.example.toki.iqtest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

// All classes extend MainActivity to ensure consistency to the mResult variable
public class QuestionSix extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_six);

        RadioGroup group6 = findViewById(R.id.group6);
        group6.setOnCheckedChangeListener(groupListener);
    }

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
                    case R.id.a61:
                        answerCheck = 61;
                        verifyAnswer(answerCheck);
                        goToNextQuestion();
                        break;
                    case R.id.a62:
                        answerCheck = 62;
                        verifyAnswer(answerCheck);
                        goToNextQuestion();
                        break;
                    case R.id.a63:
                        answerCheck = 63;
                        verifyAnswer(answerCheck);
                        goToNextQuestion();
                        break;
                    case R.id.a64:
                        answerCheck = 64;
                        verifyAnswer(answerCheck);
                        goToNextQuestion();
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
            if (answer == 63) {
                MainActivity.setmResult(10);
            }
        }
    }

    /*
    * When called, opens next Question page
     */
    public void goToNextQuestion() {
        Intent nextQuestion = new Intent(QuestionSix.this,QuestionSeven.class);
        startActivity(nextQuestion);
    }
}