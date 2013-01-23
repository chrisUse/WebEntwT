/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import data.Product;
import data.ProductInCart;
import data.Storage;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author danny
 */
@ManagedBean
@SessionScoped
public class CartBean 
{
    public boolean  invalidProducts = false;
    private String  description;
    private String  name;
    private float   price;
    
    public CartBean() 
    {
    }
    
    public List<ProductInCart> getProductsInCart(int pID) {
        return data.Storage.getInstance().getUserById(pID).getCart().getProductsInCart();
    }
    
    public int getCountOfProduct(int pID, int pProductId)
    {
        return data.Storage.getInstance().getUserById(pID).getCart().getCountOfProduct(pProductId);
    }
    
    public void addProduct(int pId, int pProductId)
    {
        List<ProductInCart> tProductsIC     = this.getProductsInCart(pId); 
        tProductsIC.add(new ProductInCart(1, pProductId));
        data.Storage.getInstance().getUserById(pId).getCart().setProductsInCart(tProductsIC);
    }
    
    public boolean removeProduct(int pID, int pProductId)
    {
        return data.Storage.getInstance().getUserById(pID).getCart().removeProduct(pProductId);
    }
    
    public boolean removeProductWS(int pId, int pProductId)
    {
        webservice.WebEntw_Service ws = new webservice.WebEntw_Service();
        webservice.WebEntw wsp = ws.getWebEntwPort();
        return wsp.removeProductToCart(pId, pProductId);
    }
    
    public boolean changeQuantity(int pID, int pProductId, int pQuantity)
    {
        return data.Storage.getInstance().getUserById(pID).getCart().changeQuantity(pProductId, pQuantity);
    }
    
    public boolean increaseQuantity(int pID, int pProductId)
    {
        return data.Storage.getInstance().getUserById(pID).getCart().increaseQuantity(pProductId);
    }
    
    public boolean decreaseQuantity(int pID, int pProductId)
    {
        return data.Storage.getInstance().getUserById(pID).getCart().decreaseQuantity(pProductId);
    }
    
    public boolean isInCart(int pID, int pProductID)
    {
        return data.Storage.getInstance().getUserById(pID).getCart().isInCart(pProductID);
    }
    
    public void clearCart(int pID)
    {
        data.Storage.getInstance().getUserById(pID).getCart().clearCart();
    }
    
    public void initializeProduct(int pProductID)
    {
        Product tProduct    = Storage.getInstance().getProductById(pProductID);
        this.description    = tProduct.getDescription();
        this.name           = tProduct.getName();
        this.price          = tProduct.getPrice();   
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public float getPrice()
    {
        return price;
    }
}
