package com.gil.leumicardapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gil.leumicardapp.Adapter.RecyclerViewAdapter;
import com.gil.leumicardapp.FetchData.JsonParse;
import com.gil.leumicardapp.Model.DataListCat;
import com.gil.leumicardapp.Model.DataListObject;

import java.io.IOException;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecomendedFragment extends Fragment {

    JsonParse mJsonParse = new JsonParse();
    ArrayList<DataListCat> allDataLists;
    static RecomendedFragment instance;

    public static RecomendedFragment getInstance() {
        if (instance == null) {
            instance = new RecomendedFragment();
        }
        return instance;
    }


    public RecomendedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recomended, container, false);

        allDataLists = new ArrayList<DataListCat>();

        try {
            mJsonParse.loadJson(getActivity().getAssets().open("jsonObject.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        creaeDummyData();

        RecyclerView my_recycler_view = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        my_recycler_view.setHasFixedSize(true);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), allDataLists);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);

        return v;
    }

    private void creaeDummyData() {

        for (int i = 0; i < 5; i++) {
            DataListCat dm = new DataListCat();
            dm.setCTitle("קטגוריה " + (i + 1));

            ArrayList<DataListObject> single = mJsonParse.getDataListObjectArrayList();
            for (int j = 0; j < 2; j++) {
                single.add(new DataListObject());
            }
            dm.setAllItems(single);
            allDataLists.add(dm);
        }

    }

}
