package javafxapplication1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    private ArrayList<Materiel> lesMaterielsAssures;
    
//    private ArrayList <Materiel> lesMaterielsAssures = new ArrayList <Materiel>();
    
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
    
    // AJOUTS MICKA
    
    public int getJourRestants() {
        Date currentDate = new Date();
        long diff = dateEcheance.getTime() - currentDate.getTime();
        return (int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public boolean estValide() {
        Date currentDate = new Date();
        return currentDate.after(dateDebut) && currentDate.before(dateEcheance);
    }

    public void ajouterMateriel(Materiel unMateriel) {
        if (!dateDebut.before(unMateriel.getDateInstallation())) {
            System.out.println("La date d'installation du matériel doit être supérieure à la date de début du contrat!");
            return;
        }
        this.lesMaterielsAssures.add(unMateriel);
    }

    public ArrayList<Materiel> getLesMaterielsAssures() {
        return lesMaterielsAssures;
    }

    /*public void loadMaterials() throws SQLException {
        Connecting connection = new Connecting();
        
        if (connection == null) return;
        
        lesMaterielsAssures = (ArrayList<Materiel>) connection.chargerDepuisBase(String.valueOf(this.numContrat), "Materiel");
        
        System.out.println("Matériels récupérés : \u001B[36m" + this.lesMaterielsAssures.size() + "\u001B[0m.");
    }*/
}
