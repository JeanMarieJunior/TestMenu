package com.example.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    TextView tbResultat;
    Button bt7, bt8, bt9,bt4,bt5,bt6,bt1,bt2,bt3,bt0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tbResultat = findViewById(R.id.TbResultat);
        bt7 =findViewById(R.id.bt7) ;
        bt7.setOnClickListener(this);
        bt8 =findViewById(R.id.bt8) ;
        bt8.setOnClickListener(this);
        bt9 =findViewById(R.id.bt9) ;
        bt9.setOnClickListener(this);
        bt4 =findViewById(R.id.bt4) ;
        bt4.setOnClickListener(this);
        bt5 =findViewById(R.id.bt5) ;
        bt5.setOnClickListener(this);
        bt6 =findViewById(R.id.bt6) ;
        bt6.setOnClickListener(this);
        bt1 =findViewById(R.id.bt1) ;
        bt1.setOnClickListener(this);
        bt2 =findViewById(R.id.bt2) ;
        bt2.setOnClickListener(this);
        bt3 =findViewById(R.id.bt3) ;
        bt3.setOnClickListener(this);
        bt0 =findViewById(R.id.bt0) ;
        bt0.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        tbResultat.setText("");
        switch ( v.getId()){
            case R.id.bt1:
                tbResultat.setText("Pourquoi tu n'affiches rien ?");
                break ;
            case R.id.bt7:
                tbResultat.setText("Pourquoi tu n'affiches rien ?");
                break ;
            default:
                break;
        }
    }
}