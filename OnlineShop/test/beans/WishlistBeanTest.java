/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import data.Product;
import data.Storage;
import exceptions.ProductAlreadyExistsException;
import exceptions.ProductDoesNotExistException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marco
 */
public class WishlistBeanTest {
    
    public WishlistBeanTest() {
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

    /**
     * Test of getProducts method, of class WishlistBean.
     */
    @Test
    public void testTest() {
        // init
        int userID = 1;
        int productID = 1;
        
        WishlistBean instance = new WishlistBean();
        List expResult = new ArrayList<Product>();
        List result = instance.getProducts(userID);
        
        // 1 test
        assertEquals(expResult, result);
        assertEquals(expResult.size(), result.size());
        
        // add first product
        try{
            instance.addProduct(userID, productID);
            result = instance.getProducts(userID);
            expResult.add(Storage.getInstance().getProductById(productID));
        }
        catch(ProductAlreadyExistsException e){
            Logger.getLogger(WishlistBeanTest.class.getName()).log(Level.SEVERE, "", e);
            fail("the product shouldn't already exist");
        }
        
        assertEquals(expResult.size(), result.size());
        
        
        // add 2nd product
        
        productID++;
        try{
            instance.addProduct(userID, productID);
            result = instance.getProducts(userID);
            expResult.add(Storage.getInstance().getProductById(productID));
        }
        catch(ProductAlreadyExistsException e){
            Logger.getLogger(WishlistBeanTest.class.getName()).log(Level.SEVERE, "", e);
            fail("the product shouldn't already exist");
        }
        
        assertEquals(expResult.size(), result.size());
        
        
        // add 3rd product
        productID++;
        try{
            instance.addProduct(userID, productID);
            result = instance.getProducts(userID);
            expResult.add(Storage.getInstance().getProductById(productID));
        }
        catch(ProductAlreadyExistsException e){
            Logger.getLogger(WishlistBeanTest.class.getName()).log(Level.SEVERE, "", e);
            fail("the product shouldn't already exist");
        }
        
        assertEquals(expResult.size(), result.size());
        
        
        // addition of  4th product should fail (same product ID)
        try{
            instance.addProduct(userID, productID);
            result = instance.getProducts(userID);
        }
        catch(ProductAlreadyExistsException e){
            Logger.getLogger(WishlistBeanTest.class.getName()).log(Level.INFO, "NO PANIC! This Exception should be thrown!", e);
            assertEquals(expResult.size(), result.size());
        }
        
        assertEquals(expResult.size(), result.size());
                
        
        // add some products with invalid IDs
        try{
            productID = 0;
            instance.addProduct(userID, productID);
            result = instance.getProducts(userID);
            productID = -1;
            instance.addProduct(userID, productID);
            result = instance.getProducts(userID);
            productID = 2000;
            instance.addProduct(userID, productID);
            result = instance.getProducts(userID);
        }
        catch(ProductAlreadyExistsException e){
            Logger.getLogger(WishlistBeanTest.class.getName()).log(Level.SEVERE, "", e);
            fail("the product shouldn't already exist");
        }
        
        
        assertEquals(expResult.size(), result.size());
        for(int i=0; i<expResult.size(); i++){
            assertEquals(((Product)expResult.get(i)).getName(), ((Product)result.get(i)).getName());
        }
        

        // remove products
        productID = 0;
        try {
            instance.removeProduct(userID, productID);
            result = instance.getProducts(userID);
        } catch (ProductDoesNotExistException e) {
            Logger.getLogger(WishlistBeanTest.class.getName()).log(Level.INFO, "NO PANIC! This Exception should be thrown!", e);
        }
        
        assertEquals(expResult.size(), result.size());
        
        productID++;
        try {
            instance.removeProduct(userID, productID);
            result = instance.getProducts(userID);
            expResult.remove(0);
        } catch (ProductDoesNotExistException e) {
            Logger.getLogger(WishlistBeanTest.class.getName()).log(Level.SEVERE, "", e);
            fail("this product should have been existing");
        }
        
        assertEquals(expResult.size(), result.size());
        
        productID++;
        try {
            instance.removeProduct(userID, productID);
            result = instance.getProducts(userID);
            expResult.remove(0);
        } catch (ProductDoesNotExistException e) {
            Logger.getLogger(WishlistBeanTest.class.getName()).log(Level.SEVERE, "", e);
            fail("this product should have been existing");
        }
        
        assertEquals(expResult.size(), result.size());
        
        productID++;
        try {
            instance.removeProduct(userID, productID);
            result = instance.getProducts(userID);
            expResult.remove(0);
        } catch (ProductDoesNotExistException e) {
            Logger.getLogger(WishlistBeanTest.class.getName()).log(Level.SEVERE, "", e);
            fail("this product should have been existing");
        }

        assertEquals(0, result.size());
        assertEquals(expResult.size(), result.size());
        
        
        // last big test
        // add products with many IDs (valid and invalid)
        for(int i = Short.MIN_VALUE; i<=Short.MAX_VALUE; i++){
            try{
                instance.addProduct(userID, i);
                result = instance.getProducts(userID);
                //if(i % 1000 == 0)
                    //System.out.println("current product ID: " + i);
            }
            catch(ProductAlreadyExistsException e){
                Logger.getLogger(WishlistBeanTest.class.getName()).log(Level.SEVERE, "Error with ID: " + String.valueOf(i), e);
                fail("the product shouldn't already exist");
            }
        }
        
        assertEquals(Storage.getInstance().getAllProducts().size(), result.size());
        
        // and again
        for(int i = Short.MIN_VALUE; i<=Short.MAX_VALUE; i++){
            try{
                instance.addProduct(userID, i);
                result = instance.getProducts(userID);
                //if(i % 1000 == 0)
                    //System.out.println("current product ID: " + i);
            }
            catch(ProductAlreadyExistsException e){
                Logger.getLogger(WishlistBeanTest.class.getName()).log(Level.INFO, "Following product ID already existed: " + String.valueOf(i) + " and it should", e);
            }
        }
        
        assertEquals(Storage.getInstance().getAllProducts().size(), result.size());
        
        // now remove everything
        for(int i = Short.MIN_VALUE; i<=Short.MAX_VALUE; i++){
            try {
               instance.removeProduct(userID, i);
               result = instance.getProducts(userID);
            } catch (ProductDoesNotExistException e) {
               //Logger.getLogger(WishlistBeanTest.class.getName()).log(Level.SEVERE, "", e);
               //fail("this product should have been existing");
            }
        }
        
        assertEquals(0, result.size());
    }
}
