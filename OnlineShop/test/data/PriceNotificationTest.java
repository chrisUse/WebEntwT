/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

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
public class PriceNotificationTest {
    
    PriceNotification instance;
    int refProductID;
    int refPrice;
    
    public PriceNotificationTest() {
        refProductID        = 23;
        refPrice        = 30;
        instance = new PriceNotification(refProductID, refPrice);
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        int result = instance.getPrice();
        assertEquals(refPrice, result);
    }
    
    @Test
    public void testGetProductID() {
        System.out.println("getProductID");
        int result = instance.getProductID();
        assertEquals(refProductID, result);
    }
    
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        int testResult = 10;
        instance.setPrice(testResult);
        int result = instance.getPrice();
        assertEquals(testResult, result);
    }
    
    @Test
    public void testSetProductID() {
        System.out.println("setProductID");
        int testResult = 5;
        instance.setProductID(testResult);
        int result = instance.getProductID();
        assertEquals(testResult, result);
    }
    
}
