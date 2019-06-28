package com.idw.project.moviecataloguesub2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Tvshow implements Parcelable {
    private int poster;
    private String judul;
    private  String deskripsi;
    private  String tanggalRilis;

    public Tvshow() {
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTanggalRilis() {
        return tanggalRilis;
    }

    public void setTanggalRilis(String tanggalRilis) {
        this.tanggalRilis = tanggalRilis;
    }

    protected Tvshow(Parcel in) {
        poster = in.readInt();
        judul = in.readString();
        deskripsi = in.readString();
        tanggalRilis = in.readString();
    }

    public static final Creator<Tvshow> CREATOR = new Creator<Tvshow>() {
        @Override
        public Tvshow createFromParcel(Parcel in) {
            return new Tvshow(in);
        }

        @Override
        public Tvshow[] newArray(int size) {
            return new Tvshow[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(poster);
        dest.writeString(judul);
        dest.writeString(deskripsi);
        dest.writeString(tanggalRilis);
    }
}
