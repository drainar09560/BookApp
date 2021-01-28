package com.example.boookapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.boookapp.DataSaver.POSITION;

public class BookActivity extends AppCompatActivity {
    DataSaver dataSaver;
    Book book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        dataSaver = DataSaver.getInstance(this);
        book = dataSaver.getBooks().get(getIntent().getIntExtra(POSITION,0));
        ImageView   bookPhoto = findViewById(R.id.bookPhoto);
        TextView    bookTitle = findViewById(R.id.bookTitle);
        TextView    bookDescription = findViewById(R.id.bookDescription);

        bookPhoto.setImageResource(book.getImgRes());
        bookTitle.setText(book.getTitle());
        bookDescription.setText(book.getDescription());

    }


    public void goToEitBookAction(View view) {
        Intent intent = new Intent(BookActivity.this,EditActivity.class);
        intent.putExtra(POSITION,dataSaver.getBooks().indexOf(book));
        startActivity(intent);
    }
}