package com.rehber.entity;

public class Cicek extends Bitki {

    private String turu;
    private String renk;

    public Cicek() {

    }

    public Cicek(String turu, String renk) {
        this.turu = turu;
        this.renk = renk;
    }

    public Cicek(String agacin_Adi, String yas, String boyu, String renk, String turu, String nesneTuru, String bitkiAdresi,String imageName) {
        super(agacin_Adi, yas, boyu, nesneTuru, bitkiAdresi,imageName);
        this.turu = turu;
        this.renk = renk;
    }

    public String getTuru() {
        return turu;
    }

    public void setTuru(String turu) {
        this.turu = turu;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    @Override
    public String toString() {
        return super.getAgacin_Adi();
    }

    public String toStringCicek() {
        return "Çiçeğin Adı :" + getAgacin_Adi() + "\nÇiçeğin Yaşı :" + getYas() + "\nRenk :" + getRenk()
                + "\nÇiçeğin Boyu :" + getBoyu() + "\nÇiçeğin Türü :" + getTuru()
                + "\nÇiçeğinAdresi :" + getBitkiAdresi();
    }

}
