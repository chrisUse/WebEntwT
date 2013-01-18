/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author chrisGno
 */
@WebService(serviceName = "WebEntwProduct")
public class WebEntwProduct {

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
}
