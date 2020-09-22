package com.alejandro.actividad_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int dia, mes, ano;
    TextInputEditText datpic,valorName,valorPhone,valorMail,valorDescrip;
    Button boton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datpic = (TextInputEditText) findViewById(R.id.datpic);
        boton = (Button) findViewById(R.id.boton);
        valorName = (TextInputEditText) findViewById(R.id.name);
        valorPhone = (TextInputEditText) findViewById(R.id.phone);
        valorMail = (TextInputEditText) findViewById(R.id.mail);
        valorDescrip = (TextInputEditText) findViewById(R.id.descrip);


        datpic.setOnClickListener(this);
        boton.setOnClickListener(n_window);

    }

    @Override
    public void onClick(View v) {
        if (v == datpic) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int mon, int day) {
                    datpic.setText(day + "/" + (mon + 1) + "/" + year);
                }
            }
                    , dia, mes, ano);
            datePickerDialog.show();
        }


    }

    private View.OnClickListener n_window = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

             Intent intent = new Intent(MainActivity.this, DetallContacActivity.class);
             intent.putExtra("nom", valorName.getText().toString());
             intent.putExtra("birth",datpic.getText().toString());
             intent.putExtra("phon",valorPhone.getText().toString());
             intent.putExtra("mai",valorMail.getText().toString());
             intent.putExtra("desc",valorDescrip.getText().toString());

             startActivity(intent);


        }

    };
}






