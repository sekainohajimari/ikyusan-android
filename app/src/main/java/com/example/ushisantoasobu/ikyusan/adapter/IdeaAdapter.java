package com.example.ushisantoasobu.ikyusan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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

        IdeaData idea = IdeaAdapter.this.getItem(position);

//        ImageView avatarImageView = (ImageView) convertView.findViewById(R.id.avatarImageView);
//        ImageUtil.set(avatarImageView, idea.getPostUser().getProfile().getIconUrl());

        TextView nameTextView = (TextView) convertView.findViewById(R.id.nameTextView);
        nameTextView.setText(idea.getCreatedAt());

        TextView dateTextView = (TextView) convertView.findViewById(R.id.dateTextView);
        dateTextView.setText(idea.getCreatedAt());

        TextView contentTextView = (TextView) convertView.findViewById(R.id.contentTextView);
        contentTextView.setText(idea.getContent());

        TextView likeTextView = (TextView) convertView.findViewById(R.id.likeTextView);
        likeTextView.setText(idea.getLikesCount().toString());

        return convertView;
    }

}
