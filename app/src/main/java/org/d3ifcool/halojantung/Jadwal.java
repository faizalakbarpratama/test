package org.d3ifcool.halojantung;

/**
 * Created by copo on 3/5/2018.
 */

public class Jadwal {
    private int ImageResourceId = NO_IMAGE_PROVIDED;
    private String WaktuAlarm, Saran;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Jadwal(int imageResourceId, String waktuAlarm, String saran) {
        ImageResourceId = imageResourceId;
        WaktuAlarm = waktuAlarm;
        Saran = saran;
    }

    public int getImageResourceId() {
        return ImageResourceId;
    }

    public boolean hasImage(){
        return ImageResourceId != NO_IMAGE_PROVIDED;
    }

    public String getWaktuAlarm() {
        return WaktuAlarm;
    }

    public String getSaran() {
        return Saran;
    }
}
