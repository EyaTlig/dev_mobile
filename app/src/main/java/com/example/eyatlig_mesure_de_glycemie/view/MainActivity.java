package com.example.eyatlig_mesure_de_glycemie.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eyatlig_mesure_de_glycemie.R;
import com.example.eyatlig_mesure_de_glycemie.controller.Controller;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 1;
    private TextView tvAge;
    private SeekBar sbAge;
    private RadioButton rbIsFasting, rbIsNotFasting;
    private EditText etValue;
    private Button btnConsulter;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("information", "onProgressChanged: " + progress);
                tvAge.setText("Votre Age :" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age;
                float value;
                boolean verifAge = false;
                boolean verifValue = false;

                if (sbAge.getProgress() != 0) {
                    verifAge = true;
                } else {
                    Toast.makeText(MainActivity.this, "Veuillez vérifier votre âge", Toast.LENGTH_SHORT).show();
                }

                if (!etValue.getText().toString().isEmpty()) {
                    verifValue = true;
                } else {
                    Toast.makeText(MainActivity.this, "Veuillez vérifier votre valeur", Toast.LENGTH_LONG).show();
                }

                if (verifAge && verifValue) {
                    age = sbAge.getProgress();
                    value = Float.valueOf(etValue.getText().toString());
                    controller.createPatient(age, value, rbIsFasting.isChecked());

                    Intent intent = new Intent(MainActivity.this, consultActivity.class);
                    intent.putExtra("reponse", controller.getResult());
                    startActivityForResult(intent, REQUEST_CODE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "System Erreur", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void init() {
        tvAge = findViewById(R.id.tvage);
        sbAge = findViewById(R.id.ageSeekBar);
        rbIsFasting = findViewById(R.id.rbtOui);
        rbIsNotFasting = findViewById(R.id.rbtnon);
        etValue = findViewById(R.id.etValue);
        btnConsulter = findViewById(R.id.btnConsulter);
        controller = Controller.getInstance();
    }

    public void Calculer(View v) {
        int age;
        float value;
        boolean verifAge = false;
        boolean verifValue = false;
        String valueString = etValue.getText().toString();
        if (sbAge.getProgress() != 0) {
            verifAge = true;
        } else {
            Toast.makeText(MainActivity.this, "Veuillez vérifier votre âge", Toast.LENGTH_SHORT).show();
        }

        if (!etValue.getText().toString().isEmpty()) {
            verifValue = true;
        } else {
            Toast.makeText(MainActivity.this, "Veuillez vérifier votre valeur", Toast.LENGTH_LONG).show();
        }

        if (verifAge && verifValue) {
            age = sbAge.getProgress();
            value = Float.valueOf(etValue.getText().toString());
        }
    }
}
