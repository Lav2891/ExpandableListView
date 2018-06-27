package lav.c;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Ashwin on 3/2/2018.
 */

public class FirstFragment extends Fragment {
    View view;
    TextView tv1,tv2,tv3;

    public FirstFragment() {
// Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
       view = inflater.inflate(R.layout.fragment_first, container, false);

        tv1 = (TextView)view.findViewById(R.id.t1);
        tv1.setText("The C Proramming Language (2nd Edition) - Brian W. Kernighan and Dennis M. Ritchie (1988)");

        tv2 = (TextView)view.findViewById(R.id.t2);
        tv2.setText("PROGRAMMING IN C (NEW AGE INTERNATIONAL) - D.Ravichandran");

        tv3 = (TextView)view.findViewById(R.id.t3);
        tv3.setText("C Pocket Reference(O'Reilly) - Peter Prinz and Ulla Kirch-Prinz ");

        return view;
    }
}

