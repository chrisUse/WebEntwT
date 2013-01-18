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
 * @author christianlinde
 */
public class StorageTest {
  
  public StorageTest() {
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
   * Test of addUser method, of class Storage.
   */
  @Test
  public void testAddUser() throws Exception {
    System.out.println("addUser");
    User u = null;
    Storage instance = null;
    int expResult = 0;
    int result = instance.addUser(u);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setUser method, of class Storage.
   */
  @Test
  public void testSetUser() {
    System.out.println("setUser");
    User u = null;
    Storage instance = null;
    instance.setUser(u);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of addProduct method, of class Storage.
   */
  @Test
  public void testAddProduct() throws Exception {
    System.out.println("addProduct");
    Product p = null;
    Storage instance = null;
    int expResult = 0;
    int result = instance.addProduct(p);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setProduct method, of class Storage.
   */
  @Test
  public void testSetProduct() {
    System.out.println("setProduct True");
    Product p = Storage.getInstance().getProductById(1);
    
    p.setName("blub");
    p.setPrice(1.0f);
    p.setDescription("noop");
    p.setManufacturer("miaaa");
    
    assertTrue(Storage.getInstance().setProduct(p));
    //Storage instance = null;
    ///instance.setProduct(p);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }

  @Test
  public void testSetProductDiff() {
    System.out.println("setProduct Diff");
    Product p = Storage.getInstance().getProductById(1);
    
    p.setName("blub");
    p.setPrice(1.0f);
    p.setDescription("noop");
    p.setManufacturer("miaaa");
    
    Storage.getInstance().setProduct(p);
    
    Product expProduct = Storage.getInstance().getProductById(1);
    
    System.out.println("Pa: " + p.getName() + " Pb: " + expProduct.getName() );
    
    assertEquals(p.getName(),expProduct.getName());
  }
  
  /**
   * Test of getUserById method, of class Storage.
   */
  @Test
  public void testGetUserById() {
    System.out.println("getUserById");
    int id = 0;
    Storage instance = null;
    User expResult = null;
    User result = instance.getUserById(id);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getProductById method, of class Storage.
   */
  @Test
  public void testGetProductById() {
    System.out.println("getProductById");
    int id = 0;
    Storage instance = null;
    Product expResult = null;
    Product result = instance.getProductById(id);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getAllProducts method, of class Storage.
   */
  @Test
  public void testGetAllProducts() {
    System.out.println("getAllProducts");
    Storage instance = null;
    List expResult = null;
    List result = instance.getAllProducts();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of deleteUserById method, of class Storage.
   */
  @Test
  public void testDeleteUserById() {
    System.out.println("deleteUserById");
    int id = 0;
    Storage instance = null;
    instance.deleteUserById(id);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of deleteProductById method, of class Storage.
   */
  @Test
  public void testDeleteProductById() {
    System.out.println("deleteProductById");
    int id = 0;
    Storage instance = null;
    instance.deleteProductById(id);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of addCoupon method, of class Storage.
   */
  @Test
  public void testAddCoupon() {
    System.out.println("addCoupon");
    Coupon c = null;
    Storage instance = null;
    instance.addCoupon(c);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getCouponByCode method, of class Storage.
   */
  @Test
  public void testGetCouponByCode() {
    System.out.println("getCouponByCode");
    String code = "";
    Storage instance = null;
    Coupon expResult = null;
    Coupon result = instance.getCouponByCode(code);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of deleteCouponByCode method, of class Storage.
   */
  @Test
  public void testDeleteCouponByCode() {
    System.out.println("deleteCouponByCode");
    String code = "";
    Storage instance = null;
    instance.deleteCouponByCode(code);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getUserIdsByName method, of class Storage.
   */
  @Test
  public void testGetUserIdsByName() {
    System.out.println("getUserIdsByName");
    String name = "";
    Storage instance = null;
    List expResult = null;
    List result = instance.getUserIdsByName(name);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getWishListForUser method, of class Storage.
   */
  @Test
  public void testGetWishListForUser() {
    System.out.println("getWishListForUser");
    int userId = 0;
    Storage instance = null;
    WishList expResult = null;
    WishList result = instance.getWishListForUser(userId);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getCartForUser method, of class Storage.
   */
  @Test
  public void testGetCartForUser() {
    System.out.println("getCartForUser");
    int userId = 0;
    Storage instance = null;
    Cart expResult = null;
    Cart result = instance.getCartForUser(userId);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getCommentsForProduct method, of class Storage.
   */
  @Test
  public void testGetCommentsForProduct() {
    System.out.println("getCommentsForProduct");
    int productId = 0;
    Storage instance = null;
    List expResult = null;
    List result = instance.getCommentsForProduct(productId);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getInstance method, of class Storage.
   */
  @Test
  public void testGetInstance() {
    System.out.println("getInstance");
    Storage expResult = null;
    Storage result = Storage.getInstance();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getUserCount method, of class Storage.
   */
  @Test
  public void testGetUserCount() {
    System.out.println("getUserCount");
    Storage instance = null;
    int expResult = 0;
    int result = instance.getUserCount();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getProductCount method, of class Storage.
   */
  @Test
  public void testGetProductCount() {
    System.out.println("getProductCount");
    Storage instance = null;
    int expResult = 0;
    int result = instance.getProductCount();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
}
