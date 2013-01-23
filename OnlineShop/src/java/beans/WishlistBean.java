/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.sun.xml.internal.ws.api.client.WSPortInfo;
import data.Product;
import data.Storage;
import exceptions.ProductAlreadyExistsException;
import exceptions.ProductDoesNotExistException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import webservice.ProductDoesNotExistException_Exception;

/**
 *
 * @author marco
 */

@ManagedBean
@NoneScoped
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
    
    public boolean removeProductWS(int userID, int productID) throws ProductDoesNotExistException{
        webservice.WebEntw_Service ws = new webservice.WebEntw_Service();
        webservice.WebEntw wsp = ws.getWebEntwPort();
        
        try {
            return wsp.removeProductFromWishlist(userID, productID);
        } catch (ProductDoesNotExistException_Exception ex) {
            throw new ProductDoesNotExistException("pdne");
        }
    }
    
    
    public boolean checkForValidProduct(int productID){
        if(data.Storage.getInstance().getProductById(productID) == null){
            return false;
        }
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
