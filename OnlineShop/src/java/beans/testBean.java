/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author christianlinde
 */
@ManagedBean
@RequestScoped
public class testBean {
  private String name;
  /**
   * Creates a new instance of testBean
   */
  public testBean() {
  }
  
  public String getName () {
    return this.name;
  }
  
  public void setName ( String name ) {
    this.name = name;
  }
}
