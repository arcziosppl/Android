package com.example.waluty;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import java.text.DecimalFormat;
import org.json.JSONException;


public class MainActivity extends AppCompatActivity {

    private static final DecimalFormat decfor = new DecimalFormat("0.00");

    Button calculate_;
    EditText num;
    TextView czk,eur,rub,usd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate_ = findViewById(R.id.nextDogButton);
        num = findViewById(R.id.editTextNumber);
        czk = findViewById(R.id.textView);
        eur = findViewById(R.id.textView3);
        rub = findViewById(R.id.textView4);
        usd = findViewById(R.id.textView2);


        calculate_.setOnClickListener(View -> calculate());
    }

    @NonNull
    private String format(double val,String name){

        double to_decimal_2 = Double.parseDouble(decfor.format(val));

        return (name + ": " +  to_decimal_2);
    }

    private void calculate() {

        RequestQueue volleyQueue = Volley.newRequestQueue(MainActivity.this);

        String url = "https://api.freecurrencyapi.com/v1/latest?apikey=fca_live_FYFdl2yJ6Unrgc48mf3d8mhc7uisvGZkVcixSRCf&currencies=EUR%2CUSD%2CCZK%2CRUB&base_currency=PLN";

        @SuppressLint("SetTextI18n")
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    try {
                        if(num.getText().length() > 0) {
                            double CZK = response.getJSONObject("data").getDouble("CZK") * Double.parseDouble(num.getText().toString());
                            double EUR = response.getJSONObject("data").getDouble("EUR") * Double.parseDouble(num.getText().toString());
                            double USD = response.getJSONObject("data").getDouble("USD") * Double.parseDouble(num.getText().toString());
                            double RUB = response.getJSONObject("data").getDouble("RUB") * Double.parseDouble(num.getText().toString());

                           eur.setText(format(EUR, "EUR"));
                           czk.setText(format(CZK, "CZK"));
                           usd.setText(format(USD, "USD"));
                           rub.setText(format(RUB, "RUB"));
                        }else {
                            Toast.makeText(MainActivity.this, "Proszę wprowadzić poprawną wartość!", Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                },

                error -> {
                    Toast.makeText(MainActivity.this, "Wystąpił błąd!", Toast.LENGTH_LONG).show();
                }
        );

        volleyQueue.add(jsonObjectRequest);
    }
}
