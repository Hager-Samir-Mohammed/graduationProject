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

public class RV_AdapterOfThird extends RecyclerView.Adapter<RV_AdapterOfThird.Book3ViewHolder>
{
    private List<ThirdBooks> bookList3_3;

    public RV_AdapterOfThird(List<ThirdBooks>bookList3_3)
    {
        this.bookList3_3 = bookList3_3;
    }

    @NonNull
    @Override
    public Book3ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_third_books , parent ,false);
        return new Book3ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Book3ViewHolder holder, int position)
    {
        holder.Img.setImageResource(bookList3_3.get(position).getImag_book3());
        holder.tv1.setText(bookList3_3.get(position).getName_book3());
        holder.tv2.setText(bookList3_3.get(position).getAuther_book3());
//        holder.ratingBar.setRating(bookList3_3.get(position).getRating3());

    }

    @Override
    public int getItemCount() {
        return bookList3_3.size();
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

            Img = itemView.findViewById(R.id.book3_1);
            tv1 = itemView.findViewById(R.id.tv3_1);
            tv2 = itemView.findViewById(R.id.tv3_2);
//            ratingBar = itemView.findViewById(R.id.ratingBar00);

        }
    }

}
