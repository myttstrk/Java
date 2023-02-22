/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author myth.superking
 */
public class Person {
   private String name;
   private String address;
   private double salary;

    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Person(String name, String address, int salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }
    public void print(){
        System.out.println("Information you have entered");
        System.out.println("Name: "+name);
        System.out.println("Address: "+address);
        System.out.println("Salary: "+salary);
    }
}
