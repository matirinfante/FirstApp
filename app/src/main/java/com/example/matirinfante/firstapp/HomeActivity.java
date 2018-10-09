package com.example.matirinfante.firstapp;



import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getSimpleName();
    TextView textoContador, textoSeekBar;
    Button botonColoreado, botonContador;
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
        botonColoreado = findViewById(R.id.btnColor);
        botonContador = findViewById(R.id.apretame);
        //SEEKBAR CODE
        progresoSeekBar = slider.getProgress();
        textoSeekBar = findViewById(R.id.seekBarText);
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Este metodo permite realizar cambios a medida que el usuario interactúa el seekBar.
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                textoSeekBar.setText(String.valueOf(progress));
                if(progress >= 0 && progress <= 20) {
                    botonColoreado.setBackgroundColor(0xFF00ff00);
                } else if(progress > 20 && progress <= 40){
                    botonColoreado.setBackgroundColor(0xFF00e500);
                } else if(progress > 40 && progress <= 60){
                    botonColoreado.setBackgroundColor(0xFF00cc00);
                } else if(progress > 60 && progress <= 80){
                    botonColoreado.setBackgroundColor(0xFF00b200);
                } else {
                    botonColoreado.setBackgroundColor(0xFF009900);
                }
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

        //AlertDialog when opening
        DialogFragment bienvenida = new WelcomeDialog();
        bienvenida.show(getSupportFragmentManager(),"initDialog");
    }

    public void mensaje(View v){
        //Method invoked by button onPress
        //Logcat de joda, itera contador de clicks
        Log.d(TAG, "MENSAJE "+this.i);
        this.i++;
        textoContador.setText(Integer.toString(i));
        if(this.i % 10 == 0){
            //When the button gets clicked a number of times multiple of 10, it gets disabled and a Toast notification appears.
            botonContador.setEnabled(false);
            CharSequence avisoMultiplo = "La cantidad de veces que presionó el botón es múltiplo de 10!";
            Toast toast = Toast.makeText(this.getApplicationContext(), avisoMultiplo, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void habilitarBoton(View v) {
        //Enables the button if its disabled.
        CheckBox habilitarBoton = (CheckBox)v;
        if(habilitarBoton.isChecked()){
            botonContador.setEnabled(true);
            habilitarBoton.setChecked(false);
        }
    }

}

