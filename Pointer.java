package lav.c;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ashwin on 2/24/2018.
 */

public class Pointer extends AppCompatActivity {
    TextView pointer_tv, program_tv,output_tv;
    String circle = "\u25CF";

    myDbAdapter helper;
    String store = "pointer";
    Boolean compare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pointer);

        helper = new myDbAdapter(this);
        // helper.updateName("logic","logic");
        compare = helper.comp(store);
        if (compare == true) {
            // helper.updateName("operator", "operator");
            long id = helper.insertData(store);
            if (id <= 0) {
               // Toast.makeText(getApplicationContext(), "Operator Unsuccssfull", Toast.LENGTH_SHORT).show();
                Log.e("OPT UNSUCCESS","Operator Unsuccssfull");
            } else {
               // Toast.makeText(getApplicationContext(), "ooooperator", Toast.LENGTH_SHORT).show();
                Log.e("OPT SUCCESS","Operator Succssfull");
            }
        }else {
            helper.updateName(store, store);
        }

        getSupportActionBar().setTitle(Html.fromHtml("<h1><font color='#ffffff' ><b>C </b><i>Programming</i></font></h1>"));

        pointer_tv=(TextView)findViewById(R.id.tv_pointer);
        pointer_tv.setText(circle+" Pointer is a variable which holds the memory address of an another variable.\n"+circle+" Sometimes, only with the pointer the comlex data type can be declared and accessed in an easy way.");

        program_tv=(TextView)findViewById(R.id.tv_program);
        program_tv.setText("#include <stdio.h>\nmain () {int x;\nint *ptr;\nx=10;\nptr=&x;\nprintf(\"x=%d and ptr=%x\\n\",x,ptr);\nprintf(\"x=%d and *ptr = %d\\n\",x,*ptr);\n}");

        output_tv=(TextView)findViewById(R.id.tv_output);
        output_tv.setText("x=10 and ptr=6149371c\nx=10 and *ptr = 10");
    }
}
