package com.example.konty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button to_k, to_f;
    TextView result;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        to_k = findViewById(R.id.button);
        to_f = findViewById(R.id.button2);
        result = findViewById(R.id.textView3);
        input = findViewById(R.id.editTextNumber);

        to_k.setOnClickListener(View -> calculate_to_k());
        to_f.setOnClickListener(View -> calculate_to_f());
    }

    private void calculate_to_k(){
        double res = Double.valueOf(input.getText().toString()) + 273;
        result.setText("Wynik: " + Double.toString(res));
    }

    private void calculate_to_f(){
        double res = ((double) 9 / 5) * Double.valueOf(input.getText().toString());
        res+=32;

        result.setText("Wynik: " + Double.toString(res));
    }
}