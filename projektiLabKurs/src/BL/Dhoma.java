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
public class Dhoma 
{
    private int id;
    private String dataPrej;
    private String dataDeri;
    private Sektori sektori;

    public Dhoma(int id, String dataPrej, String dataDeri, Sektori sektori) throws SpitaliException
    {
        if(id<=0)
            throw new SpitaliException("Id sbon me kon negative");
        if(dataPrej== null || dataPrej.trim().isEmpty())
            throw new SpitaliException("Data Prej e painicializuar.");
        if(dataDeri== null || dataDeri.trim().isEmpty())
            throw new SpitaliException("Data Deri e painicializuar.");
        if(sektori == null)
            throw new SpitaliException("Sektori pa inicializim.");
        this.id = id;
        this.dataPrej = dataPrej;
        this.dataDeri = dataDeri;
        this.sektori = sektori;
    }

    public int getId() {
        return id;
    }
    
    public String getDataPrej() {
        return dataPrej;
    }

    public String getDataDeri() {
        return dataDeri;
    }

    public Sektori getSektori() {
        return sektori;
    }

    public void setDataPrej(String dataPrej) throws SpitaliException
    {
        if(dataPrej== null || dataPrej.trim().isEmpty())
            throw new SpitaliException("Data Prej e painicializuar.");
        this.dataPrej = dataPrej;
    }

    public void setDataDeri(String dataDeri) throws SpitaliException
    {
        if(dataDeri== null || dataDeri.trim().isEmpty())
            throw new SpitaliException("Data Deri e painicializuar.");
        this.dataDeri = dataDeri;
    }

    public void setSektori(Sektori sektori) throws SpitaliException
    {
        if(sektori == null)
            throw new SpitaliException("Sektori pa inicializim.");
        this.sektori = sektori;
    }
    
    
}
