package com.powernode.spring6.beans;

import java.util.Map;

public class Map_address {
    private Map<Integer,String> ads;

    public void setAds(Map<Integer, String> ads) {
        this.ads = ads;
    }

    @Override
    public String toString() {
        return "Map_address{" +
                "ads=" + ads +
                '}';
    }
}
