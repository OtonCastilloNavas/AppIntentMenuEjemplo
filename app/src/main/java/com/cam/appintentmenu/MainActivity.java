package com.cam.appintentmenu;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textview1);
        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.mnMensaje:
                Toast.makeText(this, "Manda Mensaje", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnNuevo:
                EditText etMensaje= findViewById(R.id.etMensaje);
                Intent intent = new Intent(MainActivity.this,
                        SegundaActivity.class);
                    intent.putExtra("valor",
                            etMensaje.getText().toString());
               // startActivity(intent);
                startActivityForResult(intent,2545);
                //Toast.makeText(this, "Hace un nuevo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnHora:
         //       startActivityForResult(intent,1475);
                Intent intent1 = new Intent(this
                        ,SegundaActivity.class);
                startActivityForResult(intent1,4444);
                //Toast.makeText(this, "Son las 4pm", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnExt:
                Toast.makeText(this, "Menu extensivo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnOp1:
                Toast.makeText(this, "Opcion 01", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnOp2:
                Toast.makeText(this, "Opcion 02", Toast.LENGTH_SHORT).show();
                break;
        }
        //Toast.makeText(this, "Saludos", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //requestCode numero de invocacion
        //resultCode numero de respuesta

        if(requestCode==2545)
        {
            if(resultCode==RESULT_OK)
                Toast.makeText(this,
                        "Regreso bien", Toast.LENGTH_SHORT).show();
            else if(resultCode==RESULT_CANCELED)
                Toast.makeText(this,
                        "Regreso mal", Toast.LENGTH_SHORT).show();
        }
        else if(requestCode==4444)
        {
            if(resultCode==RESULT_CANCELED)
            {
                Toast.makeText(this, "no regreso",
                        Toast.LENGTH_SHORT).show();
            }
            else if(resultCode==RESULT_OK)
            {
                Bundle extra = data.getExtras();
                if(extra!=null)
                {
                    String mensaje= extra.getString("mensaje");
                    Toast.makeText(this, mensaje
                            , Toast.LENGTH_SHORT).show();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextual,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this, "Menu contextual", Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item);
    }
}
