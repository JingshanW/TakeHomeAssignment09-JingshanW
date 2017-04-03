package com.example.android.takehomeassignment09_jingshanw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.R.attr.y;

public class SecondActivity extends AppCompatActivity {

    private FirebaseDatabase database=FirebaseDatabase.getInstance();
    private DatabaseReference bookRef=database.getReference("book");


    private TextView name;
    private TextView year;
    private CheckBox inStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name= (TextView) findViewById(R.id.name_text_view);
        year= (TextView) findViewById(R.id.yearOfPublish_text_view);
        inStock= (CheckBox) findViewById(R.id.inStock_checkbox);
    }

    public void addBook(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        String n=name.getText().toString();
        int y=Integer.parseInt(year.getText().toString());
        boolean i=inStock.isChecked();
        Book book=new Book(n,i,y);
        bookRef.push().setValue(book);

        startActivity(intent);


    }
}
