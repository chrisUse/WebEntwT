/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.*;

/**
 *
 * @author delbertooo
 */
public class Product extends StorageData {

    private String name;
    private float price;
    private String description;
    private String manufacturer;
    private List<Comment> comments = new ArrayList<Comment>();

    public Product(String name, float price, String description, String manufacturer) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @param manufacturer the manufacturer to set
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    


    public List<Comment> getComments() {
        List<Comment> clone = new ArrayList<Comment>(comments.size());
        for (Comment item : comments) {
            clone.add(new Comment(item));
        }
        return clone;
    }
    
    public void addComment(Comment c) {
        comments.add(c);
    }

    public Product(Product p) {
        this.id = p.id;

        this.name = p.name;
        this.price = p.price;
        this.description = p.description;
        this.manufacturer = p.manufacturer;
        
        this.comments = p.getComments(); // deep copy
    }

    @Override
    public ICopyable getCopy() {
        return new Product(this);
    }    
}
