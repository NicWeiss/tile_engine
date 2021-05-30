package com.nicweiss.tileengine;

import java.util.HashMap;


public class Store {

    public static HashMap<String, Float> display = new HashMap();

    public void init(){
        display.put("width", (float)1080);
        display.put("height", (float)10920);
    }

}
