package com.alejandro.actividad_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.*;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import static android.content.Intent.*;

import androidx.appcompat.app.AppCompatActivity;


public class DetallContacActivity extends AppCompatActivity {
    TextView editName,editBirth,editPhone,editMail,editDescrip;
    Button editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detall_contac);

        editButton = (Button) findViewById(R.id.editbutton);
        editName = (TextView) findViewById(R.id.editName);
        editBirth = (TextView)findViewById(R.id.editBirth);
        editPhone = (TextView) findViewById(R.id.editPhone);
        editMail = (TextView) findViewById(R.id.editMail);
        editDescrip = (TextView) findViewById(R.id.editDescrip);


        Bundle parametros = getIntent().getExtras();
        String valorn = parametros.getString("nom");
        String valorb = parametros.getString("birth");
        String valorp = parametros.getString("phon");
        String valorm = parametros.getString("mai");
        String valord = parametros.getString("desc");



        editName.setText("Nombre: " + valorn);
        editBirth.setText("Fecha de Nacimiento: " + valorb);
        editPhone.setText("Tel. " + valorp);
        editMail.setText("Email: " + valorm);
        editDescrip.setText("Descripcion: " + valord);

        editButton.setOnClickListener(back);
    }

    private View.OnClickListener back = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            onBackPressed();
        }

     };
}


