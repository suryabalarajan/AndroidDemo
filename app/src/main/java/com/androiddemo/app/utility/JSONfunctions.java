package com.androiddemo.app.utility;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by suryabalarajan on 03/07/2019.
 */
public class JSONfunctions {

    public JSONArray getJsonFromUrl(String url)  {

        JSONArray mJson = null;
        try {

            InputStream mInputStream = new URL(url).openStream();
            BufferedReader mReader = new BufferedReader(new InputStreamReader(mInputStream, Charset.forName("UTF-8")));
            String mstr = readAll(mReader);
            mJson = new JSONArray(mstr);


        }catch ( MalformedURLException e) {
            e.printStackTrace();

        }catch ( IOException e) {
            e.printStackTrace();

        }catch ( JSONException e) {
            e.printStackTrace();

        }

        return mJson;
    }

    private String readAll(Reader mReader) throws IOException {
        StringBuilder mBuilder = new StringBuilder();
        int cp;
        while ((cp = mReader.read()) != -1) {
            mBuilder.append((char) cp);
        }
        return mBuilder.toString();
    }
}
