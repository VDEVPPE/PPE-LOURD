package javafxapplication1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author vincentf
 */
public class testPersistance {

    public static void main(String[] args) throws SQLException{
        PersistanceSQL testPersist = new PersistanceSQL();
        ResultSet resultat = null;
        ArrayList <Materiel> lesMateriels = null;
        Materiel unMateriel = null;
        testPersist.ouvrirConnexion();
        resultat = testPersist.select("SELECT * FROM materiel WHERE ID_client = 1");
   
        testPersist.close();
        System.out.print(lesMateriels);
    }
}
