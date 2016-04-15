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
public class Barnat {
    private int ID;
    private String emri;
    private double cmimi;
    private String dataSkadimit;
    private String pershkrimiKomponenteve;
    private Farmacisti farmacisti;
    private Fatura fatura;

    public Barnat(int ID, String emri, double cmimi, String dataSkadimit, String pershkrimiKomponenteve, Farmacisti farmacisti, Fatura fatura) throws SpitaliException{
        if(ID <= 0) 
            throw new SpitaliException("ID nuk duhet te jete negative!");
        if(emri == null || emri.trim().isEmpty())
            throw new SpitaliException("Emri nuk eshte inicializuar.");
        if(cmimi <= 0)
            throw new SpitaliException("Cmimi nuk duhet te jete negativ");
        if(dataSkadimit == null || dataSkadimit.trim().isEmpty())
            throw new SpitaliException("Data Skadimit nuk eshte inicializuar.");
        if(pershkrimiKomponenteve == null || pershkrimiKomponenteve.trim().isEmpty())
            throw new SpitaliException("Pershkrimi Komponenteve nuk eshte inicializuar.");
        if(farmacisti == null)
            throw new SpitaliException("Farmacisti nuk eshte i inicializuar");
        if(fatura == null)
            throw new SpitaliException("Fatura nuk eshte i inicializuar");
        
        
        this.ID = ID;
        this.emri = emri;
        this.cmimi = cmimi;
        this.dataSkadimit = dataSkadimit;
        this.pershkrimiKomponenteve = pershkrimiKomponenteve;
        this.farmacisti = farmacisti;
        this.fatura = fatura;
    }

    public int getID() {
        return ID;
    }

    public String getEmri() {
        return emri;
    }

    public double getCmimi() {
        return cmimi;
    }

    public String getDataSkadimit() {
        return dataSkadimit;
    }

    public String getPershkrimiKomponenteve() {
        return pershkrimiKomponenteve;
    }

    public Farmacisti getFarmacisti() {
        return farmacisti;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setEmri(String emri) throws SpitaliException{
        if(emri == null || emri.trim().isEmpty())
            throw new SpitaliException("Emri nuk eshte inicializuar.");
        this.emri = emri;
    }

    public void setCmimi(double cmimi) throws SpitaliException{
        if(cmimi <= 0)
            throw new SpitaliException("Cmimi nuk duhet te jete negativ");
        this.cmimi = cmimi;
    }

    public void setDataSkadimit(String dataSkadimit) throws SpitaliException{
        if(dataSkadimit == null || dataSkadimit.trim().isEmpty())
            throw new SpitaliException("Data Skadimit nuk eshte inicializuar.");
        this.dataSkadimit = dataSkadimit;
    }

    public void setPershkrimiKomponenteve(String pershkrimiKomponenteve) throws SpitaliException{
        if(pershkrimiKomponenteve == null || pershkrimiKomponenteve.trim().isEmpty())
            throw new SpitaliException("Pershkrimi Komponenteve nuk eshte inicializuar.");
        this.pershkrimiKomponenteve = pershkrimiKomponenteve;
    }

    public void setFarmacisti(Farmacisti farmacisti) throws SpitaliException{
        if(farmacisti == null)
            throw new SpitaliException("Farmacisti nuk eshte i inicializuar");
        this.farmacisti = farmacisti;
    }

    public void setFatura(Fatura fatura) throws SpitaliException{
        if(fatura == null)
            throw new SpitaliException("Fatura nuk eshte i inicializuar");
        this.fatura = fatura;
    }
}
