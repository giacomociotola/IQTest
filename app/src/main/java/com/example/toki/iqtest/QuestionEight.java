package com.example.toki.iqtest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

// All classes extend MainActivity to ensure consistency to the mResult variable
public class QuestionEight extends MainActivity {

    private CheckBox checkBoxEight[] = new CheckBox[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_eight);

        // checkboxes array
        checkBoxEight[0] = findViewById(R.id.a81);
        checkBoxEight[1] = findViewById(R.id.a82);
        checkBoxEight[2] = findViewById(R.id.a83);
        checkBoxEight[3] = findViewById(R.id.a84);
        checkBoxEight[4] = findViewById(R.id.a85);

        // assign a listener to each checkbox of the array
        for (int i = 0; i < 5; i++) {
            checkBoxEight[i].setOnCheckedChangeListener(checkListener);
        }
    }

    CompoundButton.OnCheckedChangeListener checkListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int numCheck = checkedCount(checkBoxEight);
            checkEnoughAndMakeDisabled(checkBoxEight, numCheck);
        }
    };

    /*
    * Calculates the number of checkboxes checked
    *
    * param CheckBoxEight array
     */
    public int checkedCount(CheckBox checkBox[]) {
        int checked = 0;
        for (int i=0; i<5; i++){
            if (checkBox[i].isChecked()) {
                checked += 1;
                checkBox[i].setEnabled(false);
            }
        }
        return checked;
    }

    /*
    * Verifies how many checkboxes are selected and if equal or more than given variable (a),
    * it disables unchecked checkboxes and update the mResult variable, in MainActivity.
    * Finally, it opens next Question page
    *
    * params CheckBoxEight array, number of checked checkboxes
     */
    public void checkEnoughAndMakeDisabled(CheckBox checkBoxes[], int checked) {
        int a = 2;

        if (checked >= a) {
            for (CheckBox cb : checkBoxes) {
                if (!cb.isChecked()) {
                    cb.setEnabled(false);
                }
            }
            verifyAnswer(checkBoxes);
            goToNextQuestion();
        } else {
            for (CheckBox cb : checkBoxes) {
                if (!cb.isChecked()) {
                    cb.setEnabled(true);
                }
            }
        }
    }

    /*
    * Verifies if the given answer is the right one. If so, it updates global app variable mResult, in MainActivity
    *
    * param checkBoxEight array
    */
    public void verifyAnswer(CheckBox checkBox[]) {
        if (checkBox[0].isChecked() && !checkBox[1].isChecked() && !checkBox[2].isChecked() && checkBox[3].isChecked() && !checkBox[4].isChecked()) {
            MainActivity.setmResult(10);
        }
    }

    /*
    * When called, opens next Question page
     */
    public void goToNextQuestion() {
        Intent nextQuestion = new Intent(QuestionEight.this,QuestionNine.class);
        startActivity(nextQuestion);
    }
}