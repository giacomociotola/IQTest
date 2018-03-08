package com.example.toki.iqtest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

// All classes extend MainActivity to ensure consistency to the mResult variable
public class QuestionFour extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_four);

        RadioGroup group4 = findViewById(R.id.group4);
        group4.setOnCheckedChangeListener(groupListener);
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
                    case R.id.a41:
                        answerCheck = 41;
                        verifyAnswer(answerCheck);
                        goToNextQuestion();
                        break;
                    case R.id.a42:
                        answerCheck = 42;
                        verifyAnswer(answerCheck);
                        goToNextQuestion();
                        break;
                    case R.id.a43:
                        answerCheck = 43;
                        verifyAnswer(answerCheck);
                        goToNextQuestion();
                        break;
                    case R.id.a44:
                        answerCheck = 44;
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
            if (answer == 43) {
                MainActivity.setmResult(10);
            }
        }
    }

    /*
    * When called, opens next Question page
     */
    public void goToNextQuestion() {
        Intent nextQuestion = new Intent(QuestionFour.this,QuestionFive.class);
        startActivity(nextQuestion);
    }
}