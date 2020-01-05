/*Luca Danilo Melis 65468*/

package com.example.esercitazione00;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    private EditText nameText, passwordText, confirmText, cittaText, birthText;
    private Button saveButton;

    DatePickerFragment datePickerFragment;
    public static final String PERSON_EXTRA = "com.example.esercitazione00.Person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        datePickerFragment = new DatePickerFragment();

        nameText = findViewById(R.id.AttrUserRegister);
        passwordText = findViewById(R.id.AttrPasswordRegister);
        confirmText = findViewById(R.id.AttrConfermRegister);
        cittaText = findViewById(R.id.AttrCittaRegister);
        birthText = findViewById(R.id.AttrDateRegister);
        saveButton = findViewById(R.id.savebutton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkInput()){
                    Intent showResult =new Intent(RegisterActivity.this, MainActivity.class);
                    showResult.putExtra("USER", nameText.getText().toString());
                    showResult.putExtra("PASS", passwordText.getText().toString());
                    showResult.putExtra("CITY", cittaText.getText().toString());
                    showResult.putExtra("DATE", birthText.getText().toString());
                    showResult.putExtra("POS", -1);
                    startActivity(showResult);
                }
            }
        });

        birthText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });

        birthText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    datePickerFragment.show(getSupportFragmentManager(), "dataPicker");
                }
            }
        });

        datePickerFragment.setOnDatePickerFragmentChanged(new DatePickerFragment.DatePickerFragmentListener() {
            @Override
            public void onDatePickerFragmentOkButton(DialogFragment dialog, Calendar date) {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                birthText.setText(format.format(date.getTime()));
            }

            @Override
            public void onDatePickerFragmentCancelButton(DialogFragment dialog) {

            }
        });
    }

    private boolean checkInput() {
        int errors = 0;

        if (nameText.getText() == null || nameText.getText().length() == 0) {
            nameText.setError("Inserire un Username");
            errors++;
        } else {
            nameText.setError(null);
        }

        if(passwordText.getText() == null || passwordText.getText().length() == 0){
            passwordText.setError("Inserire la password di accesso");
            errors++;
        } else{
           passwordText.setError(null);
        }

        if(confirmText.getText() == null || confirmText.getText().length() == 0){
            confirmText.setError("Conferma la password");
            errors++;
        } else{
            if (passwordText.getText().toString().equals(confirmText.getText().toString())) {
                passwordText.setError(null);
                confirmText.setError(null);
            }else{
                passwordText.setError("La password non corrisponde");
                confirmText.setError("La password non corrisponde");
                errors++;
            }
        }
        if(cittaText.getText() == null || cittaText.getText().length() == 0){
            cittaText.setError("Inserire la città di provenienza");
            errors++;
        } else{
            cittaText.setError(null);
        }

        if(birthText.getText() == null || birthText.getText().length() == 0){
            birthText.setError("Inserire una data di nascita");
            errors++;
        } else{
            birthText.setError(null);
        }

        return errors == 0;
    }
}

