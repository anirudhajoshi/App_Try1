package com.example.aniru.publibapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.List;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    public static final int RC_SIGN_IN = 1;

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabase;

    private TestData mTestData = new TestData();

    boolean mSignedOutState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mFirebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = mFirebaseAuth.getCurrentUser();
        if( currentUser==null ){
            HideSignOutMenuItem();
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setIsSmartLockEnabled(false)
                            .setAvailableProviders(
                                    Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build())
                            )
                            .build(),
                    RC_SIGN_IN);
        }
        else{
            ShowSignOutMenuItem();
        }
    }

    public void OnOk(View v) {
        Toast.makeText(this, "OnOk", Toast.LENGTH_SHORT).show();
    }

    public void OnCamera(View v) {
        Toast.makeText(this, "OnCamera", Toast.LENGTH_SHORT).show();
    }

    public void OnArchive(View v) {
        Intent intent = new Intent(this, ArchivedBooksActivity.class);
        startActivity(intent);
    }

    public void OnFavorites(View v) {

        Intent intent = new Intent(this, FavoriteBooksActivity.class);
        startActivity(intent);
    }

    public void OnAddTestDataToArchive(View v) {
        List<BookDetails_FB> archiveBooks = mTestData.SetupArchiveTestData();
        for(int i=0;i<archiveBooks.size();i++) {
            Timber.d(archiveBooks.get(i).getTitle());
            mDatabase.child("archive").push().setValue(archiveBooks.get(i));
        }

        mTestData.Clear();
    }

    public void OnAddTestDataToFavorites(View v) {
        List<BookDetails_FB> favBooks =  mTestData.SetupFavoriteTestData();
        for(int i=0;i<favBooks.size();i++) {
            Timber.d(favBooks.get(i).getTitle());
            mDatabase.child("favorites").push().setValue(favBooks.get(i));
        }

        mTestData.Clear();
    }

    public void OnClearArchive(View v) {

       try {
           mDatabase.getDatabase().getReference().getRoot().child("archive").setValue(null);
       }
       catch (Exception e){
           Timber.d(e.toString());
           Toast.makeText(this, getString(R.string.clearArchiveException), Toast.LENGTH_SHORT).show();
       }

    }

    public void OnClearFavorites(View v) {
        try {
            mDatabase.getDatabase().getReference().getRoot().child("favorites").setValue(null);
        }
        catch (Exception e){
            Timber.d(e.toString());
            Toast.makeText(this, getString(R.string.clearArchiveException), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        MenuItem menuItem_SignOut = (MenuItem) menu.findItem(R.id.sign_out);

        if( mSignedOutState ==false ){
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
                HideSignOutMenuItem();
                // finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void HideSignOutMenuItem() {
        mSignedOutState = false;
        invalidateOptionsMenu();
    }

    private void ShowSignOutMenuItem() {
        mSignedOutState = true;
        invalidateOptionsMenu();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( requestCode==RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                ShowSignOutMenuItem();
            }
        }
    }
}
