package com.example.matirinfante.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getSimpleName();
    TextView textoContador, textoSeekBar;
    SeekBar slider;
    int i = 0, progresoSeekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Logcat msg
        Log.d(TAG, "Creando el URI...");

        //Inicializa componentes
        textoContador = findViewById(R.id.contador);
        slider = findViewById(R.id.seekBar2);

        //SEEKBAR CODE
        progresoSeekBar = slider.getProgress();
        textoSeekBar = findViewById(R.id.seekBarText);
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Este metodo permite realizar cambios a medida que el usuario interactúa el seekBar.
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                textoSeekBar.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void mensaje(View v){
        //Method invoked by button onPress
        //Logcat de joda, itera contador de clicks
        Log.d(TAG, "MENSAJE "+this.i);
        this.i++;
        textoContador.setText(Integer.toString(i));
    }

}
