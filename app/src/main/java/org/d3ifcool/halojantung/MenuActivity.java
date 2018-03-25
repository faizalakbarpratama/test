
package org.d3ifcool.halojantung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity  {

    private FirebaseAuth firebaseAuth;
    private Button ButtonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageButton sidikjari = (ImageButton)findViewById(R.id.sidikjari);
        sidikjari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, FingerprintActivity.class);
                startActivity(intent);
            }
        });

        Button jadwal = (Button)findViewById(R.id.jadwal);
        jadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, JadwalActivity.class);
                startActivity(intent);
            }
        });
    }
}
