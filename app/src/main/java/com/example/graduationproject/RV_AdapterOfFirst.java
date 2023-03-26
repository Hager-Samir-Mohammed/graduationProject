package com.example.graduationproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RV_AdapterOfFirst extends RecyclerView.Adapter<RV_AdapterOfFirst.Book2ViewHolder>
{
    private List<FirstBooks> booksList2;

    public RV_AdapterOfFirst (List<FirstBooks>booksList2)
    {
        this.booksList2 = booksList2;
    }
    @NonNull
    @Override
    public Book2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_first_books, parent , false);
        return new Book2ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Book2ViewHolder holder, int position)
    {

        holder.Img.setImageResource(booksList2.get(position).getImag_book2());
        holder.tv1.setText(booksList2.get(position).getName_book());
        holder.tv2.setText(booksList2.get(position).getAuther_book());
//        holder.ratingBar.setRating(booksList2.get(position).getRating());

    }

    @Override
    public int getItemCount() {
        return booksList2.size();
    }

    public class Book2ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView Img;
        private TextView tv1;
        private TextView tv2;
//        private RatingBar ratingBar;

        public Book2ViewHolder(@NonNull View itemView) {
            super(itemView);

            Img       = itemView.findViewById(R.id.book4);
            tv1       = itemView.findViewById(R.id.textView);
            tv2       = itemView.findViewById(R.id.textView2);
//            ratingBar = itemView.findViewById(R.id.ratingBar);

        }

    }
}
