package com.powernode.spring6.beans;

import java.util.Date;

public class C {
    private String name;
    private int age;
    private Date birth;

    public C(String name, int age, Date birth) {
        this.name = name;
        this.age = age;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "c{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }
}
