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
public class Client {
    int    numClient;
    String nomClient;
    String adresse;
    String telClient;
    int    telCopCli;
    String email;
    int    siren;
    int    codeApe;
    int    dureeDeplacement;
    int    distanceKm;
    int    numAgence;
    
    public PersistanceSQL connexion;
    
    ArrayList <Materiel> lesMateriels= null/*new ArrayList <Materiel>()*/;
    ContratMaintenance leContrat;
    
    public Client(){
        
    }
/*******************************************/    
    public int getNumClient(){
        return numClient;
    }
    public void setNumClient(int numClient){
        this.numClient = numClient;
    }
/*******************************************/
    public String getNomClient(){
        return nomClient;
    }
    public void setNomClient(String nomClient){
        this.nomClient = nomClient;
    }
/*******************************************/
    public String getAdresse(){
        return adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
/*******************************************/
    public String getTelClient(){
        return telClient;
    }
    public void setTelClient(String telClient){
        this.telClient = telClient;
    }
/*******************************************/    
    public int getTelCopClient(){
        return telCopCli;
    }
    public void setTelCopCli(int telCopClient){
        this.telCopCli = telCopCli;
    }
/*******************************************/    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
/*******************************************/    
    public int getSiren(){
        return siren;
    }
    public void setSiren(int siren){
        this.siren = siren;
    }
/*******************************************/
    public int getCodeApe(){
        return codeApe;
    }
    public void setCodeApe(int codeApe){
        this.codeApe = codeApe;
    }
/*******************************************/
    public int getDureeDeplacement(){
        return dureeDeplacement;
    }
    public void setDureeDeplacement(int dureeDeplacement){
        this.dureeDeplacement = dureeDeplacement;
    }
/*******************************************/
    public int getDistanceKm(){
        return distanceKm;
    }
    public void setDistanceKm(int distanceKm){
        this.distanceKm = distanceKm;
    }
/*******************************************/
    public int getNumAgence(){
        return numAgence;
    }
    public void setNumAgence(int numAgence){
        this.numAgence = numAgence;
    }
/*******************************************/
    public ContratMaintenance getLeContrat(){
        return leContrat;        
    }
    public void setLeContrat(ContratMaintenance lecontrat){
        this.numAgence = numAgence;
    }
/*******************************************/
    
    public List <Materiel> getLesMateriels(ResultSet resultat) throws SQLException{
        Materiel unMateriel = null;
        try{
            while (resultat.next()){
                lesMateriels        = new ArrayList <Materiel>();
                unMateriel          = new Materiel();
                
                int     idMat       = resultat.getInt("ID_mat");
                String  nomMat      = resultat.getString("nom_mat");
                Date    dateInstal  = resultat.getDate("Date_instal_mat");
                float   prixMat     = resultat.getFloat("prix_mat");
                String  emplacement = resultat.getString("emplacement_mag");
                int     idType      = resultat.getInt("ID_typemat");
                int     idContrat   = resultat.getInt("ID_contrat"); 	
                int     idClient    = resultat.getInt("ID_client");
                
                unMateriel.setNumSerie(idMat);
                unMateriel.setNom(nomMat);
                unMateriel.setDateInstallation(dateInstal);
                unMateriel.setPrixVente(prixMat);
                unMateriel.setEmplacement(emplacement);
                unMateriel.setIdTypeMateriel(idType);
                unMateriel.setIdContrat(idContrat);
                unMateriel.setIdClient(idClient);

                lesMateriels.add(unMateriel);
            }
        }
        catch (SQLException ex){
            System.out.println(ex);
        }
        return lesMateriels;
    }
}