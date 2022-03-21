/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defaultpackage;

import Controller.Utility;
import View.View_Person;
import java.io.IOException;

/**
 *
 * @author myth.superking
 */
public class Main {

    public static void main(String[] args) throws IOException {

        View_Person vPerson = new View_Person();
        while (true) {
            vPerson.View_Menu();
            //input choice 1-3
            int choice = Utility.checkInputIntLimit(1, 4);
            switch (choice) {
                case 1:

                    vPerson.View_AddPerson();
                    break;
                case 2:

                    vPerson.View_Display();
                    break;
                case 3:

                    vPerson.View_SortBySalary();
                    break;
                case 4:

                    break;
            }
        }
    }
}
