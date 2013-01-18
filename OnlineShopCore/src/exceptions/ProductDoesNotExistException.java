/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Marco
 */
public class ProductDoesNotExistException extends WishlistException{
    public ProductDoesNotExistException(String message) {
        super(message);
    }
}
