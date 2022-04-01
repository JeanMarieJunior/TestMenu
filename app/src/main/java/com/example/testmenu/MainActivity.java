package com.example.testmenu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   Context context ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this ;

        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context ,"Le test a effectivement réussi", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void gestionClick(View view){

        DialogFragment dialogFragment = new ChoixDate();
        dialogFragment.show(getSupportFragmentManager(),"Choix_date");
    }
}