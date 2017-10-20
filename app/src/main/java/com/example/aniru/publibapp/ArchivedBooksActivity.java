package com.example.aniru.publibapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.aniru.publibapp.FB.BookDetails_FB;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class ArchivedBooksActivity extends AppCompatActivity {

    @BindView(R.id.rv_ArchivedBooks)
    RecyclerView rv_ArchivedBooks;

    private ArchivedBooksAdapter mArchivedBooksAdapter;

    ArrayList<BookDetails_FB> mArchivedBooks = new ArrayList<BookDetails_FB>();

    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private ChildEventListener mChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archivedbooks);

        ButterKnife.bind(this);

        mArchivedBooksAdapter = new ArchivedBooksAdapter(this, mArchivedBooks);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv_ArchivedBooks.setLayoutManager(mLayoutManager);

        rv_ArchivedBooks.setAdapter(mArchivedBooksAdapter);

        if( mChildEventListener == null) {
            mDatabase.child("archive").addChildEventListener(mChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    BookDetails_FB bookDetails = dataSnapshot.getValue(BookDetails_FB.class);
                    mArchivedBooks.add(bookDetails);
                    mArchivedBooksAdapter.notifyDataSetChanged();
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
