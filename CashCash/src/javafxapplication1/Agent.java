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
    
    //
/*****Récupération des informations Agent*****/
    public int getIdAgent(){
        return idAgent;
    }
    public void setIdAgent(int idAgent){
        this.idAgent = idAgent;
    }
/*********************************************/
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
/*********************************************/
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
/*********************************************/
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
/*********************************************/
    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
/*********************************************/
    public String getAdresse(){
        return adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
/*********************************************/
    public Date getDate_embauche(){
        return date_embauche;
    }
    public void setDate_embauche(Date date_embauche){
        this.date_embauche = date_embauche;
    }
/*********************************************/
    public int getIdAgence(){
        return idAgence;
    }
    public void setIdAgence(int idAgence){
        this.idAgence = idAgence;
    }
/*********************************************/
    public int getIdRegion(){
        return idRegion;
    }
    public void setIdRegion(int idRegion){
        this.idRegion = idRegion;
    }
/*********************************************/
    


    
    public Agent identification(String unId) throws SQLException{
        //Fonction de récupération des information dans la base
        //de l'agent renseigné par son identifient
        //(id = valeur unique et non modifiable)
        String          mdp;
        Agent           retour      = new   Agent();
        PersistanceSQL  connexion   = new PersistanceSQL();
        //On établi la connexion à la base
        connexion.ouvrirConnexion();
        //On Select l'agent
        ResultSet resultat = connexion.select("SELECT * FROM agent WHERE ID_agent = " + unId);
        while (resultat.next()){
            //Temps qu'il y'a des infos à prendre on prend
            //et on les renseignes dans la variable qui va bien

            //      Variable       Champs SQL 
            int     idAgent      = resultat.getInt("ID_agent");
            String  type         = resultat.getString("Type");
            String  nom          = resultat.getString("nom");
            mdp                  = resultat.getString("Password");
            String  prenom       = resultat.getString("prenom");
            String  adresse      = resultat.getString("adresse");
            Date    dateEmbauche = resultat.getDate("Date_embauche");
            int     idAgence     = resultat.getInt("ID_agence");
            int     idRegion     = resultat.getInt("ID_region");
            
            //Puis on les transmets à l'objet Agent retourné par la fonction  
            retour.setIdAgent(idAgent);
            retour.setType(type);
            retour.setPassword(mdp);
            retour.setPrenom(prenom);
            retour.setNom(nom);
            retour.setAdresse(adresse);
            retour.setDate_embauche(dateEmbauche);
            retour.setIdAgence(idAgence);
            retour.setIdRegion(idRegion);
            }
    return retour;
    }
}