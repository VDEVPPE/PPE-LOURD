package javafxapplication1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author vincentf
 */
public class testGetMateriel {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException { 
        List <Materiel> testResMat = null;
        Materiel unMateriel = new Materiel();
        Client testClient = new Client();
        PersistanceSQL testPersist = new PersistanceSQL();
        ResultSet resultat = null;
        
        try{
            resultat = testPersist.select("SELECT * FROM materiel WHERE ID_client = 1 AND ID_mat = 1");
            testResMat = testClient.getLesMateriels(resultat);
            for(Materiel materiel : testResMat){
                System.out.println("Identifiant matériel : " + materiel.idMateriel);
                System.out.println("Nom                  : " + materiel.nom);
                System.out.println("Date d'installation  : " + materiel.dateInstallation);
                System.out.println("Prix de vente        : " + materiel.prixVente);
                System.out.println("Emplacement materiel : " + materiel.emplacement);
                System.out.println("Type de materiel     : " + materiel.leType);
                System.out.println("Identifiant contrat  : " + materiel.idContrat);
                System.out.println("Identifiant client   : " + materiel.idClient);
            }
        }
        catch (SQLException ex){
            System.out.println(ex);
        }
        
        
        
        
        
    }
    
}
