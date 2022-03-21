/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Person;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author myth.superking
 */
public class PersonManager {

    public PersonManager() {
    }
    private ArrayList<Person> listPerson = new ArrayList<>();

    public ArrayList<Person> getListPerson() {
        return listPerson;
    }

    public boolean checklistPersonEmpty() {
        return listPerson.isEmpty();
    }

    public void setListEmployee(ArrayList<Person> listPerson) {
        this.listPerson = listPerson;
    }

    public void addPerson(String name, String address, double salary) {
        listPerson.add(new Person(name, address, salary));
       
    }

    public ArrayList<Person> ListPersonSortBySalary() {
        ArrayList<Person> getListPersonBySalary = new ArrayList<>();
        for (Person person : listPerson) {
            getListPersonBySalary.add(person);
        }
        Collections.sort(getListPersonBySalary, new MySalaryComp());

        return getListPersonBySalary;
    }

    class MySalaryComp implements Comparator<Person> {

        @Override
        public int compare(Person e1, Person e2) {
            if (e1.getSalary() < e2.getSalary()) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
