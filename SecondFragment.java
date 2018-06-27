package lav.c;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Ashwin on 3/2/2018.
 */

public class SecondFragment extends Fragment {
    View view;
    RadioButton arithmetic_rb,logic_rb,if_rb,ifelse_rb,switch_rb,for_rb,while_rb,dowhile_rb,simple_rb,argument_rb,single_rb,multi_rb,pointers_rb;
    myDbAdapter helper;
    String x = "hello";
    String status;
    Boolean o,l,i,ie,sw,forl,whilel,dowl,sf,af,sda,mda,p;

    public SecondFragment() {
// Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_second, container, false);

        helper = new myDbAdapter(getActivity());
        String data = helper.getData();
       // Toast.makeText(getContext(),data,Toast.LENGTH_SHORT).show();

        // status = helper.compare(operator);
        //Toast.makeText(getContext(),status,Toast.LENGTH_LONG).show();

        arithmetic_rb=(RadioButton)view.findViewById(R.id.rb_arithmetic);
        String operator = "operator";
        o = helper.comp(operator);
        //Toast.makeText(getContext(),o.toString(),Toast.LENGTH_LONG).show();
        if (o==false){
            arithmetic_rb.setChecked(true);
        }

        logic_rb=(RadioButton)view.findViewById(R.id.rb_logic);
        String logic = "logic";
        l = helper.comp(logic);
        //Toast.makeText(getContext(),l.toString(),Toast.LENGTH_LONG).show();
        if (l==false){
            logic_rb.setChecked(true);
        }

        if_rb=(RadioButton)view.findViewById(R.id.rb_if);
        String iff = "if";
        i = helper.comp(iff);
        //Toast.makeText(getContext(),l.toString(),Toast.LENGTH_LONG).show();
        if (i==false){
            if_rb.setChecked(true);
        }

        ifelse_rb=(RadioButton)view.findViewById(R.id.rb_ifelse);
        String ife = "ifelse";
        ie = helper.comp(ife);
       // Toast.makeText(getContext(),l.toString(),Toast.LENGTH_LONG).show();
        if (ie==false){
            ifelse_rb.setChecked(true);
        }

        switch_rb=(RadioButton)view.findViewById(R.id.rb_switch);
        String switc = "switch";
        sw = helper.comp(switc);
      //  Toast.makeText(getContext(),l.toString(),Toast.LENGTH_LONG).show();
        if (sw==false){
            switch_rb.setChecked(true);
        }

        for_rb=(RadioButton)view.findViewById(R.id.rb_for);
        String fl = "for";
        forl = helper.comp(fl);
      //  Toast.makeText(getContext(),l.toString(),Toast.LENGTH_LONG).show();
        if (forl==false){
            for_rb.setChecked(true);
        }

        while_rb=(RadioButton)view.findViewById(R.id.rb_while);
        String whil = "while";
        whilel = helper.comp(whil);
      //  Toast.makeText(getContext(),l.toString(),Toast.LENGTH_LONG).show();
        if (whilel==false){
            while_rb.setChecked(true);
        }

        dowhile_rb=(RadioButton)view.findViewById(R.id.rb_dowhile);
        String dow = "dowhile";
        dowl = helper.comp(dow);
      //  Toast.makeText(getContext(),l.toString(),Toast.LENGTH_LONG).show();
        if (dowl==false){
            dowhile_rb.setChecked(true);
        }

        simple_rb=(RadioButton)view.findViewById(R.id.rb_simple);
        String simp = "simple";
        sf = helper.comp(simp);
       // Toast.makeText(getContext(),l.toString(),Toast.LENGTH_LONG).show();
        if (sf==false){
            simple_rb.setChecked(true);
        }

        argument_rb=(RadioButton)view.findViewById(R.id.rb_argument);
        String arg = "argument";
        af = helper.comp(arg);
      //  Toast.makeText(getContext(),l.toString(),Toast.LENGTH_LONG).show();
        if (af==false){
            argument_rb.setChecked(true);
        }

        single_rb=(RadioButton)view.findViewById(R.id.rb_singlearray);
        String sing = "single";
        sda = helper.comp(sing);
       // Toast.makeText(getContext(),l.toString(),Toast.LENGTH_LONG).show();
        if (sda==false){
            single_rb.setChecked(true);
        }

        multi_rb=(RadioButton)view.findViewById(R.id.rb_multiarray);
        String mul = "multi";
        sda = helper.comp(mul);
     //   Toast.makeText(getContext(),l.toString(),Toast.LENGTH_LONG).show();
        if (sda==false){
            multi_rb.setChecked(true);
        }

        pointers_rb=(RadioButton)view.findViewById(R.id.rb_pointer);
        String pt = "pointer";
        p = helper.comp(pt);
      //  Toast.makeText(getContext(),l.toString(),Toast.LENGTH_LONG).show();
        if (p==false){
            pointers_rb.setChecked(true);
        }



        return view;
    }
}
