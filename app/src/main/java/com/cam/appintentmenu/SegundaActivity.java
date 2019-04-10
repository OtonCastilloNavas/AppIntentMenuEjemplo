package com.cam.appintentmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        
        //getIntent().getStringExtra("valor");
        //getIntent().getExtras().getString("valor");
        Bundle extras=getIntent().getExtras();
        String valor = null;
        if(extras!=null)
        {
            valor= extras.getString("valor");
        }
        TextView tvMensaje= findViewById(R.id.tvMensaje);
        tvMensaje.setText(valor);

        Button btAceptar= findViewById(R.id.btAceptar);
        btAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("mensaje",
                        "Cerrado");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
