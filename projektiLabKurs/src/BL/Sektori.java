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
public class Sektori 
{
    private String emri;
    private int id;

    public Sektori(int i ,String e) throws SpitaliException
    {
        if(i<=0)
            throw new SpitaliException("Sbon id negative.");
        if(e == null || e.trim().isEmpty())
            throw new SpitaliException("Emri i personit nuk eshte inicializuar");
        
        id = i;
        emri = e;
    }

    public int getId() {
        return id;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) throws SpitaliException {
        if(emri == null || emri.trim().isEmpty())
            throw new SpitaliException("Emri i personit nuk eshte inicializuar");
        this.emri = emri;
    }
    
    public boolean equals(Object o)
    {
        if(o instanceof Sektori)
        { 
            Sektori s = (Sektori)o;
            return s.getId() == id;
        }
        return false;
    }
    
   /* public String toString() {
        return "Sektori " + emri;
    }*/
}
