/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.PersonManager;
import Controller.Utility;
import Model.Person;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author myth.superking
 */
public class View_Person {

    PersonManager psmng = new PersonManager();
//menu
    public void View_Menu() {

        System.out.println("Please select options:");
        System.out.println(" 1.Add");
        System.out.println(" 2.Dísplay");
        System.out.println(" 3.Sort by salary");
        System.out.println("4.Exit");
    }

    public void View_AddPerson() throws IOException {
        while (true) {
            System.out.println("Input Information of person");

            String name = Utility.checkString("Enter Name: ");
            String address = Utility.checkString("Enter address");
            double salary = Utility.checkInt("Enter salary");
            psmng.addPerson(name, address, salary);
            System.out.println("Added Person Success");
            System.out.println("");

            System.out.println("Do you want to add another? Y/N");
        Utility.checkInputYN();
        }
    }

    public void View_Display() {
        ArrayList<Person> lsPerson = psmng.getListPerson();
        for (Person person : lsPerson) {
            person.print();
        }
    }

    public void View_SortBySalary() {
        ArrayList<Person> lsPersonBySalary = psmng.ListPersonSortBySalary();//create an arraylist and put a collection into to sort by salary
        for (Person person : lsPersonBySalary) {
            person.print();
        }
    }
}
