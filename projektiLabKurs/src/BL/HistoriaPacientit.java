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
public class HistoriaPacientit {
    
    private int ID;
    private String updateDate;
    private String gjendjaMjeksore;
    private String pershkrimiKomponeteve;
    private Doktori doktori;
    private Motra motra;
    private Recepsionisti recepsionisti;
    private Pacienti pacienti;

    public HistoriaPacientit(int ID, String updateDate, String gjendjaMjeksore, String pershkrimiKomponeteve, Doktori doktori, Motra motra, Recepsionisti recepsionisti, Pacienti pacienti) throws SpitaliException{
        if(ID <= 0) 
            throw new SpitaliException("ID nuk duhet te jete negative!");
        if(updateDate == null || updateDate.trim().isEmpty())
            throw new SpitaliException("Update date nuk eshte inicializuar.");
        if(gjendjaMjeksore == null || gjendjaMjeksore.trim().isEmpty())
            throw new SpitaliException("Gjendja Mjeksore date nuk eshte inicializuar.");
        if(pershkrimiKomponeteve == null || pershkrimiKomponeteve.trim().isEmpty())
            throw new SpitaliException("Pershkrimi Komponeteve date nuk eshte inicializuar.");
        if(doktori == null)
            throw new SpitaliException("Doktori nuk eshte i inicializuar");
        if(motra == null)
            throw new SpitaliException("Motra nuk eshte i inicializuar");
        if(recepsionisti == null)
            throw new SpitaliException("Recepsionisti nuk eshte i inicializuar");
        if(pacienti == null)
            throw new SpitaliException("Pacienti nuk eshte i inicializuar");
        
        this.ID = ID;
        this.updateDate = updateDate;
        this.gjendjaMjeksore = gjendjaMjeksore;
        this.pershkrimiKomponeteve = pershkrimiKomponeteve;
        this.doktori = doktori;
        this.motra = motra;
        this.recepsionisti = recepsionisti;
        this.pacienti = pacienti;
    }

    public int getID() {
        return ID;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public String getGjendjaMjeksore() {
        return gjendjaMjeksore;
    }

    public String getPershkrimiKomponeteve() {
        return pershkrimiKomponeteve;
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

    public Pacienti getPacienti() {
        return pacienti;
    }

    public void setUpdateDate(String updateDate) throws SpitaliException{
        if(updateDate == null || updateDate.trim().isEmpty())
            throw new SpitaliException("Update date nuk eshte inicializuar.");
        this.updateDate = updateDate;
    }

    public void setGjendjaMjeksore(String gjendjaMjeksore) throws SpitaliException{
        if(gjendjaMjeksore == null || gjendjaMjeksore.trim().isEmpty())
            throw new SpitaliException("Gjendja Mjeksore date nuk eshte inicializuar.");
        this.gjendjaMjeksore = gjendjaMjeksore;
    }

    public void setPershkrimiKomponeteve(String pershkrimiKomponeteve) throws SpitaliException{
        if(pershkrimiKomponeteve == null || pershkrimiKomponeteve.trim().isEmpty())
            throw new SpitaliException("Pershkrimi Komponeteve date nuk eshte inicializuar.");
        this.pershkrimiKomponeteve = pershkrimiKomponeteve;
    }

    public void setDoktori(Doktori doktori) throws SpitaliException{
        if(doktori == null)
            throw new SpitaliException("Doktori nuk eshte i inicializuar");
        this.doktori = doktori;
    }

    public void setMotra(Motra motra) throws SpitaliException{
        if(motra == null)
            throw new SpitaliException("Motra nuk eshte i inicializuar");
        this.motra = motra;
    }

    public void setRecepsionisti(Recepsionisti recepsionisti) throws SpitaliException{
        if(recepsionisti == null)
            throw new SpitaliException("Recepsionisti nuk eshte i inicializuar");
        this.recepsionisti = recepsionisti;
    }

    public void setPacienti(Pacienti pacienti) throws SpitaliException{
        if(pacienti == null)
            throw new SpitaliException("Pacienti nuk eshte i inicializuar");
        this.pacienti = pacienti;
    }
}
