package com.example.android.myquiz;


import android.content.Context;
import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.color.transparent;
import static com.example.android.myquiz.R.id.group1;
import static com.example.android.myquiz.R.id.group2;
import static com.example.android.myquiz.R.id.group3;
import static com.example.android.myquiz.R.id.group4;
import static com.example.android.myquiz.R.id.group5;
import static com.example.android.myquiz.R.id.group6;
import static com.example.android.myquiz.R.id.group7;
import static com.example.android.myquiz.R.id.q1a1;
import static com.example.android.myquiz.R.id.q2a2;
import static com.example.android.myquiz.R.id.q3a1;
import static com.example.android.myquiz.R.id.q4a3;
import static com.example.android.myquiz.R.id.q5a3;
import static com.example.android.myquiz.R.id.q6a3;
import static com.example.android.myquiz.R.id.q7a4;


public class MainActivity extends AppCompatActivity {

    public RadioGroup jgroup1;
    public RadioGroup jgroup2;
    public RadioGroup jgroup3;
    public RadioGroup jgroup4;
    public RadioGroup jgroup5;
    public RadioGroup jgroup6;
    public RadioGroup jgroup7;
    public RadioButton q1a1j;
    public RadioButton q2a2j;
    public RadioButton q3a1j;
    public RadioButton q4a3j;
    public RadioButton q5a3j;
    public RadioButton q6a3j;
    public RadioButton q7a4j;

    final Context c = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jgroup1 = (RadioGroup) findViewById(group1);
        jgroup2 = (RadioGroup) findViewById(group2);
        jgroup3 = (RadioGroup) findViewById(group3);
        jgroup4 = (RadioGroup) findViewById(group4);
        jgroup5 = (RadioGroup) findViewById(group5);
        jgroup6 = (RadioGroup) findViewById(group6);
        jgroup7 = (RadioGroup) findViewById(group7);

        q1a1j = (RadioButton) findViewById(q1a1);
        q2a2j = (RadioButton) findViewById(q2a2);
        q3a1j = (RadioButton) findViewById(q3a1);
        q4a3j = (RadioButton) findViewById(q4a3);
        q5a3j = (RadioButton) findViewById(q5a3);
        q6a3j = (RadioButton) findViewById(q6a3);
        q7a4j = (RadioButton) findViewById(q7a4);


    }


    //This is what i get after hitting submit button

    public void submit(View view) {

        EditText editText1=(EditText) findViewById(R.id.editText);
        int score = 0;
        if ((q1a1j.isChecked())) {
            score = score + 1;}
        if ((q2a2j.isChecked())) {
            score = score + 1;}
        if ((q3a1j.isChecked())) {
            score = score + 1;}
        if ((q4a3j.isChecked())) {
            score = score + 1;}
        if ((q5a3j.isChecked())) {
            score = score + 1;}
        if ((q6a3j.isChecked())) {
            score = score + 1;}
        if ((q7a4j.isChecked())) {
            score = score + 1;}
        double answer = (score / 7.) * 100;
        int answer2 = (int) Math.floor(answer);

        // This is dialog code, it need a bit practice with him to understand

        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
        View mView = layoutInflaterAndroid.inflate(R.layout.result, null);
        if (jgroup1.getCheckedRadioButtonId()!=-1&&jgroup2.getCheckedRadioButtonId()!=-1&& jgroup3.getCheckedRadioButtonId()!=-1&&jgroup4.getCheckedRadioButtonId()!=-1
                &&jgroup5.getCheckedRadioButtonId()!=-1&&jgroup6.getCheckedRadioButtonId()!=-1&&jgroup7.getCheckedRadioButtonId()!=-1) {
            TextView dialog1 = (TextView) mView.findViewById(R.id.dialogTitle);
            dialog1.setText(editText1.getText() + " result is : " + answer2 + " % ");
            ImageView image1 = (ImageView) mView.findViewById(R.id.resultImage);
            if (answer2 >= 50)
                image1.setImageResource(R.drawable.smiley);
            else
                image1.setImageResource(R.drawable.sad3);
        }
        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
        alertDialogBuilderUserInput.setView(mView);
        alertDialogBuilderUserInput.setCancelable(true);
        if (jgroup1.getCheckedRadioButtonId()!=-1&&jgroup2.getCheckedRadioButtonId()!=-1&& jgroup3.getCheckedRadioButtonId()!=-1&&jgroup4.getCheckedRadioButtonId()!=-1
                &&jgroup5.getCheckedRadioButtonId()!=-1&&jgroup6.getCheckedRadioButtonId()!=-1&&jgroup7.getCheckedRadioButtonId()!=-1){
        alertDialogBuilderUserInput.setPositiveButton("Check Answers", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialogBox, int id) {
                        dialogBox.cancel();
                        checkAnswers();


                    }
                });
        alertDialogBuilderUserInput.setNegativeButton("Try again",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                dialogBox.cancel();
                                reset();
                            }
                        });}
        else
        {alertDialogBuilderUserInput.setNegativeButton("Back",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {
                        dialogBox.cancel();
                    }
                });}



        AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
        alertDialogAndroid.show();
    }





    //this function adds green background to my answers

    public void checkAnswers() {

                q1a1j.setBackgroundResource(R.drawable.good_answer);
                q2a2j.setBackgroundResource(R.drawable.good_answer);
                q3a1j.setBackgroundResource(R.drawable.good_answer);
                q4a3j.setBackgroundResource(R.drawable.good_answer);
                q5a3j.setBackgroundResource(R.drawable.good_answer);
                q6a3j.setBackgroundResource(R.drawable.good_answer);
                q7a4j.setBackgroundResource(R.drawable.good_answer);



    }
    //this one function is to call reset function in android button
    public void reset1 (View view){
        reset();
    }
    //this one resets every selection and background
    public void reset() {
        jgroup1.clearCheck();
        jgroup2.clearCheck();
        jgroup3.clearCheck();
        jgroup4.clearCheck();
        jgroup5.clearCheck();
        jgroup6.clearCheck();
        jgroup7.clearCheck();
        q1a1j.setBackgroundResource(android.R.color.transparent);
        q2a2j.setBackgroundResource(android.R.color.transparent);
        q3a1j.setBackgroundResource(android.R.color.transparent);
        q4a3j.setBackgroundResource(android.R.color.transparent);
        q5a3j.setBackgroundResource(android.R.color.transparent);
        q6a3j.setBackgroundResource(android.R.color.transparent);
        q7a4j.setBackgroundResource(android.R.color.transparent);
    }
}

