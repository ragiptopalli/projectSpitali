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
public class Doktori extends Stafi implements DM
{
    private String fjalkalimi;
    private String specializimi;
    private Sektori sektori;
    
    public Doktori(String e, String m, char g, String d, String de, String fjalkalimi, String specializimi, Sektori sektori) throws SpitaliException {
        super(e, m, g, d, de);
        
        if(fjalkalimi == null || fjalkalimi.trim().isEmpty())
            throw new SpitaliException("Fjalkalimi nuk eshte inicializuar ose eshte i zbrazet!");
        if(specializimi == null || specializimi.trim().isEmpty())
            throw new SpitaliException("Specializimi nuk eshte inicializuar ose eshte i zbrazet!!");
        if(sektori == null)
            throw new SpitaliException("Sektori eshte i pa inicializuar");
        
        this.fjalkalimi = fjalkalimi;
        this.specializimi = specializimi;
        this.sektori = sektori;
    }

    public String getFjalkalimi() {
        return fjalkalimi;
    }

    public Sektori getS() {
        return sektori;
    }
    
    public String getSpecializimi() {
        return specializimi;
    }

    public void setFjalkalimi(String fjalkalimi) throws SpitaliException{
        if(fjalkalimi == null || fjalkalimi.trim().isEmpty())
            throw new SpitaliException("Fjalkalimi nuk eshte inicializuar ose eshte i zbrazet!");
        this.fjalkalimi = fjalkalimi;
    }

    public void setSpecializimi(String specializimi) throws SpitaliException {
        if(specializimi == null || specializimi.trim().isEmpty())
            throw new SpitaliException("Specializimi nuk eshte inicializuar ose eshte i zbrazet!!");
        this.specializimi = specializimi;
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
        if(o instanceof Doktori) {
            Doktori d = (Doktori)o;
            return d.getEmri().equals(super.getEmri()) && d.getFjalkalimi().equals(fjalkalimi);
        }
        return false;
    }
}
