package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    String effect = "";
    Button num0,num1,num2,num3,num4,num5,num6,num7,num8,num9,add,sub,mul,div,clear,equal;
    TextView result;

    private void clear_effect(){
        result.setText("");
        effect = "";
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num0 = (Button) findViewById(R.id.button27);
        num1 = (Button) findViewById(R.id.button20);
        num2 = (Button) findViewById(R.id.button21);
        num3 = (Button) findViewById(R.id.button19);
        num4 = (Button) findViewById(R.id.button14);
        num5 = (Button) findViewById(R.id.button15);
        num6 = (Button) findViewById(R.id.button16);
        num7 = (Button) findViewById(R.id.button11);
        num8 = (Button) findViewById(R.id.button12);
        num9 = (Button) findViewById(R.id.button13);
        add = (Button) findViewById(R.id.button25);
        sub = (Button) findViewById(R.id.button24);
        mul = (Button) findViewById(R.id.button23);
        div = (Button) findViewById(R.id.button22);
        clear = (Button) findViewById(R.id.button29);
        equal = (Button) findViewById(R.id.button28);

        result = findViewById(R.id.textView);

        num0.setOnClickListener(v -> {
            effect += num0.getText().toString();
            result.setText(effect);
        });

        num1.setOnClickListener(v -> {
            effect += num1.getText().toString();
            result.setText(effect);
        });

        num2.setOnClickListener(v -> {
            effect += num2.getText().toString();
            result.setText(effect);
        });

        num3.setOnClickListener(v -> {
            effect += num3.getText().toString();
            result.setText(effect);
        });

        num4.setOnClickListener(v -> {
            effect += num4.getText().toString();
            result.setText(effect);
        });

        num5.setOnClickListener(v -> {
            effect += num5.getText().toString();
            result.setText(effect);
        });

        num6.setOnClickListener(v -> {
            effect += num6.getText().toString();
            result.setText(effect);
        });

        num7.setOnClickListener(v -> {
            effect += num7.getText().toString();
            result.setText(effect);
        });

        num8.setOnClickListener(v -> {
            effect += num8.getText().toString();
            result.setText(effect);
        });

        num9.setOnClickListener(v -> {
            effect += num9.getText().toString();
            result.setText(effect);
        });

        add.setOnClickListener(v -> {
            effect += add.getText().toString();
            result.setText(effect);
        });

        sub.setOnClickListener(v -> {
            effect += sub.getText().toString();
            result.setText(effect);
        });

        mul.setOnClickListener(v -> {
            effect += mul.getText().toString();
            result.setText(effect);
        });

        div.setOnClickListener(v -> {
            effect += div.getText().toString();
            result.setText(effect);
        });

        clear.setOnClickListener(v -> clear_effect());

        equal.setOnClickListener(v -> {
            if(effect.length() > 0) {
                if (effect.contains("*")) {
                    String[] res = effect.split(Pattern.quote("*"));
                    double n1 = Double.parseDouble(res[0]);
                    double n2 = Double.parseDouble(res[1]);
                    double result_to_print = n1*n2;
                    result.setText(Double.toString(result_to_print));
                }
                if (effect.contains("/")) {
                    String[] res = effect.split(Pattern.quote("/"));
                    double n1 = Double.parseDouble(res[0]);
                    double n2 = Double.parseDouble(res[1]);
                    double result_to_print = n1/n2;
                    result.setText(Double.toString(result_to_print));
                }
                if (effect.contains("+")) {
                    String[] res = effect.split(Pattern.quote("+"));
                    double n1 = Double.parseDouble(res[0]);
                    double n2 = Double.parseDouble(res[1]);
                    double result_to_print = n1+n2;
                    result.setText(Double.toString(result_to_print));
                }
                if (effect.contains("-")) {
                    String[] res = effect.split(Pattern.quote("-"));
                    double n1 = Double.parseDouble(res[0]);
                    double n2 = Double.parseDouble(res[1]);
                    double result_to_print = n1-n2;
                    result.setText(Double.toString(result_to_print));
                }
            }else{
                Toast.makeText(MainActivity.this, "Brak danych", Toast.LENGTH_SHORT).show();
            }
        });


    }

}