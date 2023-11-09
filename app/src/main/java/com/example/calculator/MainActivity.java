package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity{

    TextView expressionView;
    TextView expressionHistory;
    CalcBrain calcBrain;
    StringBuilder currentNumber;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnAdd;
    Button btnSub;
    Button btnDiv;
    Button btnMult;
    Button btnEq;
    Button btnC;
    Button btnHistory;

    boolean flag = false;

        void displayHistory() {
            String stringList = "";
            for(String s : calcBrain.history)
                stringList += s + "\n";
            expressionHistory.setText(stringList);
        }

        void result(){
        int result = calcBrain.calculate();
        if(result == -1000){
            Toast.makeText(this, "Please enter single digits only and make sure the expression end with numerical value", Toast.LENGTH_LONG).show();
            expressionView.setText("");
            calcBrain.expressionList.clear();
        } else if (result == -2000) {
            Toast.makeText(this, "Please enter valid value for division operation excluding zero", Toast.LENGTH_LONG).show();
            expressionView.setText("");
            calcBrain.expressionList.clear();
        } else {
            expressionView.append(" = " + result);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expressionView = findViewById(R.id.expressionView);
        expressionHistory = findViewById(R.id.expressionHistory);
        currentNumber = new StringBuilder();
        calcBrain = new CalcBrain();
        expressionView.setText("");
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnEq = findViewById(R.id.btnEq);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);
        btnC = findViewById(R.id.btnC);
        btnHistory = findViewById(R.id.btnHistory);

        expressionHistory.setVisibility(View.GONE);


        btn0.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Log.d("calculator"," btn 0 clicked" );
                 expressionView.append("0");
                 currentNumber.append("0");
                 calcBrain.push("0");
             }
         });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("calculator"," btn 1 clicked" );
                expressionView.append("1");
               // currentNumber.append("1");
                calcBrain.push("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("calculator"," btn 2 clicked" );
                expressionView.append("2");
              //  currentNumber.append("2");
                calcBrain.push("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("calculator"," btn 3 clicked" );
                expressionView.append("3");
               // currentNumber.append("3");
                calcBrain.push("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("calculator"," btn 4 clicked" );
                expressionView.append("4");
                //currentNumber.append("4");
                calcBrain.push("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("calculator"," btn 5 clicked" );
                expressionView.append("5");
               // currentNumber.append("5");
                calcBrain.push("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("calculator"," btn 6 clicked" );
                expressionView.append("6");
              //  currentNumber.append("6");
                calcBrain.push("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("calculator"," btn 7 clicked" );
                expressionView.append("7");
                //  currentNumber.append("7");
                calcBrain.push("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("calculator"," btn 8 clicked" );
                expressionView.append("8");
                //  currentNumber.append("8");
                calcBrain.push("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("calculator"," btn 9 clicked" );
                expressionView.append("9");
                //  currentNumber.append("9");
                calcBrain.push("9");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("calculator"," btn + clicked" );
                expressionView.append("+");
              //  currentNumber.append("+");
                calcBrain.push("+");
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("calculator"," btn + clicked" );
                expressionView.append("-");
                //currentNumber.append("-");
                calcBrain.push("-");
            }
        });
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("calculator"," btn * clicked" );
                expressionView.append("*");
             //   currentNumber.append("*");
                calcBrain.push("*");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("calculator"," btn / clicked" );
                expressionView.append("/");
                //   currentNumber.append("*");
                calcBrain.push("/");
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("calculator"," btn C clicked" );
                expressionView.setText("");
                calcBrain.expressionList.clear();
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Log.d("calculator", " btn History clicked");

                if (flag == true) { expressionHistory.setText("");
                    calcBrain.history.clear();
                    btnHistory.setText("Standard - No History");
                    expressionHistory.setVisibility(View.VISIBLE);
                    v.setBackgroundColor(getColor(R.color.gray));
                    // displayHistory();

                }else {
                    expressionHistory.setVisibility(View.GONE);
                    btnHistory.setText("Advanced - With History");
                    v.setBackgroundColor(getColor(R.color.olive));
                }
                flag = !flag;
            }
        });



        btnEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("calculator"," btn = clicked" );
                result();
                    String text = expressionView.getText().toString();
                        calcBrain.pushHistory(text);
                        if(flag = true){
                            displayHistory();
                        }
//                        else {
//                            expressionHistory.setText("");
//                            calcBrain.history.clear();
//                        }
               // calcBrain = new CalcBrain();
            }
        });

    }
}