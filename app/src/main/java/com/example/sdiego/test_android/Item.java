package com.example.sdiego.test_android;

import java.io.Serializable;

/**
 * Created by SDiego on 21/02/2018.
 */

public class Item implements Serializable{
    private int id;
    private String name;
    private String description;

    public Item(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Item(){
        id = 0;
        name = "";
        description = "";
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


    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;

    }
}
