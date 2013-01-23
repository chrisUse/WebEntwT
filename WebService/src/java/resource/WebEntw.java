/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import data.Product;
import data.Storage;
import data.User;
import exceptions.ProductDoesNotExistException;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author chrisGno
 */
@WebService(serviceName = "WebEntw")
public class WebEntw {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "products")
    public List<data.Product> products() {
        return data.Storage.getInstance().getAllProducts();
    }
    
    @WebMethod(operationName = "productWID") // the name product are a problem
    public data.Product product(@WebParam(name="id") int id) {
        return data.Storage.getInstance().getProductById(id);
    }

    /**
     * Web service operation "login"
     */
    @WebMethod(operationName = "login")
    public Integer login(@WebParam(name = "identifier") String identifier, @WebParam(name = "password") String password) {
        Integer uid = Storage.getInstance().getUserIdByMail(identifier);
        Integer currentUser;
        if (uid == null || !Storage.getInstance().getUserById(uid).getPassword().equals(password)) {
            currentUser = null;
        } else {
            currentUser = uid;
        }
        
        return currentUser;
    }
    
    @WebMethod(operationName = "removeProductToCart")
    public boolean removeProductToCart(@WebParam(name = "userId") int userId, @WebParam(name = "productId") int productId)
    {
        User tCurrentU      = Storage.getInstance().getUserById(userId);

        return tCurrentU.getCart().removeProduct(productId);
    }
    
    @WebMethod(operationName = "validateCode")
    public String validateCode(@WebParam(name = "couponCode") String couponCode) {
        if( data.Storage.getInstance().getCouponByCode(couponCode)){
            data.Storage.getInstance().deleteCouponByCode(couponCode);
            return "CouponAccept.jsp";
        }
        return "CouponDenied.jsp";
    }
    
    @WebMethod(operationName = "removeProductFromWishlist")
    public boolean removeProductFromWishlist(@WebParam(name = "userID") int userID, @WebParam(name = "productID") int productID) throws ProductDoesNotExistException {
        List<Product> tProducts = data.Storage.getInstance().getUserById(userID).getWishList().getProducts();
        for(Product item : tProducts) {
            if(item.getId() == productID)
            {
                tProducts.remove(item);
                return data.Storage.getInstance().getUserById(userID).getWishList().setProducts(tProducts);
            }
        }
        throw new ProductDoesNotExistException("pdne");
    }
}
