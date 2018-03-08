package com.example.toki.iqtest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

// All classes extend MainActivity to ensure consistency to the mResult variable
public class QuestionNine extends MainActivity {

    private CheckBox checkBoxNine[] = new CheckBox[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_nine);

        // checkboxes array
        checkBoxNine[0] = findViewById(R.id.a91);
        checkBoxNine[1] = findViewById(R.id.a92);
        checkBoxNine[2] = findViewById(R.id.a93);
        checkBoxNine[3] = findViewById(R.id.a94);
        checkBoxNine[4] = findViewById(R.id.a95);

        // assign a listener to each checkbox of the array
        for (int i = 0; i < 5; i++) {
            checkBoxNine[i].setOnCheckedChangeListener(checkListener);
        }
    }

    CompoundButton.OnCheckedChangeListener checkListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int numCheck = checkedCount(checkBoxNine);
            checkEnoughAndMakeDisabled(checkBoxNine, numCheck);
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
    * params CheckBoxNine array, number of checked checkboxes
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
    * param checkBoxNine array
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
        Intent nextQuestion = new Intent(QuestionNine.this,QuestionTen.class);
        startActivity(nextQuestion);
    }
}