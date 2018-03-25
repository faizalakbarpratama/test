package org.d3ifcool.halojantung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Halo_Jantung extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halo_jantung);
        Button login = (Button)findViewById(R.id.Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Halo_Jantung.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        Button Register = (Button)findViewById(R.id.register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Halo_Jantung.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}

