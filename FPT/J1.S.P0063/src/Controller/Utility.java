/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author myth.superking
 */
public class Utility {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    /**
     *
     * @author myth.superking
     */
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static int checkInt(String nhap) {
        String n;
        int n1;
        do {
            try {
                System.out.println(nhap);
                n = in.readLine();
                if (n.isEmpty()) {
                    System.out.println("Can't be empty");
                    continue;
                }
                n1 = Integer.parseInt(n);
                if (n1 <= 0) {
                    System.out.println("Must enter >0");
                    continue;
                }
                if (!(n1 == (int) n1)) {
                    System.out.println("Must enter number and >0");
                }
                break;
            } catch (Exception e) {
                System.out.println("Must enter an integer");
            }
        } while (true);
        return n1;
    }

    public static double checkDouble(String nhap) {

        int n1;
        do {
            try {
                System.out.println(nhap);
                n1 = Integer.parseInt(in.readLine());
                if (!Character.isDigit(n1)) {
                    System.out.println("Must enter input digit");
                    continue;
                } else if (n1 < 0) {
                    System.out.println("Salary must greater than zero");
                    continue;
                }
                break;

            } catch (Exception e) {
                System.out.println("Thang ngu nhap phai nhap so nguyen");
            }
        } while (true);
        return (double) n1;
    }

    public static String checkString(String nhap) {

        String n;
        do {
            try {
                System.out.println(nhap);
                n = in.readLine();
                if (n.isEmpty()) {
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Loi nhap roi cha noi");
            }
        } while (true);
        return n;

    }

    public static int checkInputIntLimit(int min, int max) throws IOException {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.readLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    
    public static String InputString() throws IOException {
        while (true) {
            String result = in.readLine().trim();
            if (result.isEmpty()) {
                System.out.println("Cannot be empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
     public static boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkString("Enter choice");
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
}
