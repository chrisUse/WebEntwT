/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.*;

/**
 * @author Stephan Stenzel
 */
public class Coupon implements ICopyable {

    private String code;
    private float value;

    public Coupon(String code, float value) {
        this.code = code;
        this.value = value;
    }

    public Coupon(Coupon c) {
        this.code = c.code;
        this.value = c.value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String nCode) {
        code = nCode;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float nValue) {
        value = nValue;
    }
    
    public boolean validateCode(String nCode) {
        if(nCode.equals(code)){
            return true;
        }
        return false;
    }

    @Override
    public ICopyable getCopy() {
        return new Coupon(this);
    }
    
    
}
