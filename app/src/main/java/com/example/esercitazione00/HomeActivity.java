/*Luca Danilo Melis 65468*/

package com.example.esercitazione00;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView username, date, password, citta, change, title;
    private Button logout;
    private String user, pass, city, dateBirth;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        title = (TextView) findViewById(R.id.TitleHomeC);
        username = (TextView)findViewById(R.id.HomeUsername);
        date = (TextView)findViewById(R.id.HomeDate);
        password = (TextView)findViewById(R.id.HomePassword);
        citta = (TextView)findViewById(R.id.HomeCitta);
        logout = (Button)findViewById(R.id.HomeLogout);
        change = (TextView)findViewById(R.id.HomeChange);

        Intent intent = getIntent();
        user = intent.getStringExtra("USER");
        pass = intent.getStringExtra("PASS");
        city = intent.getStringExtra("CITY");
        dateBirth = intent.getStringExtra("DATE");
        pos = intent.getIntExtra("POS", -1);

        title.setText("Benvenuto " + user +"!");
        username.setText("Username: " + user);
        date.setText("Data di nascita:  "+ dateBirth);
        citta.setText("Citta:   "+ city);
        password.setText("Password: " + pass);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homereturn = new Intent(HomeActivity.this, MainActivity.class);
                homereturn.putExtra("USER", user);
                homereturn.putExtra("PASS", pass);
                homereturn.putExtra("CITY",city);
                homereturn.putExtra("DATE", dateBirth);
                homereturn.putExtra("POS", pos);
                startActivity(homereturn);
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent change_pass = new Intent(HomeActivity.this, ChangeActivity.class);
                change_pass.putExtra("USER", user);
                change_pass.putExtra("PASS", pass);
                change_pass.putExtra("CITY",city);
                change_pass.putExtra("DATE", dateBirth);
                change_pass.putExtra("POS", pos);
                startActivity(change_pass);
            }
        });

    }
}
