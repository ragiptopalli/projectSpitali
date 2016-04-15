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
public class Fatura 
{
    private int ID;
    private String data;
    private String metodaPageses;
    private double cmimi;
    private String artikujt;
    private Pacienti pacienti;

    public Fatura(int ID, String data, String metodaPageses, double cmimi, String artikujt, Pacienti pacienti) throws SpitaliException
    {
        if(ID <= 0) 
            throw new SpitaliException("ID nuk duhet te jete negative!");
        if(data == null || data.trim().isEmpty())
            throw new SpitaliException("Data nuk eshte inicializuar.");
        if(metodaPageses == null || metodaPageses.trim().isEmpty())
            throw new SpitaliException("Metoda pageses nuk eshte inicializuar.");
        if(cmimi <= 0)
            throw new SpitaliException("Cmimi nuk duhet te jete negativ");
        if(artikujt == null || artikujt.trim().isEmpty())
            throw new SpitaliException("Artikujt nuk jane te inicializuar.");
        if(pacienti == null)
            throw new SpitaliException("Pacienti nuk eshte i inicializuar");
        this.ID = ID;
        this.data = data;
        this.metodaPageses = metodaPageses;
        this.cmimi = cmimi;
        this.artikujt = artikujt;
        this.pacienti = pacienti;
    }

    public int getID() {
        return ID;
    }

    public String getData() {
        return data;
    }

    public String getMetodaPageses() {
        return metodaPageses;
    }

    public double getCmimi() {
        return cmimi;
    }

    public String getArtikujt() {
        return artikujt;
    }

    public Pacienti getPacienti() {
        return pacienti;
    }

    public void setData(String data)throws SpitaliException {
        if(data == null || data.trim().isEmpty())
            throw new SpitaliException("Data nuk eshte inicializuar.");
        this.data = data;
    }

    public void setMetodaPageses(String metodaPageses)throws SpitaliException {
        if(metodaPageses == null || metodaPageses.trim().isEmpty())
            throw new SpitaliException("Metoda pageses nuk eshte inicializuar.");
        this.metodaPageses = metodaPageses;
    }

    public void setCmimi(double cmimi)throws SpitaliException {
        if(cmimi <= 0)
            throw new SpitaliException("Cmimi nuk duhet te jete negativ");
        this.cmimi = cmimi;
    }

    public void setArtikujt(String artikujt)throws SpitaliException {
        if(artikujt == null || artikujt.trim().isEmpty())
            throw new SpitaliException("Artikujt nuk jane te inicializuar.");
        this.artikujt = artikujt;
    }

    public void setPacienti(Pacienti pacienti)throws SpitaliException {
        if(pacienti == null)
            throw new SpitaliException("Pacienti nuk eshte i inicializuar");
        this.pacienti = pacienti;
    }
}
