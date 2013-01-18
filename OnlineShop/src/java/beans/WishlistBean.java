/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import data.Product;
import exceptions.ProductDoesNotExistException;
import exceptions.ProductAlreadyExistsException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author marco
 */

@ManagedBean
@SessionScoped
public class WishlistBean {
    
    public boolean invalidProducts = false;
    
    public WishlistBean() {
    }    
            
    public List<Product> getProducts(int userID) {
        return data.Storage.getInstance().getUserById(userID).getWishList().getProducts();
    }
    
    public int getSize(int userID) {
        return data.Storage.getInstance().getUserById(userID).getWishList().getProducts().size();
    }
    
    public boolean addProduct(int userID, int productID) throws ProductAlreadyExistsException{
        if(data.Storage.getInstance().getProductById(productID) == null){
          return false;    
        }
        
        if(contains(userID, productID)){
            throw new ProductAlreadyExistsException("pae");
        }
        
        List<Product> tProducts = data.Storage.getInstance().getUserById(userID).getWishList().getProducts();        
        tProducts.add(data.Storage.getInstance().getProductById(productID));
        return data.Storage.getInstance().getUserById(userID).getWishList().setProducts(tProducts);
    }
    
    
    public boolean removeProduct(int userID, int productID) throws ProductDoesNotExistException{
        List<Product> tProducts = data.Storage.getInstance().getUserById(userID).getWishList().getProducts();
        for(Product item : tProducts) {
            if(item.getId() == productID)
            {
                tProducts.remove(item);
                return data.Storage.getInstance().getUserById(userID).getWishList().setProducts(tProducts);
            }
        }
        throw new ProductDoesNotExistException("pdne");
    }
    
    
    public boolean checkForValidProduct(int productID){
        if(data.Storage.getInstance().getProductById(productID) == null)
            return false;
        return true;
    }
    
    public void removeInvalidProducts(int userID){
        List<Product> tProducts = getProducts(userID);
        for(data.Product item : tProducts){
            int tID = item.getId();
            if(!checkForValidProduct(tID)){
                try{
                    removeProduct(userID, tID);
                }
                catch(ProductDoesNotExistException ex){}
            }
        }
    }
    

    public boolean contains(int userID, int productID) {
        for(Product item : data.Storage.getInstance().getUserById(userID).getWishList().getProducts()) {
            if(item.getId() == productID){
                return true;
            }
        }
        return false;
    }
}
