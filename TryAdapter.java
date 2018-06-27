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
 * Created by Ashwin on 2/25/2018.
 */

public class TryAdapter extends RecyclerView.Adapter<TryAdapter.ViewHolder> {

    Context context;
    ArrayList<String> list;

    public TryAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public TryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tryadapter,parent,false);
        ViewHolder viewholder = new ViewHolder(v);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(TryAdapter.ViewHolder holder, int position) {
        final String get = list.get(position);
        Log.e("GET",get);
        holder.functions_tv.setText(get);
        holder.functions_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (get.equals("Simple")){
                    Intent intent = new Intent(context, Simple.class);
                     context.startActivity(intent);
                }else if (get.equals("Arguments")){
                    Intent intent = new Intent(context, Arguments.class);
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
