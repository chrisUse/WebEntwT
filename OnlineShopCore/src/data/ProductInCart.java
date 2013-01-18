/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author drubner, delbertooo
 */
public class ProductInCart {

    private int count;
    private int productId;

    public ProductInCart(int count, int productId) {
        this.count = count;
        this.productId = productId;
    }

    public ProductInCart(ProductInCart pic) {
        this.count = pic.count;
        this.productId = pic.productId;
    }
    
    public int getId(){
        return productId;
    }
    
    public int getCount(){
        return count;
    }
    
    public void setId(int id){
        this.productId  = id;
    }
    
    public void setCount(int count){
        this.count      = count;
    }
}
