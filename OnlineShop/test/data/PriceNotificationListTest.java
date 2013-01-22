/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;
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
public class PriceNotificationListTest {
    
    PriceNotificationList instance;
    PriceNotification inst;
    List<PriceNotification> testList;
    int refProductID;
    int refPrice;
    
    public PriceNotificationListTest() {
        refProductID        = 23;
        refPrice        = 30;
        inst = new PriceNotification(refProductID, refPrice);
        instance = new PriceNotificationList();
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
    public void testAddNotification() {
        System.out.println("addNotification");
        boolean testResult = false;
        boolean test = instance.addNotification(refProductID, refPrice);
        testList = instance.getPriceNotifications();
        for(PriceNotification item : testList) {
            if(item.getProductID() == refProductID){
                testResult = true;
            }
            else {
                testResult = false;
            }
        }
        assertTrue(testResult);
    }
}
