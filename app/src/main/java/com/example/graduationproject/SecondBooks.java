package com.example.graduationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SecondBooks  {

    int    imag_book3;
    String name_book3;
    String auther_book3;
    Float rating3;

    public SecondBooks(int imag_book3, String name_book3, String auther_book3, Float rating3) {
        this.imag_book3 = imag_book3;
        this.name_book3 = name_book3;
        this.auther_book3 = auther_book3;
        this.rating3 = rating3;
    }

    public int getImag_book3() {
        return imag_book3;
    }

    public String getName_book3() {
        return name_book3;
    }

    public String getAuther_book3() {
        return auther_book3;
    }

    public Float getRating3() {
        return rating3;
    }
}