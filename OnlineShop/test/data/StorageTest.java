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
  
 
}
