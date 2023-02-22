/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Employee;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author myth.superking
 */
public class Utility {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static int checkInt(String nhap) {
        String n;
        int n1;
        do {
            try {
                System.out.println(nhap);
                n = in.readLine();
                if (n.isEmpty()) {
                    continue;
                }
                n1 = Integer.parseInt(n);
                break;
            } catch (Exception e) {
                System.out.println("Thang ngu nhap phai nhap so nguyen");
            }
        } while (true);
        return n1;
    }

    public static double checkDouble(String nhap) {
        String n;
        double n1;
        do {
            try {
                System.out.println(nhap);
                n = in.readLine();
                if (n.isEmpty()) {
                    continue;
                }
                n1 = Double.parseDouble(n);
                break;
            } catch (Exception e) {
                System.out.println("Thang ngu nhap phai nhap so thuc");
            }
        } while (true);
        return n1;
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

   

    public static boolean checkNhapYN() throws IOException {
        String d;
        d = in.readLine();
        if (d.compareToIgnoreCase("Y") == 0) {
            return true;
        } else {
            return false;
        }

    }

    public static String checkEmail(String mess) throws IOException {
        String email;
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        while (true) {
            System.out.println(mess);
            email = in.readLine();
            if (!email.matches(regex)) {
                System.out.println("Please input a valid email");
                continue;
            } else {
                return email;
            }
        }

    }

    public static String checkPhone(String str) throws IOException {
//require to input 10 number phone
        String phoneNo;
        while (true) {
            System.out.println("Enter phone");
            phoneNo = in.readLine();
            if (phoneNo.matches("\\d{10}")) {
                return phoneNo;

            } else {
                System.out.println("Please reinput ten-number phone number ");
                continue;

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

    public static String checkSex(String nhap) throws IOException {
        String n;
        String n1 = "Male";
        String n2 = "Female";
        Boolean n3;
        do {
            try {
                System.out.println(nhap);
                n = in.readLine();
                if (n.isEmpty()) {
                    continue;
                }
                if (n.equalsIgnoreCase("Male")) {
                    return n1;
                }
                if (n.equalsIgnoreCase("Female")) {
                    return n2;
                }

            } catch (Exception e) {
                System.out.println("Must enter Male or Female");
            }
        } while (true);

    }

    public static String checkDate(String mess) throws IOException {
        String sdate;
        while (true) {
            System.out.println(mess);
            sdate = in.readLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");//sử dụng  SDF  lấy form ngày-tháng-năm
            formatter.setLenient(false);
            try {
                Date date1 = formatter.parse(sdate);
                Calendar c = Calendar.getInstance();
                break;

            } catch (ParseException e) {
                System.out.println(sdate + " is Invalid Date format,please reinput");

            }

        }
        return sdate;
    }
}
