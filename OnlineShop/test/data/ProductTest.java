/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import javax.xml.stream.events.Comment;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author christianlinde
 */
public class ProductTest {
  Product instance;
  String refName;
  float  refPrice;
  String refDescription;
  String refManufacturer;
  
  public ProductTest() {
    refName         = "TestName";
    refPrice        = 2.34565f;
    refDescription  = "TestDescription";
    refManufacturer = "TestManufactorer";
    instance = new Product (refName, refPrice, refDescription, refManufacturer);
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
   * Test of getName method, of class Product.
   */
  @Test
  public void testGetName() {
    System.out.println("getName");
    String result = instance.getName();
    assertEquals(refName, result);
  }
  
  @Test
  public void testGetPrice() {
    System.out.println("getPrice");
    float result = instance.getPrice();
    assertTrue( refPrice == result );
  }
  
  @Test
  public void testGetDescription() {
    System.out.println("getDescription");
    String result = instance.getDescription();
    assertEquals(refDescription, result);
  }
  
  @Test
  public void testGetManufacturer() {
    System.out.println("getManufacturer");
    String result = instance.getManufacturer();
    assertEquals(refManufacturer, result);
  }

  /**
   * Test of getComments method, of class Product.
   */
  
  @Test
  public void testGetComments() {
    System.out.println("getComments");
    
    /*Comment myComment = new Comment ("TestCommentName","TestCommentText", new Date ());
    
    //instance.addComment();
    
    List<Comment> expComment = new ArrayList<Comment>();
    expComment.add(new Comment ("TestCommentName","TestCommentText", new Date ()))
    //List expResult = null;
    List result = instance.getComments();
    assertEquals(expComment.get(0), result.get(0));
    */ // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
  /**
   * Test of addComment method, of class Product.
   */
  
  @Test
  public void testAddComment() {
    System.out.println("addComment");
    Comment c = null;
    Product instance = null;
    //instance.addComment(c);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
  /**
   * Test of getCopy method, of class Product.
   */
  @Test
  public void testGetCopy() {
    System.out.println("getCopy");
    ICopyable expResult = new Product("TestName",2.34565f,"TestDescription","TestManufactorer");
    ICopyable result = instance.getCopy();
    
    assertEquals(((Product)expResult).getName(), ((Product)result).getName());
    assertTrue(((Product)expResult).getPrice() == ((Product)result).getPrice());
    assertEquals(((Product)expResult).getDescription(), ((Product)result).getDescription());
    assertEquals(((Product)expResult).getManufacturer(), ((Product)result).getManufacturer());
  }
  
}
