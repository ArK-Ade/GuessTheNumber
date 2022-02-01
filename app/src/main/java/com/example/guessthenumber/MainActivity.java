package com.example.guessthenumber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random r = new Random();
        int i1 = r.nextInt(100);

        //ConstraintLayout Layout =  (ConstraintLayout) findViewById(R.id.layout);
        TextView viewText = this.findViewById(R.id.texte);
        EditText edit = this.findViewById(R.id.Resultat);
        Button button = this.findViewById(R.id.button);
        Button recommencer = this.findViewById(R.id.button2);
        Button quitter = this.findViewById(R.id.button3);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //button.setText(String.valueOf(i1));
                String choice = edit.getText().toString();
                Check(i1, Integer.parseInt(choice), viewText, recommencer, quitter);
            }
        });

        recommencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());

            }
        });

        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void Check(int random, int choice, TextView edit, Button recommencer, Button quitter){
        if(choice > random)
        {
            edit.setText(R.string.greater);
        }else if (choice < random){
            edit.setText(R.string.lesser);
        }else{
            edit.setText(R.string.goodNumber);
            recommencer.setVisibility(View.VISIBLE);
            quitter.setVisibility(View.VISIBLE);
        }
    }
}