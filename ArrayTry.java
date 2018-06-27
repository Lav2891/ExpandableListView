package lav.c;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;

import java.util.ArrayList;

/**
 * Created by Ashwin on 2/28/2018.
 */

public class ArrayTry extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager lm;
    ArrayAdapter adapter;
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arraytry);

        getSupportActionBar().setTitle(Html.fromHtml("<h1><font color='#ffffff' ><b>C </b><i>Programming</i></font></h1>"));

        recyclerView=(RecyclerView)findViewById(R.id.rview);
        lm=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);
        list.add("Single Dimentional");
        list.add("Multi Dimentional");
        adapter=new ArrayAdapter(this,list);
        recyclerView.setAdapter(adapter);

    }
}
