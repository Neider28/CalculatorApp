package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private TextView number_a;
    private TextView number_b;

    private boolean state_a = false;
    private boolean state_b = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_0 = findViewById(R.id.button0);
        Button btn_1 = findViewById(R.id.button1);
        Button btn_2 = findViewById(R.id.button2);
        Button btn_3 = findViewById(R.id.button3);
        Button btn_4 = findViewById(R.id.button4);
        Button btn_5 = findViewById(R.id.button5);
        Button btn_6 = findViewById(R.id.button6);
        Button btn_7 = findViewById(R.id.button7);
        Button btn_8 = findViewById(R.id.button8);
        Button btn_9 = findViewById(R.id.button9);
        Button btn_sumar = findViewById(R.id.button_sumar);
        Button btn_restar = findViewById(R.id.button_restar);
        Button btn_multiplicar = findViewById(R.id.button_multiplicar);
        Button btn_dividir = findViewById(R.id.button_dividir);
        Button btn_reset = findViewById(R.id.button_reset);

        result = findViewById(R.id.result);
        number_a = findViewById(R.id.numberA);
        number_b = findViewById(R.id.numberB);
        result.setBackgroundResource(R.color.green_200);
        number_a.setBackgroundResource(R.color.green_500);
        number_b.setBackgroundResource(R.color.green_500);

        number_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state_a = true;
                state_b = false;
            }
        });

        number_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state_a = false;
                state_b = true;
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert("9");
            }
        });

        btn_sumar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(number_a.getText().toString() != "" && number_b.getText().toString() != "") {
                    result.setText(Integer.toString(sumar(Integer.parseInt(number_a.getText().toString()), Integer.parseInt(number_b.getText().toString()))));
                }
            }
        });

        btn_restar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(number_a.getText().toString() != "" && number_b.getText().toString() != "") {
                    result.setText(Integer.toString(restar(Integer.parseInt(number_a.getText().toString()), Integer.parseInt(number_b.getText().toString()))));
                }
            }
        });

        btn_multiplicar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(number_a.getText().toString() != "" && number_b.getText().toString() != "") {
                    result.setText(Integer.toString(multiplicar(Integer.parseInt(number_a.getText().toString()), Integer.parseInt(number_b.getText().toString()))));
                }
            }
        });

        btn_dividir.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (number_a.getText().toString() != "" && number_b.getText().toString() != "") {
                    result.setText(Float.toString(dividir(Float.parseFloat(number_a.getText().toString()), Float.parseFloat(number_b.getText().toString()))));
                }
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
                number_a.setText("");
                number_b.setText("");
                state_a = false;
                state_b = false;
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void insert(String number) {
        if(state_a && !state_b) {
            number_a.setText(number_a.getText().toString() + number);
        }

        if(!state_a && state_b) {
            number_b.setText(number_b.getText().toString() + number);
        }
    }

    public int sumar(int a, int b) {
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public float dividir(float a, float b) {
        float res = 0;

        if (b != 0) {
            res = a / b;
        }
        return res;
    }
}