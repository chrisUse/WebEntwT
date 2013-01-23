package beans;

import data.Product;
import data.Storage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Marco
 */

@ManagedBean
@ApplicationScoped
public class Search implements Serializable{
    private String searchTerm = new String();
    private List<Product> products = new ArrayList<Product>();
    private HashMap<String, HashSet<String>> filter = new HashMap<String, HashSet<String>>();
    //private HashMap<String, String> activatedFilter = new HashMap<String, String>();
    private String testFilter = null;
    //private Set<String> filterCategories;
    
    public String getTestFilter(){
        return testFilter;
    }
    
    public void setTestFilter(String filter){
        if(testFilter == null)
            testFilter = filter;
        else
            this.testFilter = testFilter + "," + filter;
        //System.out.println("testFilter was set to " + testFilter);
    }
    
    public String getSearchTerm(){
        return searchTerm;
    }
    
    public void setSearchTerm(String searchTerm){
        this.searchTerm = searchTerm;
    }
    
    public List<Product> getProducts(){
        //System.out.println("returning all products");
        //System.out.println(products.size() + " products in list");
        return products;
    }
    
    public void setProducts(List<Product> products){
        this.products = products;
        this.evaluateFilters();
        //System.out.println("products set");
        //System.out.println(products.size() + " products in list");
    }
    
    public HashMap<String, HashSet<String>> getFilter(){
        return filter;
    }
    
    public void setFilter(HashMap<String, HashSet<String>> pFilter){
        this.filter = pFilter;
    }
    
    public void addFilter(String pCategory, String pFilter){
        HashSet<String> tFilterCategory = this.filter.remove(pCategory);
        
        if(tFilterCategory == null){
            tFilterCategory = new HashSet<String>();   
        }
        
        tFilterCategory.add(pFilter);
        
        this.filter.put(pCategory, tFilterCategory);
    }
    
    public void removeFilter(String pCategory, String pFilter){
        HashSet<String> tFilterCategory = this.filter.remove(pCategory);
        
        if(tFilterCategory == null)
            return;
        
        tFilterCategory.remove(pFilter);
        
        this.filter.put(pCategory, tFilterCategory);
        
        /*for(int i=0; i<this.filter.size(); i++){
            if(this.filter.get(i).compareToIgnoreCase(pFilter) == 0)
                this.filter.remove(i);
        }*/
    }
    
    public void evaluateFilters(){
        this.filter.clear();
        
        for(Product tProduct : products){
            addFilter("manufacturer", tProduct.getManufacturer().toLowerCase());
            addFilter("price", String.valueOf(tProduct.getPrice()).toLowerCase());
        }
        
        //System.out.println(filter.size() + " filter evaluated");
        //System.out.println("manufactorers: " + this.filter.get("manufacturer").toString());
        //System.out.println("prices       : " + this.filter.get("price").toString());
    }
    
    public List<String> getFilterCategories(){
        //System.out.println("getFilterCategories() entered");
        return new ArrayList<String>(this.filter.keySet());
    }
    
    public List<String> getFilterByCategory(String category){
        return new ArrayList<String>(this.filter.get(category));
    }
    
    public String searchByTerm(){
        searchTerm = searchTerm.toLowerCase();
        
        //System.out.println("search term: " + searchTerm);
        
        String[] tSearchTerms = searchTerm.split(" ");
        
        if(products == null)
             products = new ArrayList<Product>();
        products.clear();
        
        for(data.Product tProduct : Storage.getInstance().getAllProducts()){
            for(String tSearchTerm : tSearchTerms){
                
                //System.out.println(tSearchTerm);
                
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
        
        evaluateFilters();
        
        return "ForwardToViewProduct.jsp";
    }
    
    public String setFilterAndSearch(){
        
        //System.out.println("entered");
        if(!searchTerm.isEmpty()){
            //System.out.println("searching");
            searchByTerm();
        }
        else{
            //System.out.println("get all products");
            this.products = new ArrayList(Storage.getInstance().getAllProducts());
        }
        
        //System.out.println("got products");
        
        String[] tGivenFilters = testFilter.split(",");
        String[] tFilters = new String[2];
        testFilter = null;
        
        for(int i=0; i<tFilters.length; i++){
            tFilters[i] = "";
        }
        for(int i=0; i<tGivenFilters.length; i++){
            tFilters[i] = tGivenFilters[i];
        }
        
        //System.out.print("filter separated: ");
        
        //for(String tOut : tFilters){
            //System.out.print("\"" + tOut + "\" ");
        //}
        //System.out.println();

        if(this.products == null)
             this.products = new ArrayList<Product>();
        List<Product> tProducts = new ArrayList(this.products);
        
        //System.out.println(tProducts.size() + " products pulled");
        
        this.products.clear();
        
        //System.out.println("system products cleared: " + products.size());
        
        for(data.Product tProduct : tProducts){
            boolean tAddToList = false;
            
            //System.out.print(String.valueOf(tProduct.getPrice()).toLowerCase() + "  -->  " + tFilters[0] + "        ");
            //System.out.print(tProduct.getManufacturer().toLowerCase() + "  -->  " + tFilters[1] + "     ");

            if((!tFilters[0].isEmpty() && String.valueOf(tProduct.getPrice()).toLowerCase().contains(tFilters[0])) ||
               (!tFilters[1].isEmpty() && tProduct.getManufacturer().toLowerCase().contains(tFilters[1])))
            {
                //System.out.println("TRUE");
                tAddToList = true;
            }
            //else
                //System.out.println("FALSE");

            if(tAddToList && !products.contains(tProduct))
                products.add(tProduct);
        }
        
        //System.out.println("finished: " + products.size());
        
        return "ForwardToViewProduct.jsp";
    }
}
