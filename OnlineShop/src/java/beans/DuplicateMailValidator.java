/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import data.Storage;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author delbertooo
 */
@FacesValidator(value = "duplicateMailValidator")
public class DuplicateMailValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (Storage.getInstance().getUserIdByMail((String) value) != null) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Diese E-Mail Adresse ist bereits registriert.", null);
            throw new ValidatorException(fm);
        }
    }
}