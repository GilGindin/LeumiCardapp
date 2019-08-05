package com.gil.leumicardapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataListCat extends DataObject {
    @SerializedName("CTitle")
    private String CTitle;

    @SerializedName("CatId")
    private int CatId;

    private ArrayList<DataListObject> allItems;

    public DataListCat() {
    }

    public ArrayList<DataListObject> getAllItems() {
        return allItems;
    }

    public void setAllItems(ArrayList<DataListObject> allItems) {
        this.allItems = allItems;
    }

    public String getCTitle() {
        return CTitle;
    }

    public void setCTitle(String CTitle) {
        this.CTitle = CTitle;
    }

    public int getCatId() {
        return CatId;
    }

    public void setCatId(int catId) {
        CatId = catId;
    }
}
