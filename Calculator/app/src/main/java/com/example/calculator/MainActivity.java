package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int counter=0;
    public String strOperation;
    float n1, n2;
    String operatorSwitch;
    int output;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnZero;
    Button btnPoint, btnDash, buttonGENERATED, buttonVALIDATE, btnClear, btnScore, btnFinish;
    TextView tvTitle, tvRandom;
    EditText etAnswer;

    ArrayList<QuizResult> ResultArrayList;  //===========================================RESULT ARRAYLIST

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {


        tvTitle = findViewById(R.id.tvTitle);
        tvRandom = findViewById(R.id.tvRandom);

        ResultArrayList = new ArrayList<>();

        etAnswer = findViewById(R.id.etAnswer);

        btnZero = findViewById(R.id.btnZero);


        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etAnswer.setText(etAnswer.getText() + "0");
            }
        });

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etAnswer.setText(etAnswer.getText() + "1");
            }
        });


        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etAnswer.setText(etAnswer.getText() + "2");
            }
        });

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etAnswer.setText(etAnswer.getText() + "3");
            }
        });

        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etAnswer.setText(etAnswer.getText() + "4");
            }
        });

        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etAnswer.setText(etAnswer.getText() + "5");
            }
        });

        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etAnswer.setText(etAnswer.getText() + "6");
            }
        });

        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etAnswer.setText(etAnswer.getText() + "7");
            }
        });

        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etAnswer.setText(etAnswer.getText() + "8");
            }
        });

        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etAnswer.setText(etAnswer.getText() + "9");
            }
        });

        btnPoint = findViewById(R.id.btnPoint);
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etAnswer.getText().toString().contains(".")) {
                    etAnswer.setText(etAnswer.getText() + ".");
                }
            }
        });

        btnDash = findViewById(R.id.btnDash);
        btnDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etAnswer.getText().toString().contains("-")) {
                    etAnswer.setText( "-" + etAnswer.getText());
                }
            }
        });
//=================================================================================GENERATED 2 RANDOM NUMBERS AND RANDON OPERATOR  (START)
        buttonGENERATED = findViewById(R.id.buttonGENERATED);

        buttonGENERATED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                Random rand2 = new Random();
                int num1 = rand.nextInt(10);
                int num2 = rand2.nextInt(10);


                Random operatorChoice = new Random();
                int operator = operatorChoice.nextInt(4);

                switch (operator) {

                    case 0:
                        operatorSwitch = "+";
                        output = num1 + num2;
                        break;
                    case 1:
                        operatorSwitch = "-";
                        output = num1 - num2;
                        break;
                    case 2:
                        operatorSwitch = "*";
                        output = num1 * num2;
                        break;
                    case 3:
                        operatorSwitch = "/";
                        if(num2 != 0) {
                            output = num1 / num2;
                        }
                        else {
                            num2 = rand2.nextInt(10)+1;
                            output = num1 / num2;
                        }
                        break;
                    default:
                        operatorSwitch = "";

                }

                strOperation = (String.valueOf(num1 + " " + operatorSwitch + " " + num2).toString() + " = " + output);

                tvRandom.setText(String.valueOf(num1 + " " + operatorSwitch + " " + num2).toString());
                etAnswer.setText("");
            }
        });

//=================================================================================GENERATED 2 RANDOM NUMBERS AND RANDON OPERATOR  (END)
//=================================================================================COMPARES ANSWER TO GENERATED NUMBERS AND THEIR RANDOM FUNCTION "+,-,*,/"(START)

//=================================================================================COMPARES ANSWER TO GENERATED NUMBERS AND THEIR RANDOM FUNCTION "+,-,*,/"(END)

//=================================================================================CLEARS SCREEN (START)

        btnClear = findViewById(R.id.btnClear);
        //btnClear.setOnClickListener(this);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etAnswer.setText("");
            }
        });

        btnScore = findViewById(R.id.btnScore);
        btnScore.setOnClickListener(this);
//==================================================================================ENDS APPLICATION (START)
        btnFinish = findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        buttonVALIDATE = findViewById(R.id.buttonVALIDATE);
        buttonVALIDATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etAnswer.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),"Enter a value",Toast.LENGTH_SHORT).show();
                } else{
                    int userInput = Integer.parseInt(etAnswer.getText().toString());
                    if(userInput == output){
                        QuizResult quizResult= new QuizResult(strOperation, etAnswer.getText().toString(), "Right");
                        ResultArrayList.add(quizResult);
                        Toast.makeText(getApplicationContext(), "Answers Right " , Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        QuizResult quizResult= new QuizResult(strOperation, etAnswer.getText().toString(), "Wrong" );
                        ResultArrayList.add(quizResult);
                        Toast.makeText(getApplicationContext(), "Answer Wrong ", Toast.LENGTH_LONG).show();
                    }
                }


            }
        });
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnScore:
                showScore();
                break;
            case R.id.btnFinish:
                finishApp();
                break;
        }

    }
//=================================================================================SHUTS DOWN APP

    private void finishApp() {
        System.exit(0);
    }
//=================================================================================METHOD DISPLAY ARRAY LIST OF SCORES

    private void showScore() {

        Bundle bundle = new Bundle();
        bundle.putSerializable("bundleContent",ResultArrayList);
        Intent intent = new Intent(this,Result.class);
        intent.putExtra("intentExtra",bundle);
        startActivityForResult(intent,1);

    }
//=================================================================================GETS RESPONSE FRON NEXT ACTIVITY VALIDATION OF ACTION

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                //tvTitle.setText(String.valueOf(data.getIntExtra("result",0)));
                tvTitle.setText("Thank You :" + String.valueOf(data.getStringExtra("name")));
            }if(resultCode == RESULT_CANCELED)
                tvTitle.setText("!!!!");

        }

    }



}
