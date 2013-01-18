/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author delbertooo
 */
public class DuplicateEntryException extends StorageException {

    public DuplicateEntryException(String message) {
        super(message);
    }
    
}
