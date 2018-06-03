package javafxapplication1;

import java.util.Date;

/**
 * @author vincentf
 */
public class Materiel {
    public int          numSerie;
    public String       nom;
    public Date         dateInstallation;
    public float        prixVente;
    public Date         dateVente;
    public int          NbrJourAvantEcheance;
    public String       emplacement;
    public TypeMateriel leType;
    public int          idTypeMateriel;
    public int          idMateriel;
    public int          idContrat;
    public int          idClient;
 
    public Materiel(){
        
    }
    
    public Materiel(int numSerie, String nom, Date dateInstallation, float prixVente, Date dateVente,int NbrJourAvantEcheance,String emplacement, TypeMateriel leType, int idMateriel, int idContrat, int idClient){
        this.numSerie           = numSerie;
        this.nom                = nom;
        this.dateInstallation   = dateInstallation;
        this.prixVente          = prixVente;
        this.dateVente          = dateVente;
        this.NbrJourAvantEcheance = NbrJourAvantEcheance;
        this.emplacement        = emplacement;
        this.leType             = leType;
        this.idMateriel         = idMateriel;
        this.idContrat          = idContrat;
        this.idClient           = idClient;
    }
    
/*******************************************/    
    public int getNumSerie(){
        return numSerie;
    }
    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }
/********************************************/
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
/*******************************************/
    public Date getDateInstallation(){
        return dateInstallation;
    }
    public void setDateInstallation(Date dateInstallation){
        this.dateInstallation = dateInstallation;
    }
/*******************************************/
    public float getPrixVente(){
        return prixVente;
    }
    public void setPrixVente(float prixVente){
        this.prixVente = prixVente;
    }
/*******************************************/
    public String getEmplacement(){
        return emplacement;
    }
    public void setEmplacement(String emplacement){
        this.emplacement = emplacement;
    }
/*******************************************/
    public int getIdMateriel(){
        return idMateriel;
    }
    public void setIdMateriel(int idMateriel){
        this.idMateriel = idMateriel;
    }
/*******************************************/
    public int getIdContrat(){
        return idContrat;
    }
    public void setIdContrat(int idContrat){
        this.idContrat = idContrat;
    }
/*******************************************/
    public int getIdClient(){
        return idClient;
    }
    public void setIdClient(int idClient){
        this.idClient = idClient;
    }
/*******************************************/
    public int getIdTypeMateriel(){
        return idTypeMateriel;
    }
    public void setIdTypeMateriel(int idTypeMateriel){
        this.idTypeMateriel = idTypeMateriel;
    }
 /*******************************************/
    public Date getDateVente(){
        return dateVente;
    }
    public void setDateVente(Date dateVente){
        this.dateVente = dateVente;
    }
/*******************************************/
    public int getNbrJourAvantEcheance(){
        return NbrJourAvantEcheance;
    }
    public void setNbrJourAvantEcheance(int NbrJourAvantEcheance){
        this.NbrJourAvantEcheance = NbrJourAvantEcheance;
    } 
/*******************************************/  
}
