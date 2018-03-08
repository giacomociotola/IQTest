package com.example.toki.iqtest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

// All classes extend MainActivity to use its set and get method to change and get the mResult variable
public class QuestionSeven extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_seven);

        RadioGroup group7 = findViewById(R.id.group7);
        group7.setOnCheckedChangeListener(groupListener);
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
                    case R.id.a71:
                        answerCheck = 71;
                        verifyAnswer(answerCheck);
                        goToNextQuestion();
                        break;
                    case R.id.a72:
                        answerCheck = 72;
                        verifyAnswer(answerCheck);
                        goToNextQuestion();
                        break;
                    case R.id.a73:
                        answerCheck = 73;
                        verifyAnswer(answerCheck);
                        goToNextQuestion();
                        break;
                    case R.id.a74:
                        answerCheck = 74;
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
            if (answer == 74) {
                MainActivity.setmResult(10);
            }
        }
    }

    /*
    * When called, opens next Question page
     */
    public void goToNextQuestion() {
        Intent nextQuestion = new Intent(QuestionSeven.this,QuestionEight.class);
        startActivity(nextQuestion);
    }
}