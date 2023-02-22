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
public class StoreKeeper {

    String idSK;
    String nameSK;

    public StoreKeeper(String idSK, String nameSK) {
        this.idSK = idSK;
        this.nameSK = nameSK;
    }

    public String getIdSK() {
        return idSK;
    }

    public void setIdSK(String idSK) {
         try {
            if (!idSK.isEmpty()) {
                this.idSK = idSK;
            }
        } catch (NullPointerException ex) {
            System.out.println(" Can't be null");
        }
    }

    public String getNameSK() {
        return nameSK;
    }

    public void setNameSK(String nameSK) {
           try {
            if (!nameSK.isEmpty()) {
                this.nameSK= nameSK;
            }
        } catch (NullPointerException ex) {
            System.out.println(" Can't be null");
        }

    }

    
  

   
    public void display() {
        System.out.format("%-10s%-10s\n", idSK, nameSK);
    }
}
