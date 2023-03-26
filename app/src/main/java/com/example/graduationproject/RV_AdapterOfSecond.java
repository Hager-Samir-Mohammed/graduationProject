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

public class RV_AdapterOfSecond extends RecyclerView.Adapter<RV_AdapterOfSecond.Book3ViewHolder>
{
    private List<SecondBooks> bookList3;

    public RV_AdapterOfSecond(List<SecondBooks>bookList3)
    {
        this.bookList3 = bookList3;
    }

    @NonNull
    @Override
    public Book3ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_second_books , parent ,false);
        return new Book3ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Book3ViewHolder holder, int position)
    {
        holder.Img.setImageResource(bookList3.get(position).getImag_book3());
        holder.tv1.setText(bookList3.get(position).getName_book3());
        holder.tv2.setText(bookList3.get(position).getAuther_book3());
//        holder.ratingBar.setRating(bookList3.get(position).getRating3());

    }

    @Override
    public int getItemCount() {
        return bookList3.size();
    }

    public class Book3ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView Img;
        private TextView tv1;
        private TextView tv2;
//        private RatingBar ratingBar;

        public Book3ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            Img = itemView.findViewById(R.id.book6);
            tv1 = itemView.findViewById(R.id.textView5);
            tv2 = itemView.findViewById(R.id.textView6);
//            ratingBar = itemView.findViewById(R.id.ratingBar00);

        }
    }

}
