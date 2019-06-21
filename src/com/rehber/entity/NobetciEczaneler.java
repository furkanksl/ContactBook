package com.rehber.entity;

public class NobetciEczaneler extends NobetYerleri {

    private String eczane_NobetGunu;

    public NobetciEczaneler(String eczane_NobetGunu) {
        this.eczane_NobetGunu = eczane_NobetGunu;
    }

    public NobetciEczaneler(String isim, String eczane_NobetGunu, String nesnenin_Turu, String adres_Bilgileri, String tel_NO, String imageName) {
        super(nesnenin_Turu, isim, adres_Bilgileri, tel_NO,  imageName);
        this.eczane_NobetGunu = eczane_NobetGunu;
    }

    public String getEczane_NobetGunu() {
        return eczane_NobetGunu;
    }

    public void setEczane_NobetGunu(String eczane_NobetGunu) {
        this.eczane_NobetGunu = eczane_NobetGunu;
    }

    @Override
    public String toString() {
        return super.getIsim();
    }

    public String toStringEczane() {
        return "Eczanenin Adı : " + getIsim() + "\nNöbet Günü : " + getEczane_NobetGunu() + "\nTel : " + getTel_NO()
                + "\nAdres : " + getAdres_Bilgileri();
    }

}
