package org.izv.igg.ad.garciagutierrez.palabrascodelab.view.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.izv.igg.ad.garciagutierrez.palabrascodelab.R;

public class WordViewHolder extends RecyclerView.ViewHolder {

    private TextView wordItemView;

    public WordViewHolder(@NonNull View itemView) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.textView);
    }

    public TextView getWordItemView() {
        return wordItemView;
    }
}
