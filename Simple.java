package lav.c;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ashwin on 2/22/2018.
 */

public class Simple extends AppCompatActivity {
    TextView simple_tv, program_tv,output_tv;
    String circle = "\u25CF";

    myDbAdapter helper;
    String store = "simple";
    Boolean compare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple);

        helper = new myDbAdapter(this);
        compare = helper.comp(store);
        if (compare == true) {
            // helper.updateName("operator", "operator");
            long id = helper.insertData(store);
            if (id <= 0) {
              //  Toast.makeText(getApplicationContext(), "Operator Unsuccssfull", Toast.LENGTH_SHORT).show();
                Log.e("OPT UNSUCCESS","Operator Unsuccssfull");

            } else {
               // Toast.makeText(getApplicationContext(), "ooooperator", Toast.LENGTH_SHORT).show();
                Log.e("OPT SUCCESS","Operator Succssfull");
            }
        }else {
            helper.updateName(store, store);
        }


        getSupportActionBar().setTitle(Html.fromHtml("<h1><font color='#ffffff' ><b>C </b><i>Programming</i></font></h1>"));

        simple_tv=(TextView)findViewById(R.id.tv_simple);
        simple_tv.setText(circle+" No formal arguments\n"+circle+" No return statement");

        program_tv=(TextView)findViewById(R.id.tv_program);
        program_tv.setText("#include <stdio.h>\nmain () {\nint x=1;\nout();\n}\nvoid out(){\nprintf(\"hello\");\n}");

        output_tv=(TextView)findViewById(R.id.tv_output);
        output_tv.setText("hello");
    }
}
