/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Stephan
 */
@ManagedBean
@RequestScoped
public class couponBean {
    
    private String couponCode;
    
    public couponBean() {
    }
    
    public String getCouponCode(){
        return couponCode;
    }
    
    public void setCouponCode(String couponCode){
        this.couponCode = couponCode;
    }
    
    public String validateCode() {
        if( data.Storage.getInstance().getCouponByCode(couponCode) != null){
            return "ViewProduct.jsp";
        }
        return "ViewProduct.jsp";
    }
}
