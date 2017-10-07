package com.example.usama.contactlist;

/**
 * Created by Usama on 9/30/2017.
 */

public class Contact {

    private int id;
    private String name, number, gender;

    @Override
    public String toString() {
        return "User{" +

                "id=" + id +

                ", Name: '" + name + '\'' +
                ", number: '" + number + '\'' +
                ", gender: '" + gender + '\'' +
                '}';
    }

    public Contact(int id, String name, String number, String gender) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
