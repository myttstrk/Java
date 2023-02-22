/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author myth.superking
 */
public class Product {
   private String id;
   private String name;
   private String location;
   private int price;
   private String expDate;
   private String DOManu;
   private String category;
   private String receiptDate;
   private String storeKeeper;

    public String getId() {
        return id;
    }

    public void setId(String id) {
         try {
            if (!id.isEmpty()) {
                this.id = id;
            }
        } catch (NullPointerException ex) {
            System.out.println(" Can't be null");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
         try {
            if (!name.isEmpty()) {
                this.name =name;
            }
        } catch (NullPointerException ex) {
            System.out.println(" Can't be null");
        }

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
         try {
            if (!location.isEmpty()) {
                this.location = location;
            }
        } catch (NullPointerException ex) {
            System.out.println(" Can't be null");
        }

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
         try {
            if (price<= 0) {
                throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!");
            }else{
                this.price=price;
            }
        } catch (Exception e){
           throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!");
        }
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        try {
            if (!expDate.isEmpty()) {
                this.expDate = expDate;
            }
        } catch (NullPointerException ex) {
            System.out.println(" Can't be null");
        }

    }

    public String getDOManu() {
        return DOManu;
    }

    public void setDOManu(String DOManu) {
        try {
            if (!DOManu.isEmpty()) {
                this.DOManu =DOManu;
            }
        } catch (NullPointerException ex) {
            System.out.println(" Can't be null");
        }

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
       try {
            if (!category.isEmpty()) {
                this.category = category;
            }
        } catch (NullPointerException ex) {
            System.out.println(" Can't be null");
        }

    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        try {
            if (!receiptDate.isEmpty()) {
                this.receiptDate = receiptDate;
            }
        } catch (NullPointerException ex) {
            System.out.println(" Can't be null");
        }

    }

   

    public Product(String id, String name, String location, int price, String expDate, String DOManu, String category, String receiptDate, String storeKeeper) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.DOManu = DOManu;        
        this.expDate = expDate;
        this.category = category;
        this.receiptDate = receiptDate;
        this.storeKeeper = storeKeeper;
    }

    public String getStoreKeeper() {
        return storeKeeper;
    }

    public void setStoreKeeper(String storeKeeper) {
       try {
            if (!storeKeeper.isEmpty()) {
                this.storeKeeper =storeKeeper;
            }
        } catch (NullPointerException ex) {
            System.out.println(" Can't be null");
        }

    }

    public void print(){
System.out.format("%-15s%-15s%-15s%-15d%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n", id,name,location,price,expDate,DOManu,category,storeKeeper,receiptDate);

    }
  
    
    
}
