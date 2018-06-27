package lav.c;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ashwin on 2/28/2018.
 */

public class ArrayAdapter extends RecyclerView.Adapter<ArrayAdapter.ViewHolder> {

    Context context;
    ArrayList<String> list;

    public ArrayAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ArrayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.arrayadapter,parent,false);
        ArrayAdapter.ViewHolder viewholder = new ArrayAdapter.ViewHolder(v);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(ArrayAdapter.ViewHolder holder, int position) {
        final String get = list.get(position);
        Log.e("GET",get);
        holder.functions_tv.setText(get);
        holder.functions_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (get.equals("Single Dimentional")){
                    Intent intent = new Intent(context, Single.class);
                    context.startActivity(intent);
                }else if (get.equals("Multi Dimentional")){
                    Intent intent = new Intent(context, Multi.class);
                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView functions_tv;

        public ViewHolder(View itemView) {
            super(itemView);

            functions_tv=(TextView)itemView.findViewById(R.id.tv_functions);
        }
    }
}

