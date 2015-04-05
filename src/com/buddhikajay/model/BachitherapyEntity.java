package com.buddhikajay.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;

/**
 * Created by buddhika on 4/3/15.
 */
public class BachitherapyEntity {
    SimpleDateFormat date;
    SimpleIntegerProperty icrNo;
    SimpleStringProperty name;
    SimpleIntegerProperty age;
    SimpleStringProperty clinicNo;
    SimpleStringProperty address;
    SimpleIntegerProperty phoneNo;
    SimpleDateFormat date1;
    SimpleDateFormat date2;
    SimpleDateFormat date3;
    SimpleStringProperty remarks;

    public BachitherapyEntity(){
        date = new SimpleDateFormat();
        icrNo = new SimpleIntegerProperty();
        name = new SimpleStringProperty();
        age = new SimpleIntegerProperty();
        clinicNo = new SimpleStringProperty();
        address = new SimpleStringProperty();
        phoneNo = new SimpleIntegerProperty();
        date1 = new SimpleDateFormat();
        date2 = new SimpleDateFormat();
        date3 = new SimpleDateFormat();
        remarks = new SimpleStringProperty();
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }

    public int getIcrNo() {
        return icrNo.get();
    }

    public SimpleIntegerProperty icrNoProperty() {
        return icrNo;
    }

    public void setIcrNo(int icrNo) {
        this.icrNo.set(icrNo);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getAge() {
        return age.get();
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public String getClinicNo() {
        return clinicNo.get();
    }

    public SimpleStringProperty clinicNoProperty() {
        return clinicNo;
    }

    public void setClinicNo(String clinicNo) {
        this.clinicNo.set(clinicNo);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public int getPhoneNo() {
        return phoneNo.get();
    }

    public SimpleIntegerProperty phoneNoProperty() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo.set(phoneNo);
    }

    public SimpleDateFormat getDate1() {
        return date1;
    }

    public void setDate1(SimpleDateFormat date1) {
        this.date1 = date1;
    }

    public SimpleDateFormat getDate2() {
        return date2;
    }

    public void setDate2(SimpleDateFormat date2) {
        this.date2 = date2;
    }

    public SimpleDateFormat getDate3() {
        return date3;
    }

    public void setDate3(SimpleDateFormat date3) {
        this.date3 = date3;
    }

    public String getRemarks() {
        return remarks.get();
    }

    public SimpleStringProperty remarksProperty() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks.set(remarks);
    }
}
