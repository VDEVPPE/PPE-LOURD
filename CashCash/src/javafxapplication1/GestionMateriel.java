package javafxapplication1;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import java.net.URISyntaxException;

import java.sql.SQLException;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;



public class GestionMateriel {

    private Client client;
    public PersistanceSQL gestMat;
    
    public GestionMateriel(Client client) {
        this.client = client;
        try {
            this.xmlClient() ;
        } catch ( URISyntaxException e) {
        }
    }

    private void xmlClient() throws URISyntaxException {
     
        ArrayList<Materiel> lesMaterielsExpires     = new ArrayList<>();
        ArrayList<Materiel> lesMaterielsSousContrat = new ArrayList<>();
        
        if (this.client.getLeContrat() == null) {
            try {
                this.client.loadContracts();
            } catch (SQLException e) {
            }
        }

        // Permet de remplir les listes des matériels
        
        ArrayList<ContratMaintenance> leContrat = this.client.getLeContrat();
        if (leContrat.size() > 0) {
            for (ContratMaintenance contrat : leContrat) {
                if (contrat.getLesMaterielsAssures() == null) {
                    try {
                        contrat.loadMaterials();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                ArrayList<Materiel> lesMateriels = contrat.getLesMaterielsAssures();
                for (Materiel materiel : lesMateriels) {
                    if (materiel.getNbrJourAvantEcheance() <= 0) {
                        lesMaterielsExpires.add(materiel);
                    }
                    else{
                        lesMaterielsSousContrat.add(materiel);
                    } 
                 
                }
            }
        }

            
        try {
             DocumentBuilderFactory factory     =   DocumentBuilderFactory.newInstance();
            //Creation d'un parseur 
            final DocumentBuilder builder       =   factory.newDocumentBuilder();

            //Creation d'un document 
            final Document document             =   builder.newDocument();

            //Creation des éléments racine 
            final Element listeMateriel         =   document.createElement("listeMateriel");
            final Element lesMateriels          =   document.createElement("materiels");    

            
            
            //ajout élément racine au document
            document.appendChild(listeMateriel);
            
            listeMateriel.appendChild(lesMateriels);
            
            lesMateriels.setAttribute("idClient", String.valueOf(client.getNumClient()));
            
            
            
        for (Materiel unMaterielExpire : lesMaterielsExpires) {
            //Creation des sous éléments
           
            final Element type                  =   document.createElement("type");
            final Element famille               =   document.createElement("famille");
            final Element date_vente            =   document.createElement("date_vente");
            final Element date_installation     =   document.createElement("date_installation");
            final Element prix_vente            =   document.createElement("prix_vente");
            final Element emplacement           =   document.createElement("emplacement");
            final Element nbJourAvantEcheance   =   document.createElement("nbJourAvantEcheance");
            final Element sousContrat           =   document.createElement("sousContrat");
            final Element horsContrat           =   document.createElement("horsContrat");
            final Element unMateriel            =   document.createElement("materiel");
            
            lesMateriels.appendChild(horsContrat);
            horsContrat.appendChild(unMateriel);
            
            unMateriel.setAttribute("numSerie", String.valueOf(unMaterielExpire.getNumSerie()));
   
            
            type.setAttribute("refInterne", String.valueOf(unMaterielExpire.getNumSerie()));
            type.setAttribute("libelle", unMaterielExpire.getNom());
            
            unMateriel.appendChild(type);
            System.out.println(unMaterielExpire.getLeType().getLaFamille().getCodeFamille());
            //famille.setAttribute("codeFamille", unMaterielExpire.getLeType().getCode());
            //famille.setAttribute("libelle", String.valueOf(unMaterielExpire.getLeType().getLibelleTypeMateriel()));
            unMateriel.appendChild(famille);

            date_vente.appendChild(document.createTextNode(String.valueOf(unMaterielExpire.getDateVente()))); 
            unMateriel.appendChild(date_vente);

            date_installation.appendChild(document.createTextNode(String.valueOf(unMaterielExpire.getDateInstallation())));
            unMateriel.appendChild(date_installation);
          
            prix_vente.appendChild(document.createTextNode(String.valueOf(unMaterielExpire.getPrixVente())));
            unMateriel.appendChild(prix_vente);
         
            emplacement.appendChild(document.createTextNode(unMaterielExpire.getEmplacement()));
            unMateriel.appendChild(emplacement);

            nbJourAvantEcheance.appendChild(document.createTextNode(String.valueOf(unMaterielExpire.getNbrJourAvantEcheance())));
            unMateriel.appendChild(nbJourAvantEcheance);
            
        }
        
        for (Materiel unMaterielSousContrat : lesMaterielsSousContrat){
            
            final Element type                  =   document.createElement("type");
            final Element famille               =   document.createElement("famille");
            final Element date_vente            =   document.createElement("date_vente");
            final Element date_installation     =   document.createElement("date_installation");
            final Element prix_vente            =   document.createElement("prix_vente");
            final Element emplacement           =   document.createElement("emplacement");
            final Element nbJourAvantEcheance   =   document.createElement("nbJourAvantEcheance");
            final Element sousContrat           =   document.createElement("sousContrat");
            final Element horsContrat           =   document.createElement("horsContrat");
            final Element unMateriel            =   document.createElement("materiel");
            
            sousContrat.appendChild(unMateriel);
            
            unMateriel.setAttribute("numSerie", String.valueOf(unMaterielSousContrat.getNumSerie()));
   
            
            type.setAttribute("refInterne", String.valueOf(unMaterielSousContrat.getNumSerie()));
            type.setAttribute("libelle", unMaterielSousContrat.getNom());
            
            unMateriel.appendChild(type);
            
            //famille.setAttribute("codeFamille", String.valueOf(materielExpirés.getLeType().getCode()));
            //famille.setAttribute("libelle", String.valueOf(materielExpirés.getLeType().getLibelleTypeMateriel()));
            //unMateriel.appendChild(famille);

            date_vente.appendChild(document.createTextNode(String.valueOf(unMaterielSousContrat.getDateVente())));
            unMateriel.appendChild(date_vente);

            date_installation.appendChild(document.createTextNode(String.valueOf(unMaterielSousContrat.getDateInstallation())));
            unMateriel.appendChild(date_installation);
          
            prix_vente.appendChild(document.createTextNode(String.valueOf(unMaterielSousContrat.getPrixVente())));
            unMateriel.appendChild(prix_vente);
         
            emplacement.appendChild(document.createTextNode(unMaterielSousContrat.getEmplacement()));
            unMateriel.appendChild(emplacement);

            nbJourAvantEcheance.appendChild(document.createTextNode(String.valueOf(unMaterielSousContrat.getNbrJourAvantEcheance())));
            unMateriel.appendChild(nbJourAvantEcheance);
            
        }
        
    
            //AFFICHAGE
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            
            //PROLOGUE
            transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

            //INDENTATION 
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            
            // Sortie sur un ficher xml
            StreamResult result = new StreamResult(new File("C:\\Users\\Raphael\\Desktop\\PPE-Heavy-Client-master\\PPE-Heavy-Client-master\\Myproject\\generated\\xml\\Materielclientcli"+ client.getNumClient() +".xml"));
	   
            //Sortie sur la console
            //StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);
                
            System.out.println("File Saved");
            
        } catch (final ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
      
        
    }
    
    

}
