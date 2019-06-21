package com.rehber.controller;

import com.rehber.entity.Agac;
import com.rehber.entity.Cicek;
import com.rehber.entity.Hayvan;
import com.rehber.entity.Insan;
import com.rehber.entity.Kurulus;
import com.rehber.entity.NobetciEczaneler;
import com.rehber.entity.TaxiDuragi;
import com.rehber.fileOperations.FileOperations;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class NewController extends FotoEkle implements interfacecontroller {

    AddObject add = new AddObject();

    @FXML
    private TextField textFieldAktifTaksiSayisi;

    @FXML
    private TextField textFieldDurakAdi;

    @FXML
    private TextArea tFABTaksiDuragi;

    @FXML
    private TextField tFTelNoTaksiDuragi;
    ////----eczane

    @FXML
    private TextField textFieldEczaneninAdi;

    @FXML
    private Button btnFotografEkleEczane;

    @FXML
    private TextField tfEczaneTel;

    @FXML
    private TextField tfEcaneNobetGunu;

    @FXML
    private TextField tfEczaneAdres;

    ////-----agac
    @FXML
    private AnchorPane agacanchor;

    @FXML
    private TextField textfieldAgacinBoyu;

    @FXML
    private TextField textfieldAgacAdi;

    @FXML
    private TextField textfieldAgacinYas;
    @FXML
    private TextField tfAgacVeimlilik;

    @FXML
    private TextField textfieldAgacinSaglikDurumu;

    @FXML
    private TextArea tFagacinAdresi;
    ////-----cicek
    @FXML
    private AnchorPane Cicekanchor;
    @FXML
    private TextField textFieldCicekYasi;

    @FXML
    private TextField textFieldCicekRenki;

    @FXML
    private TextField textFieldCicekIsmi;

    @FXML
    private TextField textFieldCicekBoyu;

    @FXML
    private TextField tfCiceckTuru;

    @FXML
    private TextField tFCiceginAdresi;

    ////-----hayvan
    @FXML
    private AnchorPane Hayvananchor;
    @FXML
    private TextField tfEvcil;
    @FXML
    private TextField tfHayvanTel;

    @FXML
    private TextField textFieldHayvanYas;

    @FXML

    private TextField textFieldHayvanIsim;

    @FXML
    private TextField tfHayvanAdresBilgisi;

    ////----kurulus
    @FXML
    private AnchorPane kurulusAnchor;

    @FXML
    private TextField tFInsaTarihi;

    @FXML
    private TextField tFKurulusunIsmi;

    @FXML
    private Button krulusFotografEkle;

    @FXML
    private TextField tFKurulusSektoru;

    @FXML
    private TextField tFTelNoKurulus;

    @FXML
    private TextArea tFKurulusunAdresi;

/// -----insan
    @FXML
    private AnchorPane anchorInsan;

    @FXML
    private Button btnIptal;

    @FXML
    private TextField textFieldYas;

    @FXML
    private TextField textFieldMeslek;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldTelefon;

    @FXML
    private TextField textFieldAdres;

    @FXML
    private TextField textFieldİsimSoyİsim;

    @FXML
    private TextField textFieldUyruk;

    @FXML
    private ImageView myImageView;
    private String fotografismi;

    @FXML

    public void onClik_image_save(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose an Image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"));

        File selectedFile = fileChooser.showOpenDialog(stage);

        Image tmp = new Image(selectedFile.toURI().toString());
        myImageView.setImage(tmp);
        BufferedImage BI = ImageIO.read(selectedFile);

        fotografismi = selectedFile.getName();
        ImageIO.write(BI, "jpg", new File("uploadphotos/" + selectedFile.getName()));

    }

    // String filename=new SimpleDateFormat("File-ddMMyy-hhmmss.SSS.png");
    public void addHuman() throws IOException {

        String eklenecek_TamIsim = textFieldİsimSoyİsim.getText();
        //  Image eklenecek_Foto = ImageUpload.getInstance().getImage();
        String foto_isimi = fotografismi;
        String nesnenin_Turu = "insan";
        String telNo = textFieldTelefon.getText();
        String adresBilgisi = textFieldAdres.getText();
        String yas = textFieldYas.getText();
        String uyruk = textFieldUyruk.getText();
        String insan_Meslegi = textFieldMeslek.getText();
        String e_mail = textFieldEmail.getText();
        if (eklenecek_TamIsim.isEmpty() || telNo.isEmpty() || adresBilgisi.isEmpty() || yas.isEmpty() || uyruk.isEmpty() || insan_Meslegi.isEmpty() || e_mail.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Boş alanları doldurunuz!");
        } else if (!isNumber(telNo)) {
            JOptionPane.showMessageDialog(null, "Tel No rakamlardan oluşmalı!");
        } else if (!isNumber(yas)) {
            JOptionPane.showMessageDialog(null, "Yas rakamlardan oluşmalı!");
        } else {
            Insan insanEklenen = new Insan(eklenecek_TamIsim, yas, uyruk, insan_Meslegi, e_mail, adresBilgisi, telNo, foto_isimi);
            add.Add(insanEklenen);
//FileOperations.getInstance().personAdd(insanEklenen);
            System.out.println("Succes");
            close();
        }
    }

    public void addAnimal() throws IOException {
        String eklenecek_TamIsim = textFieldHayvanIsim.getText();
        String foto_isimi = fotografismi;
        String telNo = tfHayvanTel.getText();
        String adresBilgisi = tfHayvanAdresBilgisi.getText();
        String yas = textFieldHayvanYas.getText();
        String evcil = tfEvcil.getText();
        if (eklenecek_TamIsim.isEmpty() || telNo.isEmpty() || adresBilgisi.isEmpty() || yas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Boş alanları doldurunuz!");
        } else if (!isNumber(telNo)) {
            JOptionPane.showMessageDialog(null, "Sahip Tel No rakamlardan oluşmalı!");
        } else if (!isNumber(yas)) {
            JOptionPane.showMessageDialog(null, "Yas rakamlardan oluşmalı!");
        } else {
            Hayvan hayvanEklenen = new Hayvan(eklenecek_TamIsim, yas, evcil, adresBilgisi, telNo, foto_isimi);
            //  hayvanEklenen.setEklenecek_Foto(eklenecek_Foto);
            //FileOperations.getInstance().animalAdd(hayvanEklenen);
            add.Add(hayvanEklenen);
            System.out.println("Succes");
            close();
        }
    }

    public void addCompany() throws IOException {
        String eklenecek_TamIsim = tFKurulusunIsmi.getText();
        String foto_isimi = fotografismi;
        String telNo = tFTelNoKurulus.getText();
        String adresBilgisi = tFKurulusunAdresi.getText();
        String yas = tFInsaTarihi.getText();
        String kurulus_Sektoru = tFKurulusSektoru.getText();

        if (eklenecek_TamIsim.isEmpty() || telNo.isEmpty() || adresBilgisi.isEmpty() || yas.isEmpty() || kurulus_Sektoru.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Boş alanları doldurunuz!");
        } else if (!isNumber(telNo)) {
            JOptionPane.showMessageDialog(null, "Kuruluş Tel No rakamlardan oluşmalı!");
        } else if (!isNumber(yas)) {
            JOptionPane.showMessageDialog(null, "kuruluş inşa tarihi rakamlardan oluşmalı!");
        } else {
            Kurulus kurulusEklenen = new Kurulus(eklenecek_TamIsim, yas, kurulus_Sektoru, adresBilgisi, telNo, foto_isimi);
           // FileOperations.getInstance().companyAdd(kurulusEklenen);
           add.Add(kurulusEklenen);
           System.out.println("Succes");
            close();
        }
    }

    public void addFlower() throws IOException {
        String eklenecek_TamIsim = textFieldCicekIsmi.getText();
        String nesnenin_Turu = "cicek";
        String turu = tfCiceckTuru.getText();
        String adresBilgisi = tFCiceginAdresi.getText();
        String yas = textFieldCicekYasi.getText();
        String renk = textFieldCicekRenki.getText();
        String boy = textFieldCicekBoyu.getText();
        if (eklenecek_TamIsim.isEmpty() || turu.isEmpty() || adresBilgisi.isEmpty() || yas.isEmpty() || renk.isEmpty() || boy.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Boş alanları doldurunuz!");
        } else if (!isNumber(yas)) {
            JOptionPane.showMessageDialog(null, "Cicegin yaşı alanı rakamlardan oluşmalı!");
        } else if (!isNumber(boy)) {
            JOptionPane.showMessageDialog(null, "Cicegin boyu alanı rakamlardan oluşmalı!");
        } else {
            Cicek cicekEklenen = new Cicek(eklenecek_TamIsim, yas, boy, renk, turu, nesnenin_Turu, adresBilgisi, fotografismi);
         //   FileOperations.getInstance().flowerAdd(cicekEklenen);
         add.Add(cicekEklenen);
         System.out.println("Succes");
            close();
        }
    }

    public void addTree() throws IOException {
        String eklenecek_TamIsim = textfieldAgacAdi.getText();
        String foto_isimi = fotografismi;
        String nesnenin_Turu = "agac";
        String boyu = textfieldAgacinBoyu.getText();
        String adresBilgisi = tFagacinAdresi.getText();
        String yas = textfieldAgacinYas.getText();
        String durumu = textfieldAgacinSaglikDurumu.getText();
        String verimli = tfAgacVeimlilik.getText();
        if (eklenecek_TamIsim.isEmpty() || boyu.isEmpty() || adresBilgisi.isEmpty() || yas.isEmpty() || durumu.isEmpty() || verimli.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Boş alanları doldurunuz!");
        } else if (!isNumber(yas)) {
            JOptionPane.showMessageDialog(null, "Agacın yaşı alanı rakamlardan oluşmalı!");
        } else if (!isNumber(boyu)) {
            JOptionPane.showMessageDialog(null, "Agacın boyu alanı rakamlardan oluşmalı!");
        } else {
            Agac agacEklenen = new Agac(durumu, verimli, eklenecek_TamIsim, yas, boyu, nesnenin_Turu, adresBilgisi, foto_isimi);
            //FileOperations.getInstance().treeAdd(agacEklenen);
            add.Add(agacEklenen);
            System.out.println("Succes");
            close();
        }
    }

    public void addPharmacy() throws IOException {
        String eklenecek_TamIsim = textFieldEczaneninAdi.getText();
        String foto_isimi = fotografismi;
        String nesnenin_Turu = "eczane";
        String nobet_Gunu = tfEcaneNobetGunu.getText();
        String adresBilgisi = tfEczaneAdres.getText();
        String Tel = tfEczaneTel.getText();
        if (eklenecek_TamIsim.isEmpty() || nobet_Gunu.isEmpty() || adresBilgisi.isEmpty() || Tel.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Boş alanları doldurunuz!");
        } else if (!isNumber(Tel)) {
            JOptionPane.showMessageDialog(null, "Eczanenin Tel No rakamlardan oluşmalı!");
        } else {
            NobetciEczaneler eczaneEkle = new NobetciEczaneler(eklenecek_TamIsim, nobet_Gunu, nesnenin_Turu, adresBilgisi, Tel, foto_isimi);
          //  FileOperations.getInstance().pharmacyAdd(eczaneEkle);
          add.Add(eczaneEkle);
            System.out.println("Succes");
            close();
        }
    }

    public void addTaxi() throws IOException {
        String eklenecek_TamIsim = textFieldDurakAdi.getText();
        String foto_isimi = fotografismi;
        String nesnenin_Turu = "taxi";
        String aktif_taxi_sayisi = textFieldAktifTaksiSayisi.getText();
        String adresBilgisi = tFABTaksiDuragi.getText();
        String Tel = tFTelNoTaksiDuragi.getText();
        if (eklenecek_TamIsim.isEmpty() || aktif_taxi_sayisi.isEmpty() || adresBilgisi.isEmpty() || Tel.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Boş alanları doldurunuz!");
        } else if (!isNumber(Tel)) {
            JOptionPane.showMessageDialog(null, "Taxi duragi Tel No rakamlardan oluşmalı!");
        } else if (!isNumber(aktif_taxi_sayisi)) {
            JOptionPane.showMessageDialog(null, "Aktif taxi sayısının alanı rakamlardan oluşmalı!");
        } else {
            TaxiDuragi taxiEklenen = new TaxiDuragi(eklenecek_TamIsim, aktif_taxi_sayisi, nesnenin_Turu, adresBilgisi, Tel, foto_isimi);
            //FileOperations.getInstance().taxiAdd(taxiEklenen);
            add.Add(taxiEklenen);
            System.out.println("Succes");
            close();
        }
    }

    @FXML
    @Override
    public void close() {
        Stage stage;
        stage = (Stage) btnIptal.getScene().getWindow();
        stage.close();
    }

    //Bu metot şu işlem icin : gelen string degişkeni kontrol ediyor eger rakamdan oluşmuşsa true donderir degilse False
    public boolean isNumber(String tmp) {

        try {
            Long.parseLong(tmp);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
