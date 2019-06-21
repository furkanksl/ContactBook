package com.rehber.entity;

import javafx.scene.image.Image;

public class Insan extends EklenecekVarlik {

    private String uyruk;
    private String insan_Meslegi;
    private String e_mail;

    public Insan(String eklenecek_TamIsim, String yas, String uyruk, String insan_Meslegi, String e_mail, String adresBilgisi, String telNo, String foto) {
        super(eklenecek_TamIsim, "Insan", telNo, adresBilgisi, yas, foto);
        this.uyruk = uyruk;
        this.insan_Meslegi = insan_Meslegi;
        this.e_mail = e_mail;

    }

    public String getUyruk() {
        return uyruk;
    }

    public void setUyruk(String uyruk) {
        this.uyruk = uyruk;
    }

    public String getInsan_Meslegi() {
        return insan_Meslegi;
    }

    public void setInsan_Meslegi(String insan_Meslegi) {
        this.insan_Meslegi = insan_Meslegi;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    @Override
    public String toString() {
        return super.getEklenecek_TamIsim();
    }

    public String toStringInsan() {
        return "" + "İSİM : " + this.getEklenecek_TamIsim() + "\nYAŞ :" + this.getYas() + "\nUYRUK :" + uyruk
                + "\nMESLEK :" + insan_Meslegi + "\nE MAIL : " + e_mail + "\nTEL : " + this.getTelNo() + "\nADRES : "
                + this.getAdresBilgisi();
    }

}
