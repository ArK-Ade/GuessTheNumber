package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random r = new Random();
        int i1 = r.nextInt(100 - 0);

        ConstraintLayout Layout =  (ConstraintLayout) findViewById(R.id.layout);
        TextView viewText = (TextView) this.findViewById(R.id.texte);
        EditText edit = (EditText) this.findViewById(R.id.Resultat);
        Button button = (Button) this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //button.setText(String.valueOf(i1));
                String choice = (String) edit.getText().toString();
                Check(i1,Integer.parseInt(choice),viewText);
            }
        });
    }

    public void Check(int random, int choice, TextView edit){
        if(choice > random)
        {
            edit.setText(R.string.greater);
        }else if (choice < random){
            edit.setText(R.string.lesser);
        }else{
            edit.setText(R.string.goodNumber);
        }
    }
}