/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

/**
 *
 * @author vincentf
 */
public class TypeMateriel {
    String  referenceInterne;
    String  libelleTypeMateriel;
    Famille laFamille;
    
    public TypeMateriel(String reference, String libelle, Famille uneFamille){
        this.referenceInterne    = reference;
        this.libelleTypeMateriel = libelle;
        this.laFamille           = uneFamille;
    }
    
    public String getReferenceInterne(){
        return referenceInterne;
    }
    
    public String getLibelleTypeMateriel(){
        return libelleTypeMateriel;
    }
    
    public Famille getLaFamille(){
        return laFamille;
    }
}
