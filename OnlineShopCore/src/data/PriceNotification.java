/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.*;

/**
 * @author Stephan Stenzel
 */
public class PriceNotification {

    private int price;
    private int productID;

    public PriceNotification(int productID, int nPrice) {
        this.price = nPrice;
        this.productID = productID;
    }
    
    public PriceNotification(PriceNotification nPriceNotification) {
        this.price = nPriceNotification.price;
        this.productID = nPriceNotification.productID;
    }  

    public float getPrice() {
        return price;
    }

    public void setPrice(int nPrice) {
        price = nPrice;
    }
    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int nProductID) {
        productID = nProductID;
    }
}
