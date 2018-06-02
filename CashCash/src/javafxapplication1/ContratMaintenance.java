/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vincentf
 */
public class ContratMaintenance {
    private int      numContrat;
    private Date     dateDebut;
    private Date     dateEcheance;
    private Date     dateRenouvel;
    private int      idClient;
    
    private List <Materiel> lesMaterielsAssures = new ArrayList <Materiel>();
    
    public ContratMaintenance(){
        
    }
    
    public int getNumContrat(){
        return numContrat;
    }
    public void setNumContrat(int numContrat){
        this.numContrat = numContrat;
    }
    
    public Date getDateDebut(){
        return dateDebut;
    }
    public void setDateDebut(Date dateDebut){
        this.dateDebut = dateDebut;
    }
    
    public Date getDateEcheance(){
        return dateEcheance;
    }
    public void setDateEcheance(Date dateEcheance){
        this.dateEcheance = dateEcheance;
    }
    
    public Date getDateRenouvel(){
        return dateRenouvel;
    }
    public void setDateRenouvel(Date dateRenouvel){
        this.dateRenouvel = dateRenouvel;
    }
    
    public int getIdClient(){
        return idClient;
    }
    public void setIdClient(int idClient){
        this.idClient = idClient;
    }
}