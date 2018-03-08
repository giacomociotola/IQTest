package com.example.toki.iqtest;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// All classes extend MainActivity to ensure consistency to the mResult variable
public class QuestionOne extends MainActivity {

    private EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_one);

        answer = findViewById(R.id.answer);

        Button send = findViewById(R.id.send_button);
        send.setOnClickListener(sendListener);
    }

    View.OnClickListener sendListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String ans1 = answer.getText().toString();
            if (TextUtils.isEmpty(ans1)) {
                Toast.makeText(QuestionOne.this, R.string.question_null, Toast.LENGTH_LONG).show();
            } else {
                ans1.trim();
                int answer1 = Integer.parseInt(ans1);
                verifyAnswer(answer1);

                // After the verify of answer value, the following intent is to go to the next question page
                Intent nextQuestion = new Intent(QuestionOne.this, QuestionTwo.class);
                startActivity(nextQuestion);
            }
        }
    };

    /*
    * Verifies if the given answer is the right one. If so, it updates global app variable mResult, in MainActivity
    * param answer
    */
    public void verifyAnswer(int answer) {
        if (answer == 15) {
            MainActivity.setmResult(10);
        }
    }
}