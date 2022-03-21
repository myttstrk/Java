/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.Utility;
import View.View_Store;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author myth.superking
 */
public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, ParseException {
        View_Store vStore = new View_Store();
        while (true) {
            vStore.View_Menu();
            //input choice 1-6
            int choice = Utility.checkInputIntLimit(1, 6);
            switch (choice) {
                case 1:

                    vStore.View_AddStoreKeeper();
                    break;
                case 2:

                    vStore.View_AddProduct();
                    break;
                case 3:

                    vStore.View_UpdateProduct();
                    break;
                case 4:

                    vStore.View_Search();
                    break;
                case 5:

                    vStore.View_Sort();
                    break;
                case 6:
                    return;
            }
        }

    }
}
