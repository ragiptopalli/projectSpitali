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
public class Pacienti 
{
    private String emri;
    private String mbiemri;
    private char gjinia;
    private String dataLindjes;
    private double pesha;
    private double gjatesia;
    private String numriTelefonit;
    private String detajeTjera;
    private Dhoma dhoma;

    public Pacienti(String emri, String mbiemri, char gjinia, String dataLindjes, double pesha, double gjatesia, String numriTelefonit, String detajeTjera, Dhoma dhoma) throws SpitaliException
    {
        if(emri == null || emri.trim().isEmpty())
            throw new SpitaliException("Emri nuk eshte inicializuar.");
        if(mbiemri == null || mbiemri.trim().isEmpty())
            throw new SpitaliException("Mbiemri nuk eshte inicializuar.");
        if(gjinia != 'M' || gjinia!='F')
            throw new SpitaliException("Gjinia duhet te jete M ose F");
        if(dataLindjes == null || dataLindjes.trim().isEmpty())
            throw new SpitaliException("Data lindjes nuk eshte inicializuar.");
        if(pesha <=0)
            throw new SpitaliException("Pesha nuk bon me kon negative.");
        if(gjatesia <=0)
            throw new SpitaliException("Gjatesia nuk bon me kon negative.");
        if(numriTelefonit == null || numriTelefonit.trim().isEmpty() || numriTelefonit.length() < 7)
            throw new SpitaliException("Numri telefonit duhet inicializuar.");
        if(dhoma == null)
            throw new SpitaliException("Dhoma duhet inicializuar.");
        
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.gjinia = gjinia;
        this.dataLindjes = dataLindjes;
        this.pesha = pesha;
        this.gjatesia = gjatesia;
        this.numriTelefonit = numriTelefonit;
        this.detajeTjera = detajeTjera;
        this.dhoma = dhoma;
    }

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public char getGjinia() {
        return gjinia;
    }

    public String getDataLindjes() {
        return dataLindjes;
    }

    public double getPesha() {
        return pesha;
    }

    public double getGjatesia() {
        return gjatesia;
    }

    public String getNumriTelefonit() {
        return numriTelefonit;
    }

    public String getDetajeTjera() {
        return detajeTjera;
    }

    public Dhoma getDhoma() {
        return dhoma;
    }

    public void setEmri(String emri) throws SpitaliException
    {
        if(emri == null || emri.trim().isEmpty())
            throw new SpitaliException("Emri nuk eshte inicializuar.");
        this.emri = emri;
    }

    public void setMbiemri(String mbiemri) throws SpitaliException
    {
        if(mbiemri == null || mbiemri.trim().isEmpty())
            throw new SpitaliException("Mbiemri nuk eshte inicializuar.");
        this.mbiemri = mbiemri;
    }

    public void setGjinia(char gjinia) throws SpitaliException
    {
        if(gjinia != 'M' || gjinia!='F')
            throw new SpitaliException("Gjinia duhet te jete M ose F");
        this.gjinia = gjinia;
    }

    public void setDataLindjes(String dataLindjes) throws SpitaliException
    {
        if(dataLindjes == null || dataLindjes.trim().isEmpty())
            throw new SpitaliException("Data lindjes nuk eshte inicializuar.");
        this.dataLindjes = dataLindjes;
    }

    public void setPesha(double pesha) throws SpitaliException
    {
        if(pesha <=0)
            throw new SpitaliException("Pesha nuk bon me kon negative.");
        this.pesha = pesha;
    }

    public void setGjatesia(double gjatesia) throws SpitaliException
    {
        if(gjatesia <=0)
            throw new SpitaliException("Gjatesia nuk bon me kon negative.");
        this.gjatesia = gjatesia;
    }

    public void setNumriTelefonit(String numriTelefonit) throws SpitaliException
    {
        if(numriTelefonit == null || numriTelefonit.trim().isEmpty() || numriTelefonit.length() < 7)
            throw new SpitaliException("Numri telefonit duhet inicializuar.");
        this.numriTelefonit = numriTelefonit;
    }

    public void setDetajeTjera(String detajeTjera) throws SpitaliException
    {
        if(detajeTjera == null || detajeTjera.trim().isEmpty())
            throw new SpitaliException("Detajet e tjera e painicializuar.");
        this.detajeTjera = detajeTjera;
    }

    public void setDhoma(Dhoma dhoma) throws SpitaliException
    {
        if(dhoma == null)
            throw new SpitaliException("Dhoma duhet inicializuar.");
        this.dhoma = dhoma;
    }
    
    
}
