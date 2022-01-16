package com.example.bmi;

import java.io.Serializable;

public class bmiModel implements Serializable {
    private String height;
    private String weight;
    private  String gender;
    private String age;

    public bmiModel(String height, String weight, String gender, String age) {
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
