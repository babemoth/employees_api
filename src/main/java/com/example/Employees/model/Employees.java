package com.example.Employees.model;

import jdk.jfr.DataAmount;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEES")
public class Employees {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    @Column(name = "NAME")
    private String name;


    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;


    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;


    /*
    Конструктор
     */
    public Employees(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString(){
        return "Employees [id=" + id + ", name=" + name + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", departmentName=" + departmentName + "]";
    }


}
