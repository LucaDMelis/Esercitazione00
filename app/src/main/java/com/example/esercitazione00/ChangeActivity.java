/*Luca Danilo Melis 65468*/

package com.example.esercitazione00;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChangeActivity extends AppCompatActivity {

    private TextView username, password;
    private EditText new_pass, confirm_pass;
    private Button home, savebutton;
    private String user, pass, city, dateBirth;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        username = (TextView)findViewById(R.id.ChangeUser);
        password = (TextView)findViewById(R.id.ChangePassword);
        new_pass = (EditText)findViewById(R.id.editNewPass);
        confirm_pass = (EditText)findViewById(R.id.editConfirmPass);
        home = (Button)findViewById(R.id.HomeButton);
        savebutton = (Button)findViewById(R.id.button);

        Intent intent = getIntent();
        user = intent.getStringExtra("USER");
        pass = intent.getStringExtra("PASS");
        city = intent.getStringExtra("CITY");
        dateBirth = intent.getStringExtra("DATE");
        pos = intent.getIntExtra("POS", -1);

        username.setText("Username: "+ user + " " + pos);
        password.setText("Password: "+ pass);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_home = new Intent(ChangeActivity.this, HomeActivity.class);
                intent_home.putExtra("USER", user);
                intent_home.putExtra("PASS", pass);
                intent_home.putExtra("CITY",city);
                intent_home.putExtra("DATE", dateBirth);
                intent_home.putExtra("POS", pos);
                startActivity(intent_home);
            }
        });

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(new_pass.getText() == null || new_pass.getText().length() == 0){
                    new_pass.setError("Password troppo corta");
                }else {
                    if (confirm_pass.getText() == null || confirm_pass.getText().length() == 0) {
                        confirm_pass.setError("Non avete confermato la password");
                    } else {
                        if (new_pass.getText().toString().equals(pass)) {
                            new_pass.setError("Password uguale alla prercedente");
                        } else {
                            if (new_pass.getText().toString().equals(confirm_pass.getText().toString())) {
                                pass = new_pass.getText().toString();
                                password.setText("Password: "+ pass);

                            } else {
                                confirm_pass.setError("La password non corrisponde");
                            }
                        }
                    }
                }
            }
        });
    }
}
