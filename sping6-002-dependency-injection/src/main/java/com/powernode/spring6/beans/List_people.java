package com.powernode.spring6.beans;

import java.util.List;

public class List_people {
    private List<String> name;

    public void setName(List<String> name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "List_people{" +
                "name=" + name +
                '}';
    }
}
