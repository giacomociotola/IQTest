package com.example.toki.iqtest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

// All classes extend MainActivity to ensure consistency to the mResult variable
public class QuestionFive extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_five);

        RadioGroup group5 = findViewById(R.id.group5);
        group5.setOnCheckedChangeListener(groupListener);
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
                    case R.id.a51:
                        answerCheck = 51;
                        verifyAnswer(answerCheck);
                        goToNextQuestion();
                        break;
                    case R.id.a52:
                        answerCheck = 52;
                        verifyAnswer(answerCheck);
                        goToNextQuestion();
                        break;
                    case R.id.a53:
                        answerCheck = 53;
                        verifyAnswer(answerCheck);
                        goToNextQuestion();
                        break;
                    case R.id.a54:
                        answerCheck = 54;
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
            if (answer == 54) {
                MainActivity.setmResult(10);
            }
        }
    }

    /*
    * When called, opens next Question page
     */
    public void goToNextQuestion() {
        Intent nextQuestion = new Intent(QuestionFive.this,QuestionSix.class);
        startActivity(nextQuestion);
    }
}