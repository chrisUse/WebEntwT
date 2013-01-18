/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import exceptions.StorageException;

/**
 *
 * @author delbertooo
 */
public interface IStorageData {
    public int getId();
    
    /**
     * Sets the ID of a the data object or throws StorageException if 
     * the ID is already set.
     * 
     * @param id ID of the data object
     * @throws StorageException 
     */
    public void setId(int id) throws StorageException;
    
    //public IStorageData getCopy();
}
