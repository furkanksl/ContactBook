package com.rehber.entity;

public class TaxiDuragi extends NobetYerleri {

    private String aktif_Taksi_Sayisi;

    public TaxiDuragi(String aktif_Taksi_Sayisi) {
        this.aktif_Taksi_Sayisi = aktif_Taksi_Sayisi;
    }

    public TaxiDuragi(String isim, String aktif_Taksi_Sayisi, String nesnenin_Turu, String adres_Bilgileri, String tel_NO, String imageName) {
        super(nesnenin_Turu, isim, adres_Bilgileri, tel_NO, imageName);
        this.aktif_Taksi_Sayisi = aktif_Taksi_Sayisi;
    }

    public String getAktif_Taksi_Sayisi() {
        return aktif_Taksi_Sayisi;
    }

    public void setAktif_Taksi_Sayisi(String aktif_Taksi_Sayisi) {
        this.aktif_Taksi_Sayisi = aktif_Taksi_Sayisi;
    }

    @Override
    public String toString() {
        return super.getIsim();
    }

    public String toStringTaxi() {
        return "Durak Adı : " + getIsim() + "\nAktif Taxi Sayısı : " + getAktif_Taksi_Sayisi() + "\nTel : " + getTel_NO()
                + "\nAdres : " + getAdres_Bilgileri();
    }
}
