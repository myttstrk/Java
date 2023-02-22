/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StoreKeeper;
import Model.Product;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author myth.superking
 */
public class StoreManager {

    private ArrayList<Product> lsProduct = new ArrayList<>();
    private ArrayList<StoreKeeper> lsStoreKeeper = new ArrayList<>();

    public StoreManager() {
    }

    public ArrayList<Product> getListProduct() {// lấy ra list của product
        return lsProduct;
    }

    public void setListProduct(ArrayList<Product> lsProduct) {//set list
        this.lsProduct = lsProduct;
    }

    public ArrayList<StoreKeeper> getListStoreKeeper() {//lấy ra list của storekeeper
        return lsStoreKeeper;
    }

    public void setListStoreKeeper(ArrayList<StoreKeeper> lsStoreKeeper) {
        this.lsStoreKeeper = lsStoreKeeper;
    }
    //check id exist

    public boolean checkProductIdExist(String id) {
        int count = 0;
        for (Product product : lsProduct) {
            if (id.equalsIgnoreCase(product.getId())) {
                count++;
            }
        }
        if (count == 0) {
            return false;
        } else {
            return true;
        }
        //check product exist
    }
    
    public boolean checkStoreKeeperIdExist(String id) {
        for (StoreKeeper strkp : lsStoreKeeper) {
            if (id.equalsIgnoreCase(strkp.getIdSK())) {
                return true;
            }
        }
        return false;
    }

//thêm storekeeper
    public void addStoreKeeper(String id, String name) {
        lsStoreKeeper.add(new StoreKeeper(id, name));

    }
//thêm product

    public void addProduct(String id, String name, String location, int price, String expDate, String DOManu, String category, String receiptDate, String storekeeper) {
        lsProduct.add(new Product(id, name, location, price, expDate, DOManu, category, receiptDate, storekeeper));

    }
//check list empty

    public boolean checklistProductEmpty() {
        return lsProduct.isEmpty();
    }

    public boolean checklistStoreKeeperEmpty() {
        return lsStoreKeeper.isEmpty();
    }

    public ArrayList<Product> SearchByName(String name) throws IOException {
        ArrayList<Product> lsByName = new ArrayList<>();

        for (Product product : lsProduct) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                lsByName.add(product);

            }
        }
        return lsByName;
    }

    public ArrayList<Product> SearchByCategory(String category) throws IOException {
        ArrayList<Product> lsByCategory = new ArrayList<>();

        for (Product product : lsProduct) {
            if (product.getCategory().toLowerCase().contains(category.toLowerCase())) {
                lsByCategory.add(product);
            }
        }
        return lsByCategory;
    }

    public ArrayList<Product> SearchBySTK(String stk) {
        ArrayList<Product> lsByStk = new ArrayList<>();
        for (Product product : lsProduct) {
            if (product.getStoreKeeper().equalsIgnoreCase(stk)) {
                lsByStk.add(product);
            }

        }
        return lsByStk;

    }

    public ArrayList<Product> SearchByReceipt(String receipt) throws IOException {
        ArrayList<Product> lsByReceiptDate = new ArrayList<>();
        for (Product product : lsProduct) {
            if (product.getReceiptDate().equalsIgnoreCase(receipt)) {
                lsByReceiptDate.add(product);
            }
        }
        return lsByReceiptDate;

    }

//sort theo ngày sx
    public ArrayList<Product> ListProductSortByDoma() {//hàm để sort salary,là 1 arraylist mới dựa theo thông tin của arraylist ban đầu,sử dụng comparator
        ArrayList<Product> getListProductByDoma = new ArrayList<>();
        for (Product product : lsProduct) {
            getListProductByDoma.add(product);
        }

        Collections.sort(lsProduct, new Comparator<Product>() {
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");

            @Override
            public int compare(Product o1, Product o2) {
                try {
                    return f.parse(o1.getDOManu()).compareTo(f.parse(o2.getDOManu()));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });
        return getListProductByDoma;
    }

    public ArrayList<Product> ListProductSortByExp() {//hàm để sort salary,là 1 arraylist mới dựa theo thông tin của arraylist ban đầu,sử dụng comparator
        ArrayList<Product> getListProductByExp = new ArrayList<>();
        for (Product product : lsProduct) {
            getListProductByExp.add(product);
        }

        Collections.sort(lsProduct, new Comparator<Product>() {
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");

            @Override
            public int compare(Product o1, Product o2) {
                try {
                    return f.parse(o1.getExpDate()).compareTo(f.parse(o2.getExpDate()));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });
        return getListProductByExp;
    }

}
