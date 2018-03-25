package org.d3ifcool.halojantung;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class JadwalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);

        ArrayList<Jadwal> jadwal = new ArrayList<>();
        jadwal.add(new Jadwal(R.drawable.pagi,"Pagi", ""));
        jadwal.add(new Jadwal(R.drawable.siang,"Siang", ""));
        jadwal.add(new Jadwal(R.drawable.sore,"Sore", ""));

        JadwalAdapter jadwalAdapter = new JadwalAdapter(this, jadwal);
        ListView listView = findViewById(R.id.listjadwal);
        listView.setAdapter(jadwalAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Intent jadwal_pagi = new Intent(JadwalActivity.this, AlarmActivity.class);
                    startActivity(jadwal_pagi);

                }


            }
        }

        );
    }



}
