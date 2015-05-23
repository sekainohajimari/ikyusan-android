package com.example.ushisantoasobu.ikyusan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.example.ushisantoasobu.ikyusan.R;
import com.example.ushisantoasobu.ikyusan.model.IdeaData;

import java.util.List;

public class IdeaAdapter extends ArrayAdapter<IdeaData> {

    private LayoutInflater layoutInflater_;

    public IdeaAdapter(Context context, int textViewResourceId, List<IdeaData> objects) {
        super(context, textViewResourceId, objects);
        layoutInflater_ = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = layoutInflater_.inflate(R.layout.idea_row, null);
        }
        return convertView;
    }

}
