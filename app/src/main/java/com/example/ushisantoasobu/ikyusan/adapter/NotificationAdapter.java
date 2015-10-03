package com.example.ushisantoasobu.ikyusan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ushisantoasobu.ikyusan.model.NotificationData;

import java.util.List;

/**
 * Created by ushisantoasobu on 15/10/03.
 */
public class NotificationAdapter extends ArrayAdapter<NotificationData> {

    private LayoutInflater layoutInflater_;

    public NotificationAdapter(Context context, int textViewResourceId, List<NotificationData> objects) {
        super(context, textViewResourceId, objects);
        layoutInflater_ = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = layoutInflater_.inflate(android.R.layout.simple_list_item_2, null);
        }

        NotificationData notification = NotificationAdapter.this.getItem(position);

        TextView textView1 = (TextView) convertView.findViewById(android.R.id.text1);
        textView1.setText(notification.getTitle());
        TextView textView2 = (TextView) convertView.findViewById(android.R.id.text2);
        textView2.setText(notification.getBody());

        return convertView;
    }

}
