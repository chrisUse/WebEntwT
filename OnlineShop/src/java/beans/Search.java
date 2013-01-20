/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.sun.istack.internal.NotNull;
import com.sun.org.apache.xerces.internal.xs.StringList;
import data.Product;
import data.Storage;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marco
 */

@ManagedBean
@ApplicationScoped
public class Search {
    private String searchTerm;
    private List<data.Product> products;
    
    public String getSearchTerm(){
        return searchTerm;
    }
    
    public void setSearchTerm(String searchTerm){
        this.searchTerm = searchTerm;
    }
    
    public String searchByTerm(){
        searchTerm = searchTerm.toLowerCase();
        
        System.out.println("search term: " + searchTerm);
        
        String[] tSearchTerms = searchTerm.split(" ");
        
        if(products == null)
             products = new ArrayList<Product>();
        products.clear();
        
        for(data.Product tProduct : Storage.getInstance().getAllProducts()){
            for(String tSearchTerm : tSearchTerms){
                
                System.out.println(tSearchTerm);
                
                boolean tAddToList = false;
                
                
                
                if(tProduct.getName().toLowerCase().contains(tSearchTerm) ||
                   tProduct.getManufacturer().toLowerCase().contains(tSearchTerm) ||
                   tProduct.getDescription().toLowerCase().contains(tSearchTerm))
                {
                    tAddToList = true;
                }
                
                if(tAddToList && !products.contains(tProduct))
                    products.add(tProduct);
            }
        }
        return "ForwardToViewProduct.jsp";
    }
    
    public List<Product> getProducts(){
        System.out.println("returning all products");
        System.out.println(products.size() + " products in list");
        return products;
    }
}
