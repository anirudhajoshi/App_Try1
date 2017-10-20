package com.example.aniru.publibapp.FB;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aniru.publibapp.R;

import java.util.ArrayList;

/**
 * Created by aniru on 10/20/2017.
 */

public class FavoritesBooksAdapter extends RecyclerView.Adapter<FavoritesBooksAdapter.ViewHolder> {

    ArrayList<BookDetails_FB> mFavoritesBooks;
    Context mContext;

    TextView tv_BookTitle, tv_BookISBN, tv_BookPageCount;

    public FavoritesBooksAdapter(Context context, ArrayList<BookDetails_FB> books){
        mFavoritesBooks = books;
        mContext = context;
    }

    @Override
    public FavoritesBooksAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_archivedbooks, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        tv_BookTitle.setText(mFavoritesBooks.get(position).getTitle());
        tv_BookISBN.setText(mFavoritesBooks.get(position).getIsbn());
        tv_BookPageCount.setText(Integer.toString(mFavoritesBooks.get(position).getPageCount()));
    }

    @Override
    public int getItemCount() {
        return mFavoritesBooks.size();
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
