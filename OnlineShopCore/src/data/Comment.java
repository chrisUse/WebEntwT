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
    private java.util.Date date;

    public Comment(String name, String text, Date date) {
        this.name = name;
        this.text = text;
        this.date = date;
    }

    public Comment(Comment c) {
        this.date = c.date;
        this.name = c.name;
        this.text = c.text;
    }
}
