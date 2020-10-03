package com.example.heroesofearth.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.heroesofearth.R;
import com.example.heroesofearth.pojos.Challenge;

import java.util.ArrayList;

public class DailyChallengesAdapter extends BaseAdapter {

    private static final int HEADER_ITEM = 0;
    private static final int CHALLENGE_ITEM = 1;
    ArrayList<Object> list;
    private LayoutInflater layoutInflater;

    public DailyChallengesAdapter(Context context, ArrayList<Object> list) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position) instanceof Challenge) {
            return CHALLENGE_ITEM;
        }
        return HEADER_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int viewType = getItemViewType(position);

        if (convertView == null) {
            if (viewType == CHALLENGE_ITEM) {
                convertView = layoutInflater.inflate(R.layout.layout_list_item_challenge, null);
            } else {
                convertView = layoutInflater.inflate(R.layout.layout_list_item_header, null);
            }
        }

        if (viewType == CHALLENGE_ITEM) {
            CheckBox checkBox = convertView.findViewById(R.id.checkbox);
            Challenge challenge = (Challenge) list.get(position);

            checkBox.setText(challenge.getTask());
            checkBox.setChecked(challenge.isCompleted());

            checkBox.setTag(position);

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = (int) v.findViewById(R.id.checkbox).getTag();
                    Challenge challenge = (Challenge) list.get(pos);
                    challenge.toggleCompleted();

                    Log.v("JERRY", challenge.getTask() + " : Toggled to "
                            + challenge.isCompleted());
                }
            });
        } else {
            TextView headerTextView = convertView.findViewById(R.id.textViewHeader);
            String headerString = (String) list.get(position);

            headerTextView.setText(headerString);
        }

        return convertView;
    }
}