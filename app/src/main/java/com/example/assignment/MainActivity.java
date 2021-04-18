package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView name;
    private ImageButton plus1;
    private ImageButton plus2;
    private ImageButton minus1;
    private ImageButton minus2;
    private Button order;
    private TextView amount1;
    private TextView amount2;
    private TextView price;
    private TextView price2;
    private int count;
    private int count2;
    private int num1;
    private int num2;
    private String sub;
    private String nam;
    private String donuts;
    private String froy;
    private String all;
    private String exit;

    //Buttons
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.plus1:
                    plus1Count();
                    break;
                case R.id.plus2:
                    plus2Count();
                    break;
                case R.id.minus1:
                    minus1Count();
                    break;
                case R.id.minus2:
                    minus2Count();
                    break;
                case R.id.order:
                    submitOrder();
                    break;
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = findViewById(R.id.name);

        amount1= findViewById(R.id.amount1);
        amount2 = findViewById(R.id.amount2);
        price= findViewById(R.id.price);
        price2 = findViewById(R.id.price2);
        plus2 = findViewById(R.id.plus2);
        plus2.setOnClickListener(clickListener);
        plus1 = findViewById(R.id.plus1);
        plus1.setOnClickListener(clickListener);
        minus2 = findViewById(R.id.minus2);
        minus2.setOnClickListener(clickListener);
        minus1 = findViewById(R.id.minus1);
        minus1.setOnClickListener(clickListener);



        order = findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitOrder();
            }
        });

        Am1();
        Am2();
    }
    private void Am1(){
        count = 1;
        num1 = num1+count*10;
        amount1.setText(""+count);

    }
    private void Am2(){
        count2 = 1;
        num2 = num2+count2*12;
        amount2.setText(""+count2);


    }
    private void plus1Count(){
        count++;
        amount1.setText(""+count);
        num1 = count*10;

    }
    private void plus2Count(){
        count2++;
        amount2.setText(""+count2);
        num2 = count2*12;

    }
    private void minus1Count(){
        count--;
        if (count<1){
            count=1;
        }
        amount1.setText(""+count);


    }
    private void minus2Count(){
        count2--;
        if (count2<1){
            count2=1;
        }
        amount2.setText(""+count2);
    }


    public void submitOrder(){
        sub = "Term 2 Test App order for ";
        nam = "Name: ";
        donuts = "Donuts: ";
        froy = "Froyo: ";
        all = "Total Price: R";
        exit = "Thank you!";

        String subject = sub+name.getText().toString();
        String message = nam+name.getText().toString();
        String message2 = donuts+count;
        String message3 = froy+count2;
        String message4 = all+num1+num2;
        String message5 = exit;
        String messages = message + "\n" + message2 + "\n" + message3 + "\n" + message4 + "\n" + message5;
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, messages);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose Email"));



    }
}
