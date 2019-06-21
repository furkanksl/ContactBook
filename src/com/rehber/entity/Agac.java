package com.rehber.entity;

public class Agac extends Bitki {

    private String agacin_Durumu;
    private String verimli;

    public Agac(String agacin_Durumu, String verimli) {
        this.agacin_Durumu = agacin_Durumu;
        this.verimli = verimli;
    }

    public Agac(String agacin_Durumu, String verimli, String agacin_Adi, String yas, String boyu, String nesneTuru, String bitkiAdresi,String imageName) {
        super(agacin_Adi, yas, boyu, nesneTuru, bitkiAdresi,imageName);
        this.agacin_Durumu = agacin_Durumu;
        this.verimli = verimli;
    }

    public String getAgacin_Durumu() {
        return agacin_Durumu;
    }

    public void setAgacin_Durumu(String agacin_Durumu) {
        this.agacin_Durumu = agacin_Durumu;
    }

    public String getVerimli() {
        return verimli;
    }

    public void setVerimli(String verimli) {
        this.verimli = verimli;
    }

    public String toStringAgac() {
        return "Ağacın Adı :" + getAgacin_Adi() + "\nAğacın Yaşı :" + getYas() + "\nVerimlilik Durumu :" + getVerimli()
                + "\nAğacın Boyu :" + getBoyu() + "\nAğacın Durumu :" + getAgacin_Durumu()
                + "\nAğacın Adresi :" + getBitkiAdresi();

    }
    @Override
    public String toString() {
        return super.getAgacin_Adi();
    }

}
