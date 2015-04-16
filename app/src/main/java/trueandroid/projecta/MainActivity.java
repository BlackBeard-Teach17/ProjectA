package trueandroid.projecta;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends Activity {

    HashMap<String, List<String>> Athletes_category;
    List<String> Athletes_list;
    ExpandableListView Exp_list;
    AthleteSportCategoryAdapter adapter;

    private ListView GetAllAthleteListView;
    private JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.GetAllAthleteListView = (ListView) this.findViewById(R.id.GetAllAthleteListView);



        Exp_list = (ExpandableListView) findViewById(R.id.exp_list);
        Athletes_category = AthleteDataFeed.getInfo();
        Athletes_list = new ArrayList<String>(Athletes_category.keySet());
        adapter = new AthleteSportCategoryAdapter(this, Athletes_category, Athletes_list);
        Exp_list.setAdapter(adapter);
    }

    public void setListAdapter(JSONArray jsonArray) {
        this.GetAllAthleteListView.setAdapter(new GetAllAthleteListViewAdapter(jsonArray, this));
    }


}
