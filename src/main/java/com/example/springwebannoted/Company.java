package com.example.springwebannoted;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class Company {

    private int comId;
    private String comName;
    private String comOwner;
    private double comValue;
    private int comStrength;

    public Company() {
    }

    public Company(String comName, String comOwner, double comValue, int comStrength) {
        this.comName = comName;
        this.comOwner = comOwner;
        this.comValue = comValue;
        this.comStrength = comStrength;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    private MultipartFile file;

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }


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
        return "Company{" + "comName='" + comName + '\'' + ", comOwner='" + comOwner + '\'' + ", comValue=" + comValue + ", comStrength=" + comStrength + '}';
    }
}
