package com.example.caste.expcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int[][] matrice = new int[][] {
            {25,50,75,100},
            {50,100,150,200},
            {75,150,225,400},
            {125,250,375,500},
            {250,500,750,1100},
            {300,600,900,1400},
            {350,750,1100,1700},
            {450,900,1400,2100},
            {550,1100,1600,2400},
            {600,1200,1900,2800},
            {800,1600,2400,3600},
            {1000,2000,3000,4500},
            {1100,2200,3400,5100},
            {1250,2500,3800,5700},
            {1400,2800,4300,6400},
            {1600,3200,4800,7200},
            {2000,3900,5900,8800},
            {2100,4200,6300,9500},
            {2400,4900,7300,10900},
            {2800,5700,8500,12700}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

        public void pressMe(View view) {

            //Values dell'Activity
            EditText numero = findViewById(R.id.numeroPg);
            EditText livello = findViewById(R.id.livelloPg);
            TextView facile = findViewById(R.id.easyChallenge);
            TextView medio = findViewById(R.id.mediumChallenge);
            TextView difficile = findViewById(R.id.hardChallenge);
            TextView mortale = findViewById(R.id.deadlyChallenge);

            //Parsing dei dati
            int numeroParsed = 0;
            int livelloParsed = 0;
            try {
                numeroParsed = Integer.parseInt(numero.getText().toString());
                livelloParsed = Integer.parseInt(livello.getText().toString());
                boolean check = (numeroParsed > 0) && (livelloParsed <= 20) && (livelloParsed > 0);

                if (check) {
                    facile.setText(Integer.toString(numeroParsed * matrice[(livelloParsed - 1)][0]));
                    medio.setText(Integer.toString(numeroParsed * matrice[(livelloParsed - 1)][1]));
                    difficile.setText(Integer.toString(numeroParsed * matrice[(livelloParsed - 1)][2]));
                    mortale.setText(Integer.toString(numeroParsed * matrice[(livelloParsed - 1)][3]));
                } else
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Invalid input!", Toast.LENGTH_SHORT).show();
            }
        }
        
}
