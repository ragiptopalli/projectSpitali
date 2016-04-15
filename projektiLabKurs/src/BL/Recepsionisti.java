/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

/**
 *
 * @author Edmond
 */
public class Recepsionisti extends Stafi{
    
    private String fjalkalimi;
    
    public Recepsionisti(String e, String m, char g, String d, String de, String fjalkalimi) throws SpitaliException {
        super(e, m, g, d, de);
        
        if(fjalkalimi == null || fjalkalimi.trim().isEmpty())
            throw new SpitaliException("Specializimi nuk eshte inicializuar ose eshte i zbrazet!!");
        
        this.fjalkalimi = fjalkalimi;
    }

    public String getFjalkalimi() {
        return fjalkalimi;
    }

    public void setFjalkalimi(String fjalkalimi) throws SpitaliException{
        if(fjalkalimi == null || fjalkalimi.trim().isEmpty())
            throw new SpitaliException("Specializimi nuk eshte inicializuar ose eshte i zbrazet!!");
        this.fjalkalimi = fjalkalimi;
    }
    
    public boolean equals(Object o) {
        if(o instanceof Recepsionisti) {
            Recepsionisti d = (Recepsionisti)o;
            return d.getEmri().equals(super.getEmri()) && d.getFjalkalimi().equals(fjalkalimi);
        }
        return false;
    }
}
