package lav.c;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Ashwin on 2/24/2018.
 */

public class Array extends AppCompatActivity {
    TextView array_tv, program_tv,output_tv;
    TextView array2_tv, program2_tv,output2_tv;
    String circle = "\u25CF";
    String print = "\"%d\\n\"";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.array);

        array_tv=(TextView)findViewById(R.id.tv_array);
        array_tv.setText(circle+" Array is a collection of identical data objects\n"+circle+" Objects are stored in consecutive memory location in a common heading\n\n"+circle+" Types:\n"+"     "+circle+" Single dimensional\n"+"     "+circle+" Multi dimensional\n");

        program_tv=(TextView)findViewById(R.id.tv_program);
        program_tv.setText("#include <stdio.h>\nmain () {\nint x[5]={3,6,7,1,8};\n int i;\nfor(i=0;i<5;i++){\nprintf("+print+",i)\n}\n}");

        output_tv=(TextView)findViewById(R.id.tv_output);
        output_tv.setText("3\n6\n7\n1\n8");

        array2_tv=(TextView)findViewById(R.id.tv_array2);
        array2_tv.setText(circle+" Two dimensional array\n");

        program2_tv=(TextView)findViewById(R.id.tv_program2);
        program2_tv.setText("#include <stdio.h>\nmain () {\nint x[2][2]={1,2,3,4};\n for(int i=0;i<2;i++){\nfor(int j=0;j<2 ;j++); {\n                                                                                                                                                                                                                                                                                                                ;j++){\nprintf("+print+",x[i][j])\n}\n}\n}");

        output2_tv=(TextView)findViewById(R.id.tv_output2);
        output2_tv.setText("1\n2\n3\n4");

    }
}
