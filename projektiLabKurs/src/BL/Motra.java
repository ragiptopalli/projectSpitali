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
public class Motra extends Stafi implements DM
{
    private String fjalkalimi;

    private Sektori sektori;
    
    public Motra(String e, String m, char g, String d, String de, String fjalkalimi, Sektori sektori) throws SpitaliException {
        super(e, m, g, d, de);
        
        if(fjalkalimi == null || fjalkalimi.trim().isEmpty())
            throw new SpitaliException("Fjalkalimi nuk eshte inicializuar ose eshte i zbrazet!");
        if(sektori == null)
            throw new SpitaliException("Sektori eshte i pa inicializuar");
        
        this.fjalkalimi = fjalkalimi;
        this.sektori = sektori;
    }

    public String getFjalkalimi() {
        return fjalkalimi;
    }

    public Sektori getS() {
        return sektori;
    }
    

    public void setFjalkalimi(String fjalkalimi) throws SpitaliException{
        if(fjalkalimi == null || fjalkalimi.trim().isEmpty())
            throw new SpitaliException("Fjalkalimi nuk eshte inicializuar ose eshte i zbrazet!");
        this.fjalkalimi = fjalkalimi;
    }

    public void setS(Sektori sektori) throws SpitaliException{
        if(sektori == null)
            throw new SpitaliException("Sektori eshte i pa inicializuar");
        this.sektori = sektori;
    }

    @Override
    public Sektori getSektori() {
        return sektori;
    }
    
    public boolean equals(Object o) {
        if(o instanceof Motra) {
            Motra d = (Motra)o;
            return d.getEmri().equals(super.getEmri()) && d.getFjalkalimi().equals(fjalkalimi);
        }
        return false;
    }
}
