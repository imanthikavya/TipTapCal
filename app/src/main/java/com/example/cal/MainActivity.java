package com.example.cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;


import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private Cal tipCalc;
    private EditText billEditText;
    private EditText tipEditText;
    private EditText personEditText;

    public NumberFormat money = NumberFormat.getCurrencyInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tipCalc =new Cal(0.2f, 100.0f , 1);
        setContentView(R.layout.activity_main);
        billEditText =(EditText) findViewById(R.id.amount_bill_hint);
        tipEditText =(EditText) findViewById(R.id.amount_tip_percent_hint);
        personEditText = (EditText) findViewById(R.id.amount_person);
        TextChangeHandler tch =new TextChangeHandler();
        billEditText.addTextChangedListener(tch);
        tipEditText.addTextChangedListener(tch);
        personEditText.addTextChangedListener(tch);
    }
    public void calculate(){
        String billString = billEditText.getText().toString();
        String tipString = tipEditText.getText().toString();
        String personString = personEditText.getText().toString();
        TextView tipTextView =(TextView) findViewById(R.id.amount_tip);
        TextView totalTextView = (TextView)findViewById(R.id.amount_total);
        TextView personTextView = (TextView)findViewById(R.id.amount_personOutput);
        try {
            float billAmount = Float.parseFloat(billString);
            int tipPercent = Integer.parseInt(tipString);
            int personAmount = Integer.parseInt(personString);

            tipCalc.setBill(billAmount);
            tipCalc.setTip(.01f* tipPercent);
            tipCalc.setPerson(personAmount);

            float tip = tipCalc.tipAmount();
            float total = tipCalc.totalAmount();
            float person = tipCalc.totalPerson();


            tipTextView.setText(money.format(tip));
            totalTextView.setText(money.format(total));
            personTextView.setText(money.format(person));

        }
        catch (NumberFormatException e) {

        }
    }
    private class TextChangeHandler implements TextWatcher
    {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
        calculate();
        }
    }


    /*public void calculate(View v){
        EditText billEditText =(EditText) findViewById(R.id.amount_bill_hint);
        EditText tipEditText =(EditText) findViewById(R.id.amount_tip_percent_hint);
        String billString = billEditText.getText().toString();
        String tipString = tipEditText.getText().toString();

        TextView tipTextView = (TextView)findViewById(R.id.amount_tip);
        TextView totalTextView = (TextView)findViewById(R.id.amount_total);
        try {
            float billAmount = Float.parseFloat(billString);
            int tipPercent = Integer.parseInt(tipString);

            tipCalc.setBill(billAmount);
            tipCalc.setTip(.01f* tipPercent);

            float tip = tipCalc.tipAmount();
            float total = tipCalc.totalAmount();

            tipTextView.setText(money.format(tip));
            totalTextView.setText((money.format(total)));
        }
        catch (NumberFormatException e) {

        }*/
    }
