package com.rehber.entity;

import javafx.scene.image.Image;

public class Bitki {

    private String agacin_Adi;
    private String yas;
    private String boyu;
    private String nesneTuru;
    private String bitkiAdresi;
    private String imageName;

    public Bitki() {
    }

    public Bitki(String agacin_Adi, String yas, String boyu, String nesneTuru, String bitkiAdresi,String imageName) {
        this.agacin_Adi = agacin_Adi;
        this.yas = yas;
        this.boyu = boyu;
        this.nesneTuru = nesneTuru;
        this.bitkiAdresi = bitkiAdresi;
        this.imageName=imageName;
    }

    public String getAgacin_Adi() {
        return agacin_Adi;
    }

    public void setAgacin_Adi(String agacin_Adi) {
        this.agacin_Adi = agacin_Adi;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public String getBoyu() {
        return boyu;
    }

    public void setBoyu(String boyu) {
        this.boyu = boyu;
    }

    public String getNesneTuru() {
        return nesneTuru;
    }

    public void setNesneTuru(String nesneTuru) {
        this.nesneTuru = nesneTuru;
    }

    public String getBitkiAdresi() {
        return bitkiAdresi;
    }

    public void setBitkiAdresi(String bitkiAdresi) {
        this.bitkiAdresi = bitkiAdresi;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    
}
