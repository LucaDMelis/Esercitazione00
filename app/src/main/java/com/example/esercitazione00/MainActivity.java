/*Luca Danilo Melis 65468*/

package com.example.esercitazione00;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button accedi;
    private TextView registrazione;
    private Person person;
    private String user, pass, city, date;
    static public ArrayList<Person> utenti = new ArrayList<>();
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.attrUsername);
        password = (EditText)findViewById(R.id.attrPassword);
        accedi = (Button)findViewById(R.id.Accedibutton);
        registrazione = (TextView)findViewById(R.id.Registrazione);

        Intent intent = getIntent();
        user = intent.getStringExtra("USER");
        pass = intent.getStringExtra("PASS");
        city = intent.getStringExtra("CITY");
        date = intent.getStringExtra("DATE");
        position = intent.getIntExtra("POS", -1);

        if(user != null){
            if(position == -1)
                utenti.add(new Person(user, pass, city, date));
            else
                utenti.set(position, new Person(user, pass, city, date));
        }


        accedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(), password.getText().toString());
            }
        });

        registrazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void validate (String name , String pass){

            if(check(name, pass) !=  -1){
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("USER", user);
                intent.putExtra("PASS", pass);
                intent.putExtra("CITY",city);
                intent.putExtra("DATE", date);
                intent.putExtra("POS", check(name, pass));
                startActivity(intent);
            } else {
            username.setError("Username non trovato");
            password.setError("Password errata");
        }
    }

    private int check(String name, String pass){

        for (int i = 0; i < utenti.size(); i++){
            if(name.equals(utenti.get(i).getName()) && pass.equals(utenti.get(i).getPassword()))
                return i;
        }
        return -1;
    }
}
