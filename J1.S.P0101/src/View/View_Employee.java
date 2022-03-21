/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.EmployeeManager;
import Controller.Utility;
import Model.Employee;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author myth.superking
 */
public class View_Employee {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    EmployeeManager Employeemng = new EmployeeManager();

    //Show menu
    public void View_Menu() {
        ArrayList<Employee> listEmp = Employeemng.ListEmp();//sẽ in thông tin của Menu và BAO GỒM cả những Employee đã nhập từ trước nếu không thì không in gì cả
        if (Employeemng.checklistEmployeeEmpty()) {
            for (Employee employee : listEmp) {
                employee.print();

            }
        }
        System.out.println("Please select options:");
        System.out.println(" 1.	Create");
        System.out.println(" 2.	Updates");
        System.out.println(" 3.	Remove");
        System.out.println(" 4.	Search");
        System.out.println(" 5.	Sort by Salary");
        System.out.println(" 6.Exit");
        System.out.print(" Enter your choice: ");

    }

    public void View_AddEmployees() throws IOException {

        int number = Utility.checkInt("Enter how many employee?");//hỏi xem add bao nhiêu người
        for (int i = 0; i < number; i++) {
            String id = Utility.checkString("Enter id");
            if (Employeemng.checkIdExist(id)) {
                System.out.println("Id has exist . Please re-input");
                continue;
            }

            String firstname = Utility.checkString("Enter firstName: ");
            String lastname = Utility.checkString("Enter last name:");
            String phone = Utility.checkPhone("Enter phone");

            String email = Utility.checkEmail("Enter email");
            String address = Utility.checkString("Enter address");
            String dob = Utility.checkDate("Enter dob");
            String sex = Utility.checkSex("Enter sex(Male/Female)");
            int salary = Utility.checkInt("Enter salary");
            String egency = Utility.checkString("Enter egency");
            if (Employeemng.checkEmployeeExist(id, firstname, lastname, phone, email, address, dob)) {
                //// nếu trùng với employee có trong list thì báo lỗi và yêu cầu nhập lại
                System.out.println("Duplicate!");
                System.out.println("Please re-input");
                continue;
            } else {
                Employeemng.addEmployee(id, firstname, lastname, phone, email, address, dob, sex, salary, egency);
            }
        }
    }

    public void View_Update() throws IOException, Exception {
        boolean flag = false;
        if (Employeemng.checklistEmployeeEmpty()) { //kiểm tra xem list có hay trống không 
            System.err.println("List Empty");
            return;
        }
        System.out.println("Enter employee's id to search: ");//yêu cầu nhập id để tìm
        String id = Utility.InputString();
        for (Employee employee : Employeemng.ListEmp()) {
            if (id.equalsIgnoreCase(employee.getId())) {//nếu có thì in ra màn hình
                flag = true;
                System.out.println("Found employee");
            }
        }

        if (flag == false) {//nếu không có employee có id như đã nhập thì báo không
            System.out.println("Not found employee");
            return;
        }
        for (Employee employee : Employeemng.ListEmp()) {
            if (id.equalsIgnoreCase(employee.getId())) {
                System.out.println("Please choose information to change");
                System.out.println("(1)ID (2)FirstName (3)LastName (4)Phone (5)Email (6)Address (7)DOB (8)Sex (9)Salary (10)Egency");
                int choose = Utility.checkInputIntLimit(1, 10);
                switch (choose) {
                    case 1:
                        String id1 = Utility.checkString("Enter new id");
                        employee.setId(id1);
                        System.out.println("Changed successfully");
                        return;
                    case 2:
                        String firstname = Utility.checkString("Enter new firstName: ");
                        employee.setFirstName(firstname);
                        System.out.println("Changed successfully");
                        return;
                    case 3:
                        String lastname = Utility.checkString("Enter  new last name:");
                        employee.setLastName(lastname);
                        System.out.println("Changed successfully");
                        return;
                    case 4:
                        String phone = Utility.checkPhone("Enter new phone");
                        employee.setPhone(phone);
                        System.out.println("Changed successfully");
                        return;
                    case 5:
                        String email = Utility.checkEmail("Enter new email");
                        employee.setEmail(email);
                        System.out.println("Changed successfully");
                        return;
                    case 6:
                        String address = Utility.checkString("Enter new address");
                        employee.setAddress(address);
                        System.out.println("Changed successfully");
                        return;
                    case 7:
                        String dob = Utility.checkDate("Enter new DOB");
                        employee.setAddress(dob);
                        System.out.println("Changed successfully");
                        return;
                    case 8:
                        String sex = Utility.checkSex("Enter new sex(Male/Female)");
                        employee.setSex(sex);
                        System.out.println("Changed successfully");
                        return;
                    case 9:
                        int salary = Utility.checkInt("Enter new salary");
                        employee.setSalary(salary);
                        System.out.println("Changed successfully");
                        return;
                    case 10:
                        String egency = Utility.checkString("Enter new egency");
                        employee.setEgency(egency);
                        System.out.println("Changed successfully");
                        return;

                }

            }
        }
    }

