 package com.example.eyatlig_mesure_de_glycemie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {
    private TextView tvAge;
    private SeekBar sbAge;
    private RadioButton  rbIsFasting,rbIsNotFasting ;
    private EditText etValue;
    private Button btnConsulter ;
    private TextView tvResult ;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            init();
            sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    Log.i("information", "onProgressChanged: "+i);
                    tvAge.setText("Votre Age :" +i);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        }
        private void init(){
            // Initialisez les éléments de l'interface utilisateur.
            tvAge=(TextView)findViewById(R.id.tvage);
            sbAge=(SeekBar)findViewById(R.id.ageSeekBar);
            rbIsFasting=(RadioButton) findViewById(R.id.rbtOui);
            rbIsNotFasting=(RadioButton) findViewById(R.id.rbtnon);
            etValue=(EditText) findViewById(R.id.etValue);
            btnConsulter=(Button) findViewById(R.id.btnConsulter);
            tvResult=(TextView) findViewById(R.id.tvResult);
        }

     public void  Calculer (View v) {
         int age;
         float value;
         boolean verifAge = false;
         boolean verifValue = false;
         String valueString = etValue.getText().toString();
         if (sbAge.getProgress() != 0) {
             verifAge = true;
         } else {
             Toast.makeText(MainActivity.this, "veuillez verifier votre age", Toast.LENGTH_SHORT).show();
         }

         if (!etValue.getText().toString().isEmpty()) {
             verifValue = true;
         } else {
             Toast.makeText(MainActivity.this, "veuillez verifier votre valeur", Toast.LENGTH_LONG).show();
         }
         if(verifAge && verifValue ){
             age=sbAge.getProgress();
             value=Float.valueOf(etValue.getText().toString());
             if(rbIsFasting.isChecked()){
                 if(age>=10){
                     if(value<5.0)
                         tvResult.setText("Le niveau de glycemie est tres bas ");
                     else if (value >=5.0 && value <=7.2)
                         tvResult.setText("Le niveau de glycemie est normal ");
                     else tvResult.setText("Le niveau de glycemie est elevé");
                     if(age >=6 && age <=12)
                         if(value<5.0) tvResult.setText("Le niveau de glycemie est tres bas ");
                         else if (value>=5.0 && value<=10.5) tvResult.setText("Le niveau de glycemie est normal ");
                         else tvResult.setText("Le niveau de glycemie est elevé");
                     else if (value <5.5)  tvResult.setText("Le niveau de glycemie est bas");
                     else if (value>=5.0 && value <=10.0) tvResult.setText("Le niveau de glycemie est normal");
                     else tvResult.setText("Le niveau de glycemie est elevé");
                 }
             } else if (value<10.5) tvResult.setText("Le niveau de glycemie est normal");
             else  tvResult.setText("Le niveau de glycemie est élevé");

         }

     }
     //btnconsulter.setonclickListene(new view.onclickListener{
     //public voidonClick(view v)
     //{calculer(v);}}
        }


