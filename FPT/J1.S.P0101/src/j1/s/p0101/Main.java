/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0101;
import Controller.Utility;
import View.View_Employee;
import java.io.IOException;

/**
 *
 * @author myth.superking
 */
public class Main  {
      public static void main(String[] args) throws IOException, Exception {
        View_Employee vEmployee = new View_Employee();
        //print the menu for user to input  to command
        while(true)
        {
           vEmployee.View_Menu();
            //input choice 1-6
            int choice = Utility.checkInputIntLimit(1,6);
            switch(choice){
                    case 1:
                        //user create employee by inputting information from keyboard.
                        vEmployee.View_AddEmployees();
                        break;
                    case 2:
                        //require id to find employee,if id exists ,starting to input information from keyboard.if not,return empty list
                        vEmployee.View_Update();
                        break;
                    case 3:
                      //require id to delete employee,ask 1 more time if mistake or not,then delete
                        vEmployee.View_Delete();
                        break;
                    case 4:
                      //show employee by input id,if list empty ,notify.if there exists employee,show information
                        vEmployee.View_Search();
                        break;
                    case 5:
                        //check list if empty first,then sort by Comparator
                        vEmployee.View_SortSalary();
                        break;
                    case 6:
                        return;
            }
        }
}
}
