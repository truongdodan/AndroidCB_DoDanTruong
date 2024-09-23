package com.example.thuchanh_gui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bai4 extends AppCompatActivity {
    private EditText ten, chieuCao, canNang, bmiEdTxt, chuanDoanEdTxt;
    private Button tinhBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ten = (EditText) findViewById(R.id.tenTxt);
        chieuCao = (EditText) findViewById(R.id.chieuCaoTxt);
        canNang = (EditText) findViewById(R.id.canNangTxt);
        bmiEdTxt = (EditText) findViewById(R.id.bmiTxt);
        chuanDoanEdTxt = (EditText) findViewById(R.id.chuanDoanTxt);
        tinhBtn = (Button) findViewById(R.id.tinhBtn);

        tinhBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double bmi;
                String chuanDoan;

                bmi = calBMI(Double.parseDouble(canNang.getText().toString()), Double.parseDouble(chieuCao.getText().toString()));
                chuanDoan = dianose(bmi);

                bmiEdTxt.setText(bmi.toString());
                chuanDoanEdTxt.setText(chuanDoan);
            }
        });

    }

    private double calBMI(double weight, double height) {
        return weight / (height*height);
    }

    private String dianose(double bmi) {
        String result = "";
        if(bmi < 18) result = "Ban gay";
        else if (bmi <= 24.9) result = "Ban binh thuong";
        else if (bmi <= 29.9) result = "Ban bi beo phi cap do I";
        else if (bmi <= 34.9) result = "Ban bi beo phi cap do II";
        else result = "Ban bi beo phi cap do III";

        return result;
    }
}