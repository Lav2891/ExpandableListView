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

public class Whileloop extends AppCompatActivity {
    TextView program_tv,output_tv;
    String circle = "\u25CF";
    String strget;
    String equalget;
    String notequalget;

    myDbAdapter helper;
    String store = "while";
    Boolean compare;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whileloop);

        helper = new myDbAdapter(this);
        compare = helper.comp(store);
        if (compare == true) {
            // helper.updateName("operator", "operator");
            long id = helper.insertData(store);
            if (id <= 0) {
               // Toast.makeText(getApplicationContext(), "Operator Unsuccssfull", Toast.LENGTH_SHORT).show();
                Log.e("OPT UNSUCCESS","Operator Unsuccssfull");
            } else {
              //  Toast.makeText(getApplicationContext(), "ooooperator", Toast.LENGTH_SHORT).show();
                Log.e("OPT SUCCESS","Operator Succssfull");
            }
        }else {
            helper.updateName(store, store);
        }



        strget=getString(R.string.str);
        equalget=getString(R.string.equal);
        notequalget=getString(R.string.notequal);

        getSupportActionBar().setTitle(Html.fromHtml("<h1><font color='#ffffff' ><b>C </b><i>Programming</i></font></h1>"));
        program_tv=(TextView)findViewById(R.id.tv_program);
        program_tv.setText("#include <stdio.h>\nmain ()\n{\nint a=10;\nwhile( a < 15 ) {\nprintf(\"value of a: %d\\n\", a);\na++;\n}\n}");
        output_tv=(TextView)findViewById(R.id.tv_output);
        output_tv.setText("value of a: 10\nvalue of a: 11\nvalue of a: 12\nvalue of a: 13\nvalue of a: 14");



    }
}
