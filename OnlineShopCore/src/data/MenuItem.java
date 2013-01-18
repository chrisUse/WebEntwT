/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author delbertooo
 */
public class MenuItem {

    private String action;
    private String linkText;
    private boolean forAdminOnly = false;
    private boolean forRegistredUsersOnly = false;
    private boolean forAnonymousUsersOnly = false;
    private boolean forEveryone = false;

    public MenuItem(String action, String linkText, MenuItemVisibility visibility) {
        this.action = action;
        this.linkText = linkText;
        switch (visibility) {
            case ADMINS_ONLY:
                this.forAdminOnly = true;
                break;
            case ANONYMOUS_USERS_ONLY:
                this.forAnonymousUsersOnly = true;
                break;
            case REGISTRED_USERS_ONLY:
                this.forRegistredUsersOnly = true;
                break;
            case EVERYONE:
                this.forEveryone = true;
                break;
        }
    }

    public boolean isForEveryone() {
        return forEveryone;
    }

    public boolean isForAnonymousUsersOnly() {
        return forAnonymousUsersOnly;
    }

    public String getLinkText() {
        return linkText;
    }

    public String getAction() {
        return action;
    }

    public boolean isForAdminOnly() {
        return forAdminOnly;
    }

    public boolean isForRegistredUsersOnly() {
        return forRegistredUsersOnly;
    }
}
