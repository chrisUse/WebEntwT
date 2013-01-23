/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stephan
 */
public class coupoBeanTest {
    
    private couponBean cB = new couponBean();
    private String refCode = "111111";
    private float refValue = 11;
    private boolean tAccept;
    data.Coupon coupon;
    data.Storage refStorage;
    
    public coupoBeanTest() {
        coupon = new data.Coupon(refCode, refValue);
        refStorage = data.Storage.getInstance();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testValidateCodeTrue() {
        System.out.println("validateCodeTrue");
        refStorage.addCoupon(coupon);
        cB.setCouponCode(refCode);
        if(cB.validateCode() == "CouponAccept.jsp") {
            tAccept = true;
        }
        else {
            tAccept = false;
        }
        
        assertTrue(tAccept);
    }
    
    @Test
    public void testValidateCodeFalse() {
        System.out.println("validateCodeFalse");
        cB.setCouponCode(refCode);
        if(cB.validateCode() == "CouponDenied.jsp") {
            tAccept = true;
        }
        else {
            tAccept = false;
        }
        
        assertTrue(tAccept);
    }
}
