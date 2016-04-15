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
public class Orari 
{
    private int ID;
    private String dataFillimit;
    private String dataMbarimit;
    private String kohaFilimit;
    private String kohaMbarimit;
    private Doktori doktori;
    private Motra motra;
    private Recepsionisti recepsionisti;
    private Farmacisti farmacisti;
    private Punetori punetori;
    
    public Orari(int ID, String dataFillimit, String dataMbarimit, String kohaFillimit, String kohaMbarimit, Doktori doktori, Motra motra, Recepsionisti recepsionisti, Farmacisti farmacisti, Punetori punetori) throws SpitaliException {
        if(ID <= 0) 
            throw new SpitaliException("ID nuk duhet te jete negative!");
        if(dataFillimit == null || dataFillimit.trim().isEmpty())
            throw new SpitaliException("Data Fillimit nuk eshte inicializuar apo eshte e zbrazet!");
        if(dataMbarimit == null || dataMbarimit.trim().isEmpty())
            throw new SpitaliException("Data Mbarimit nuk eshte inicializuar apo eshte e zbrazet!");
        if(kohaFillimit == null || kohaFillimit.trim().isEmpty())
            throw new SpitaliException("Koha Fillimit nuk eshte inicializuar apo eshte e zbrazet!");
        if(kohaMbarimit == null || kohaMbarimit.trim().isEmpty())
            throw new SpitaliException("Koha Mbarimit nuk eshte inicializuar apo eshte e zbrazet!");
        if(doktori == null)
            throw new SpitaliException("Doktori eshte i pa inicializuar!");
        if(motra == null)
            throw new SpitaliException("Motra eshte i pa inicializuar!");
        if(recepsionisti == null)
            throw new SpitaliException("Recepsionisti eshte i pa inicializuar!");
        if(farmacisti == null)
            throw new SpitaliException("Farmacisti eshte i pa inicializuar!");
        if(punetori == null)
            throw new SpitaliException("Punetori eshte i pa inicializuar!");
        
        this.ID = ID;
        this.dataFillimit = dataFillimit;
        this.dataMbarimit = dataMbarimit;
        this.kohaFilimit = kohaFillimit;
        this.kohaMbarimit = kohaMbarimit;
        this.doktori = doktori;
        this.motra = motra;
        this.recepsionisti = recepsionisti;
        this.farmacisti = farmacisti;
        this.punetori = punetori;
    }

    public int getID() {
        return ID;
    }

    public String getDataFillimit() {
        return dataFillimit;
    }

    public String getDataMbarimit() {
        return dataMbarimit;
    }

    public String getKohaFilimit() {
        return kohaFilimit;
    }

    public String getKohaMbarimit() {
        return kohaMbarimit;
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

    public void setDataFillimit(String dataFillimit) throws SpitaliException {
        if(dataFillimit == null || dataFillimit.trim().isEmpty())
            throw new SpitaliException("Data Fillimit nuk eshte inicializuar apo eshte e zbrazet!");
        this.dataFillimit = dataFillimit;
    }

    public void setDataMbarimit(String dataMbarimit) throws SpitaliException{
        if(dataMbarimit == null || dataMbarimit.trim().isEmpty())
            throw new SpitaliException("Data Mbarimit nuk eshte inicializuar apo eshte e zbrazet!");
        this.dataMbarimit = dataMbarimit;
    }

    public void setKohaFilimit(String kohaFillimit) throws SpitaliException{
        if(kohaFillimit == null || kohaFillimit.trim().isEmpty())
            throw new SpitaliException("Koha Fillimit nuk eshte inicializuar apo eshte e zbrazet!");
        this.kohaFilimit = kohaFilimit;
    }

    public void setKohaMbarimit(String kohaMbarimit) throws SpitaliException{
        if(kohaMbarimit == null || kohaMbarimit.trim().isEmpty())
            throw new SpitaliException("Koha Mbarimit nuk eshte inicializuar apo eshte e zbrazet!");
        this.kohaMbarimit = kohaMbarimit;
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
}
