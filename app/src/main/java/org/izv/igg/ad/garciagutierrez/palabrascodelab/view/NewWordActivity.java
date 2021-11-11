package org.izv.igg.ad.garciagutierrez.palabrascodelab.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import org.izv.igg.ad.garciagutierrez.palabrascodelab.R;

public class NewWordActivity extends AppCompatActivity {

    //public static final String EXTRA_REPLY = ;
    private EditText mEditWordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        initialize();
    }

    private void initialize() {
        mEditWordView = findViewById(R.id.etWord);

        final Button button = findViewById(R.id.btSave);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            // mEditWordView.getText().toString().isEmpty() - Lo mismo que abajo
            if (TextUtils.isEmpty(mEditWordView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String word = mEditWordView.getText().toString();
                replyIntent.putExtra("word", word);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}