package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    TextView expressionField;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    Button buttonAdd;
    Button buttonSubstrate;
    Button buttonDivide;
    Button buttonMultiply;
    Button buttonClear;
    Button buttonEquals;

    Integer num1 = 0;;
    Integer num2 = 0;
    String operator = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expressionField = findViewById(R.id.textView);
        button1 = findViewById(R.id.one);
        button2 = findViewById(R.id.two);
        button3 = findViewById(R.id.three);
        button4 = findViewById(R.id.four);
        button5 = findViewById(R.id.five);
        button6 = findViewById(R.id.six);
        button7 = findViewById(R.id.seven);
        button8 = findViewById(R.id.eight);
        button9 = findViewById(R.id.nine);
        button0 = findViewById(R.id.zero);
        buttonAdd = findViewById(R.id.addition);
        buttonSubstrate = findViewById(R.id.substrate);
        buttonDivide = findViewById(R.id.divide);
        buttonMultiply = findViewById(R.id.btnmultiply);
        buttonClear = findViewById(R.id.clear);
        buttonEquals = findViewById(R.id.equals);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClicked(0);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClicked(1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClicked(2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClicked(3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClicked(4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClicked(5);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClicked(6);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClicked(7);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClicked(8);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClicked(9);
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperatorButtonClicked("+");
            }
        });

        buttonSubstrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperatorButtonClicked("-");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperatorButtonClicked("*");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperatorButtonClicked("/");
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleEqualsButtonClicked();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClearButtonClicked();
            }
        });

    }

    void handleButtonClicked(String pressedKey, boolean clearText) {
        String priorText = expressionField.getText().toString();
        if(pressedKey == "+" || pressedKey == "-" || pressedKey == "/" || pressedKey == "*") {
            String newText = priorText + pressedKey;
            expressionField.setText(newText);
        } else {
            if (clearText) {
                priorText = "";
            }
            String newText = priorText + pressedKey;
            expressionField.setText(newText);
        }
    }

    void handleNumberButtonClicked(int number) {
        if(String.valueOf(num1).length() < 6 && operator == null) {
            num1 *= 10;
            num1 += number;
            handleButtonClicked(Integer.toString(number), false);

        } else if(String.valueOf(num2).length() < 6 && operator != null) {
            num2 *= 10;
            num2 += number;
            handleButtonClicked(Integer.toString(number), false);
        }
    }

    void handleClearButtonClicked() {
        expressionField.setText("");
        num1 = 0;
        num2 = 0;
    }

    void handleOperatorButtonClicked(String operator) {
        handleButtonClicked(operator, false);
        this.operator = operator;
    }

    void handleEqualsButtonClicked() {
        int result = 0;

        switch(operator) {
            case "+":
                result = num1 + num2;
                break;

            case "-":
                result = num1 - num2;
                break;

            case "*":
                result = num1 * num2;
                break;

            case "/":
                result = (num2 == 0)? - 1: num1 / num2;
        }

        expressionField.setText(String.valueOf(result));
        num1 = null;
        num2 = null;
        operator = null;
    }
}






















