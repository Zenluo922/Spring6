package com.powernode.factory.method;

public class Client {
    public static void main(String[] args) {
        WeaponFactory factory = new GunFactory();
        Weapon weapon = factory.get();
        weapon.attack();

        WeaponFactory factory1 = new DaggerFactory();
        Weapon weapon1 = factory1.get();
        weapon1.attack();
    }
}
