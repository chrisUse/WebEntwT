/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import data.Product;
import exceptions.PriceNotificationListException;
import exceptions.ProductDoesNotExistException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

/**
 *
 * @author Stephan
 */

@ManagedBean
@NoneScoped
public class PriceNotificationListBean {
    
    public boolean invalidProducts = false;
    
    public PriceNotificationListBean() {
    }    
            
    public List<data.PriceNotification> getPriceNotifications(int userID) {
        return data.Storage.getInstance().getUserById(userID).getPriceNotificationList().getPriceNotifications();
    }
    
    /*
    public int getSize(int userID) {
        return data.Storage.getInstance().getUserById(userID).getPriceNotificationList().getPriceNotifications().size();
    }*/
    
    public boolean addNotification(int userID, int productID, int notifyValue) throws PriceNotificationListException{
        if(data.Storage.getInstance().getProductById(productID) == null){
          return false;    
        }
        
        if(contains(userID, productID)){
            throw new PriceNotificationListException("pae");
        }
        
        if(data.Storage.getInstance().getProductById(productID).getPrice() > notifyValue){
            return data.Storage.getInstance().getUserById(userID).getPriceNotificationList().addNotification(productID, notifyValue);
        }
        else {
            throw new PriceNotificationListException("pth");
        }
        
       // List<PriceNotification> tPriceNotifications = data.Storage.getInstance().getUserById(userID).getPriceNotificationList().getPriceNotifications();        
       // tProducts.add(data.Storage.getInstance().getProductById(productID));
    }
    
    public boolean contains(int userID, int productID) {
        for(data.PriceNotification item : data.Storage.getInstance().getUserById(userID).getPriceNotificationList().getPriceNotifications()) {
            if(item.getProductID() == productID){
                return true;
            }
        }
        return false;
    }
}
