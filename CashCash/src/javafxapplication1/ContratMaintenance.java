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
    public String   numContrat;
    public Date     dateSignature;
    public Date     dateEcheance;
    
    public List <Materiel> lesMaterielsAssures = new ArrayList <Materiel>();
    
    public ContratMaintenance(String numContrat, Date dateSignature, Date dateEcheance, Materiel lesMaterielsAssures) throws SQLException{
        this.numContrat = numContrat;
        this.dateSignature = dateSignature;
        this.dateEcheance = dateEcheance;        
    }
}