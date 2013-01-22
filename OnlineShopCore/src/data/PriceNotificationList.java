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
    //PriceNotification pNotify;
    
    public PriceNotificationList(){
        
    }
    
    public boolean addNotification(int productID, int price) {
         return this.priceNotifications.add(new PriceNotification(productID, price));
         
         //return true;
    }
    
    public List<PriceNotification> getPriceNotifications() {
        List<PriceNotification> clone = new ArrayList<PriceNotification>(priceNotifications.size());
        for (PriceNotification item : priceNotifications) {
            clone.add(new PriceNotification(item));
        }
        return clone;
    }
    
    public boolean updateNotification(int productID, int price){
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
