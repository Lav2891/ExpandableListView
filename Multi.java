package lav.c;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.x;

/**
 * Created by Ashwin on 2/28/2018.
 */

public class Multi extends AppCompatActivity {
    TextView array2_tv, program2_tv,output2_tv;
    String circle = "\u25CF";
    String print = "\"%d\\n\"";

    myDbAdapter helper;
    String store = "multi";
    Boolean compare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi);

        helper = new myDbAdapter(this);
        compare = helper.comp(store);
        if (compare == true) {
            // helper.updateName("operator", "operator");
            long id = helper.insertData(store);
            if (id <= 0) {
                //Toast.makeText(getApplicationContext(), "Operator Unsuccssfull", Toast.LENGTH_SHORT).show();
                Log.e("OPT UNSUCCESS","Operator Unsuccssfull");

            } else {
               // Toast.makeText(getApplicationContext(), "ooooperator", Toast.LENGTH_SHORT).show();
                Log.e("OPT SUCCESS","Operator Succssfull");
            }
        }else {
            helper.updateName(store, store);
        }



        getSupportActionBar().setTitle(Html.fromHtml("<h1><font color='#ffffff' ><b>C </b><i>Programming</i></font></h1>"));

        array2_tv=(TextView)findViewById(R.id.tv_array2);
        array2_tv.setText(circle+" Two dimensional array\n");

        program2_tv=(TextView)findViewById(R.id.tv_program2);
        program2_tv.setText("#include <stdio.h>\nmain () {\nint x[2][2]={1,2,3,4};\n for(int i=0;i<2;i++){\n    for(int j=0;j<2;j++){\n     printf("+print+",x[i][j])\n     }\n  }\n}");

        output2_tv=(TextView)findViewById(R.id.tv_output2);
        output2_tv.setText("1\n2\n3\n4");
    }
}
