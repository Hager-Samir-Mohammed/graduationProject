package com.example.graduationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FirstBooks extends AppCompatActivity {

    int    imag_book2;
    String name_book;
    String auther_book;
    Float rating;

    public FirstBooks(int imag_book2, String name_book, String auther_book, Float rating) {
        this.imag_book2 = imag_book2;
        this.name_book = name_book;
        this.auther_book = auther_book;
        this.rating = rating;
    }

    public int getImag_book2() {
        return imag_book2;
    }

    public String getName_book() {
        return name_book;
    }

    public String getAuther_book() {
        return auther_book;
    }

    public Float getRating() {
        return rating;
    }
}