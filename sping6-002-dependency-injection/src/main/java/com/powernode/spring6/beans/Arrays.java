package com.powernode.spring6.beans;

public class Arrays {
    private String []muiscs;

    private Arrays2[]arrays2s;//非简单类型

    @Override
    public String toString() {
        return "Arrays{" +
                "muiscs=" + java.util.Arrays.toString(muiscs) +
                ", arrays2s=" + java.util.Arrays.toString(arrays2s) +
                '}';
    }

    public void setArrays2s(Arrays2[] arrays2s) {
        this.arrays2s = arrays2s;
    }

    public void setMuiscs(String[] muiscs) {
        this.muiscs = muiscs;
    }

}
