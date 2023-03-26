package com.example.graduationproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RV_AdapterOfMain extends RecyclerView.Adapter<RV_AdapterOfMain.BookViewHolder>
{
    public List<MainBooks> booksList;


    public RV_AdapterOfMain(List<MainBooks> booksList) {
        this.booksList = booksList;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder
    {
        ImageView Img;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            //inflate
            Img = itemView.findViewById(R.id.book_interface3);
        }
    }
    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_books, parent , false);

        return new BookViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position)
    {
        holder.Img.setImageResource(booksList.get(position).getImag_book());

    }

    @Override
    public int getItemCount()
    {
        return booksList.size(); //Books.size
    }

    // Holder class for Recycler View

}
