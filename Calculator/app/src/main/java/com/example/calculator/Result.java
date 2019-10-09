package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Result extends AppCompatActivity implements View.OnClickListener {

    ArrayList<QuizResult> ResultArrayList;
    ArrayList<QuizResult> ResultArrayListRadio;
    ArrayAdapter<QuizResult> listAdapter;

    RadioGroup rgSelection;
    RadioButton rbAll, rbRight, rbWrong, rbSortA, rbSortD;
    EditText etRegister;
    TextView tvScore;
    Button buttonShow, buttonRegister;

    ListView lvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();
        getMyIntent();
        FinalScore();
    }

    public void init() {
        etRegister = findViewById(R.id.etName);
        tvScore = findViewById(R.id.tvScore);
        rgSelection = findViewById(R.id.rgSelectOption);
        rbAll = findViewById(R.id.rbAll);
        rbRight = findViewById(R.id.rbRight);
        rbWrong = findViewById(R.id.rbWrong);
        rbWrong.setOnClickListener(this);
        rbSortA = findViewById(R.id.rbSortA);
        rbSortD = findViewById(R.id.rbSortD);
        buttonShow = findViewById(R.id.buttonShow);
        buttonShow.setOnClickListener(this);
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(this);
        lvResult = findViewById(R.id.lvResult);
    }
//=================================================================================RECIEVES ARRAYLIST OF ANSWERS

    public void getMyIntent() {

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("intentExtra");
        Serializable bundleContent = bundle.getSerializable("bundleContent");
        ResultArrayList = (ArrayList<QuizResult>) bundleContent;
    }
 //====================================================================================== DISPLAY SCORE
    public void FinalScore(){

        int count = 0;
        int total = ResultArrayList.size();

        for (QuizResult avg : ResultArrayList){
            if(avg.getResultAction().equals("Right")){
                count++;
            }
            tvScore.setText((((100*count)/total)) +"%");
        }
    }
//=================================================================================SHOW RESULT METHOD BASED ON RADIO BUTTONS

    public void showResult(String rate) {
        StringBuilder sbMyResultList = new StringBuilder();
        ResultArrayListRadio = new ArrayList<QuizResult>();

        Collections.sort(ResultArrayList);

        switch (rate) {
            case "All":

                for (QuizResult result2 : ResultArrayList) {

                      ResultArrayListRadio.add(result2);

                }
                break;

            case "Right":
                for (QuizResult result2 : ResultArrayList) {
                    if (result2.getResultAction().equals("Right")) {
                        ResultArrayListRadio.add(result2);
                    }

                }
                break;

            case "Wrong":
                for (QuizResult result2 : ResultArrayList) {
                    if (result2.getResultAction().equals("Wrong")) {
                        ResultArrayListRadio.add(result2);
                    }
                }
                break;

            case "SortA":
                Collections.sort(ResultArrayList);
                for (QuizResult result2 : ResultArrayList) {
                    ResultArrayListRadio.add(result2);
                }
                break;

            case "SortD":
                Collections.sort(ResultArrayList, Collections.reverseOrder());
                for (QuizResult result2 : ResultArrayList) {
                    ResultArrayListRadio.add(result2);
                }
                break;
        }

        listAdapter = new ArrayAdapter<QuizResult>(this, android.R.layout.simple_dropdown_item_1line, ResultArrayListRadio);
        lvResult.setAdapter(listAdapter);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.buttonShow:
                String strRbSelect = "All";

                if (rbAll.isChecked())
                    strRbSelect = "All";

                else if (rbRight.isChecked())
                    strRbSelect = "Right";

                else if (rbWrong.isChecked())
                    strRbSelect = "Wrong";

                else if (rbSortA.isChecked())
                    strRbSelect = "SortA";
                else if (rbSortD.isChecked())
                    strRbSelect = "SortD";

                //textViewClients.setText(str);

                showResult(strRbSelect);  //====================================== CALLS SHOW RESULT METHOD ABOVE AFTER CHOICE IS MADE
                break;

            //=================================================================================RECEIVES NAME AND PUTS IT TO MAIN PAGE AFTER GAME

            case R.id.buttonRegister:
                if (etRegister.getText() == null || etRegister.getText().toString().equals("")) {
                    Toast.makeText(this, "Enter Yor Name!", Toast.LENGTH_SHORT).show();

                } else {
                    Intent intent = new Intent();
                    String name = etRegister.getText().toString();
                    intent.putExtra("name", name);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                break;

        }

    }

}
