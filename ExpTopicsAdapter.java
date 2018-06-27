package lav.c;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ashwin on 2/21/2018.
 */

public class ExpTopicsAdapter extends ExpTopics {
    private Context context;
    private List<String> operators;
    private HashMap<String, List<String>> operatortypes;

    public ExpTopicsAdapter(Context context, ArrayList<String> operators, HashMap<String, List<String>> operatortypes) {

        this.context=context;
        this.operators=operators;
        this.operatortypes=operatortypes;
    }

    @Override
    public int getGroupCount() {
        return this.operators.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.operatortypes.get(this.operators.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.operators.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.operatortypes.get(this.operators.get(groupPosition))
                .get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        Log.e("GRPPOST", String.valueOf(groupPosition));
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        ImageView img = (ImageView)convertView.findViewById(R.id.iv);
        if (groupPosition==3 || groupPosition==4 || groupPosition==5){
           // img.setVisibility(View.GONE);
            img.setImageResource(0);
        }else {
           // img.setVisibility(View.VISIBLE);
            img.setImageResource(R.drawable.arrowdown);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
      /*  if (groupPosition==1){
            //lblListHeader.setTypeface(null, Typeface.BOLD);
            lblListHeader.setVisibility(View.GONE);
        }else {
           // lblListHeader.setTypeface(null, Typeface.ITALIC);
            lblListHeader.setVisibility(View.VISIBLE);
        }*/

        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);


        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);


        txtListChild.setText(childText);
        txtListChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (childText.equals("Arithmetic")) {

                    Intent intent = new Intent(context, Operators.class);
                    context.startActivity(intent);

                }else if(childText.equals("Logical")){
                    Intent intent = new Intent(context, LogicOptr.class);
                    context.startActivity(intent);
                }else if (childText.equals("If")){
                    Intent intent = new Intent(context, If.class);
                    context.startActivity(intent);
                }else if (childText.equals("If-else")){
                    Intent intent = new Intent(context, IfElse.class);
                    context.startActivity(intent);
                }else if (childText.equals("Switch Case")){
                    Intent intent = new Intent(context, Switch.class);
                    context.startActivity(intent);
                }else if (childText.equals("For Loop")) {
                    Intent intent = new Intent(context, Forloop.class);
                    context.startActivity(intent);
                }else if (childText.equals("While Loop")) {
                    Intent intent = new Intent(context, Whileloop.class);
                    context.startActivity(intent);
                }else if (childText.equals("Do-While Loop")) {
                    Intent intent = new Intent(context, DoWhile.class);
                    context.startActivity(intent);
                }
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
