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
public class Adresa 
{
    private int ID;
    private String qyteti;
    private String shteti;
    private String rruga;
    private int numri;
    private Doktori doktori;
    private Motra motra;
    private Recepsionisti recepsionisti;
    private Farmacisti farmacisti;
    private Punetori punetori;
    private Pacienti pacienti;
    
    public Adresa(int ID, String qyteti, String shteti, String rruga, int numri, Doktori doktori, Motra motra, Recepsionisti recepsionisti, Farmacisti farmacisti, Punetori punetori , Pacienti pacineti) throws SpitaliException {
        if(ID <= 0) 
            throw new SpitaliException("ID nuk duhet te jete negative!");
        if(qyteti == null || qyteti.trim().isEmpty())
            throw new SpitaliException("Qyteti nuk eshte inicializuar apo eshte e zbrazet!");
        if(shteti == null || shteti.trim().isEmpty())
            throw new SpitaliException("Shteti nuk eshte inicializuar apo eshte e zbrazet!");
        if(rruga == null || rruga.trim().isEmpty())
            throw new SpitaliException("Rruga nuk eshte inicializuar apo eshte e zbrazet!");
        if(numri <=0 )
            throw new SpitaliException("Numri i shtepise nuk bene negative.");
        if(doktori == null && motra == null && recepsionisti == null && farmacisti == null && punetori == null && pacineti == null )
            throw new SpitaliException("Nuk eshte i inicializuar asnje staf apo pacient.");
        
        
        this.ID = ID;
        this.qyteti = qyteti;
        this.shteti = shteti;
        this.rruga = rruga;
        this.numri = numri;
        this.doktori = doktori;
        this.motra = motra;
        this.recepsionisti = recepsionisti;
        this.farmacisti = farmacisti;
        this.punetori = punetori;
        this.pacienti = pacienti;
    }

    public int getID() {
        return ID;
    }

    public String getQyteti() {
        return qyteti;
    }

    public String getShteti() {
        return shteti;
    }

    public String getRruga() {
        return rruga;
    }

    public int getNumri() {
        return numri;
    }

    public Doktori getDoktori() {
        return doktori;
    }

    public Motra getMotra() {
        return motra;
    }

    public Recepsionisti getRecepsionisti() {
        return recepsionisti;
    }

    public Farmacisti getFarmacisti() {
        return farmacisti;
    }

    public Punetori getPunetori() {
        return punetori;
    }

    public Pacienti getPacienti() {
        return pacienti;
    }

    public void setQyteti(String qyteti)throws SpitaliException
    {
        if(qyteti == null || qyteti.trim().isEmpty())
            throw new SpitaliException("Qyteti nuk eshte inicializuar apo eshte e zbrazet!");
        this.qyteti = qyteti;
    }

    public void setShteti(String shteti) throws SpitaliException
    {
        if(shteti == null || shteti.trim().isEmpty())
            throw new SpitaliException("Shteti nuk eshte inicializuar apo eshte e zbrazet!");
        this.shteti = shteti;
    }

    public void setRruga(String rruga) throws SpitaliException
    {
        if(rruga == null || rruga.trim().isEmpty())
            throw new SpitaliException("Rruga nuk eshte inicializuar apo eshte e zbrazet!");
        this.rruga = rruga;
    }

    public void setNumri(int numri) throws SpitaliException
    {
        if(numri <=0 )
            throw new SpitaliException("Numri i shtepise nuk bene negative.");
        this.numri = numri;
    }

    public void setDoktori(Doktori doktori) throws SpitaliException{
        if(doktori == null)
            throw new SpitaliException("Doktori eshte i pa inicializuar!");
        this.doktori = doktori;
    }

    public void setMotra(Motra motra) throws SpitaliException{
        if(motra == null)
            throw new SpitaliException("Motra eshte i pa inicializuar!");
        this.motra = motra;
    }

    public void setRecepsionisti(Recepsionisti recepsionisti) throws SpitaliException{
        if(recepsionisti == null)
            throw new SpitaliException("Recepsionisti eshte i pa inicializuar!");
        this.recepsionisti = recepsionisti;
    }

    public void setFarmacisti(Farmacisti farmacisti) throws SpitaliException{
        if(farmacisti == null)
            throw new SpitaliException("Farmacisti eshte i pa inicializuar!");
        this.farmacisti = farmacisti;
    }

    public void setPunetori(Punetori punetori) throws SpitaliException{
        if(punetori == null)
            throw new SpitaliException("Punetori eshte i pa inicializuar!");
        this.punetori = punetori;
    }

    public void setPacienti(Pacienti pacienti)throws SpitaliException 
    {
        if(pacienti == null)
            throw new SpitaliException("Pacienti eshte i pa inicializuar!");
        this.pacienti = pacienti;
    }
    
    

}
