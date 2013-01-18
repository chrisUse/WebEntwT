/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.*;

/**
 *
 * @author drubner, delbertooo
 */
public class Cart {

    private List<ProductInCart> productsInCart = new ArrayList<ProductInCart>();

    public Cart() {
    }
    
    public Cart(Cart c) {
        this.productsInCart = c.getProductsInCart(); // deep copy
    }

    public List<ProductInCart> getProductsInCart() {
        List<ProductInCart> clone = new ArrayList<ProductInCart>(productsInCart.size());
        for (ProductInCart item : productsInCart) {
            clone.add(new ProductInCart(item));
        }
        return clone;
    }
    
    public int getCountOfProduct(int pProductId)
    {
        for(ProductInCart tProduct:productsInCart)
            if(tProduct.getId() == pProductId)
                return tProduct.getCount();
        
        return 0;
    }
    
    public boolean addProduct(ProductInCart pProduct)
    {
        return productsInCart.add(pProduct);
    }
    
    public boolean addProduct(int pProductId)
    {
        return productsInCart.add(new ProductInCart(1, pProductId));
    }
    
    public boolean addProduct(Product pProduct)
    {
        return this.addProduct(pProduct.getId());
    }
    
    public boolean removeProduct(int pProductId)
    {
        for(ProductInCart tProduct:productsInCart)
            if(tProduct.getId() == pProductId)
                return productsInCart.remove(tProduct);
        
        return false;
    }
    
    public boolean changeQuantity(int pProductId, int pQuantity){
         for(ProductInCart product:productsInCart)
         {
            if(product.getId() == pProductId)
            {
                product.setCount(pQuantity);
                return true;
            }
         }
         
         return false;
    }
    
    public boolean increaseQuantity(int pProductId){
         for(ProductInCart tProduct:productsInCart)
         {
            if(tProduct.getId() == pProductId)
            {
                tProduct.setCount(tProduct.getCount() + 1);
                return true;
            }
         }
         return false;
    }
    
    public boolean decreaseQuantity(int pProductId){
         for(ProductInCart tProduct:productsInCart)
         {
            if(tProduct.getId() == pProductId)
            {
                if(tProduct.getCount() > 0)
                    tProduct.setCount(tProduct.getCount() - 1);
                    
                return true;
            }
         }
         return false;
    }
    
    public boolean isInCart(int pProductID)
    {
        for(ProductInCart tProductIC : productsInCart)
            if(tProductIC.getId() == pProductID)
                return true;
   
        return false;
    }
    
    public void clearCart()
    {
        productsInCart.clear();
    }
}
