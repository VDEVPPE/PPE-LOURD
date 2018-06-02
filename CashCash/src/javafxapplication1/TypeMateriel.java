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
    int  idTypeMat;
    String  libelleTypeMateriel;
    Famille laFamille;
    
    public TypeMateriel(){
        
    }
    
    public int getReferenceInterne(){
        return idTypeMat;
    }

    public void setIdTypeMat(int idTypeMat){
        this.idTypeMat = idTypeMat;
    }
    
    public String getLibelleTypeMateriel(){
        return libelleTypeMateriel;
    }
    
    public void setLibelleTypeMateriel(String libelleTypeMateriel){
        this.libelleTypeMateriel = libelleTypeMateriel;
    }
    
    public Famille getLaFamille(){
        return laFamille;
    }
    
    public void setLaFamille(Famille laFamille){
        this.laFamille = laFamille;
    }
}
