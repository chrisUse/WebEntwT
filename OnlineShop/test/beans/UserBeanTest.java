/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author delbertooo
 */
public class UserBeanTest {
    
    /*public UserBeanTest() {
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
    }*/


    /**
     * Test of completeRegistration method, of class UserBean.
     */
    @Test
    public void testCompleteRegistration() {
        System.out.println("completeRegistration");
        UserBean instance = new UserBean();
        String expResult = "FinalizeRegister";
        String result = instance.completeRegistration();
        assertEquals(expResult, result);
        assertEquals(false, instance.isRegistrationComplete());
        
        instance.setName("test name");
        instance.setMail("test@name.de");
        instance.setPassword("password");
        instance.setCity("my city");
        instance.setStreet("my street");
        
        expResult = "FinalizeRegister";
        result = instance.completeRegistration();
        
        assertEquals(expResult, result);
        assertEquals(true, instance.isRegistrationComplete());
        
        instance.cleanUp();
        instance.setName("test name");
        instance.setMail("test@name.de");
        instance.setPassword("password");
        instance.setCity("my city");
        instance.setStreet("my street");
        
        expResult = "FinalizeRegister";
        result = instance.completeRegistration();
        
        assertEquals(expResult, result);
        assertEquals(false, instance.isRegistrationComplete());  //duplicate mail
    }
}
