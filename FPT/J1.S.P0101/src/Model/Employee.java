/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author myth.superking
 */
public class Employee {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    protected String id;
    protected String firstName;
    protected String lastName;
    protected String phone;
    protected String email;
    protected String address;
    protected String DOB;
    protected String sex;
    protected int salary;
    protected String egency;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    //Create a default Empolyee
    public Employee(String id, String firstName, String lastName, String phone, String email, String address, String DOB, String sex, int salary, String egency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.DOB = DOB;
        this.sex = sex;
        this.salary = salary;
        this.egency = egency;
    }

    public String getId() {
        return id;
    }
//the id to set
    public void setId(String id) throws IOException {
        try {
            if (!id.isEmpty()) {
                this.id = id;
            }
        } catch (NullPointerException ex) {
            System.out.println(" Can't be null");
        }

    }

    public String getFirstName() {
        return firstName;
    }
//the name to set
    public void setFirstName(String firstName) throws IOException {
        try {

            if (!firstName.isEmpty()) {
                this.firstName = firstName;
            }
        } catch (NullPointerException ex) {
            System.out.println(" Can't be null");
        }

    }

    public String getLastName() {
        return lastName;
    }
//the last name to set
    public void setLastName(String lastName) throws IOException {
        try {
            if (!lastName.isEmpty()) {
                this.lastName = lastName;
            }
        } catch (NullPointerException ex) {
            System.out.println(" Can't be null");
        }
    }

    public String getPhone() {
        return phone;
    }
//the phone to set
    public void setPhone(String phone) throws IOException {

        String regexStr = "\\d{10}";
        try {
            if (!phone.matches(regexStr)) {
                throw new IllegalArgumentException("Unvalid phone number");
            } else {
                this.phone = phone;
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public String getEmail() {
        return email;
    }
//the email to set
    public void setEmail(String email) throws IOException {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        try {
            if (!email.matches(regex)) {
                throw new IllegalArgumentException("Unvalid email");
            } else {
                this.email = email;
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public String getAddress() {
        return address;
    }
//the address to set
    public void setAddress(String address) throws IOException {
        try {
            if (!address.isEmpty()) {
                this.address = address;
            }
        } catch (NullPointerException ex) {
            System.out.println(" Can't be null");
        }

    }

    public String getDOB() {
        return DOB;
    }
//the date of birth to set
    public void setDOB(String DOB) throws IOException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");//sử dụng  SDF  lấy form ngày-tháng-năm
        try {
            Date date1 = formatter.parse(DOB);
            this.DOB = DOB;
        } catch (ParseException e) {
            System.out.println(DOB + " is Invalid Date format,please reinput");

        }

    }

    public String getSex() {
        return sex;
    }
//the sex to set
    public void setSex(String sex) {

        String n1 = "Male";
        String n2 = "Female";
        Boolean n3;
        try {
            if (sex == null) {
                throw new RuntimeException("Can't be empty");
            }
            if (sex.equalsIgnoreCase("Male")) {
                this.sex = sex;
            }
            if (sex.equalsIgnoreCase("Female")) {
                this.sex = sex;
            }

        } catch (Exception e) {
            System.out.println("Must enter Male or Female");
        }
    }

    public int getSalary() {
        return salary;
    }
//the salary to set
    public void setSalary(int salary) throws Exception {
        try {
            if (salary <= 0) {
                throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!");
            }else{
                this.salary=salary;
            }
        } catch (Exception e){
           throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!");
        }
    }

    public String getEgency() {
        return egency;
    }
//The egency to set
    public void setEgency(String egency) {
        try {
            if (!egency.isEmpty()) {
                this.egency=egency;
            }
        } catch (NullPointerException ex) {
            System.out.println(" Can't be null");
        }

    }

    public SimpleDateFormat getFormatter() {
        return formatter;
    }

    public void setFormatter(SimpleDateFormat formatter) {
        this.formatter = formatter;
    }
//print the employee information
    public void print() {
        System.out.format("%-10s%-10s%-10s%-10s\t%-10s\t%-15s\t%-15s\t%-15s\t%-10s\t%-10s\n", id, firstName, lastName, phone, email, address, DOB, sex, salary, egency);
    }

}
