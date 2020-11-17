package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondMain extends AppCompatActivity {

    TextView question;
    int floor, ceil, average;
    Button yesButton, noButton;
    boolean win = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        yesButton = findViewById(R.id.buttonNo);
        noButton = findViewById(R.id.buttonYes);
        question = findViewById(R.id.questionField);

        Intent intent = getIntent();
        floor = intent.getIntExtra("floor", 0);
        ceil = intent.getIntExtra("ceil", 10);

        if (floor > ceil) {
            int a = floor;
            floor = ceil;
            ceil = a;
        }

        average = (floor + ceil) / 2;
        question.setText("Is your number greater than " + average + "?");
    }

    public void onClickYes(View view) {
        if (ceil - 1 == average)
            checkNumber();
        floor = average + 1;
        checkNumber();
    }

    public void onClickNo(View view) {
        ceil = average;
        checkNumber();
    }

    public void checkNumber() {
        if (win == false) {
            average = (ceil + floor) / 2;
            question.setText("Is your number greater than " + average + "?");
            if (ceil == floor) {
                question.setText("Your number is " + ceil + "!");
                win = true;
            }
        }
    }
}