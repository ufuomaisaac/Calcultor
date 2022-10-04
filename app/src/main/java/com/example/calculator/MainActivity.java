package com.example.calculator;

import static android.util.Log.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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

    Integer num1 = null;
    Integer num2 = null;
    String operator = null;
    int result = 0;
    int operatorCounter = 0;
    boolean negateNum2 = false;
    boolean negateNum1 = false;



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

    void handleButtonClicked(String pressedKey) {
        String priorText = expressionField.getText().toString();
            String newText = priorText + pressedKey;
            expressionField.setText(newText);
    }

    void handleNumberButtonClicked(int number) {
        if(result != 0 && num1.equals(result)) {
            handleClearButtonClicked();
        }
            if (operator == null) {
                if (num1 == null) {
                    num1 = number;
                    handleButtonClicked(Integer.toString(number));
                } else if (String.valueOf(num1).length() < 6) {
                    String firstNumber = String.valueOf(num1).concat(String.valueOf(number));
                    num1 = Integer.valueOf(firstNumber);
                    handleButtonClicked(Integer.toString(number));
                }
            }else if (operator != null) {
                    if (num2 == null) {
                    num2 = number;
                    handleButtonClicked(Integer.toString(number));
                } else if (String.valueOf(number).length() < 6){
                    String secondNumber = String.valueOf(num2).concat(String.valueOf(number));
                    num2 = Integer.valueOf(secondNumber);
                    handleButtonClicked(Integer.toString(number));
                }
            }
    }

    void handleClearButtonClicked() {
        expressionField.setText("");
        num1 = null;
        num2 = null;
        operator = null;
        result = 0;
        operatorCounter = 0;
        negateNum1 = false;
        negateNum2 = false;

    }

    void handleOperatorButtonClicked(String operator) {
        handleButtonClicked(operator);
        Log.d("correct", "it is working");
        if (num1 == null) {
            Log.d("correct", "it is working");
            if(operator.equals("-")) {
                negateNum1 = true;
            } else if (num1.equals("+")) {
                negateNum1 = false;
            } else
                operatorCounter = operatorCounter + 2;
        } else {
            int prevoiusChar = expressionField.getText().toString().length() - 2;
            String str = expressionField.getText().toString();
            if (operatorCounter == 0) {
                this.operator = operator;
                operatorCounter++;
            } else if (String.valueOf(str.charAt(prevoiusChar)).equals("*")) {

                if (operator.equals("+"))
                    negateNum2 = false;
                else if (operator.equals("-"))
                    negateNum2 = true;
                else if (operator.equals("*") || operator.equals("/"))
                    operatorCounter++;

            } else if (String.valueOf(str.charAt(prevoiusChar)).equals("/")) {
                if (operator.equals("+"))
                    negateNum2 = false;
                else if (operator.equals("-"))
                    negateNum2 = true;
                else if (operator.equals("*") || operator.equals("/"))
                    operatorCounter++;
            } else
                operatorCounter++;
        }
    }

    void handleEqualsButtonClicked() {
        if (negateNum1) {
            num1 = num1 * -1;
        }
        if (negateNum2) {
            num2 = num2 * -1;
        }
        if (operator == null) {
            result = num1;
            expressionField.setText(String.valueOf(result));
        } else if(operatorCounter >= 2) {
            expressionField.setText("Syntax error");
        } else
         {
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
        }


        num1 = result;
        num2 = null;
        operator = null;
        operatorCounter = 0;
        negateNum2 = false;
        negateNum1 = false;

    }
}






















