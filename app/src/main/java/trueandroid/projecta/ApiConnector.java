package trueandroid.projecta;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by David
 */
public class ApiConnector {

    public JSONArray GetAthleteInfo(){

        //URL for getting the athletes information
        String url = "http://localhost/phpmyadmin/athletesDatabase.php?";

        //Getting HttpResponseObject from the url
        //Get HttpEntity from HttpResponse Object

        HttpEntity httpEntity = null;

        try{
            DefaultHttpClient  httpClient= new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();

        }catch (ClientProtocolException e){
            //Signal error in the http protocol
            e.printStackTrace();
            //Log errors here
        }catch (IOException e) {
            e.printStackTrace();
        }

        //Converting HttpEntity into a JSONArray object
        JSONArray jsonArray = null;

            if (httpEntity != null) {

            try{
                String entityResponse = EntityUtils.toString(httpEntity);
                Log.e("Entity Response: ", entityResponse);
                jsonArray = new JSONArray(entityResponse);
            }catch (JSONException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }
        return jsonArray;
    }
    public JSONArray GetAthleteDetailsID (int AthleteID) {
        //URL for getting the athletes information
        String url = "http://news.nwu.ac.za";

        //Getting HttpResponseObject from the url
        //Get HttpEntity from HttpResponse Object

        HttpEntity httpEntity = null;

        try{
            DefaultHttpClient  httpClient= new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();

        }catch (ClientProtocolException e){
            //Signal error in the http protocol
            e.printStackTrace();
            //Log errors here
        }catch (IOException e) {
            e.printStackTrace();
        }

        //Converting HttpEntity into a JSONArray object
        JSONArray jsonArray = null;

        if (httpEntity != null) {

            try{
                String entityResponse = EntityUtils.toString(httpEntity);
                Log.e("Entity Response: ", entityResponse);
                jsonArray = new JSONArray(entityResponse);
            }catch (JSONException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }
        return jsonArray;

    }

}
