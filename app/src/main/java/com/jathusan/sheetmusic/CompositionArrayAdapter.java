package com.jathusan.sheetmusic;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class CompositionArrayAdapter extends ArrayAdapter<Composition> {

    int resource;
    Context ctx;
    private int lastPosition = -1;

    public CompositionArrayAdapter(Context context, int resource, List<Composition> items) {
        super(context, resource, items);
        this.resource=resource;
        this.ctx = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LinearLayout view;

        Composition composition = getItem(position);

        if(convertView==null) {

            view = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater)getContext().getSystemService(inflater);
            vi.inflate(resource, view, true);

        } else {
            view = (LinearLayout) convertView;
        }

        TextView title = (TextView) view.findViewById(R.id.subjectListTitle);
        TextView subtitle = (TextView) view.findViewById(R.id.subjectListSubtitle);

        subtitle.setTextColor(Color.parseColor("#8bc34a"));

        title.setTypeface(Typeface.createFromAsset(ctx.getAssets(), "roboto-thin.ttf"));

        title.setText(composition.getTitle()
                + ", " + composition.getComposer());

        if (composition.getDate() == null || composition.getDate().isEmpty()){
            composition.setDate("N/A");
        }

        if (composition.getStyle() == null || composition.getStyle().isEmpty()){
            composition.setStyle("N/A");
        }

        if (composition.getKey() == null || composition.getKey().isEmpty()){
            composition.setKey("N/A");
        }

        subtitle.setText("Year: " + composition.getDate()
                         + " | Key: " + composition.getKey()
                         + " | Style: " + composition.getStyle());

        Animation animation = AnimationUtils.loadAnimation(getContext(), (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        view.startAnimation(animation);
        lastPosition = position;

        return view;
    }

}