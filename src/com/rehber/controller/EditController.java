package com.rehber.controller;

import com.jfoenix.controls.JFXListView;
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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class EditController extends FotoEkle implements Initializable, interfacecontroller {
    ////////////////////////////edit Human

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
    private TextField tfEvcil;
    @FXML
    private TextField textFieldUyruk;
    @FXML
    private TextField tfAgacVeimlilik;
    @FXML
    private ImageView myImageView;

    @FXML
    private JFXListView<Insan> lvEditHuman;
    private String fotografismi;
    private String eskiFotograf;

    @FXML
    public void close() {
        Stage stage;
        stage = (Stage) btnIptal.getScene().getWindow();
        stage.close();
    }
    int i;

    public void setTextHuman() {
        Insan secilenVarlik = lvEditHuman.getSelectionModel().getSelectedItem();
        if (secilenVarlik != null) {
            i = lvEditHuman.getSelectionModel().getSelectedIndex();
            textFieldİsimSoyİsim.setText(secilenVarlik.getEklenecek_TamIsim());
            Image image = new Image("file:///" + System.getProperty("user.dir") + "/uploadphotos/" + secilenVarlik.getImageName());
            myImageView.setImage(image);
            this.eskiFotograf = secilenVarlik.getImageName();
            textFieldTelefon.setText(secilenVarlik.getTelNo());
            textFieldAdres.setText(secilenVarlik.getAdresBilgisi());
            textFieldYas.setText(secilenVarlik.getYas());
            textFieldUyruk.setText(secilenVarlik.getUyruk());
            textFieldEmail.setText(secilenVarlik.getE_mail());
            textFieldMeslek.setText(secilenVarlik.getInsan_Meslegi());
        }
    }

    public void addHuman() throws IOException {

        String eklenecek_TamIsim = textFieldİsimSoyİsim.getText();
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
        } else if (myImageView.getImage().equals(null)) {
            JOptionPane.showMessageDialog(null, "Lütfen bir fotoğraf seçiniz !");
        } else {
            Insan insanEklenen = new Insan(eklenecek_TamIsim, yas, uyruk, insan_Meslegi, e_mail, adresBilgisi, telNo, foto_isimi);
            FileOperations.getInstance().getPersonList().remove(i);
            FileOperations.getInstance().getPersonList().add(i, insanEklenen);

            System.out.println("Updated");
            close();
        }
    }
    ////////////////////////////edit Animal

    @FXML
    private TextField textFieldHayvanYas;

    @FXML
    private TextField textFieldHayvanIsim;

    @FXML
    private TextField tfHayvanAdresBilgisi;

    @FXML
    private TextField tfHayvanTel;

    @FXML
    private JFXListView<Hayvan> lvEditAnimal;

    public void setTextAnimal() throws IOException {
        Hayvan secilenVarlik = lvEditAnimal.getSelectionModel().getSelectedItem();
        if (secilenVarlik != null) {
            i = lvEditAnimal.getSelectionModel().getSelectedIndex();
            Image image = new Image("file:///" + System.getProperty("user.dir") + "/uploadphotos/" + secilenVarlik.getImageName());
            this.eskiFotograf = secilenVarlik.getImageName();
            myImageView.setImage(image);
            tfEvcil.setText(secilenVarlik.getHayvan_EvcilDurumu());
            textFieldHayvanIsim.setText(secilenVarlik.getEklenecek_TamIsim());
            tfHayvanTel.setText(secilenVarlik.getTelNo());
            tfHayvanAdresBilgisi.setText(secilenVarlik.getAdresBilgisi());
            textFieldHayvanYas.setText(secilenVarlik.getYas());
        }
    }

    public void addAnimal() throws IOException {
        String eklenecek_TamIsim = textFieldHayvanIsim.getText();
        String foto_isimi = fotografismi;
        String telNo = tfHayvanTel.getText();
        String adresBilgisi = tfHayvanAdresBilgisi.getText();
        String yas = textFieldHayvanYas.getText();
        if (eklenecek_TamIsim.isEmpty() || telNo.isEmpty() || adresBilgisi.isEmpty() || yas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Boş alanları doldurunuz!");
        } else if (!isNumber(telNo)) {
            JOptionPane.showMessageDialog(null, "Sahip Tel No rakamlardan oluşmalı!");
        } else if (!isNumber(yas)) {
            JOptionPane.showMessageDialog(null, "Yas rakamlardan oluşmalı!");
        } else if (myImageView.getImage().equals(null)) {
            JOptionPane.showMessageDialog(null, "Lütfen bir fotoğraf seçiniz !");
        } else {
            Hayvan hayvanEklenen = new Hayvan(eklenecek_TamIsim, yas, "evcil", adresBilgisi, telNo, foto_isimi);
            FileOperations.getInstance().getHayvanList().remove(i);
            FileOperations.getInstance().getHayvanList().add(i, hayvanEklenen);
            System.out.println("Updated");
            close();
        }
    }

    //////////// edit Company
    @FXML
    private TextField tFInsaTarihi;

    @FXML
    private TextField tFKurulusunIsmi;

    @FXML
    private TextField tFKurulusSektoru;

    @FXML
    private TextField tFTelNoKurulus;

    @FXML
    private TextArea tFKurulusunAdresi;

    @FXML
    private JFXListView<Kurulus> lvEditCompany;

    public void setTextCompany() throws IOException {
        Kurulus secilenVarlik = lvEditCompany.getSelectionModel().getSelectedItem();
        if (secilenVarlik != null) {
            i = lvEditCompany.getSelectionModel().getSelectedIndex();
            Image image = new Image("file:///" + System.getProperty("user.dir") + "/uploadphotos/" + secilenVarlik.getImageName());
            myImageView.setImage(image);
            this.eskiFotograf = secilenVarlik.getImageName();
            tFKurulusunIsmi.setText(secilenVarlik.getEklenecek_TamIsim());
            tFTelNoKurulus.setText(secilenVarlik.getTelNo());
            tFKurulusunAdresi.setText(secilenVarlik.getAdresBilgisi());
            tFInsaTarihi.setText(secilenVarlik.getYas());
            tFKurulusSektoru.setText(secilenVarlik.getKurulus_Sektoru());
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
        } else if (myImageView.getImage().equals(null)) {
            JOptionPane.showMessageDialog(null, "Lütfen bir fotoğraf seçiniz !");
        } else {

            Kurulus kurulusEklenen = new Kurulus(eklenecek_TamIsim, yas, kurulus_Sektoru, adresBilgisi, telNo, foto_isimi);
            FileOperations.getInstance().getKurulusList().remove(i);
            FileOperations.getInstance().getKurulusList().add(i, kurulusEklenen);
            System.out.println("Updated");
            close();
        }
    }
    //////////// edit Flower
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

    @FXML
    private JFXListView<Cicek> lvEditFlower;

    public void setTextFlower() throws IOException {
        Cicek secilenVarlik = lvEditFlower.getSelectionModel().getSelectedItem();
        if (secilenVarlik != null) {
            i = lvEditFlower.getSelectionModel().getSelectedIndex();
            Image image = new Image("file:///" + System.getProperty("user.dir") + "/uploadphotos/" + secilenVarlik.getImageName());
            myImageView.setImage(image);
            this.eskiFotograf = secilenVarlik.getImageName();
            textFieldCicekIsmi.setText(secilenVarlik.getAgacin_Adi());
            tfCiceckTuru.setText(secilenVarlik.getTuru());
            tFCiceginAdresi.setText(secilenVarlik.getBitkiAdresi());
            textFieldCicekYasi.setText(secilenVarlik.getYas());
            textFieldCicekRenki.setText(secilenVarlik.getRenk());
            textFieldCicekBoyu.setText(secilenVarlik.getBoyu());
        }
    }

    public void addFlower() throws IOException {
        String eklenecek_TamIsim = textFieldCicekIsmi.getText();
        String foto_isimi = fotografismi;
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
        } else if (myImageView.getImage().equals(null)) {
            JOptionPane.showMessageDialog(null, "Lütfen bir fotoğraf seçiniz !");
        } else {
            Cicek cicekEklenen = new Cicek(eklenecek_TamIsim, yas, boy, renk, turu, nesnenin_Turu, adresBilgisi, foto_isimi);
            FileOperations.getInstance().getCicekList().remove(i);
            FileOperations.getInstance().getCicekList().add(i, cicekEklenen);
            System.out.println("Succes");
            close();
        }
    }
    //////// edit Pharmacy
    @FXML
    private TextField textFieldEczaneninAdi;

    @FXML
    private TextField tfEczaneTel;

    @FXML
    private TextField tfEcaneNobetGunu;

    @FXML
    private TextField tfEczaneAdres;

    @FXML
    private JFXListView<NobetciEczaneler> lvEditPharmacy;

    public void setTextPharmacy() throws IOException {

        NobetciEczaneler secilenVarlik = lvEditPharmacy.getSelectionModel().getSelectedItem();
        if (secilenVarlik != null) {
            i = lvEditPharmacy.getSelectionModel().getSelectedIndex();
            Image image = new Image("file:///" + System.getProperty("user.dir") + "/uploadphotos/" + secilenVarlik.getImageName());
            this.eskiFotograf = secilenVarlik.getImageName();
            myImageView.setImage(image);
            textFieldEczaneninAdi.setText(secilenVarlik.getIsim());
            tfEcaneNobetGunu.setText(secilenVarlik.getEczane_NobetGunu());
            tfEczaneAdres.setText(secilenVarlik.getAdres_Bilgileri());
            tfEczaneTel.setText(secilenVarlik.getTel_NO());
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
        } else if (myImageView.getImage().equals(null)) {
            JOptionPane.showMessageDialog(null, "Lütfen bir fotoğraf seçiniz !");
        } else {
            NobetciEczaneler eczaneEklenen = new NobetciEczaneler(eklenecek_TamIsim, nobet_Gunu, nesnenin_Turu, adresBilgisi, Tel, foto_isimi);
            FileOperations.getInstance().getEczaneList().remove(i);
            FileOperations.getInstance().getEczaneList().add(i, eczaneEklenen);
            System.out.println("Succes");
            close();
        }
    }

    /////// edit Taxi
    @FXML
    private TextField textFieldAktifTaksiSayisi;

    @FXML
    private TextField textFieldDurakAdi;

    @FXML
    private TextArea tFABTaksiDuragi;

    @FXML
    private TextField tFTelNoTaksiDuragi;

    @FXML
    private JFXListView<TaxiDuragi> lvEditTaxi;

    public void setTextTaxi() throws IOException {
        Image image = null;
        TaxiDuragi secilenVarlik = lvEditTaxi.getSelectionModel().getSelectedItem();
        if (secilenVarlik != null) {
            i = lvEditTaxi.getSelectionModel().getSelectedIndex();
            if (secilenVarlik.getImageName() != null) {

                image = new Image("file:///" + System.getProperty("user.dir") + "/uploadphotos/" + secilenVarlik.getImageName());

                myImageView.setImage(image);
            }
            textFieldDurakAdi.setText(secilenVarlik.getIsim());
            textFieldAktifTaksiSayisi.setText(secilenVarlik.getAktif_Taksi_Sayisi());
            this.eskiFotograf = secilenVarlik.getImageName();
            tFABTaksiDuragi.setText(secilenVarlik.getAdres_Bilgileri());
            tFTelNoTaksiDuragi.setText(secilenVarlik.getTel_NO());

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
        } else if (myImageView.getImage().equals(null)) {
            JOptionPane.showMessageDialog(null, "Lütfen bir fotoğraf seçiniz !");
        } else {
            TaxiDuragi taxiEklenen = new TaxiDuragi(eklenecek_TamIsim, aktif_taxi_sayisi, nesnenin_Turu, adresBilgisi, Tel, foto_isimi);
            FileOperations.getInstance().getTaxiList().remove(i);
            FileOperations.getInstance().getTaxiList().add(i, taxiEklenen);
            System.out.println("Succes");
            close();
        }
    }

    //////edit  Tree
    @FXML
    private TextField textfieldAgacinBoyu;

    @FXML
    private TextField textfieldAgacAdi;

    @FXML
    private TextField textfieldAgacinYas;

    @FXML
    private TextField textfieldAgacinSaglikDurumu;

    @FXML
    private TextArea tFagacinAdresi;

    @FXML
    private JFXListView<Agac> lvEditTree;

    public void setTextTree() throws IOException {
        Agac secilenVarlik = lvEditTree.getSelectionModel().getSelectedItem();
        if (secilenVarlik != null) {
            i = lvEditTree.getSelectionModel().getSelectedIndex();
            Image image = new Image("file:///" + System.getProperty("user.dir") + "/uploadphotos/" + secilenVarlik.getImageName());
            myImageView.setImage(image);
            tfAgacVeimlilik.setText(secilenVarlik.getVerimli());
            this.eskiFotograf = secilenVarlik.getImageName();
            textfieldAgacAdi.setText(secilenVarlik.getAgacin_Adi());
            textfieldAgacinBoyu.setText(secilenVarlik.getBoyu());
            tFagacinAdresi.setText(secilenVarlik.getBitkiAdresi());
            textfieldAgacinYas.setText(secilenVarlik.getYas());
            textfieldAgacinSaglikDurumu.setText(secilenVarlik.getAgacin_Durumu());
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
        } else if (myImageView.getImage().equals(null)) {
            JOptionPane.showMessageDialog(null, "Lütfen bir fotoğraf seçiniz !");
        } else {
            Agac agacEklenen = new Agac(durumu, verimli, eklenecek_TamIsim, yas, boyu, nesnenin_Turu, adresBilgisi, foto_isimi);
            FileOperations.getInstance().getAgacList().remove(i);
            FileOperations.getInstance().getAgacList().add(i, agacEklenen);
            System.out.println("Succes");
            close();
        }
    }

    public void fotografSil(String secilen_Fotograf) {
        File file = new File(System.getProperty("user.dir") + "\\uploadphotos\\" + secilen_Fotograf);
        boolean result;
        try {
            result = file.delete();
            if (result) {
                System.out.println("Successfully deleted: " + file.getCanonicalPath());
            } else {
                System.out.println("Failed deleting " + file.getCanonicalPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            lvEditHuman.getItems().setAll(FileOperations.getInstance().getPersonList());
            lvEditHuman.getSelectionModel().selectFirst();
        } catch (Exception e) {
        }
        try {
            lvEditAnimal.getItems().setAll(FileOperations.getInstance().getHayvanList());
            lvEditAnimal.getSelectionModel().selectFirst();
        } catch (Exception e) {
        }
        try {
            lvEditCompany.getItems().setAll(FileOperations.getInstance().getKurulusList());
            lvEditCompany.getSelectionModel().selectFirst();
        } catch (Exception e) {
        }
        try {
            lvEditPharmacy.getItems().setAll(FileOperations.getInstance().getEczaneList());
            lvEditPharmacy.getSelectionModel().selectFirst();
        } catch (Exception e) {
        }
        try {
            lvEditTaxi.getItems().setAll(FileOperations.getInstance().getTaxiList());
            lvEditTaxi.getSelectionModel().selectFirst();
        } catch (Exception e) {
        }
        try {
            lvEditTree.getItems().setAll(FileOperations.getInstance().getAgacList());
            lvEditTree.getSelectionModel().selectFirst();
        } catch (Exception e) {
        }
        try {
            lvEditFlower.getItems().setAll(FileOperations.getInstance().getCicekList());
            lvEditFlower.getSelectionModel().selectFirst();
        } catch (Exception e) {
        }
    }

    @Override
    public boolean isNumber(String tmp) {
        try {
            Long.parseLong(tmp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
