package org.izv.igg.ad.garciagutierrez.palabrascodelab.view.recycler;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import org.izv.igg.ad.garciagutierrez.palabrascodelab.R;
import org.izv.igg.ad.garciagutierrez.palabrascodelab.model.data.Word;
import org.izv.igg.ad.garciagutierrez.palabrascodelab.view.MainActivity;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordViewHolder> {
    // de LiveData<List<Word>> a List<Word>
    private List<Word> mAllWord;
    private int cont1 = 0, cont2 = 0;

    public WordAdapter(List<Word> mAllWord) {
        this.mAllWord = mAllWord;
    }

    // Crea el layout
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        cont1++;
        // Log.v(MainActivity.TAG, "onCreateViewHolder: " + cont1);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new WordViewHolder(view);
    }

    // Asocia el layout con el dato que le metemos
    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        cont2++;
        // Log.v(MainActivity.TAG, "onBindViewHolder: " + cont2);
        TextView textView = holder.getWordItemView();
        textView.setText(mAllWord.get(position).getWord());
    }

    @Override
    public int getItemCount() {
        if (mAllWord == null) {
            return 0;
        } else {
            return mAllWord.size();
        }
    }

    public void update(List<Word> words) {
        mAllWord = words;
        notifyDataSetChanged();
    }


}
