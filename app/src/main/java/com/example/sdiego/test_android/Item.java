package com.example.sdiego.test_android;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by SDiego on 21/02/2018.
 */

public class Item implements Parcelable {
    private int id;
    private String name;
    private String depto;
    private String height;

    public Item(int id, String name, String depto,String height){
        this.id = id;
        this.name = name;
        this.depto = depto;
        this.height = height;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDepto(){
        return depto;
    }
    public String getHeight(){
        return height;
    }

    protected Item(Parcel in) {
        id = in.readInt();
        name = in.readString();
        depto = in.readString();
        height = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(depto);
        dest.writeString(height);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
