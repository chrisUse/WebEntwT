/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.sun.faces.util.MessageFactory;
import data.*;
import exceptions.DuplicateEntryException;
import exceptions.StorageException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.*;
/**
 * @author delbertooo
 */
@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    private String name;
    private String password;
    private String mail;
    private String street;
    private String city;
    
    private String salutation;
    private boolean termsAccepted = false;
    private boolean wantsCommercials = false;
    
    private boolean comElectro, comBooks, comMedia;
    
    private boolean registrationComplete = false;

    public UserBean() {
    }

    public boolean isWantsCommercials() {
        return wantsCommercials;
    }

    public boolean isComElectro() {
        return comElectro;
    }

    public void setComElectro(boolean comElectro) {
        this.comElectro = comElectro;
    }

    public boolean isComBooks() {
        return comBooks;
    }

    public void setComBooks(boolean comBooks) {
        this.comBooks = comBooks;
    }

    public boolean isComMedia() {
        return comMedia;
    }

    public void setComMedia(boolean comMedia) {
        this.comMedia = comMedia;
    }

    public void setWantsCommercials(boolean wantsCommercials) {
        this.wantsCommercials = wantsCommercials;
    }

    
    public String getSalutation() {
        return salutation;
    }
    
    public List<String> getSalutations() {
        List<String> l = new ArrayList<String>();
        l.add("Herr");
        l.add("Frau");
        l.add("Prof.");
        return l;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public boolean isTermsAccepted() {
        return termsAccepted;
    }

    public void setTermsAccepted(boolean termsAccepted) {
        this.termsAccepted = termsAccepted;
    }
    
    public void validateTermsAccepted(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Boolean && ((Boolean)value.equals(Boolean.FALSE))) {
            String cId = component.getClientId(context);
            FacesMessage m = MessageFactory.getMessage(UIInput.REQUIRED_MESSAGE_ID, cId);
            throw new ValidatorException(m);
        }
    }
    
    

    public boolean isRegistrationComplete() {
        
        return registrationComplete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public void validateMail() {
        if (Storage.getInstance().getUserIdByMail(this.mail) != null) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Diese E-Mail Adresse ist bereits registriert.", null);
            throw new ValidatorException(fm);
        }
    }
    
    public void cleanUp() {
        this.name = null;
        this.password = null;
        this.mail = null;
        this.street = null;
        this.city = null;
        this.registrationComplete = false;
    }

    public String completeRegistration() {
        FacesContext fc = FacesContext.getCurrentInstance();
        this.registrationComplete = true;
        
        if (this.name == null || this.password == null || this.mail == null || this.street == null || this.city == null) {
            this.registrationComplete = false;
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Es wurden nicht alle Felder ausgefüllt.", null);
            fc.addMessage(null, fm);
            
            return "FinalizeRegister";
        }
        try {
            
            Storage.getInstance().addUser(new User(false, this.name, this.password, this.mail, this.street, this.city));
        } catch (DuplicateEntryException ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Diese E-Mail Adresse ist bereits registriert.", null);
            fc.addMessage("mail", fm);
            this.registrationComplete = false;
        } catch (StorageException ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Unbekannter Fehler.", null);
            fc.addMessage(null, fm);
            this.registrationComplete = false;
        }
        /** @todo registrierung leeren **/
        return "FinalizeRegister";
    }
}
