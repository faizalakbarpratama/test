package org.d3ifcool.halojantung;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by copo on 3/9/2018.
 */

public class JadwalAdapter extends ArrayAdapter <Jadwal> {
    public JadwalAdapter(@NonNull Context context, @NonNull List<Jadwal> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Jadwal currentJadwal = getItem(position);

        TextView Waktu = (TextView) listItemView.findViewById(R.id.waktualarm);
        Waktu.setText(currentJadwal.getWaktuAlarm());

        TextView Saran = (TextView) listItemView.findViewById(R.id.saran);
        Saran.setText(currentJadwal.getSaran());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this word or not
        if (currentJadwal.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentJadwal.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }
        return listItemView;
    }

}
