/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Danny
 */
public class CartTest {
    
    Cart            refCart;
    ProductInCart   refProduct;
    int             refProductId;
    int             refQuantity;
    int             refCount;
    
    public CartTest() {
        refCount        = 1;
        refProductId    = 1;
        refQuantity     = 2;
        
        refCart         = new Cart();
        refProduct      = new ProductInCart(refCount, refProductId);
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
    // @Test
    // public void hello() {}
    @Test
    public void testAddProduct()
    {
        System.out.println("addProductToCart");
        refCart.addProduct(refProductId);
        
        boolean tExpect     = false;
        List<ProductInCart> tList   = refCart.getProductsInCart();
        for(ProductInCart tProduct : tList)
        {
            if(tProduct.getId() == refProductId)
                tExpect = true;
        }
        
        assertTrue(tExpect);
    }
    
    @Test 
    public void testEditProduct()
    {
        System.out.println("editProductInCart");
        refCart.addProduct(refProduct);
        
        boolean tExpect     = false;
        tExpect             = refCart.changeQuantity(refProductId, refQuantity);
        
        assertTrue(tExpect);
    }
    
    @Test 
    public void testIncreaseQuantityProductByOne()
    {
        System.out.println("increaseQuantityProductInCartByOne");
        refCart.addProduct(refProduct);
        
        boolean tExpect     = false;
        tExpect             = refCart.increaseQuantity(refProductId);
        
        assertTrue(tExpect);
    }
    
    @Test 
    public void testDecreaseQuantityProductByOne()
    {
        System.out.println("DecreaseQuantityProductInCartOne");
        refCart.addProduct(refProduct);
        
        boolean tExpect     = false;
        tExpect             = refCart.decreaseQuantity(refProductId);
        
        assertTrue(tExpect);
    }
    
    @Test
    public void testRemoveProduct()
    {
        System.out.println("removeProductFromCart");
        refCart.addProduct(refProductId);
        
        boolean tExpect     = false;
        tExpect             = refCart.removeProduct(refProductId);
        
        assertTrue(tExpect);
    }
}
