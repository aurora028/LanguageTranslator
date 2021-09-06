package com.example.languagetranslator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText textView1 = findViewById(R.id.inputText);
        TextView textView = findViewById(R.id.translatedText);
        Intent intent = getIntent();
        String str = intent.getStringExtra("key");
        textView1.setText(str);


        String x = intent.getStringExtra("done");
        textView.setText(x);
    }
}