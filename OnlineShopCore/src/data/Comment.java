/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;

/**
 *
 * @author delbertooo
 */
public class Comment implements Cloneable {

    private String name;
    private String text;
    private Date date;
    
    public Comment(String name, String text, Date date) {
        this.name = name;
        this.text = text;
        this.date = date;
    }
    
     public Comment(Comment c) {
        this(c.getName(), c.getText(), c.getDate());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
