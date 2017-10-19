package com.example.aniru.publibapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.aniru.publibapp.FB.BookDetails_FB;
import com.example.aniru.publibapp.FB.TestData;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    boolean mSignOutState;

    private FirebaseAuth mFirebaseAuth;

    private TestData mTestData = new TestData();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();;
        FirebaseUser currentUser = mFirebaseAuth.getCurrentUser();
        if( currentUser==null ){
            mSignOutState = false;
        }
        else{
            mSignOutState = true;
        }

        invalidateOptionsMenu();
    }

    public void OnOk(View v) {
        Toast.makeText(this, "OnOk", Toast.LENGTH_SHORT).show();
    }

    public void OnCamera(View v) {
        Toast.makeText(this, "OnCamera", Toast.LENGTH_SHORT).show();
    }

    public void OnArchive(View v) {
        Toast.makeText(this, "OnArchive", Toast.LENGTH_SHORT).show();
    }

    public void OnFavorites(View v) {
        Toast.makeText(this, "OnFavs", Toast.LENGTH_SHORT).show();
    }

    public void OnAddTestDataToArchive(View v) {
        List<BookDetails_FB> archiveBooks = mTestData.SetupArchiveTestData();
        for(int i=0;i<archiveBooks.size();i++)
            Timber.d(archiveBooks.get(i).getTitle());

        mTestData.Clear();
    }

    public void OnAddTestDataToFavorites(View v) {
        List<BookDetails_FB> favBooks =  mTestData.SetupFavoriteTestData();
        for(int i=0;i<favBooks.size();i++) {
            Timber.d(favBooks.get(i).getTitle());
        }

        mTestData.Clear();
    }

    public void OnClearArchive(View v) {
        Toast.makeText(this, "Clear archive here", Toast.LENGTH_SHORT).show();
    }

    public void OnClearFavorites(View v) {
        Toast.makeText(this, "Clear favorites here", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        MenuItem menuItem_SignOut = (MenuItem) menu.findItem(R.id.sign_out);

        if( mSignOutState==false ){
            menuItem_SignOut.setVisible(false);
        }
        else{
            menuItem_SignOut.setVisible(true);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.sign_out:
                AuthUI.getInstance().signOut(this);
                Toast.makeText(this, "Sign Out", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
