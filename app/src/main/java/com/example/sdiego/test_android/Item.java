package com.example.sdiego.test_android;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/**
 * Created by SDiego on 21/02/2018.
 */

public class Item implements Parcelable {
    private int id;
    private String country;
    private String continent;
    private List<ItemSec> volcanes;

    public Item(int id, String country, String continent, List<ItemSec> volcanes){
        this.id = id;
        this.country = country;
        this.continent = continent;
        this.volcanes = volcanes;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getCountry(){
        return country;
    }
    public String getContinent(){
        return continent;
    }
    public List<ItemSec> getVolcanes(){
        return volcanes;
    }


    protected Item(Parcel in) {
        id = in.readInt();
        country = in.readString();
        continent = in.readString();
        if (in.readByte() == 0x01) {
            volcanes = new ArrayList<ItemSec>();
            in.readList(volcanes, ItemSec.class.getClassLoader());
        } else {
            volcanes = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(country);
        dest.writeString(continent);
        if (volcanes == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(volcanes);
        }
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
