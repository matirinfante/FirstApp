package com.example.matirinfante.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getSimpleName();
    TextView textoContador = (TextView) findViewById(R.id.contador);
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "Creando el URI...");
    }

    public void mensaje(View v){
        Log.d(TAG, "MENSAJE "+this.i);
        this.i++;
        textoContador.setText(Integer.toString(i));
    }

}
