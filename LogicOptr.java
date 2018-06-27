package lav.c;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ashwin on 2/21/2018.
 */

public class LogicOptr extends AppCompatActivity {
    TextView logic_tv, program_tv,and_tv,or_tv,not_tv,output_tv;
    String circle = "\u25CF";
    String print = "%d";
    String optr="&&";

    myDbAdapter helper;
    String store = "logic";
    Boolean compare;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logicoptr);

        helper = new myDbAdapter(this);
       // helper.updateName("logic","logic");
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

        logic_tv=(TextView)findViewById(R.id.tv_logic);
        logic_tv.setText(circle+" Low in precedence than the relational operators (< and >) wich are lower than + and -.\n"+circle+"The operator && is higher than ||.\n\n"+circle+" They are:\n\n"+"  "+circle+" Logical AND (&&)\n"+"  "+circle+" Logical OR (||)\n"+"  "+circle+" Not (!)\n");
       // logic_tv.setText(circle+"Low in precedence than the relational operators (< and >) wich are lower than + and -.\n"+circle+"The operator && is higher than ||.");

        output_tv=(TextView)findViewById(R.id.tv_output);
        program_tv=(TextView)findViewById(R.id.tv_program);
       // program_tv.setText("#include <iostream>\nmain()\n{\nint x=3;\nint y=3;\nint c = x"+optr+"y;\nprintf("+print+",c);\n}");
        program_tv.setText("#include <iostream>\nmain()\n{\nint m=40,n=20;\nint o=20,p=30;\nif (m>n && m !=0)\n{\nprintf(\"&& Operator : Both conditions are true\\n\");\n}\nif (o>p || p!=20)\n{\n printf(\"|| Operator : Only one condition is true\\n\");\n}\nif (m!=0)\n{\nprintf(\"! Operator : Condition is true\\n\");\n}\n}");
        and_tv=(TextView)findViewById(R.id.tv_and);
        and_tv.setText("&&");
        and_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output_tv.setText("&& Operator : Both conditions are true");
            }
        });
        or_tv=(TextView)findViewById(R.id.tv_or);
        or_tv.setText("||");
        or_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output_tv.setText("|| Operator : Only one condition is true");
            }
        });
        not_tv=(TextView)findViewById(R.id.tv_not);
        not_tv.setText("!");
        not_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output_tv.setText("! Operator : Condition is true");
            }
        });

    }
}
