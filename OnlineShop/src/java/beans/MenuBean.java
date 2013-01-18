/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import data.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.*;

/**
 * @author delbertooo
 */
@ManagedBean
@ApplicationScoped
public class MenuBean {

    private List<MenuItem> menuItems;

    public MenuBean() {
        menuItems = new ArrayList<MenuItem>();
        menuItems.add(new MenuItem("Login.jsp", "Anmeldung", MenuItemVisibility.ANONYMOUS_USERS_ONLY));
        menuItems.add(new MenuItem("Register.xhtml", "Registrierung", MenuItemVisibility.ANONYMOUS_USERS_ONLY));
        menuItems.add(new MenuItem("AddNewProduct.xhtml", "New Product JSF", MenuItemVisibility.ADMINS_ONLY));
        menuItems.add(new MenuItem("ViewProductWS.jsp", "Product View JSP WS", MenuItemVisibility.EVERYONE));
        //menuItems.add(new MenuItem("ViewProduct.jsp", "Product View JSP", MenuItemVisibility.EVERYONE));
        menuItems.add(new MenuItem("ShowWishlist.jsp", "Show Wishlist", MenuItemVisibility.REGISTRED_USERS_ONLY));
        menuItems.add(new MenuItem("showCart.jsp?userID=1", "Show Cart", MenuItemVisibility.REGISTRED_USERS_ONLY));
        menuItems.add(new MenuItem("Logout.jsp", "Abmelden", MenuItemVisibility.REGISTRED_USERS_ONLY));
    }

    public List<MenuItem> getMenuItems() {
        List<MenuItem> t = new ArrayList<MenuItem>();

        for (MenuItem entry : menuItems) {
            t.add(entry);
        }
        return t;
    }
}
