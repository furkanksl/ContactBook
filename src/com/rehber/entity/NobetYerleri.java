package com.rehber.entity;

import javafx.scene.image.Image;

public class NobetYerleri {

    private String nesnenin_Turu;
    private String isim;
    private String adres_Bilgileri;
    private String tel_NO;
    private String imageName;

    public NobetYerleri() {
    }

    public NobetYerleri(String nesnenin_Turu, String isim, String adres_Bilgileri, String tel_NO, String imageName) {
        this.nesnenin_Turu = nesnenin_Turu;
        this.isim = isim;
        this.adres_Bilgileri = adres_Bilgileri;
        this.tel_NO = tel_NO;
        this.imageName=imageName;
    }

    public String getNesnenin_Turu() {
        return nesnenin_Turu;
    }

    public void setNesnenin_Turu(String nesnenin_Turu) {
        this.nesnenin_Turu = nesnenin_Turu;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getAdres_Bilgileri() {
        return adres_Bilgileri;
    }

    public void setAdres_Bilgileri(String adres_Bilgileri) {
        this.adres_Bilgileri = adres_Bilgileri;
    }

    public String getTel_NO() {
        return tel_NO;
    }

    public void setTel_NO(String tel_NO) {
        this.tel_NO = tel_NO;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    

}
