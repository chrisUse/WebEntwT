/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

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
public class caseProductTest {
  
  public caseProductTest() {
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
   * Test of isProductExist method, of class caseProduct.
   */
  @Test
  public void testIsProductExist() {
    System.out.println("isProductExist");
    String name = "";
    caseProduct instance = new caseProduct();
    boolean expResult = false;
    boolean result = instance.isProductExist(name);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of addProduct method, of class caseProduct.
   */
  @Test
  public void testAddProduct() throws Exception {
    System.out.println("addProduct");
    String name = "";
    float price = 0.0F;
    String description = "";
    String manufactorer = "";
    caseProduct instance = new caseProduct();
    int expResult = 0;
    int result = instance.addProduct(name, price, description, manufactorer);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of loadProductByID method, of class caseProduct.
   */
  @Test
  public void testLoadProductByID() {
    System.out.println("loadProductByID");
    int id = 0;
    caseProduct instance = new caseProduct();
    instance.loadProductByID(id);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of deleteProduct method, of class caseProduct.
   */
  @Test
  public void testDeleteProduct() {
    System.out.println("deleteProduct");
    caseProduct instance = new caseProduct();
    String expResult = "";
    String result = instance.deleteProduct();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getAddProductID method, of class caseProduct.
   */
  @Test
  public void testGetAddProductID() {
    System.out.println("getAddProductID");
    caseProduct instance = new caseProduct();
    int expResult = 0;
    int result = instance.getAddProductID();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setAddProductID method, of class caseProduct.
   */
  @Test
  public void testSetAddProductID() {
    System.out.println("setAddProductID");
    int addProductID = 0;
    caseProduct instance = new caseProduct();
    instance.setAddProductID(addProductID);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getName method, of class caseProduct.
   */
  @Test
  public void testGetName() {
    System.out.println("getName");
    caseProduct instance = new caseProduct();
    String expResult = "";
    String result = instance.getName();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setName method, of class caseProduct.
   */
  @Test
  public void testSetName() {
    System.out.println("setName");
    String name = "";
    caseProduct instance = new caseProduct();
    instance.setName(name);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getPrice method, of class caseProduct.
   */
  @Test
  public void testGetPrice() {
    System.out.println("getPrice");
    caseProduct instance = new caseProduct();
    float expResult = 0.0F;
    float result = instance.getPrice();
    assertEquals(expResult, result, 0.0);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getDescription method, of class caseProduct.
   */
  @Test
  public void testGetDescription() {
    System.out.println("getDescription");
    caseProduct instance = new caseProduct();
    String expResult = "";
    String result = instance.getDescription();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getManufacturer method, of class caseProduct.
   */
  @Test
  public void testGetManufacturer() {
    System.out.println("getManufacturer");
    caseProduct instance = new caseProduct();
    String expResult = "";
    String result = instance.getManufacturer();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setPrice method, of class caseProduct.
   */
  @Test
  public void testSetPrice() {
    System.out.println("setPrice");
    float price = 0.0F;
    caseProduct instance = new caseProduct();
    instance.setPrice(price);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setDescription method, of class caseProduct.
   */
  @Test
  public void testSetDescription() {
    System.out.println("setDescription");
    String description = "";
    caseProduct instance = new caseProduct();
    instance.setDescription(description);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setManufacturer method, of class caseProduct.
   */
  @Test
  public void testSetManufacturer() {
    System.out.println("setManufacturer");
    String manufacturer = "";
    caseProduct instance = new caseProduct();
    instance.setManufacturer(manufacturer);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of insertNewProduct method, of class caseProduct.
   */
  @Test
  public void testInsertNewProduct() {
    System.out.println("insertNewProduct");
    caseProduct instance = new caseProduct();
    String expResult = "";
    String result = instance.insertNewProduct();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of updateProduct method, of class caseProduct.
   */
  @Test
  public void testUpdateProduct() {
    System.out.println("updateProduct");
    caseProduct instance = new caseProduct();
    String expResult = "";
    String result = instance.updateProduct();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getAllProducts method, of class caseProduct.
   */
  @Test
  public void testGetAllProducts() {
    System.out.println("getAllProducts");
    caseProduct instance = new caseProduct();
    List expResult = null;
    List result = instance.getAllProducts();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
}
