package lav.c;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ashwin on 2/28/2018.
 */

public class Single extends AppCompatActivity {
    TextView array_tv, program_tv,output_tv;
    String circle = "\u25CF";
    String print = "\"%d\\n\"";

    myDbAdapter helper;
    String store = "single";
    Boolean compare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single);

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


        getSupportActionBar().setTitle(Html.fromHtml("<h1><font color='#ffffff' ><b>C </b><i>Programming</i></font></h1>"));

        array_tv = (TextView) findViewById(R.id.tv_array);
        array_tv.setText(circle + " Array is a collection of identical data objects\n" + circle + " Objects are stored in consecutive memory location in a common heading\n\n" + circle + " Types:\n" + "     " + circle + " Single dimensional\n" + "     " + circle + " Multi dimensional\n");

        program_tv = (TextView) findViewById(R.id.tv_program);
        program_tv.setText("#include <stdio.h>\nmain () {\nint x[5]={3,6,7,1,8};\n int i;\nfor(i=0;i<5;i++){\nprintf(" + print + ",i)\n}\n}");

        output_tv = (TextView) findViewById(R.id.tv_output);
        output_tv.setText("3\n6\n7\n1\n8");
    }
}
