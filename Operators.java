package lav.c;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ashwin on 2/20/2018.
 */

public class Operators extends AppCompatActivity {
    TextView arithmetic_tv, program_tv,add_tv,mul_tv,div_tv,mod_tv,output_tv;
    Button sub_tv;
    String circle = "\u25CF";
    String printget;
    String optr="+";

    myDbAdapter helper;
    String store = "operator";
    Boolean compare;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operators);

        helper = new myDbAdapter(this);
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
                helper.updateName("operator", "operator");
            }
        /*long id = helper.insertData(store);
        if(id<=0) {
            Toast.makeText(getApplicationContext(),"Operator Unsuccssfull",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),"ooooperator",Toast.LENGTH_SHORT).show();
        }*/

        getSupportActionBar().setTitle(Html.fromHtml("<h1><font color='#ffffff' ><b>C </b><i>Programming</i></font></h1>"));

        arithmetic_tv=(TextView)findViewById(R.id.tv_arithmetic);
        arithmetic_tv.setText(circle+" Basic and common operators\n"+circle+" They are:\n"+"  "+circle+" Addition(+)\n"+"  "+circle+" Subtraction(-)\n"+"  "+circle+" Multiplication(*)\n"+"  "+circle+" Division(/)\n"+"  "+circle+" Modulo(%)\n");

        printget=getString(R.string.print);
        output_tv=(TextView)findViewById(R.id.tv_output);
        program_tv=(TextView)findViewById(R.id.tv_program);
        program_tv.setText("#include <iostream>\nmain()\n{\nint x=3;\nint y=3;\nint c = x"+optr+"y;\nprintf("+printget+",c);\n}");
        add_tv=(TextView)findViewById(R.id.tv_add);
        add_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optr = "+";
                program_tv.setText("#include <iostream>\nmain()\n{\nint x=3;\nint y=3;\nint c = x"+optr+"y;\nprintf("+printget+",c);\n}");
                output_tv.setText("6");
            }
        });
        sub_tv=(Button) findViewById(R.id.tv_sub);
        sub_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optr = "-";
                program_tv.setText("#include <iostream>\nmain()\n{\nint x=3;\nint y=3;\nint c = x"+optr+"y;\nprintf("+printget+",c);\n}");
                output_tv.setText("0");
            }
        });
        mul_tv=(TextView)findViewById(R.id.tv_mul);
        mul_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optr = "*";
                program_tv.setText("#include <iostream>\nmain()\n{\nint x=3;\nint y=3;\nint c = x"+optr+"y;\nprintf("+printget+",c);\n}");
                output_tv.setText("9");
            }
        });
        div_tv=(TextView)findViewById(R.id.tv_div);
        div_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optr = "/";
                program_tv.setText("#include <iostream>\nmain()\n{\nint x=3;\nint y=3;\nint c = x"+optr+"y;\nprintf("+printget+",c);\n}");
                output_tv.setText("1");
            }
        });
        mod_tv=(TextView)findViewById(R.id.tv_mod);
        mod_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optr = "%";
                program_tv.setText("#include <iostream>\nmain()\n{\nint x=3;\nint y=3;\nint c = x"+optr+"y;\nprintf("+printget+",c);\n}");
                output_tv.setText("0");
            }
        });

    }
}
