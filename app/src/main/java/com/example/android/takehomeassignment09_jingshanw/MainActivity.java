package com.example.android.takehomeassignment09_jingshanw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private FirebaseDatabase database=FirebaseDatabase.getInstance();
    private DatabaseReference bookRef=database.getReference("book");
    private ArrayList<Book>bookList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display= (TextView) findViewById(R.id.display_text_view);

        bookRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                bookList.add(dataSnapshot.getValue(Book.class));
                displayBook();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                Toast.makeText(MainActivity.this,dataSnapshot.getValue(Book.class)+"has changed",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

                Toast.makeText(MainActivity.this,dataSnapshot.getValue(Book.class)+"is moved",Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void add(View view) {
        Intent intent=new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    public void displayBook()
    {
        String text="";
        for (Book b : bookList)
            text += b + "\n";
        display.setText(text);
    }
}
