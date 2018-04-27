package javafxapplication1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author vincentf
 */
public class Agent {
    public int    idAgent;
    public String type;
    public String nom;
    public String password;
    public String prenom;
    public String adresse;
    public Date   date_embauche;
    public int    idAgence;
    public int    idRegion;
    
    public Agent(int idAgent, String type, String nom, String password, String prenom, String adresse, Date date_embauche, int idAgence, int idRegion){
        this.idAgent = idAgent;
        this.type = type;
        this.nom = nom;
        this.password = password;
        this.prenom = prenom;
        this.adresse = adresse;
        this.date_embauche = date_embauche;
        this.idAgence = idAgence;
        this.idRegion = idRegion;
    }
    
    public Agent(){
        
    }
/*******************************************/
    public int getIdAgent(){
        return idAgent;
    }
    public void setIdAgent(int idAgence){
        this.idAgent = idAgent;
    }
/*******************************************/
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
/*******************************************/
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
/*******************************************/
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
/*******************************************/
    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
/*******************************************/
    public String getAdresse(){
        return adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
/*******************************************/
    public Date getDate_embauche(){
        return date_embauche;
    }
    public void setDate_embauche(Date date_embauche){
        this.date_embauche = date_embauche;
    }
/*******************************************/
    public int getIdAgence(){
        return idAgence;
    }
    public void setIdAgence(int idAgence){
        this.idAgence = idAgence;
    }
/*******************************************/
    public int getIdRegion(){
        return idRegion;
    }
    public void setIdRegion(int idRegion){
        this.idRegion = idRegion;
    }
/*******************************************/
    
    public boolean identification(String unId, String unPassword) throws SQLException{
        String          mdp;
        boolean         retour      = false;
        List <Agent>    agent       = null;
        PersistanceSQL  connexion   = new PersistanceSQL();
        try{
            connexion.ouvrirConnexion();
            ResultSet resultat = connexion.select("SELECT Password FROM agent WHERE ID_agent = " + unId);
            while (resultat.next()){
                System.out.println("Password : |" + unPassword + "|");
                mdp = resultat.getString("Password");
                System.out.println("Password de l'agent : |" + mdp + "|; Password : |" + unPassword + "|");
                if (mdp.equals(unPassword)){
                    retour = true;
                }
            }
        }
        catch (SQLException ex){
            System.out.println("Erreur@ç01 recup mdp : " + ex);
        }
        return retour;
    }
}
