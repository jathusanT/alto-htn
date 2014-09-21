package com.jathusan.sheetmusic;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;


public class MainActivity extends AltoActivity {

    private ScaleAnimation scaleAnimation;
    private ImageView searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        //Intent resultsActivity = new Intent(getApplicationContext(), ResultsListActivity.class);
        //startActivity(resultsActivity);
    }

    private void initialize(){

        searchButton = (ImageView) findViewById(R.id.searchButton);

        searchButton.setAnimation(scaleAnimation);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //initializeVoiceService();
                Intent i = new Intent(getApplicationContext(), CompositionListActivity.class);
                startActivity(i);
                // get voice data
                // send request to wit.ai
                // get response
                // add extras into bundle, start activity
            }
        });
    }

    private void initializeVoiceService(){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "What do you want to do?");
        startActivityForResult(intent, Constants.REQUEST_CODE);
    }
}
