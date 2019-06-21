
package com.rehber.entity;

import javafx.scene.image.Image;


public  class Hayvan extends EklenecekVarlik 
{
    
    private String hayvan_EvcilDurumu = "evcil";

    public Hayvan( String eklenecek_TamIsim,String yas,String hayvan_EvcilDurumu, String adresBilgisi,String telNo ,String imageName) {
        super(eklenecek_TamIsim, "Hayvan", telNo, adresBilgisi, yas,imageName);
        this.hayvan_EvcilDurumu = hayvan_EvcilDurumu;
    }
    
   
    
    
    public String getHayvan_EvcilDurumu() {
        return hayvan_EvcilDurumu;
    }

    public void setHayvan_EvcilDurumu(String hayvan_EvcilDurumu) {
        this.hayvan_EvcilDurumu = hayvan_EvcilDurumu;
    }

    public String toStringHayvan() {
        return "\n\n" + "İSİM : " + this.getEklenecek_TamIsim() +"\nYAŞ :" + this.getYas() + 
                "\nEvcil Durumu :" + hayvan_EvcilDurumu +  "\nTEL : " + this.getTelNo() + "\nADRES : "
                + this.getAdresBilgisi();
    }

   
    
 
  
    
    
}

