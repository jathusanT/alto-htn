package com.jathusan.sheetmusic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import org.json.JSONArray;

import java.net.URL;
import java.util.ArrayList;

public class CompositionActivity extends AltoActivity {

    private ArrayList<Bitmap> images = new ArrayList<Bitmap>();
    private int idValue = -1;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_composition);

        image = (ImageView) findViewById(R.id.image);

        if (getIntent().getExtras() != null){
            idValue = getIntent().getExtras().getInt("id_value", -1);
        }

        new CompositionImagePullTask().execute();
    }

    private class CompositionImagePullTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void[] params) {

            try {

                String bufferResponse = AltoHttpClient.getBufferResponse("http://10.21.91.255:8000/api/sheetmusic?id=" + idValue);

                if (bufferResponse != null) {
                    JSONArray jsonImages = new JSONArray(bufferResponse);

                    for (int i = 0; i < jsonImages.length(); i++){

                        URL url = new URL(jsonImages.get(i).toString());
                        Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                        images.add(bmp);
                    }
                }

            } catch (Exception e){
                Log.e("Error Pulling Images", "Error Pulling Images");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (images.get(0)!=null) {
                image.setImageBitmap(images.get(0));
            }
        }
    }


    /*

     */

}
