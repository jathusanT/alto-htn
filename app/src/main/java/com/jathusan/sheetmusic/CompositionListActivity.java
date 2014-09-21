package com.jathusan.sheetmusic;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class CompositionListActivity extends AltoActivity {

    private String a = "Nothing";
    private ListView listView;
    private CompositionArrayAdapter compositionArrayAdapter;
    private TextView tempTV;
    private String artist = "beethoven";
    private ArrayList<Composition> compositions = new ArrayList<Composition>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_list_activity);
        tempTV = (TextView) findViewById(R.id.temp);

        // do api call with composer name for the results

        listView = (ListView) findViewById(R.id.compositionList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), CompositionActivity.class);
                i.putExtra("id_value", compositions.get(position).getImagesId());
                startActivity(i);
            }
        });

        new CompositionDataPullTask().execute();
    }

    private class CompositionDataPullTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            try {

                String bufferResponse = AltoHttpClient.getBufferResponse("http://10.21.91.255:8000/api/search?query=" + artist);

                if (bufferResponse != null) {

                    JSONArray jsonArray = new JSONArray(bufferResponse);

                    for (int i = 0; i < jsonArray.length(); i ++){

                        JSONObject jsonComposition = jsonArray.getJSONObject(i);

                        Composition composition = new Composition();
                        composition.setTitle(jsonComposition.getString("title"));
                        composition.setStyle(jsonComposition.getString("style"));
                        composition.setDifficulty(jsonComposition.getString("difficulty"));
                        composition.setKey(jsonComposition.getString("key"));
                        composition.setDate(jsonComposition.getString("date"));
                        composition.setComposer(jsonComposition.getString("composer"));
                        composition.setImagesId(jsonComposition.getInt("id"));

                        compositions.add(composition);
                    }

                } else {
                    Log.i("Composition Pull Task", "Response was null");
                }

            } catch (Exception e){
                Log.i("Composition Pull Task", e.getStackTrace().toString());
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            compositionArrayAdapter = new CompositionArrayAdapter(getApplicationContext(), R.layout.list_row, compositions);
            listView.setAdapter(compositionArrayAdapter);
            tempTV.setVisibility(View.GONE);
        }
    }


}
