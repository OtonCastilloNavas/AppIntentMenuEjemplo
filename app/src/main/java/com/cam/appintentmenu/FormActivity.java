package com.cam.appintentmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }

    public void onClick(View v)
    {
        EditText etNombre=findViewById(R.id.etNombre);
        Intent intent = new Intent();
        intent.putExtra("res",etNombre.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
}
