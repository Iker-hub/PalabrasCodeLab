package org.izv.igg.ad.garciagutierrez.palabrascodelab.view.old;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.izv.igg.ad.garciagutierrez.palabrascodelab.R;

public class WordViewHolder extends RecyclerView.ViewHolder {

    private final TextView wordItemView;

    public WordViewHolder(@NonNull View itemView) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text) {
        wordItemView.setText(text);
    }

    public static WordViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new WordViewHolder(view);
    }
}
