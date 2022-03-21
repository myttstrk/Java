/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StoreManager;
import Controller.Utility;
import Model.Product;
import Model.StoreKeeper;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author myth.superking
 */
public class View_Store {

    StoreManager Storemng = new StoreManager();

    public void View_Menu() {
        ArrayList<Product> listProduct = Storemng.getListProduct();
        if (!Storemng.checklistProductEmpty()) {//in ra list nếu tồn tại sau khi thực hiện chọn
            System.out.println("List Product Currently");
            System.out.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "id ", "name ",
                    "location", "price", "Exp date", "Date of Manu", " category", "storekeeper", "receipt date");
            for (Product product : listProduct) {
                product.print();

            }
        }
        System.out.println("Please select options:");
        System.out.println(" 1.	Add storekeeper");
        System.out.println(" 2.	Add product");
        System.out.println(" 3.	Update product");
        System.out.println(" 4.	Search by Name,Category,Storekeeper,ReceiptDate");
        System.out.println(" 5.	Sort by Expiry date,Date of manufacture");
        System.out.println(" 6.Exit");
        System.out.print(" Enter your choice: ");

    }

    public void View_AddStoreKeeper() throws IOException {
        while (true) {
            String id = Utility.checkString("Enter storekeeper id");
            if (Storemng.checkStoreKeeperIdExist(id)) {//kiểm tra xem có có trùng không
                System.out.println("Id has exist . Please re-input");
                continue;
            }
            String name = Utility.checkString("Enter storekeeper name");
            Storemng.addStoreKeeper(id, name);
            System.out.println("Added storekeeper successfully");
            System.out.println(" ");
            break;
        }
        return;
    }

    public void View_AddProduct() throws IOException {
        //add product bắt buộc phải có storekeepeer,nên em yêu cầu người dùng nhập tên của storekeeper trước
        //rồi mới add product
        while (true) {
            if (Storemng.checklistStoreKeeperEmpty()) {
                System.out.println("You must enter storekeeper first");
                View_AddStoreKeeper();
            }
            String storeKeeperID = Utility.checkString("Enter storekeeper id");
            if (!Storemng.checkStoreKeeperIdExist(storeKeeperID)) {
                System.out.println("Must enter avaiable storekeeper");
                System.out.format("%-10s%-10s\n", "id SK", "name SK");
                for (StoreKeeper stk : Storemng.getListStoreKeeper()) {
                    stk.display();
                }
                continue;
            } else {

                String id = Utility.checkString("Enter product id");//nếu id của product trùng thì y/c nhập lại
                if (Storemng.checkProductIdExist(id)) {
                    System.out.println("Id has already existed,please reinput");
                    continue;
                }
                String name = Utility.checkString("Enter product name");
                String location = Utility.checkString("Enter product location");
                int price = Utility.checkInt("Enter product price");
                String DoManu = Utility.checkDate("Enter  product Date of manufacturer");
                String expDate = Utility.checkDate("Enter product expire date");
                if (!Utility.compareDate(DoManu, expDate)) {
                    System.out.println("Please reinput valid date");
                    continue;
                }
                String category = Utility.checkString("Enter category");
                String receiptDate = Utility.checkDate("Enter receipt Date");

                Storemng.addProduct(id, name, location, price, expDate, DoManu, category, receiptDate, storeKeeperID);
                System.err.println("Added Product Success");
                System.out.println("");
                break;
            }
        }
        return;
    }

    public void View_UpdateProduct() throws IOException {
//yêu cầu phải có storekeeper check nếu có hay không,rồi check product của storekeeper đó
        while (true) {
            String storeKeeperID = Utility.checkString("Enter storekeeper ID to update");
            if (Storemng.checklistStoreKeeperEmpty()) {
                System.out.println("You must enter Store Keeper first");
                View_AddStoreKeeper();
                return;
            }
            if (!Storemng.checkStoreKeeperIdExist(storeKeeperID)) {
                System.out.println("Not found storekeeper");
                System.out.println("Please reinput");
                continue;
            }
            if (Storemng.checklistProductEmpty()) {
                System.out.println("You must add product first");
                View_AddProduct();
                continue;
            }
            String productID = Utility.checkString("Enter product ID");
            if (!Storemng.checkProductIdExist(productID)) {
                System.out.println("Not found Product by this id");
                continue;
            } else {

                for (Product product : Storemng.getListProduct()) {//sửa 1 trong những thông tin trên
                    if (productID.equalsIgnoreCase(product.getId())) {
                        System.out.println("(1)ID (2)Name (3)Location (4)Price (5)Date of Manufacture (6)Expire Date (7)Category (8)Receipt Date ");
                        System.out.println("Please choose information to change");//sua lai nhap nhieu truong,kiem tra phan domu va expire
                        System.out.println("Enter how many informations you want to change");
                        int choice = Utility.checkInt("Enter quantity");
                        for (int i = 0; i < choice; i++) {
                            System.out.println("(1)ID (2)Name (3)Location (4)Price (5)Date of Manufacture (6)Expire Date (7)Category (8)Receipt Date ");
                            System.out.println("Please choose information to change");
                            int choose = Utility.checkInputIntLimit(1, 10);
                            switch (choose) {
                                case 1:
                                    String id1 = Utility.checkString("Enter new id");
                                    product.setId(id1);
                                    System.out.println("Changed successfully");
                                    continue;
                                case 2:
                                    String name = Utility.checkString("Enter new Name: ");
                                    product.setName(name);
                                    System.out.println("Changed successfully");
                                    continue;
                                case 3:
                                    String location = Utility.checkString("Enter  new location:");
                                    product.setLocation(location);
                                    System.out.println("Changed successfully");
                                    continue;
                                case 4:
                                    int price = Utility.checkInt("Enter new price");
                                    product.setPrice(price);
                                    System.out.println("Changed successfully");
                                    continue;
                                case 5:
                                    String DOManu = Utility.checkDate("Enter Date of manufacturer");
                                    if (!Utility.compareDate(DOManu, product.getExpDate())) {
                                        System.out.println("Invalid Date change");
                                        continue;
                                    } else {
                                        product.setDOManu(DOManu);
                                        System.out.println("Changed successfully");
                                        continue;
                                    }
                                case 6:
                                    String exp = Utility.checkDate("Enter new exp date");
                                    if (!Utility.compareDate(product.getDOManu(), exp)) {
                                        System.out.println("Invalid Date change");
                                        continue;
                                    } else {
                                        product.setExpDate(exp);
                                        System.out.println("Changed successfully");
                                        continue;
                                    }

                                case 7:
                                    String category = Utility.checkString("Enter new category");
                                    product.setCategory(category);
                                    System.out.println("Changed successfully");
                                    continue;
                                case 8:
                                    String receiptdate = Utility.checkString("Enter new salary");
                                    if (!Utility.compareReceiptDate(product.getDOManu(), product.getExpDate(), receiptdate)) {
                                        System.out.println("Invalid Date change,must between DOManu and Exp Date");
                                    } else {
                                        product.setReceiptDate(receiptdate);
                                        System.out.println("Changed successfully");
                                        continue;
                                    }

                            }
                            break;
                        }
                    }
                }
            }
            return;
        }
    }

    public void View_Search() throws IOException {
        while (true) {
            if (Storemng.checklistStoreKeeperEmpty()) {
                System.out.println("You must enter Store Keeper first");
                View_AddStoreKeeper();
            }
            if (Storemng.checklistProductEmpty()) {
                System.out.println("You must enter Product first");
                View_AddProduct();
            }
            System.out.println("Please choose an option to search");
            System.out.println("1.Name 2.Category 3.Storekeeper 4.ReceiptDate ");
            int a = Utility.checkInputIntLimit(1, 4);
            switch (a) {
                case 1:
                    String b = Utility.checkString("Enter name");
                    ArrayList<Product> ls1 = Storemng.SearchByName(b);
                    if (ls1.isEmpty()) {
                        System.err.println("Not found");
                        return;
                    } else {
                        for (Product prd : ls1) {
                            prd.print();
                        }
                    }
                    return;
                case 2:
                    String c = Utility.checkString("Enter category");
                    ArrayList<Product> ls2 = Storemng.SearchByCategory(c);

                    if (ls2.isEmpty()) {
                        System.out.println("Not found");
                        return;
                    } else {
                        for (Product prd : ls2) {
                            prd.print();
                        }
                    }
                    return;
                case 3:
                    String g = Utility.checkString("Enter Storekeeper id");
                    ArrayList<Product> ls3 = Storemng.SearchBySTK(g);
                    if (ls3.isEmpty()) {
                        System.out.println("Not found");
                        return;
                    } else {
                        for (Product prd : ls3) {
                            prd.print();
                        }
                    }
                    return;
                case 4:
                    String e = Utility.checkDate("Enter receipt date");
                    ArrayList<Product> ls4 = Storemng.SearchByReceipt(e);
                    if (ls4.isEmpty()) {
                        System.out.println("Not found");
                        return;
                    } else {
                        for (Product prd : ls4) {
                            prd.print();
                        }
                    }
                    return;
            }

        }

    }

    public void View_Sort() throws IOException, ParseException {

        if (Storemng.checklistStoreKeeperEmpty()) {
            System.out.println("You must enter Store Keeper first");
            View_AddStoreKeeper();
        }
        if (Storemng.checklistProductEmpty()) {
            System.out.println("You must enter Product first");
            View_AddProduct();
        }
        System.out.println("Choose an option to sort");
        System.out.println("Sort by Expiry date(1)|| Sort by Date of manufacture(2)");
        int a = Utility.checkInt("Enter ");
        switch (a) {
            case 1://tạo ra 1 list mới mà không thay đổi list cũ
                ArrayList<Product> lsSortByExp = Storemng.ListProductSortByExp();

                System.out.printf("%-10s%-10s%-10s%-10s%-10s\t%-10s%-10s\t%-10s%-10s\n", "id ", "name ", "location", "price", "Exp date", "Date of Manu", " category", "storekeeper", "receipt date");
                break;

            case 2:////tạo ra 1 list mới mà không thay đổi list cũ
                System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n", "id ", "name ", "location", "price", "Exp date", "Date of Manu", " category", "storekeeper", "receipt date");
                ArrayList<Product> lsSortByDoma = Storemng.ListProductSortByDoma();
                break;

        }
    }

}
