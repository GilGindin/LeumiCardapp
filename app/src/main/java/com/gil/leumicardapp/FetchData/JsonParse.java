package com.gil.leumicardapp.FetchData;

import android.content.Context;
import android.util.Log;

import com.gil.leumicardapp.Model.DataListCat;
import com.gil.leumicardapp.Model.DataListObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JsonParse {

    private static final String TAG = "JsonParse";
    private String json;
    private Context mContext;
    private ArrayList<DataListObject> mDataListObjectArrayList = new ArrayList<>();
    private ArrayList<DataListCat> mDataListCats = new ArrayList<>();

    public String loadJson(InputStream inputStream) {

        try {
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
            Log.d(TAG, "loadJSONfromAsset: -------------" + json.toString());

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;

        }
        return json;
    }

    private ArrayList<DataListObject> loadJSONfromAsset() {

        try {
            JSONObject obj = new JSONObject(json);
            JSONObject inside_object = obj.getJSONObject("DataObject");
            JSONArray m_array = inside_object.getJSONArray("DataListObject ");

            for (int i = 0; i < m_array.length(); i++) {
                JSONObject inside_obg = m_array.getJSONObject(i);
                DataListObject myObject = new DataListObject();

                myObject.setCatId(inside_obg.getInt("CatId"));
                myObject.setTitle(inside_obg.getString("Title"));
                myObject.setSTitle(inside_obg.getString("STitle"));
                myObject.setImag(inside_obg.getString("Imag"));
                myObject.setId(inside_obg.getInt("Id"));

                mDataListObjectArrayList.add(myObject);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return mDataListObjectArrayList;
    }

    private ArrayList<DataListCat> loadJsonFromAssetCategory() {

        try {
            JSONObject obj = new JSONObject(json);
            JSONObject inside_obj = obj.getJSONObject("DataObject");
            JSONArray ms_array = inside_obj.getJSONArray("DataListCat");

            for (int i = 0; i < ms_array.length(); i++) {
                JSONObject ins_obj = ms_array.getJSONObject(i);
                DataListCat my_in_object = new DataListCat();
                my_in_object.setCatId(ins_obj.getInt("CatId"));
                my_in_object.setCTitle(ins_obj.getString("CTitle"));

                mDataListCats.add(my_in_object);
            }

        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return mDataListCats;
    }

    public ArrayList<DataListObject> getDataListObjectArrayList() {
        return loadJSONfromAsset();
    }

    public ArrayList<DataListCat> getDataListCats() {
        return loadJsonFromAssetCategory();
    }


}
