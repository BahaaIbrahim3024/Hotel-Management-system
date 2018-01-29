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
public class Staff {

    private int id;
    private String username;
    private String password;
    private String fname;
    private String lname;
    private int age;
    private String phone;
    private String address;

    public Staff() {
    }

    public Staff(String username, String password, String fname, String lname, int age, String phone, String address) {
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    public Staff(int id, String username, String password, String fname, String lname, int age, String phone, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id + ", username=" + username + ", password=" + password + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", phone=" + phone + ", address=" + address + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
