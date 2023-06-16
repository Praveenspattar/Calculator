package com.Myapps.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CardView zero,one,two,three,four,five,six,seven,eight,nine,add,div,mul,sub,back,point,equal,clear;
    TextView operation,result;
    String input="",output;
    ArrayList<String> operants = new ArrayList<String>();
    double finalResult = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //defining the hooks
        definehooks();
        //set listener
        setListener();

        //result.setVisibility(View.GONE);
        operation.setText("0");
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
        one = findViewById(R.id.one);
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
            operation("0");
        }else if (view == one){
            operation("1");
        } else if (view == two) {
            operation("2");
        } else if (view == three) {
            operation("3");
        } else if (view == four) {
            operation("4");
        } else if (view == five) {
            operation("5");
        }else if (view == six) {
            operation("6");
        } else if (view == seven) {
            operation("7");
        } else if (view == eight) {
            operation("8");
        } else if (view == nine) {
            operation("9");
        } else if (view == point) {
            operation(".");
        } else if (view == add) {
            operation(" + ");
        } else if (view == mul) {
            operation(" X ");
        } else if (view == div) {
            operation(" % ");
        } else if (view == sub) {
            operation(" - ");
        } else if (view == equal) {
            operation("result");
        } else if (view == clear) {
            operation("AC");
        } else if (view == back) {
            operation("<-");
        }

    }

    private void operation(String no) {
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibe.vibrate(60);
        if (no.equals("AC")){
            input = "";
        } else if (no.equals("<-")){
            if (!input.equals("")) {
                Character last = input.charAt(input.length()-1);
                if (last.equals(" ")) {
                    input = input.substring(0, input.length() - 2);
                }else{
                    input = input.substring(0, input.length()-1);
                }
            }
        } else if (no.equals("result")) {
            getResult();
        } else {
            boolean istwiceoperator = false;
            String prev ="";
            if (input.length()>1){
                prev = input.substring(input.length() - 2, input.length()-1);
            }
            if ((prev.equals("+") || prev.equals("X") || prev.equals("-") || prev.equals("%") || prev.equals("."))&& (no.equals(" + ") || no.equals(" - ") || no.equals(" X ") || no.equals(" % ") || no.equals(" . ")) ) {
                istwiceoperator = true;
            }
            if (input.equals("") && (no.equals(" + ") || no.equals(" - ") || no.equals(" X ") || no.equals(" % ") || no.equals(".")) ){
                istwiceoperator =  true;
            }
            if (!istwiceoperator){
                input = input + no;
            }
        }
        operation.setText(input);
    }

    private void getResult() {
        operants.clear();
        String dup = input;
        dup = dup+" ";
        int len = dup.length();
        String value = " ";
        Character ch;
        for (int i = 0; i<len; i++){
            ch = dup.charAt(i);
            if (ch.equals(' ')){
                value = value.trim();
                operants.add(value);
                value = " ";
            }
            value = value+ch;
        }
        getAns("%");
        getAns("X");
        getAns("+");
        getAns("-");

        finalResult=Double.parseDouble(operants.get(0));
        result.setText(String.valueOf(finalResult));
    }

    private void getAns(String operator) {
        int len = operants.size();
        for (int j = 0;j<len*len;j++){
            for (int i = 0;i<len;i++) {
                if (operants.get(i).equals(operator)) {
                    if (operants.get(i).equals("%")) {
                        finalResult = Double.parseDouble(operants.get(i - 1)) / Double.parseDouble(operants.get(i + 1));
                    } else if (operants.get(i).equals("X")) {
                        finalResult = Double.parseDouble(operants.get(i - 1)) * Double.parseDouble(operants.get(i + 1));
                    } else if (operants.get(i).equals("+")) {
                        finalResult = Double.parseDouble(operants.get(i - 1)) + Double.parseDouble(operants.get(i + 1));
                    } else if (operants.get(i).equals("-")) {
                        finalResult = Double.parseDouble(operants.get(i - 1)) - Double.parseDouble(operants.get(i + 1));
                    }
                    operants.remove(i - 1);
                    operants.add(i-1,String.valueOf(finalResult));
                    operants.remove(i + 1);
                    operants.remove(i);
                    len = len - 2;
                }
            }
        }
    }

}