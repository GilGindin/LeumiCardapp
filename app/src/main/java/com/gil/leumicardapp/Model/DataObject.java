package com.gil.leumicardapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataObject {

    @SerializedName("DataListObject")
    private List<DataListObject> dataList;

    @SerializedName("DataListCat")
    private List<DataListCat> myCategoriesList;

    public List<DataListCat> getMyCategoriesList() {
        return myCategoriesList;
    }

    public void setMyCategoriesList(List<DataListCat> myCategoriesList) {
        this.myCategoriesList = myCategoriesList;
    }

    public List<DataListObject> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListObject> dataList) {
        this.dataList = dataList;
    }


}
