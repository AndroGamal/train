package com.example.andro.train;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class myadapter extends ArrayAdapter<String> {
    int Resource;
    Context Con;
    TextView nameshow;
    List<java_train_journey> list;
    View view;
    static int s;

    public myadapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        Resource = resource;
        Con = context;
        list = objects;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(Con);
        try {
            view = layoutInflater.inflate(Resource, parent, false);
            nameshow = view.findViewById(R.id.from_to);
            nameshow.setText(list.get(position).getFrom() + " to " + list.get(position).getTo());
        }catch (Exception e){}
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.show_one_layout(MainActivity.ArrayView[4], MainActivity.ArrayView);
            }
        });
        return view;

    }
}

