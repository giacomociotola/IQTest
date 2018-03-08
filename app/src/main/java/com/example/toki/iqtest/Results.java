package com.example.toki.iqtest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

// All classes extend MainActivity to ensure consistency to the mResult variable
public class Results extends MainActivity {

    private TextView textResult;
    private String mensaUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        Button back = findViewById(R.id.back);
        back.setOnClickListener(backListener);

        Toast.makeText(this, "Your result is: " + MainActivity.getmResult() + "/100", Toast.LENGTH_LONG).show();

        textResult = findViewById(R.id.text_results);
        setTextResult();

        TextView mensaLink = findViewById(R.id.mensa_link);
        mensaUrl = mensaLink.getText().toString();
        mensaLink.setOnClickListener(mensaClick);

    }

    View.OnClickListener backListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent backToMainActivity = new Intent(Results.this, MainActivity.class);
            startActivity(backToMainActivity);
        }
    };

    View.OnClickListener mensaClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent mensaTest = new Intent(Intent.ACTION_VIEW);
            mensaTest.setData(Uri.parse(mensaUrl));
            startActivity(mensaTest);
        }
    };

    /*
    Set text of TextView to show results of the test
     */
    public void setTextResult() {
        String textRes = "Your score is " + MainActivity.getmResult() + "/100";
        textResult.setText(textRes);
    }

    private Boolean exit = false;
    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);
        }
    }
}