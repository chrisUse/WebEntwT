/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.*;

/**
 * Provides a simple wish list for the user. Stores the products in the list 
 * products. Provides methods to add and remove products to the list.
 * @author Marco Wilhelm, delbertooo
 */
public class WishList {
    private List<Product> products = new ArrayList<Product>();

    public WishList() {
    }
    
    public WishList(WishList l) {
        this.products = l.getProducts();
    }
    
    
    public List<Product> getProducts() {
        List<Product> clone = new ArrayList<Product>(products.size());
        for (Product item : products) {
            clone.add(new Product(item));
        }
        return clone;
    }
    
    
    public boolean setProducts(List<Product> newProducts){        
        this.products = new ArrayList<Product>(newProducts.size());
        for (Product item : newProducts) {
            boolean res = this.products.add(new Product(item));
            if(!res){
                return false;
            }
        }
        return true;
    }
}
