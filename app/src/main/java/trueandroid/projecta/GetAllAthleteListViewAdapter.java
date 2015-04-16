package trueandroid.projecta;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by David .
 */
public class GetAllAthleteListViewAdapter extends BaseAdapter {

    private JSONArray dataArray;
    private Activity activity;

    private static LayoutInflater inflater = null;

    public GetAllAthleteListViewAdapter (JSONArray jsonArray, Activity a){

        this.dataArray = jsonArray;
        this.activity = a;

        inflater = (LayoutInflater) this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount(){
        return this.dataArray.length();
    }
    @Override
    public Object getItem (int position){
        return position;
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView (int position, View convertView, ViewGroup Parent){
        //Set up ConvertView if it is null
        ListCell cell;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.get_all_athlete_list_view_cell,null);

            cell = new ListCell();

            cell.FullName = (TextView) convertView.findViewById(R.id.athlete_full_name);

            cell.Age = (TextView) convertView.findViewById(R.id.athlete_age);

            cell.Category= (TextView) convertView.findViewById(R.id.race_specialty);

            cell.Honours = (TextView) convertView.findViewById(R.id.achievements);

            cell.Profile = (ImageView) convertView.findViewById(R.id.athlete_profile);

            convertView.setTag(cell);
        }
        else {
            cell= (ListCell) convertView.getTag();
        }
        try{
            JSONObject jsonObject = this.dataArray.getJSONObject(position);

            cell.FullName.setText(jsonObject.getString("FirstName")+ "" +
                    jsonObject.getString("LastName"));
            cell.Age.setText(" "+jsonObject.getInt("Age"));

            cell.Category.setText(jsonObject.getString("Race Specialty"));
            cell.Honours.setText(jsonObject.getString("Achievements"));

            String profile = jsonObject.getString("Profile");

            if (profile.equals("Tshepo")){
                cell.Profile.setImageResource(R.drawable.tshepo);
            }
            else if (profile.equals("Keamo")){
                cell.Profile.setImageResource(R.drawable.ic_action_name);
            }
            else if (profile.equals("Bra Skhalo")){
                cell.Profile.setImageResource(R.drawable.skhalo);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return convertView;
    }
    private class ListCell {

        private TextView FullName;
        private TextView Category;
        private TextView Age;
        private ImageView Profile;
        private TextView Honours;
    }
}
