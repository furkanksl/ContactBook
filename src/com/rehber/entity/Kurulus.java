package com.rehber.entity;

import javafx.scene.image.Image;

public class Kurulus extends EklenecekVarlik {

    private String kurulus_Sektoru;

    public Kurulus(String eklenecek_TamIsim, String yas, String kurulus_Sektoru, String adresBilgisi, String telNo,String imageName) {
        super(eklenecek_TamIsim, "kurulus", telNo, adresBilgisi, yas,imageName);
        this.kurulus_Sektoru = kurulus_Sektoru;
    }

    public String getKurulus_Sektoru() {
        return kurulus_Sektoru;
    }

    public void setKurulus_Sektoru(String kurulus_Sektoru) {
        this.kurulus_Sektoru = kurulus_Sektoru;
    }

    @Override
    public String toString() {
        return super.getEklenecek_TamIsim();
    }

    public String toStringKurulus() {
        return "" + "İSİM : " + this.getEklenecek_TamIsim() + "\nKuruluş Tarihi:" + this.getYas() + "\nKuruluş Sektörü :" + kurulus_Sektoru
                + "\nTEL : " + this.getTelNo() + "\nADRES : "
                + this.getAdresBilgisi();
    }
}
