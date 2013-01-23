/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import data.Storage;
import data.User;
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
public class SessionBeanTest {
    
    /*public SessionBeanTest() {
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

    
    private Integer loginAsAdmin(SessionBean instance, boolean withWS) {
        instance.setMail("admin@example.com");
        instance.setPassword("password");
        return withWS ? instance.loginWithWS() : instance.login();
    }
    
    private Integer loginAsAdmin(SessionBean instance) {
        return loginAsAdmin(instance, false);
    }
    
    /**
     * Test of getCurrentUser method, of class SessionBean.
     */
    @Test
    public void testGetCurrentUser() {
        System.out.println("getCurrentUser");
        SessionBean instance = new SessionBean();
        User expResult = null;
        User result = instance.getCurrentUser();
        assertEquals(expResult, result);
        
        loginAsAdmin(instance);
        expResult = Storage.getInstance().getUserById(1);
        result = instance.getCurrentUser();
        assertEquals(expResult.getMail(), result.getMail());

    }

    /**
     * Test of getCurrentUserID method, of class SessionBean.
     */
    @Test
    public void testGetCurrentUserID() {
        System.out.println("getCurrentUserID");
        SessionBean instance = new SessionBean();
        Integer expResult = null;
        Integer result = instance.getCurrentUserID();
        assertEquals(expResult, result);
        
        loginAsAdmin(instance);
        expResult = 1;
        result = instance.getCurrentUserID();
        assertEquals(expResult, result);
    }

    /**
     * Test of isCurrentUserAdmin method, of class SessionBean.
     */
    @Test
    public void testIsCurrentUserAdmin() {
        System.out.println("isCurrentUserAdmin");
        SessionBean instance = new SessionBean();
        boolean expResult = false;
        boolean result = instance.isCurrentUserAdmin();
        assertEquals(expResult, result);
        
        loginAsAdmin(instance);
        expResult = true;
        result = instance.isCurrentUserAdmin();
        assertEquals(expResult, result);
    }

    /**
     * Test of login method, of class SessionBean.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        SessionBean instance = new SessionBean();
        Integer expResult = null;
        Integer result = instance.getCurrentUserID();
        assertEquals(expResult, result);
        
        loginAsAdmin(instance);
        expResult = 1;
        result = instance.getCurrentUserID();
        assertEquals(expResult, result);
    }

    /**
     * Test of loginWithWS method, of class SessionBean.
     */
    @Test
    public void testLoginWithWS() {
        System.out.println("loginWithWS");
        SessionBean instance = new SessionBean();
        Integer expResult = null;
        Integer result = instance.getCurrentUserID();
        assertEquals(expResult, result);
        
        System.out.println(loginAsAdmin(instance, true));
        expResult = 1;
        result = instance.getCurrentUserID();
        assertEquals(expResult, result);
    }

    /**
     * Test of logout method, of class SessionBean.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        SessionBean instance = new SessionBean();
        loginAsAdmin(instance);
        assertNotNull(instance.getCurrentUser());
        instance.logout();
        assertNull(instance.getCurrentUser());
    }
}
