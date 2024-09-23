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

public class Bai2 extends AppCompatActivity {
    private EditText cel, fah;
    private Button toCel, toFah, clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        cel = (EditText) findViewById(R.id.txtCel);
        fah = (EditText) findViewById(R.id.txtFah);

        toCel = (Button) findViewById(R.id.toCBtn);
        toFah = (Button) findViewById(R.id.toFBtn);
        clear = (Button) findViewById(R.id.clearBtn);

        toCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double newCel = toCel(Double.parseDouble(fah.getText().toString()));

                cel.setText(newCel.toString());
            }
        });

        toFah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double newFah = toFah(Double.parseDouble(cel.getText().toString()));

                fah.setText(newFah.toString());
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fah.setText("");
                cel.setText("");
            }
        });

    }

    private double toCel(double fah) {
        return (fah - 32) * 5/9;
    }

    private double toFah(double cel) {
        return (cel * (9/5)) + 32;
    }
}