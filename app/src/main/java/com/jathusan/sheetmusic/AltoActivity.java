package com.jathusan.sheetmusic;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

public class AltoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setupActionBar();
    }

    public void setupActionBar() {
        ActionBar ab = getActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal)));
        ab.setIcon(R.drawable.drawer_icon);
        final int actionbarTitle = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        TextView actionBarText = (TextView) findViewById(actionbarTitle);
        actionBarText.setTypeface(Typeface.createFromAsset(getAssets(), "roboto-light.ttf"));
        actionBarText.setTextColor(getResources().getColor(R.color.white));
    }

}
