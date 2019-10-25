package com.example.andro.train;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

/**
 * Created by Andro on 10/24/2019.
 */

public class MyAdapter_Recycler extends RecyclerView.Adapter<MyAdapter_Recycler.MyViewHolder> {
    int Resource;
    Context Con;
    List<java_train_journey> list;
    View view;
    Button select;

    MyAdapter_Recycler(Context context, int resource, List objects) {
        Resource = resource;
        Con = context;
        list = objects;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View v) {
            super(v);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(Con);
        view = layoutInflater.inflate(Resource, parent, false);
        select = view.findViewById(R.id.select);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.num.setText(++MainActivity.i + "");
                MainActivity.my_ticket.add(list.get(position));
                list.remove(position);
                MainActivity.mAdapter = new MyAdapter_Recycler(Con, R.layout.object_tecket, Start.list);
                MainActivity.recycler.setLayoutManager(new LinearLayoutManager(Con));
                MainActivity.recycler.setAdapter(MainActivity.mAdapter);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
