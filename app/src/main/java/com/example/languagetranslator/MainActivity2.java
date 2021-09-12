package com.example.languagetranslator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage;

import org.w3c.dom.Text;

import java.util.Locale;
import java.util.Set;

public class MainActivity2 extends AppCompatActivity {

    TextToSpeech mTTS;
    Button voice;
    TextInputEditText textView1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView1 = findViewById(R.id.inputText);
        textView = findViewById(R.id.translatedText);
        voice = findViewById(R.id.voice);

        Intent intent = getIntent();
        String str = intent.getStringExtra("key");
        textView1.setText(str);


        String x = intent.getStringExtra("done");
        textView.setText(x);

        String code = intent.getStringExtra("token");




        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS){

                    int result = getCode(code);

                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Toast.makeText(getApplicationContext(), "Voice not supported!", Toast.LENGTH_SHORT).show();
                        Log.e("TTS", "Language not supported");
                    }else {
                        voice.setEnabled(true);
                    }
                }else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
    }

    private void speak() {
        String text = textView.getText().toString();

        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }

    @Override
    protected void onDestroy() {
        if (mTTS != null){
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();
    }

    public int getCode(String code) {
        int result = 0;
        Locale loc;
        //int result = mTTS.setLanguage(Locale.FRENCH);
        switch (code) {
            case "Arabic":
                //Arabic
                loc = new Locale("ar-XA", "AR");
                result = mTTS.setLanguage(loc);
                break;
            case "Bengali":
                //Bengali
                loc = new Locale("bn-IN", "IN");
                result = mTTS.setLanguage(loc);
                break;
            case "Chinese":
                //Chinese
                result = mTTS.setLanguage(Locale.CHINESE);
                break;
            case "Dutch":
                //Dutch
                loc = new Locale("nl", "NL");
                result = mTTS.setLanguage(loc);
                break;
            case "French":
                //French
                result = mTTS.setLanguage(Locale.FRENCH);
                break;
            case "German":
                //German
                result = mTTS.setLanguage(Locale.GERMAN);
                break;
            case "Greek":
                //Greek
                loc = new Locale("el", "GR");
                result = mTTS.setLanguage(loc);
                break;
            case "Gujarati":
                //Gujarati
                loc = new Locale("gu-IN", "IN");
                result = mTTS.setLanguage(loc);
                break;
            case "Hindi":
                //Hindi
                loc = new Locale("hi-IN", "IN");
                result = mTTS.setLanguage(loc);
                break;
            case "Italian":
                //Italian
                result = mTTS.setLanguage(Locale.ITALIAN);
                break;
            case "Japanese":
                //Japanese
                result = mTTS.setLanguage(Locale.JAPANESE);
                break;
            case "Kannada":
                //Kannada
                loc = new Locale("kn-IN", "IN");
                result = mTTS.setLanguage(loc);
                break;
            case "Korean":
                //Korean
                result = mTTS.setLanguage(Locale.KOREAN);
                break;
            case "Marathi":
                //Marathi
                loc = new Locale("mr_IN", "IN");
                result = mTTS.setLanguage(loc);
                break;
            case "Spanish":
                //Spanish
                loc = new Locale("es", "ES");
                result = mTTS.setLanguage(loc);
                break;
            case "Urdu":
                //Urdu
                loc = new Locale("ur", "AR");
                result = mTTS.setLanguage(loc);
                break;
        }
        return result;
    }

}