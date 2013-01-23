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
        if( data.Storage.getInstance().getCouponByCode(couponCode)){
            data.Storage.getInstance().deleteCouponByCode(couponCode);
            return "CouponAccept.jsp";
        }
        return "CouponDenied.jsp";
    }
    
    public String validateCodeWithWS() {
        webservice.WebEntw_Service ws = new webservice.WebEntw_Service();
        webservice.WebEntw wsp = ws.getWebEntwPort();
        
        return wsp.validateCode(couponCode);
    }
}
