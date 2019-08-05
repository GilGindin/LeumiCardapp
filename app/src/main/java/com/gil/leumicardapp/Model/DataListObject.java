package com.gil.leumicardapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataListObject extends DataObject {

    @SerializedName("CatId")
    private int CatId;

    @SerializedName("Title")
    private String Title;

    @SerializedName("STitle")
    private String STitle;

    @SerializedName("Imag")
    private String Imag;

    @SerializedName("Id")
    private int Id;
    @SerializedName("DataListAddr")
    private List<DataListAddr> addrList;

    public DataListObject() {
    }

    public int getCatId() {
        return CatId;
    }

    public void setCatId(int catId) {
        CatId = catId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSTitle() {
        return STitle;
    }

    public void setSTitle(String STitle) {
        this.STitle = STitle;
    }

    public String getImag() {
        return Imag;
    }

    public void setImag(String imag) {
        Imag = imag;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<DataListAddr> getAddrList() {
        return addrList;
    }

    public void setAddrList(List<DataListAddr> addrList) {
        this.addrList = addrList;
    }

}
