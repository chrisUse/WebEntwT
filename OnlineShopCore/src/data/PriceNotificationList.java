/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.*;
/**
 *
 * @author stenzel
 */
public class PriceNotificationList {
    private List<PriceNotification> priceNotifications = new ArrayList<PriceNotification>();
    
    public PriceNotificationList(){
        
    }
    public boolean addNotification(PriceNotification pNotify){
        return priceNotifications.add(pNotify);
    }
    
    public boolean updateNotification(int productID, float price){
        if(!priceNotifications.isEmpty()){
      
            for (PriceNotification item:priceNotifications){
                if(item.getProductID() == productID) {
                    item.setPrice(price);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean removeNotification(PriceNotification pNotify){
        return priceNotifications.remove(pNotify);
    }
}
