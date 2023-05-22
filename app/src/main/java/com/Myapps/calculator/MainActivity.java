package com.Myapps.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CardView zero,one,two,three,four,five,six,seven,eight,nine,add,div,mul,sub,back,point,equal,clear;
    TextView operation,result;
    //String input="",output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //defining the hooks
        definehooks();
        //set listener
        setListener();
    }

    private void setListener() {
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        div.setOnClickListener(this);
        mul.setOnClickListener(this);
        sub.setOnClickListener(this);
        add.setOnClickListener(this);
        back.setOnClickListener(this);
        point.setOnClickListener(this);
        equal.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    private void definehooks() {
        zero = findViewById(R.id.zero);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        div = findViewById(R.id.divide);
        mul = findViewById(R.id.multiply);
        sub = findViewById(R.id.minus);
        add = findViewById(R.id.add);
        back = findViewById(R.id.back);
        point = findViewById(R.id.point);
        equal = findViewById(R.id.equals);
        clear = findViewById(R.id.AC);
        result = findViewById(R.id.result);
        operation = findViewById(R.id.operation);
    }

    @Override
    public void onClick(View view) {
        if (view == zero){
            operation.setText("w");
        }

    }
}