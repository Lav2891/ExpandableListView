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

public class Arguments extends AppCompatActivity {
    TextView argument_tv, program_tv,output_tv;
    TextView argument2_tv, program2_tv,output2_tv;
    String circle = "\u25CF";

    myDbAdapter helper;
    String store = "argument";
    Boolean compare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arguments);

        helper = new myDbAdapter(this);
        compare = helper.comp(store);
        if (compare == true) {
            // helper.updateName("operator", "operator");
            long id = helper.insertData(store);
            if (id <= 0) {
                //Toast.makeText(getApplicationContext(), "Operator Unsuccssfull", Toast.LENGTH_SHORT).show();
                Log.e("OPT UNSUCCESS","Operator Unsuccssfull");
            } else {
                //Toast.makeText(getApplicationContext(), "ooooperator", Toast.LENGTH_SHORT).show();
                Log.e("OPT SUCCESS","Operator Succssfull");
            }
        }else {
            helper.updateName(store, store);
        }


        getSupportActionBar().setTitle(Html.fromHtml("<h1><font color='#ffffff' ><b>C </b><i>Programming</i></font></h1>"));

        argument_tv=(TextView)findViewById(R.id.tv_argument);
        argument_tv.setText(circle+" Passing formal arguments\n"+circle+" No return statement");

        program_tv=(TextView)findViewById(R.id.tv_program);
        program_tv.setText("#include <stdio.h>\nmain () {\nint x=1;\nint y=2\nout(1,2);\n}\nvoid out(x,y){\nint c = x+y;\nprintf(\"%d\",c);\n}");

        output_tv=(TextView)findViewById(R.id.tv_output);
        output_tv.setText("3");

        argument2_tv=(TextView)findViewById(R.id.tv_argument2);
        argument2_tv.setText(circle+" Passing formal arguments\n"+circle+" Has return statement");

        program2_tv=(TextView)findViewById(R.id.tv_program2);
        program2_tv.setText("#include <stdio.h>\nint c;\nmain()\n{\nint x=2;\nint y =5;\nout(2,5);\nprintf(\"%d\",c);\n}\nint out(x,y){\nc = x+y;\nreturn c;\n}");

        output2_tv=(TextView)findViewById(R.id.tv_output2);
        output2_tv.setText("7");
    }
}
