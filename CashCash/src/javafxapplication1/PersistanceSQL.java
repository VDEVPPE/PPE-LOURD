package javafxapplication1;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.JOptionPane;
/**
 * @author vincentf
 */
public class PersistanceSQL {
    public String url = "jdbc:mysql://localhost:3306/id4068001_bddcashcash";
    public String user = "root";
    public String password = "";

    public ResultSet resultat = null;
    private static Connection connexion = null; 
    
    public boolean ouvrirConnexion() throws SQLException {
        try {
            connexion = DriverManager.getConnection(url, user, password);
            return true;} 
        catch (SQLException ex) {
            //Gestion d'eventuelles erreurs
            switch(ex.getErrorCode()){
                case 0:
                    JOptionPane.showMessageDialog(null, "Connection au serveur impossible. Merci de contacter l'administrateur", "Une erreur est survenue", JOptionPane.WARNING_MESSAGE );
                    break;
                case 1045:
                    JOptionPane.showMessageDialog(null, "Identifiant ou mot de passe invalide", "Une erreur est survenue", JOptionPane.WARNING_MESSAGE );
            }
        }
        finally{
            
        }
        return false;
    }
    
    public ResultSet select(String requete) throws SQLException{
        ResultSet resultFinal = null;
        //Ouvrir connexion
        if (this.ouvrirConnexion()){
            //creation de l'object gerant les requetes
            Statement statement = connexion.createStatement();
            resultFinal = statement.executeQuery(requete);
            System.out.println("successful connection to the database");
       }
       return resultFinal;
    }
    
    public void updateInsert(String requete) throws SQLException{
        if (this.ouvrirConnexion() == true){
            Statement statement = connexion.createStatement();
            /* Execution d'une requete d'update */
            int statut = statement.executeUpdate(requete);
      }
  }
    
    public void rangerDansBase(Object unObjet) throws SQLException{
        this.ouvrirConnexion();
        if (unObjet instanceof Client){
            this.updateInsert("INSERT INTO client(ID_client, Nom_client, numero_siren_cli, code_APE_cli, adresse_cli, telephone_cli, telecopie_cli, email_cli) VALUES (" + ((Client) unObjet).getNumClient() + "," + ((Client) unObjet).getNomClient()+ "," + ((Client) unObjet).getSiren() + "," + ((Client) unObjet).getSiren() + "," + ((Client) unObjet).getCodeApe() + "," + ((Client) unObjet).getAdresse() + "," + ((Client) unObjet).getTelClient() + "," + ((Client) unObjet).getDureeDeplacement() + "," + ((Client) unObjet).getDistanceKm()+ "," + ((Client) unObjet).getNumAgence() + ")" );
        }
        if (unObjet instanceof Materiel){
            this.updateInsert("INSERT INTO materiel(NumSerie, Nom, DateVente, DateInstallation, Prix, Emplacement, Ref, Num_contrat) VALUES ("+ ((Materiel) unObjet).getNumSerie() + "," + ((Materiel) unObjet).getNom() + "," + ((Materiel) unObjet).getDateInstallation() + "," + ((Materiel) unObjet).getPrixVente() + "," + ((Materiel) unObjet).getEmplacement() + "," + ((Materiel) unObjet).getIdMateriel() + ","+ ((Materiel) unObjet).getIdContrat());            
        }
        
        if (unObjet instanceof TypeMateriel){
            this.updateInsert("INSERT INTO type_materiel(Ref, Libelle, Code) VALUES ("+ ((TypeMateriel) unObjet).getReferenceInterne() + "," + ((TypeMateriel) unObjet).getLibelleTypeMateriel() + ")");

        }
    }
    
    public void close() throws SQLException{
        connexion.close();
    }
}   