package com.example.thuchanh_gui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bai1 extends AppCompatActivity {
    private EditText soA, soB;
    private Button congBtn, truBtn, nhanBtn, chiaBtn, gCD, exitBtn;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        soA = (EditText) findViewById(R.id.soATxt);
        soB = (EditText) findViewById(R.id.soBTxt);
        result = (TextView) findViewById(R.id.ketQuaTxt);
        congBtn = (Button) findViewById(R.id.tongBtn);
        truBtn = (Button) findViewById(R.id.hieuBtn);
        nhanBtn = (Button) findViewById(R.id.tichBtn);
        chiaBtn = (Button) findViewById(R.id.thuongBtn);
        gCD = (Button) findViewById(R.id.uocChungLonNhatBtn);
        exitBtn = (Button) findViewById(R.id.thoatBtn);

        congBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("Ket qua: " + addNumber(Double.parseDouble(soA.getText().toString()), Double.parseDouble(soB.getText().toString())));
            }
        });

        truBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("Ket qua: " + subNumber(Double.parseDouble(soA.getText().toString()), Double.parseDouble(soB.getText().toString())));
            }
        });

        nhanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("Ket qua: " + mulNumber(Double.parseDouble(soA.getText().toString()), Double.parseDouble(soB.getText().toString())));
            }
        });

        chiaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("Ket qua: " + divNumber(Double.parseDouble(soA.getText().toString()), Double.parseDouble(soB.getText().toString())));
            }
        });

        gCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("Ket qua: " + GCD(Double.parseDouble(soA.getText().toString()), Double.parseDouble(soB.getText().toString())));
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
    private double addNumber(double num1, double num2) {
        return num1 + num2;
    }
    private double subNumber(double num1, double num2) {
        return num1 - num2;
    }
    private double mulNumber(double num1, double num2) {
        return num1 * num2;
    }
    private double divNumber(double num1, double num2) {
        return num1 / num2;
    }
    private double GCD(double num1, double num2) {
        double a = num1, b = num2;
        if(num1 == 0 || num2 == 0) {
            return a+b;
        }
        while (a != b) {
            if(a > b) a-=b;
            else b-=a;
        }

        return a;
    }
}