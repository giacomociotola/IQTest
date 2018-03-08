package com.example.toki.iqtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// All classes extend MainActivity to ensure consistency to the mResult variable
public class QuestionTwo extends MainActivity {

    EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_two);

        Button send = findViewById(R.id.send_button);
        send.setOnClickListener(sendListener);

        answer = findViewById(R.id.answer);
    }

    View.OnClickListener sendListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String answer2 = answer.getText().toString();
            if (TextUtils.isEmpty(answer2)) {
                Toast.makeText(QuestionTwo.this, R.string.question_null, Toast.LENGTH_LONG).show();
            } else {
                answer2.trim();
                verifyAnswer(answer2);

                // After the verify of answer value, the following intent is to go to the next question page
                Intent nextQuestion = new Intent(QuestionTwo.this, QuestionThree.class);
                startActivity(nextQuestion);
            }
        }
    };

    /*
    * Verifies if the given answer is the right one. If so, it updates global app variable mResult, in MainActivity
    * param answer
    */
    public void verifyAnswer(String answer) {
        if (answer.equals("m")) {
            MainActivity.setmResult(10);
        }
    }
}