package com.powernode.spring6.beans;

import java.util.Set;

public class Set_phone {
    private Set<String> phone;

    public void setPhone(Set<String> phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Set{" +
                "phone=" + phone +
                '}';
    }
}
