package com.example.recyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViesHolder> {
    private LayoutInflater minflater;
    private LinkedList<String> mWordList;

    public WordListAdapter(Context context, LinkedList<String> wordlist){
        minflater = LayoutInflater.from(context);
        this.mWordList=wordlist;
    }

    @NonNull
    @Override
    public WordViesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = minflater.inflate(R.layout.recycler_view_adapter,parent,false);
        return  new WordViesHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViesHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    public class WordViesHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView wordItemView;
        private WordListAdapter mAdapter;
        //<editor-fold desc="Getters and setters">
        public TextView getWordItemView() {
            return wordItemView;
        }

        public void setWordItemView(TextView wordItemView) {
            this.wordItemView = wordItemView;
        }
        //</editor-fold>

        public WordViesHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            this.wordItemView = (TextView) itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            wordItemView.setText("Clicked!" + wordItemView.getText());
        }
    }
}
