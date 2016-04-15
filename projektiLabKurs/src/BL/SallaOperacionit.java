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
public class SallaOperacionit {
    private int ID;
    private String data;
    private String ora;
    private Sektori sektori;

    public SallaOperacionit(int ID, String data, String ora, Sektori sektori) throws SpitaliException{
        if(ID <= 0) 
            throw new SpitaliException("ID nuk duhet te jete negative!");
        if(data == null || data.trim().isEmpty())
            throw new SpitaliException("Data nuk eshte inicializuar.");
        if(ora == null || ora.trim().isEmpty())
            throw new SpitaliException("Ora nuk eshte inicializuar.");
        if(sektori == null)
            throw new SpitaliException("Sektori nuk eshte i inicializuar");
        
        this.ID = ID;
        this.data = data;
        this.ora = ora;
        this.sektori = sektori;
    }

    public int getID() {
        return ID;
    }

    public String getData() {
        return data;
    }

    public String getOra() {
        return ora;
    }

    public Sektori getSektori() {
        return sektori;
    }

    public void setData(String data) throws SpitaliException{
        if(data == null || data.trim().isEmpty())
            throw new SpitaliException("Data nuk eshte inicializuar.");
        this.data = data;
    }

    public void setOra(String ora) throws SpitaliException{
        if(ora == null || ora.trim().isEmpty())
            throw new SpitaliException("Ora nuk eshte inicializuar.");
        this.ora = ora;
    }

    public void setSektori(Sektori sektori) throws SpitaliException{
        if(sektori == null)
            throw new SpitaliException("Sektori nuk eshte i inicializuar");
        this.sektori = sektori;
    }
}
