package lav.c;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static lav.c.R.color.colorPepGreen;
import static lav.c.R.color.colorWhite;
import static lav.c.R.id.parent;
import static lav.c.R.string.s;

public class MainActivity extends AppCompatActivity {

    TextView intro_tv, fratures_tv, applications_tv ;
    String circle = "\u25CF";
    ExpandableListView operator_elv;
    ExpTopicsAdapter adaptertopic;
    ArrayList<String> operators = new ArrayList<>();
    HashMap<String, List<String>> operatortypes = new HashMap<>();

    myDbAdapter helper;
   // myDbHelper myhelper;

    ArrayList<String> noind;
    String getname;
    ImageView img;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        helper = new myDbAdapter(this);
       // helper.deleteAll();
       // helper.updateName("operator","operator");
       // myhelper = new myDbHelper(this);
       // getApplicationContext().deleteDatabase(myhelper.DATABASE_NAME);

        Log.e("helo","HEEEE");
        //getActionBar().setTitle(Html.fromHtml("<font color='#ff0000'>ActionBartitle </font>"));
        getSupportActionBar().setTitle(Html.fromHtml("<h1><font color='#ffffff' ><b>C </b><i>Programming</i></font></h1>"));
       //getSupportActionBar().setTitle(R.string.s);


       intro_tv=(TextView)findViewById(R.id.tv_intro);
        intro_tv.setText(circle+" C language is the most widely used language in operating systems and embedded system development today.\n\n" +
                circle+" C is a general-purpose, high-level language that was originally developed by Dennis M. Ritchie to develop the UNIX operating system at Bell Labs.\n");

        fratures_tv=(TextView)findViewById(R.id.tv_features);
        fratures_tv.setText(circle+" Fast and Efficient\n"+circle+" Portable\n"+circle+" Poweful Operators\n"+circle+" Modularity\n"+circle+" Function rich Libraries\n"+circle+" Easy to Extend");

        applications_tv=(TextView)findViewById(R.id.tv_applications);
        applications_tv.setText(circle+" Operating Systems\n"+circle+" Language Compilers\n"+circle+" Assemblers\n"+circle+" Text Editors\n"+circle+" Print Spoolers\n"+circle+" Network Drivers\n"+circle+" Database\n"+circle+" Language Interpreter\n"+circle+" Utilities\n");

        operator_elv=(ExpandableListView)findViewById(R.id.elv_operator);
       // operator_elv.setGroupIndicator(getResources().getDrawable(R.drawable.arrowdown));
        operator_elv.setGroupIndicator(null);
       // operator_elv.setDividerHeight(2);
        operator_elv.setDivider(getResources().getDrawable(R.drawable.divider));
        prepareListData();

        Log.e("OPT", String.valueOf(operators));
        Log.e("OPTSIZ", String.valueOf(operators.size()));

       /* View v = LayoutInflater.from(this).inflate(R.layout.list_group,null);
        img= (ImageView) v.findViewById(R.id.iv);
        img.setVisibility(View.GONE);*/

        //checkforindicator(operators);
        Log.e("NOIND", String.valueOf(noind));
        adaptertopic=new ExpTopicsAdapter(this,operators,operatortypes);
        operator_elv.setAdapter(adaptertopic);
        operator_elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Log.e("GP", String.valueOf(groupPosition));

                if(id==3){
                    Log.e("ID", String.valueOf(id));
                    Intent intent = new Intent(MainActivity.this,TRY.class);
                    startActivity(intent);
                }else if (id==4){
                    Intent intent = new Intent(MainActivity.this,ArrayTry.class);
                    startActivity(intent);
                }else if (id==5){
                    Intent intent = new Intent(MainActivity.this,Pointer.class);
                    startActivity(intent);
                }
                return false;
            }
        });




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

    }
    private void prepareListData(){
        operators.add("Operators");
        operators.add("Conditional Statements");
        operators.add("Loops");
        operators.add("Functions");
        operators.add("Arrays");
        operators.add("Pointers");
        List<String> one = new ArrayList<String>();
        one.add("Arithmetic");
        one.add("Logical");
        List<String> two = new ArrayList<String>();
        two.add("If");
        two.add("If-else");
        two.add("Switch Case");
        List<String> three = new ArrayList<String>();
        three.add("For Loop");
        three.add("While Loop");
        three.add("Do-While Loop");
        List<String> four = new ArrayList<String>();
        List<String> five = new ArrayList<String>();
        List<String> six = new ArrayList<String>();

        operatortypes.put(operators.get(0), one);
        operatortypes.put(operators.get(1), two);
        operatortypes.put(operators.get(2), three);
        operatortypes.put(operators.get(3),four);
        operatortypes.put(operators.get(4),five);
        operatortypes.put(operators.get(5),six);

    }

   /* public ArrayList<String> checkforindicator(ArrayList<String> operators){
        int x = operators.size();
        Log.e("OPTSIZE", String.valueOf(x));
        for(int i=3;i<=operators.size();i++){
            getname = operators.get(i);
            noind.add(getname);
        }
        return noind;
    }*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this,Extras.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
