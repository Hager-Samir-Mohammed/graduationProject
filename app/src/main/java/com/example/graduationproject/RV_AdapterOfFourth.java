package com.example.graduationproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RV_AdapterOfFourth extends RecyclerView.Adapter<RV_AdapterOfFourth.Book3ViewHolder>
{
    private List<FourthBooks> bookList4;

    public RV_AdapterOfFourth(List<FourthBooks>bookList4){this.bookList4 = bookList4;}

    @NonNull
    @Override
    public Book3ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_fourth_books , parent ,false);
        return new Book3ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Book3ViewHolder holder, int position)
    {
        holder.Img.setImageResource(bookList4.get(position).getImag_book3());
        holder.tv1.setText(bookList4.get(position).getName_book3());
        holder.tv2.setText(bookList4.get(position).getAuther_book3());
//        holder.ratingBar.setRating(bookList3_3.get(position).getRating3());

    }

    @Override
    public int getItemCount() {
        return bookList4.size();
    }

    public static class Book3ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView Img;
        private TextView tv1;
        private TextView tv2;
//        private RatingBar ratingBar;

        public Book3ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            Img = itemView.findViewById(R.id.book4_1);
            tv1 = itemView.findViewById(R.id.tv4_1);
            tv2 = itemView.findViewById(R.id.tv4_2);
//            ratingBar = itemView.findViewById(R.id.ratingBar00);

        }
    }

}
