package com.cam.appintentmenu;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class RegistroActivity extends AppCompatActivity {

    private static int NUEVO=7987;
    private List<String> nombreList= new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Spinner spNombres= findViewById(R.id.spNombres);
        adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        nombreList);
        spNombres.setAdapter(adapter);
    }

    public  void onClick(View v)
    {
        Intent intent = new Intent(this,FormActivity.class);
        startActivityForResult(intent,NUEVO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==NUEVO)
        {
            if(resultCode==RESULT_OK)
            {
                Bundle extra= data.getExtras();
                if(extra!=null)
                {
                 String valor = extra.getString("res");
                 nombreList.add(valor);
                 adapter.notifyDataSetChanged();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
