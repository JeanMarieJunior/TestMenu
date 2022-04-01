package com.example.dialogbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gestionClick(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Avertissement");
        builder.setMessage("Vpulez-vous continuer ?");
        builder.setIcon(R.drawable.ic_warning);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}