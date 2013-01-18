/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author delbertooo
 */
public class DataType implements Comparable {
    
    protected int value;

    public DataType(int value) {
        this.value = value;
    }
    
    public int intValue() {
        return value;
    }

    @Override
    public int compareTo(Object o) {
        long diff = 0;
        if (o instanceof Integer) {
            Integer i = (Integer)o;
            diff = (long)value - (long)i;
        } else if (o instanceof DataType) {
            DataType i = (DataType)o;
            diff = (long)value - (long)i.intValue();
        }
        
        if (diff < 0)
            return -1;
        else if (diff > 0)
            return 1;
        else
            return 0;
        
    }
    
}
