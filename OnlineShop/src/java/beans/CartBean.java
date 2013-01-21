/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import data.Product;
import data.ProductInCart;
import data.Storage;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author danny
 */
@ManagedBean
@SessionScoped
public class CartBean 
{
    private List<ProductInCart> productsInCart = new ArrayList<ProductInCart>();

    private String  description;
    private String  name;
    private float   price;
    
    public CartBean() {
    }
    
    public CartBean(CartBean c) {
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
    
    public void addProduct(int pProductId)
    {
        productsInCart.add(new ProductInCart(1, pProductId));
    }
    
    public void addProduct(String pProductId)
    {
        productsInCart.add(new ProductInCart(1, Integer.getInteger(pProductId)));
    }
    
    public void addProduct(Product pProduct)
    {
        this.addProduct(pProduct.getId());
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
    
    public void initializeProduct(int pProductID)
    {
        Product tProduct    = Storage.getInstance().getProductById(pProductID);
        this.description    = tProduct.getDescription();
        this.name           = tProduct.getName();
        this.price          = tProduct.getPrice();
        
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public float getPrice()
    {
        return price;
    }
}
