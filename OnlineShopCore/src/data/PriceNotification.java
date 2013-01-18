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

    private float price;
    private int productID;

    public PriceNotification(float nPrice) {
        price = nPrice;
    }   

    public float getPrice() {
        return price;
    }

    public void setPrice(float nPrice) {
        price = nPrice;
    }
    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int nProductID) {
        productID = nProductID;
    }
}
