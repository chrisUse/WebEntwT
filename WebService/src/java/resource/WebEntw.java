/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import data.Storage;
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
}
