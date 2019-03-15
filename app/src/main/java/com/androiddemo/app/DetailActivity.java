package com.androiddemo.app;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.androiddemo.app.utility.JSONfunctions;
import com.androiddemo.app.utility.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by suryabalarajan on 03/07/2019.
 */
public class DetailActivity extends AppCompatActivity {

    private Context mContext;
    final String TAG = DetailActivity.this.toString();
    private Utils mUtilsObj;
    private String mCountryName;

    private TextView mCountryTextview, mCapitalTextView, mPopulationTextView, mAreaTextView,
            mRegionTextView, mSubRegionTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity_layout);

        mContext = this;
        mCountryName = getIntent().getStringExtra("Country");
        mUtilsObj = new Utils();

        init();

        //checking for network, if its not available, an alert is shown.
        if(mUtilsObj.isNetworkAvailable(mContext)) {
            new RunInBackGround_GetDetails().execute();
        } else {

            AlertDialog.Builder mBuilder = new AlertDialog.Builder(mContext);
            mBuilder.setMessage("Network not available! Please check your settings.");
            mBuilder.setCancelable(true);

            mBuilder.setPositiveButton(
                    "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            finish();
                        }
                    });

            AlertDialog mAlert = mBuilder.create();
            mAlert.show();

        }

    }

    // Initializing the UI elements
    public void init(){

        mCountryTextview = (TextView) findViewById(R.id.country_textview);
        mCapitalTextView = (TextView) findViewById(R.id.capital_textview);
        mPopulationTextView = (TextView) findViewById(R.id.population_textview);
        mAreaTextView = (TextView) findViewById(R.id.area_textview);
        mRegionTextView = (TextView) findViewById(R.id.region_textview);
        mSubRegionTextView = (TextView) findViewById(R.id.subregion_textview);

        mCountryTextview.setText(mCountryName);
    }

    // Async task to fetch the details from the given URL
    public class RunInBackGround_GetDetails extends AsyncTask<String, Void, JSONObject> {

        private ProgressDialog dialog;
        JSONObject mJSONObj;

        public RunInBackGround_GetDetails() {
            dialog = new ProgressDialog(mContext);
            mJSONObj = new JSONObject();
        }

        @Override
        protected void onPreExecute() {

            dialog.setMessage("Please wait");
            dialog.show();
            dialog.setCancelable(true);
        }

        @Override
        protected JSONObject doInBackground(String... strings) {

            JSONArray result = new JSONfunctions().getJsonFromUrl(
                    mContext.getResources().getString(R.string.get_details_url) + mCountryName);
            Log.i(TAG, result.toString());
            try {
                mJSONObj = result.getJSONObject(0);
                Log.i("JSONArray",mJSONObj.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return mJSONObj;
        }

        @Override
        protected void onPostExecute(JSONObject res) {
            super.onPostExecute(res);

            dialog.cancel();
            try {
                    mCapitalTextView.setText(mJSONObj.get("capital").toString());
                    mPopulationTextView.setText(mJSONObj.get("population").toString());
                    mAreaTextView.setText(mJSONObj.get("area").toString());
                    mRegionTextView.setText(mJSONObj.get("region").toString());
                    mSubRegionTextView.setText(mJSONObj.get("subregion").toString());

            }catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
