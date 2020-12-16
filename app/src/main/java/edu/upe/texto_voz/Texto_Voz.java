package edu.upe.texto_voz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Texto_Voz extends AppCompatActivity {
    Button btnreconocer;
    EditText editText;
    ttVozManager ttVozManager=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto__voz);

        ttVozManager=new ttVozManager();
        ttVozManager.init(this);
        editText=findViewById(R.id.edtInput);
        btnreconocer=findViewById(R.id.btnReconocer);
        btnreconocer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto=editText.getText().toString();
                ttVozManager.iniciarCola(texto);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttVozManager.apagar();
    }
}