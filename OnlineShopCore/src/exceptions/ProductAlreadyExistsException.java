/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Marco
 */
public class ProductAlreadyExistsException extends WishlistException{
    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
