/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author myths
 */
public class User  {
    String userID;
    String name;
    String password;
    Date DateOfBirth;
    boolean gender;
    String address;
    String avatar;

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", name=" + name + ", password=" + password + ", DateOfBirth=" + DateOfBirth + ", gender=" + gender + ", address=" + address + ", avatar=" + avatar + '}';
    }

    public User(String userID, String name, String password, Date DateOfBirth, boolean gender, String address, String avatar) {
        this.userID = userID;
        this.name = name;
        this.password = password;
        this.DateOfBirth = DateOfBirth;
        this.gender = gender;
        this.address = address;
        this.avatar = avatar;
    }

   

    public User() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

   
    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
}
