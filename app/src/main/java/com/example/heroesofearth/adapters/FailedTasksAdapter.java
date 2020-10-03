package com.example.heroesofearth.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.heroesofearth.R;
import com.example.heroesofearth.pojos.Challenge;

import java.util.ArrayList;

public class FailedTasksAdapter extends BaseAdapter {

    private ArrayList<Challenge> list;
    private LayoutInflater inflater;

    public FailedTasksAdapter(Context context, ArrayList<Challenge> list) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list = list;
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
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_list_item_failed_task, null);
        }

        TextView textView = convertView.findViewById(R.id.textViewFailedTask);
        Challenge challenge = list.get(position);

        textView.setText(challenge.getTask());

        return convertView;
    }
}