    public void View_Delete() throws IOException {
        if (Employeemng.checklistEmployeeEmpty()) {//kiểm tra ds có trống hay ko
            System.out.println("List Empty");
            return;
        }
        System.out.println("Enter employee's id to search: ");
        String id = Utility.InputString();//yêu cầu nhập id
        if (Employeemng.ListEmp().isEmpty()) {//nếu id không tồn tại thì báo không tìm thấy
            System.out.println("Not found employee");
            return;
        } else {

            System.out.println("Do you want to remove Y/N?");//yêu cầu hỏi lại xem có đúng là muốn remove hay không
            for (Employee employee : Employeemng.ListEmp()) {
                String a = Utility.InputString();
                if (a.isEmpty() && (!a.equalsIgnoreCase("Y")) && !a.equalsIgnoreCase("N")) {//kiểm tra nhập Y/N
                    continue;
                }
                if (a.equalsIgnoreCase("Y")) {
                    Employeemng.removeEmployee(employee);
                    System.out.println("Delete success");
                    return;
                } else if (a.equalsIgnoreCase("N")) {
                    return;
                }
            }
        }

    }

    public void View_Search() throws IOException {
        if (Employeemng.checklistEmployeeEmpty()) {//xem danh sach có trống hay không
            System.out.println("List Empty");
            return;
        }
        System.out.println("Enter ID to search");
        String id = Utility.InputString();//yêu cầu nhập id
        if (!Employeemng.ListEmpByID(id)) {//nếu mà list không tồn tại id thì in ra màn hình không có,ngược lại 
            System.out.println("Not found employee");
        } else {
            System.out.printf("%-10s%-10s%-10s%-10s\t%-10s\t%-15s\t%-15s\t%-15s\t%-10s\t%-10s\n", "id", "firstName", "lastName", "phone", "email", "address", "DOB", "sex", "salary", "egency");
            Employeemng.PrintListByID(id);
        }
        return;
    }

    public void View_SortSalary() {
        if (Employeemng.checklistEmployeeEmpty()) {//kiểm tra xem list có trống hay không
            System.out.println("List Empty");
            return;
        }
        ArrayList<Employee> lsSortBySalary = Employeemng.ListEmployeeSortBySalary();//tạo một arraylist riêng để thực hiện sort mà không ảnh hưởng list cũ
        System.out.format("%-10s%-10s%-10s%-10s\t%-10s\t%-15s\t%-15s\t%-15s\t%-10s\t%-10s\n", "id", "firstName", "lastName", "phone", "email", "address", "DOB", "sex", "salary", "egency");
        for (Employee employee : lsSortBySalary) {
            employee.print();
        }

        return;
    }
}
