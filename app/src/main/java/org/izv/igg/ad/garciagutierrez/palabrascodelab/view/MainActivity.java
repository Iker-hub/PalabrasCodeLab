package org.izv.igg.ad.garciagutierrez.palabrascodelab.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.izv.igg.ad.garciagutierrez.palabrascodelab.R;
import org.izv.igg.ad.garciagutierrez.palabrascodelab.model.data.Word;
import org.izv.igg.ad.garciagutierrez.palabrascodelab.view.recycler.WordAdapter;
import org.izv.igg.ad.garciagutierrez.palabrascodelab.viewmodel.WordViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getName() + "xyzyx";
    private static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    private WordViewModel mWordViewModel;

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Word word = new Word(data.getStringExtra("word"));
            mWordViewModel.insert(word);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // inflate
        initialize();
    }

    private void initialize() {
        Log.v(TAG, "initialize");
        mWordViewModel = new ViewModelProvider(this).get(WordViewModel.class);

        WordAdapter wordAdapter = new WordAdapter(null);

        mWordViewModel.getAllWords().observe(this, words -> {
            wordAdapter.update(words);
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(wordAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener((View v) -> {
            Intent intent = new Intent(MainActivity.this, NewWordActivity.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);

            // Word word = new Word(Math.random() + "");
            // mWordViewModel.insert(word);
            // mWordViewModel.cleanTable();
        });

        mWordViewModel.littleInsert();
    }
}
