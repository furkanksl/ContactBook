package com.rehber.entity;

import javafx.scene.image.Image;

public class EklenecekVarlik {

    private String eklenecek_TamIsim;
    private String nesnenin_Turu;
    private String telNo;
    private String adresBilgisi;
    private String yas;
    private String imageName;


    public EklenecekVarlik(String eklenecek_TamIsim, String nesnenin_Turu, String telNo, String adresBilgisi, String yas,String imageName) {
        this.eklenecek_TamIsim = eklenecek_TamIsim;
        this.nesnenin_Turu = nesnenin_Turu;
        this.telNo = telNo;
        this.adresBilgisi = adresBilgisi;
        this.yas = yas;
        this.imageName=imageName;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getEklenecek_TamIsim() {
        return eklenecek_TamIsim;
    }

    public void setEklenecek_TamIsim(String eklenecek_TamIsim) {
        this.eklenecek_TamIsim = eklenecek_TamIsim;
    }

    public void setAdresBilgisi(String adresBilgisi) {
        this.adresBilgisi = adresBilgisi;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

 
    public String getAdresBilgisi() {
        return adresBilgisi;
    }

    
    public String getNesnenin_Turu() {
        return nesnenin_Turu;
    }

    public void setNesnenin_Turu(String nesnenin_Turu) {
        this.nesnenin_Turu = nesnenin_Turu;
    }

    @Override
    public String toString() {
        return eklenecek_TamIsim;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    

}
