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
public abstract class Stafi 
{
    private String emri;
    private String mbiemri;
    private char gjinia;
    private String dataLindjes;
    private String detajeTjera;
    
    public Stafi(String e, String m , char g , String d , String de)throws SpitaliException
    {
        if(e == null || e.trim().isEmpty())
            throw new SpitaliException("Emri nuk eshte inicializuar.");
        if(m == null || m.trim().isEmpty())
            throw new SpitaliException("Mbiemri nuk eshte inicializuar.");
        if(g != 'M' || g !='F')
            throw new SpitaliException("Gjinia duhet te jete M ose F");
        if(d == null || d.trim().isEmpty())
            throw new SpitaliException("Data lindjes nuk eshte inicializuar.");
        
        emri = e; 
        mbiemri = m; 
        gjinia = g; 
        dataLindjes = d; 
        detajeTjera = de;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String e)throws SpitaliException
    {
        if(e == null || e.trim().isEmpty())
            throw new SpitaliException("Emri nuk eshte inicializuar.");
        emri = e;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String m)throws SpitaliException
    {
        if(m == null || m.trim().isEmpty())
            throw new SpitaliException("Emri nuk eshte inicializuar.");
        mbiemri = m;
    }

    public char getGjinia() {
        return gjinia;
    }

    public void setGjinia(char gjinia) throws SpitaliException
    {
        if(gjinia != 'M' || gjinia !='F')
            throw new SpitaliException("Gjinia duhet te jete M ose F");
        this.gjinia = gjinia;
    }

    public String getDataLindjes() {
        return dataLindjes;
    }

    public void setDataLindjes(String dataLindjes)throws SpitaliException
    {
        if(dataLindjes == null || dataLindjes.trim().isEmpty())
            throw new SpitaliException("Emri nuk eshte inicializuar.");
        this.dataLindjes = dataLindjes;
    }

    public String getDetajeTjera() {
        return detajeTjera;
    }

    public void setDetajeTjera(String detajeTjera) {
        this.detajeTjera = detajeTjera;
    }
    
    /*
    public String toString() {
        return ...
    }*/
}
