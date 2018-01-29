/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmanage.model;

/**
 *
 * @author ibaha
 */
public class Visitor {
    private String fName;
    private String lName;
    private int age;
    private String gender;
    private String phone;
    private String address;
    private String country;
    private String nationalID;
    private int company;
    
    public Visitor()
    {
            
            }
    public Visitor(String fName,String lName,int age,String gender,String phone,String address,String country,String nationalID,int company)
    {
        this.fName=fName;
        this.lName=lName;
        this.age=age;
        this.gender=gender;
        this.phone=phone;
        this.address=address;
        this.country=country;
        this.nationalID=nationalID;
        this.company=company;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    public String getlName() {
        return lName;
    }

    public String getfName() {
        return fName;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public int getCompany() {
        return company;
    }

    public String getCountry() {
        return country;
    }

    public String getGender() {
        return gender;
    }

    public String getNationalID() {
        return nationalID;
    }

    public String getPhone() {
        return phone;
    }
    
    
}
