package com.example.aniru.publibapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.aniru.publibapp.FB.BookDetails_FB;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class ArchiveActivity extends AppCompatActivity {

    @BindView(R.id.rv_Archive)
    RecyclerView rv_Archive;

    private BooksAdapter mBooksAdapter;

    ArrayList<BookDetails_FB> mBooks = new ArrayList<BookDetails_FB>();

    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private ChildEventListener mChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive);

        ButterKnife.bind(this);

        mBooksAdapter = new BooksAdapter(this, mBooks);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv_Archive.setLayoutManager(mLayoutManager);

        rv_Archive.setAdapter(mBooksAdapter);

        if( mChildEventListener == null) {
            mDatabase.child("archive").addChildEventListener(mChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    BookDetails_FB bookDetails = dataSnapshot.getValue(BookDetails_FB.class);
                    mBooks.add(bookDetails);
                    mBooksAdapter.notifyDataSetChanged();
                    Timber.d(bookDetails.getTitle());
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}
