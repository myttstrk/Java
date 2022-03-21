/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Product;
import Model.StoreKeeper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

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

    public static String checkName(String name) throws IOException {
        String regex = "[0-9]+";
        boolean flag = true;
        Pattern p = Pattern.compile(regex);
        do {
            try {
                System.out.println("Enter name");
                name = in.readLine();
                for (int i = 0; i < name.length(); i++) {
                    if (Character.isDigit(i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag == false && name.isEmpty()) {
                    System.out.println("Please enter a valid name");
                    continue;

                }
                break;
            } catch (Exception e) {
                System.out.println("Must enter a valid name");
            }

        } while (true);
        return name;
    }

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
                if (n1 <= 0) {
                    System.out.println("Must enter >0");
                    continue;
                } else {

                    break;
                }
            } catch (Exception e) {
                System.out.println("Must enter an integer");
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

    public static boolean checkIdExist(ArrayList<Product> ls, String id) {
        for (Product item : ls) {
            if (id.equalsIgnoreCase(item.getId())) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkNhapYN(String a) throws IOException {

        while (true) {
            a = in.readLine();
            if (a.isEmpty()) {
                System.out.println("Cannot be empty");
                continue;
            }
            if (a.equalsIgnoreCase("Y")) {
                return true;
            } else if (a.equalsIgnoreCase("N")) {
                return false;
            } else {
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

    public static Date checkManuDate() throws IOException {
        String sdate;
        Date date1;
        while (true) {
            System.out.println("Enter manu date");
            sdate = in.readLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");//sử dụng  SDF  lấy form ngày-tháng-năm
            try {
                date1 = formatter.parse(sdate);
                break;

            } catch (ParseException e) {
                System.out.println(sdate + " is Invalid Date format,please reinput");

            }

        }
        return date1;
    }

    public static Date checkExpDate(String mess) throws IOException {
        String sdate;
        Date date2;
        while (true) {
            System.out.println(mess);
            sdate = in.readLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");//sử dụng  SDF  lấy form ngày-tháng-năm
            formatter.setLenient(false);
            try {
                date2 = formatter.parse(sdate);
                if (checkManuDate().after(date2)) {
                    System.out.println("true");
                }
                break;

            } catch (ParseException e) {
                System.out.println(sdate + " is Invalid Date format,please reinput");

            }

        }
        return date2;
    }

    public static boolean compareDate(String a, String b) throws IOException {
        Date datea;
        Date dateb;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");//sử dụng  SDF  lấy form ngày-tháng-năm   
        try {
            datea = formatter.parse(a);
            dateb = formatter.parse(b);
            if (datea.after(dateb) ||datea.equals(dateb)) {
                System.out.println("Expire date is before Manufacture date,Impossible");
                return false;
            }
        } catch (ParseException e) {
            System.out.println("Input is Invalid Date format,please reinput");
        }
        return true;
    }

    public static String checkDate(String mess) throws IOException {
        String sdate;
        while (true) {
            System.out.println(mess);
            sdate = in.readLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");//sử dụng  SDF  lấy form ngày-tháng-năm      
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

    public static boolean compareReceiptDate(String Manu, String expdate, String receiptdate) throws IOException {
        Date datea;
        Date dateb;
        Date datec;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");//sử dụng  SDF  lấy form ngày-tháng-năm   
        try {
            datea = formatter.parse(Manu);
            dateb = formatter.parse(expdate);
            datec = formatter.parse(receiptdate);
            if (datea.after(datec) && dateb.before(datec)) {
                System.out.println("Receipt Date must between expire date and Manufacture date");
                return false;
            } else {
                return true;
            }
        } catch (ParseException e) {
            System.out.println("Input is Invalid Date format,please reinput");

        }
        return true;
    }
}
