package com.example.studentdryrunappphase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String URL = "https://student-mvn-project.herokuapp.com/api/student";
        Gson json = new Gson();
        String req="/20CS093";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL+req,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("GET Response ",response.toString());
                        String res = response.toString();
                        System.out.println(res);
                        /** TASK: Print the values of this "found" Student object on the app screen on the press of a button
                         * Optional: You can even make a type input box that stores the id no typed by a user in a String object and store it in req (upstairs)
                         * And button that.
                         * On the next view, it should display one sid and one name for now*/
                        Student found = json.fromJson(res,Student.class);
                        System.out.println(found);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("GET Error Response ",error.toString());
                        String res = error.toString();
                        System.out.println(res);
                    }
                }
        );
        requestQueue.add(objectRequest);

    }
}