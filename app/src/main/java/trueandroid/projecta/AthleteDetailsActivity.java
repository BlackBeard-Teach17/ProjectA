package trueandroid.projecta;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 DAVID
 */
public class AthleteDetailsActivity extends Activity {

    private EditText firstName;
    private EditText lastName;
    private EditText age;
    private EditText Achievements;
    private EditText RaceSpecialty;

    private int AthleteID;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete_details);

        this.firstName = (EditText)this.findViewById(R.id.firstName);
        this.lastName = (EditText)this.findViewById(R.id.lastName);
        this.age = (EditText)this.findViewById(R.id.age);

        //Get AthleteID
        this.AthleteID = getIntent().getIntExtra("AthleteID", -1);

        if (this.AthleteID > 0){
            new GetAthleteDetails().execute(new ApiConnector());
        }
    }



        private class GetAthleteDetails extends AsyncTask<ApiConnector, Long, JSONArray> {
            @Override
            protected JSONArray doInBackground(ApiConnector... params) {
                //Executed in the background thread
                return params[0].GetAthleteDetailsID(AthleteID);
            }


            @Override
            protected void onPostExecute(JSONArray jsonArray) {

                try{
                    JSONObject athlete = jsonArray.getJSONObject(0);

                    firstName.setText(athlete.getString("FirstName"));
                    lastName.setText(athlete.getString("LastName"));
                    age.setText(athlete.getInt("Age"));
                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }
    }

