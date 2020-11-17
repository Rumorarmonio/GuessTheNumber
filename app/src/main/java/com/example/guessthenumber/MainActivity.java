package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    EditText floor;
    EditText ceil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ceil = findViewById(R.id.ceil);
        floor = findViewById(R.id.floor);
    }

    public void onGame(View view) {
        if (floor.getText().toString().equals("") || ceil.getText().toString().equals("")) {
            Toast.makeText(this, "pls type numbers!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Long.parseLong(floor.getText().toString()) > 2147483647 || Long.parseLong(ceil.getText().toString()) > 2147483647) {
            Toast.makeText(this, "pls type smaller numbers !", Toast.LENGTH_SHORT).show();
            return;
        }
        intent = new Intent(this, SecondMain.class);
        intent.putExtra("floor", Integer.parseInt(floor.getText().toString()));
        intent.putExtra("ceil", Integer.parseInt(ceil.getText().toString()));
        startActivity(intent);
    }
}