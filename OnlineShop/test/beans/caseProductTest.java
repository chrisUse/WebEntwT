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
  public void testIsProductExistFalse() {
    System.out.println("isProductExist false");
    String name = "Kindle Fire HD --";
    caseProduct instance = new caseProduct();
    assertFalse(instance.isProductExist(name));
  }
  @Test
  public void testIsProductExistTrue() {
    System.out.println("isProductExist true");
    String name = "Kindle Fire HD";
    caseProduct instance = new caseProduct();
    assertTrue(instance.isProductExist(name));
  }

  /**
   * Test of addProduct method, of class caseProduct.
   */
  @Test
  public void testAddProduct() throws Exception {
    System.out.println("addProduct");
    String name = "test1";
    float price = 1.23F;
    String description = "test12";
    String manufactorer = "test123";
    caseProduct instance = new caseProduct();
    int result = instance.addProduct(name, price, description, manufactorer);
    assertTrue(result > 0);
  }

  /**
   * Test of loadProductByID method, of class caseProduct.
   */
  @Test
  public void testLoadProductByID() {
    System.out.println("loadProductByID");
    caseProduct instance = new caseProduct();
    instance.loadProductByID(1);
    assertTrue(instance.getAddProductID() > 0);
  }

  /**
   * Test of deleteProduct method, of class caseProduct.
   */
  @Test
  public void testDeleteProduct() {
    System.out.println("deleteProduct");
    caseProduct instance = new caseProduct();
    String expResult = "";
    instance.loadProductByID(1);
    String result = instance.deleteProduct();
    instance.loadProductByID(1);
    assertTrue(instance.getAddProductID() > 0);
  }

  /**
   * Test of getAddProductID method, of class caseProduct.
   */
  @Test
  public void testGetAddProductID() {
    System.out.println("getAddProductID");
    caseProduct instance = new caseProduct();
    instance.setAddProductID(6);
    assertTrue(instance.getAddProductID() == 6);
  }

  /**
   * Test of setAddProductID method, of class caseProduct.
   */
  @Test
  public void testSetAddProductID() {
    System.out.println("setAddProductID");
    caseProduct instance = new caseProduct();
    instance.setAddProductID(7);
    assertTrue(instance.getAddProductID() == 7);
  }

  /**
   * Test of getName method, of class caseProduct.
   */
  @Test
  public void testGetName() {
    System.out.println("getName");
    caseProduct instance = new caseProduct();
    String expResult = "Bubber";
    instance.setName(expResult);
    String result = instance.getName();
    assertEquals(expResult, result);
  }

  /**
   * Test of setName method, of class caseProduct.
   */
  @Test
  public void testSetName() {
    System.out.println("setName");
    String name = "Bubber123";
    caseProduct instance = new caseProduct();
    instance.setName(name);
    String result = instance.getName();
    assertEquals(name, result);
  }

  /**
   * Test of getPrice method, of class caseProduct.
   */
  @Test
  public void testGetPrice() {
    System.out.println("getPrice");
    caseProduct instance = new caseProduct();
    float expResult = 1.345F;
    instance.setPrice(expResult);
    float result = instance.getPrice();
    assertEquals(expResult, result, 0.0);
  }

  /**
   * Test of getDescription method, of class caseProduct.
   */
  @Test
  public void testGetDescription() {
    System.out.println("getDescription");
    caseProduct instance = new caseProduct();
    String expResult = "description";
    instance.setDescription(expResult);
    String result = instance.getDescription();
    assertEquals(expResult, result);
  }

  /**
   * Test of getManufacturer method, of class caseProduct.
   */
  @Test
  public void testGetManufacturer() {
    System.out.println("getManufacturer");
    caseProduct instance = new caseProduct();
    String expResult = "Manufacturer";
    instance.setManufacturer(expResult);
    String result = instance.getManufacturer();
    assertEquals(expResult, result);
  }

  /**
   * Test of setPrice method, of class caseProduct.
   */
  @Test
  public void testSetPrice() {
    System.out.println("setPrice");
    float price = 23.643F;
    caseProduct instance = new caseProduct();
    instance.setPrice(price);
    float result = instance.getPrice();
    assertEquals(price, result, 0.0);
  }

  /**
   * Test of setDescription method, of class caseProduct.
   */
  @Test
  public void testSetDescription() {
    System.out.println("setDescription");
    String description = "description";
    caseProduct instance = new caseProduct();
    instance.setDescription(description);
    String result = instance.getDescription();
    assertEquals(description, result);
  }

  /**
   * Test of setManufacturer method, of class caseProduct.
   */
  @Test
  public void testSetManufacturer() {
    System.out.println("setManufacturer");
    String manufacturer = "manufacturer";
    caseProduct instance = new caseProduct();
    instance.setManufacturer(manufacturer);
    String result = instance.getManufacturer();
    assertEquals(manufacturer, result);
  }

  /**
   * Test of insertNewProduct method, of class caseProduct.
   */
  @Test
  public void testInsertNewProduct() throws Exception {
    System.out.println("insertNewProduct");
    String name = "test1";
    float price = 1.23F;
    String description = "test12";
    String manufactorer = "test123";
    caseProduct instance = new caseProduct();
    instance.addProduct(name, price, description, manufactorer);
    String result = instance.insertNewProduct();
    assertEquals("/ViewProduct.jsp", result);
  }

  /**
   * Test of updateProduct method, of class caseProduct.
   */
  @Test
  public void testUpdateProduct() {
    System.out.println("updateProduct");
    caseProduct instance = new caseProduct();
    instance.setAddProductID(3);
    String result = instance.updateProduct();
    assertEquals("/ViewProduct.jsp", result);
  }

  /**
   * Test of getAllProducts method, of class caseProduct.
   */
  @Test
  public void testGetAllProducts() {
    System.out.println("getAllProducts");
    caseProduct instance = new caseProduct();
    List result = instance.getAllProducts();
    assertNotNull(result);
  }

    /**
     * Test of deleteProductByID method, of class caseProduct.
     */
    @Test
    public void testDeleteProductByID() {
        System.out.println("deleteProductByID");
        int id = 4;
        caseProduct instance = new caseProduct();
        boolean result = instance.deleteProductByID(id);
        assertNotNull(result);
    }

    /**
     * Test of checkNameSet method, of class caseProduct.
     */
    @Test
    public void testCheckNameSet() {
        System.out.println("checkNameSet");
        caseProduct instance = new caseProduct();
        String expResult = "Dell Latitude ST T11";
        instance.setName(expResult);
        String result = instance.checkNameSet();
        assertEquals("Product exists", result);
    }

    /**
     * Test of getPriceString method, of class caseProduct.
     */
    @Test
    public void testGetPriceString() {
        System.out.println("getPriceString");
        caseProduct instance = new caseProduct();
        String expResult = "1.284 €";
        instance.setPriceString("1.284 €");
        String result = instance.getPriceString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPriceString method, of class caseProduct.
     */
    @Test
    public void testSetPriceString() {
        System.out.println("setPriceString");
        String pS = "342.884 €";
        caseProduct instance = new caseProduct();
        instance.setPriceString(pS);
        String result = instance.getPriceString();
        assertEquals(pS, result);
    }

    /**
     * Test of getAllProductsWS method, of class caseProduct.
     */
    @Test
    public void testGetAllProductsWS() {
        System.out.println("getAllProductsWS");
        caseProduct instance = new caseProduct();
        List result = instance.getAllProductsWS();
        assertNotNull(result);
    }
}
