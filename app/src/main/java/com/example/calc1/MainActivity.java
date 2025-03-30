package com.example.calc1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import  androidx.core.view.ViewCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void calc(char t)
    {
        TextView tv = (TextView)findViewById(R.id.tv3);
        tv.setText("Valor final:");


        EditText ndinp1 = (EditText)findViewById(R.id.ed1);
        EditText ndinp2 = (EditText)findViewById(R.id.ed2);


        if(ndinp1.getText().toString().matches(""))
        {
            return;
        }

        if(ndinp2.getText().toString().matches(""))
        {
            return;
        }

        double val1 = Double.parseDouble(ndinp1.getText().toString());
        double val2 = Double.parseDouble(ndinp2.getText().toString());
        boolean zero_div = false;
        double val3 = 0;
        switch (t)
        {
            case('+'):
            {
                val3= val1+val2;
                break;
            }

            case('-'):
            {
                val3= val1-val2;
                break;
            }

            case('*'):
            {
                val3= val1*val2;
                break;
            }

            case('/'):
            {
                if(val2==0)
                {
                    zero_div=true;
                    break;

                }
                val3= val1/val2;
                break;
            }


        }

        if(!zero_div)
        {

            String st = tv.getText().toString();
            tv.setText("Valor final:" + String.valueOf(val3));
        }





    }

    public void btn_click_1(View view)
    {
        calc('+');
    }

    public void btn_click_2(View view)
    {
        calc('-');
    }

    public void btn_click_3(View view)
    {
        calc('*');
    }

    public void btn_click_4(View view)
    {
        calc('/');
    }



}