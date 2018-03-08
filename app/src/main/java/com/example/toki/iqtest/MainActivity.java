package com.example.toki.iqtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // declared static to use getmResult as a class method to call from other activities
    private static int mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button begin = findViewById(R.id.begin);
        begin.setOnClickListener(beginButton);
    }

    /*
    Other activities calls this method to add points to mResult variable. They pass an int value, defined locally in each activity
     */
    public static void setmResult(int a) {
        mResult += a;
    }

    /*
    Result class calls this method to get the value of mResult variable
     */
    public static int getmResult() {
        return mResult;
    }

    /*
    Begin button sets mResult value to 0, if some user wants to re-do the test
     */
    View.OnClickListener beginButton = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mResult = 0;
            Intent beginIntent = new Intent(MainActivity.this, QuestionOne.class);
            startActivity(beginIntent);
        }
    };

}