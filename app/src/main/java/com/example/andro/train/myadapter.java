package com.example.andro.train;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Andro on 6/1/2019.
 */

public class myadapter extends ArrayAdapter<String> {
    int Resource;
    Context Con;
    TextView nameshow, discript;
    List<java_train_journey> list;
    View view;
    static int s;
    static int color[];

    public myadapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        Resource = resource;
        Con = context;
        list = objects;
        color = new int[]{R.color.blue, R.color.colorAccent, R.color.green};
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(Con);
        view = layoutInflater.inflate(Resource, parent, false);
        nameshow = view.findViewById(R.id.from_to);
        discript = view.findViewById(R.id.detal);
        nameshow.setText(list.get(position).getFrom() + " to " + list.get(position).getTo());
        discript.setText(list.get(position).getPrice() + "\n");
        view.setBackgroundResource(color[position % 3]);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.show_one_layout(MainActivity.ArrayView[2], MainActivity.ArrayView);
                MainActivity.ArrayView[2].setBackgroundResource(color[position % 3]);
                ((TextView) (MainActivity.ArrayView[2].findViewById(R.id.title))).setText(nameshow.getText());
                ((TextView) (MainActivity.ArrayView[2].findViewById(R.id.desc))).setText(list.get(position).getDecuman() + "\nprice :" + list.get(position).getPrice());
                if (list.get(position).isSelect()) {
                    (MainActivity.ArrayView[2].findViewById(R.id.select)).setBackgroundResource(R.color.colorPrimaryDark);
                    s = position;
                } else {
                    (MainActivity.ArrayView[2].findViewById(R.id.select)).setBackgroundResource(android.R.color.darker_gray);
                    s = position;
                }
            }
        });
        return view;

    }
}

