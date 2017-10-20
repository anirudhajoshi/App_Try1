package com.example.aniru.publibapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aniru.publibapp.FB.BookDetails_FB;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by aniru on 10/20/2017.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    ArrayList<BookDetails_FB> mArchivedBooks;
    Context mContext;

    TextView tv_BookTitle, tv_BookISBN, tv_BookPageCount;

    public BooksAdapter(Context context, ArrayList<BookDetails_FB> archivedfbBooks){
        mArchivedBooks = archivedfbBooks;
        mContext = context;
    }

    @Override
    public BooksAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_archive, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        tv_BookTitle.setText(mArchivedBooks.get(position).getTitle());
        tv_BookISBN.setText(mArchivedBooks.get(position).getIsbn());
        tv_BookPageCount.setText(Integer.toString(mArchivedBooks.get(position).getPageCount()));
    }

    @Override
    public int getItemCount() {
        return mArchivedBooks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);

            tv_BookTitle = itemView.findViewById(R.id.tv_BookTitle);
            tv_BookISBN = itemView.findViewById(R.id.tv_BookISBN);
            tv_BookPageCount = itemView.findViewById(R.id.tv_BookPageCount);

        }
    }
}
