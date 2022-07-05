package com.example.springweb;

public class Company {

    private String comName;
    private String comOwner;
    private double comValue;
    private int comStrength;

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComOwner() {
        return comOwner;
    }

    public void setComOwner(String comOwner) {
        this.comOwner = comOwner;
    }

    public double getComValue() {
        return comValue;
    }

    public void setComValue(double comValue) {
        this.comValue = comValue;
    }

    public int getComStrength() {
        return comStrength;
    }

    public void setComStrength(int comStrength) {
        this.comStrength = comStrength;
    }

    @Override
    public String toString() {
        return "Company{" +
                "comName='" + comName + '\'' +
                ", comOwner='" + comOwner + '\'' +
                ", comValue=" + comValue +
                ", comStrength=" + comStrength +
                '}';
    }
}
