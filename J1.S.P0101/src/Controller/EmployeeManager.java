/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Employee;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 *
 * @author myth.superking
 */
public class EmployeeManager {

    private ArrayList<Employee> listEmployee = new ArrayList<>();

    public EmployeeManager() {
    }

    public ArrayList<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(ArrayList<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }
    //check id exist

    public boolean checkIdExist(String id) { //hàm kiểm tra xem có trùng id không
        for (Employee employee : listEmployee) {
            if (id.equalsIgnoreCase(employee.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkEmployeeExist(String id, String firstName, String lastName, String phone, String email, String address, String DOB) {
        //kiem tra xem co trung thong tin khong với employee khác không
        for (Employee employee : listEmployee) {
            if (id.equalsIgnoreCase(employee.getId())
                    && firstName.equalsIgnoreCase(employee.getFirstName())
                    && lastName.equalsIgnoreCase(employee.getLastName())
                    && phone.equalsIgnoreCase(employee.getPhone()) && email.equalsIgnoreCase(employee.getEmail()) && address.equalsIgnoreCase(employee.getAddress())
                    && DOB.equalsIgnoreCase(employee.getDOB())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Employee> ListEmp() {//lấy thông tin của list
        ArrayList<Employee> getListEmployee = new ArrayList<>();
        for (Employee employee : listEmployee) {
            getListEmployee.add(employee);
        }
        return getListEmployee;
    }
     public boolean ListEmpByID(String id) {//hàm check xem ID có tồn tại trong list không
        for (Employee employee : listEmployee) {
                if(id.equalsIgnoreCase(employee.getId())){
                    return true;
                }
        }
        return false;
    }

       public void PrintListByID(String id) { //in thông tin dựa nếu ID có tồn tại
        for (Employee employee : listEmployee) {
                if(id.equalsIgnoreCase(employee.getId())){
                  employee.print();
                }
        } 
    }
    public ArrayList<Employee> ListEmployeeSortBySalary() {//hàm để sort salary,là 1 arraylist mới dựa theo thông tin của arraylist ban đầu,sử dụng comparator
        ArrayList<Employee> getListEmployeeBySalary = new ArrayList<>();
        for (Employee employee : listEmployee) {
            getListEmployeeBySalary.add(employee);
        }
        Collections.sort(getListEmployeeBySalary, new MySalaryComp());
        return getListEmployeeBySalary;
    }
 
  
    public void addEmployee(String id, String firstname, String lastname, String phone, String email, String address, String DOB, String sex, int salary, String egency) {
        //hàm add Employee
        listEmployee.add(new Employee(id, firstname, lastname, phone, email, address, DOB, sex, salary, egency));
        System.out.println("Added Employee Success");
        System.out.println("");
    }
    //check empty

    public boolean checklistEmployeeEmpty() {//hàm kiểm tra list có tróng hay không
        return listEmployee.isEmpty();
    }

    public void removeEmployee(Employee employee) {//hàm remove Employee
        listEmployee.remove(employee);
    }
}

class MySalaryComp implements Comparator<Employee> {
//sắp xếp salary
    @Override
    public int compare(Employee e1, Employee e2) {
        if (e1.getSalary() < e2.getSalary()) {
            return 1;
        } else {
            return -1;
        }
    }
}
