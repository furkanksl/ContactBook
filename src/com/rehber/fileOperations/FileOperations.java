package com.rehber.fileOperations;

import com.rehber.entity.Agac;
import com.rehber.entity.Cicek;
import com.rehber.entity.Hayvan;
import com.rehber.entity.Insan;
import com.rehber.entity.Kurulus;
import com.rehber.entity.NobetciEczaneler;
import com.rehber.entity.TaxiDuragi;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FileOperations {

    private static FileOperations instance = new FileOperations();

    //Dosyalarin yolları 
    private static String fileNameInsan = "insan.txt";
    private static String fileNameHayvan = "hayvan.txt";
    private static String fileNameKurulus = "kurulus.txt";
    private static String fileNameCicek = "cicek.txt";
    private static String fileNameAgac = "agac.txt";
    private static String fileNameEczane = "eczane.txt";
    private static String fileNameTaxi = "taxi.txt";
    private static String fileNameRecentCalls = "calls.txt";

    File fileInsan;
    File fileHayvan;
    File fileKurulus;
    File fileCicek;
    File fileAgac;
    File fileEczane;
    File fileTaxi;

    // Butun nesnelerin ObservableListleri  
    private ObservableList<Insan> PersonList;
    private ObservableList<Hayvan> hayvanList;
    private ObservableList<Kurulus> kurulusList;
    private ObservableList<Agac> agacList;
    private ObservableList<Cicek> cicekList;
    private ObservableList<NobetciEczaneler> eczaneList;
    private ObservableList<TaxiDuragi> taxiList;

    public FileOperations() {

    }

    public static FileOperations getInstance() {
        return instance;
    }

    //Insan Dosya işlemleri
    public void writePersonFiles() throws IOException {

        Path filePath = Paths.get(fileNameInsan);
        BufferedWriter bw = Files.newBufferedWriter(filePath);
        Iterator<Insan> iterator = PersonList.iterator();
        while (iterator.hasNext()) {
            Insan readedFiles = iterator.next();

            bw.append(readedFiles.getEklenecek_TamIsim() + "^" + readedFiles.getYas() + "+" + readedFiles.getUyruk() + "%" + readedFiles.getInsan_Meslegi()
                    + "&" + readedFiles.getE_mail() + "#" + readedFiles.getAdresBilgisi() + "/" + readedFiles.getTelNo() + "$" + readedFiles.getNesnenin_Turu()
                    + "*" + readedFiles.getImageName());
            bw.newLine();
        }
        bw.close();

    }

    public void readPersonFiles() throws IOException {
        PersonList = FXCollections.observableArrayList();
        Path filePath = Paths.get(fileNameInsan);

        BufferedReader br = Files.newBufferedReader(filePath);
        String temp;
        try {

            while ((temp = br.readLine()) != null) {
                String eklenecek_TamIsim = temp.substring(0, temp.indexOf("^"));
                String yas = temp.substring(temp.indexOf("^") + 1, temp.indexOf("+"));
                String uyruk = temp.substring(temp.indexOf("+") + 1, temp.indexOf("%"));
                String meslek = temp.substring(temp.indexOf("%") + 1, temp.indexOf("&"));
                String email = temp.substring(temp.indexOf("&") + 1, temp.indexOf("#"));

                String adresBilgisi = temp.substring(temp.indexOf("#") + 1, temp.indexOf("/"));
                String telNo = temp.substring(temp.indexOf("/") + 1, temp.indexOf("$"));
                String imagename = temp.substring(temp.indexOf("*") + 1, temp.length());
                Insan tmp = new Insan(eklenecek_TamIsim, yas, uyruk, meslek, email, adresBilgisi, telNo,imagename);
                PersonList.add(tmp);
            }
            br.close();
        } catch (Exception ex) {

        }

    }

    public void personAdd(Insan eklenecekvarlik) {
        PersonList.add(eklenecekvarlik);
    }

    public void personDelete(Insan silinecekvarlik) {
        PersonList.remove(silinecekvarlik);
    }
//*****************************************************************************************************************//

    // Hayvan Dosya işlemleri
    public void writeAnimalFiles() throws IOException {

        Path filePath = Paths.get(fileNameHayvan);
        BufferedWriter bw = Files.newBufferedWriter(filePath);
        Iterator<Hayvan> iterator = hayvanList.iterator();
        while (iterator.hasNext()) {
            Hayvan readedFiles = iterator.next();

            bw.append(readedFiles.getEklenecek_TamIsim() + "^" + readedFiles.getYas() + "+" + readedFiles.getHayvan_EvcilDurumu() + "%" + readedFiles.getNesnenin_Turu()
                    + "&" + readedFiles.getAdresBilgisi() + "/" + readedFiles.getTelNo()+"*"+readedFiles.getImageName());
            bw.newLine();
        }
        bw.close();
    }

    public void readAnimalFiles() throws IOException {

        hayvanList = FXCollections.observableArrayList();
        Path filePath = Paths.get(fileNameHayvan);

        BufferedReader br = Files.newBufferedReader(filePath);
        String temp;
        try {

            while ((temp = br.readLine()) != null) {
                String eklenecek_TamIsim = temp.substring(0, temp.indexOf("^"));
                String yas = temp.substring(temp.indexOf("^") + 1, temp.indexOf("+"));
                String hayvan_EvcilDurumu = temp.substring(temp.indexOf("+") + 1, temp.indexOf("%"));
                String nesne_Turu = temp.substring(temp.indexOf("%") + 1, temp.indexOf("&"));
                String adresBilgisi = temp.substring(temp.indexOf("&") + 1, temp.indexOf("/"));
                String telNo = temp.substring(temp.indexOf("/") + 1, temp.indexOf("*"));
                String imageName = temp.substring(temp.indexOf("*") + 1, temp.length());
                Hayvan tmp = new Hayvan(eklenecek_TamIsim, yas, hayvan_EvcilDurumu, adresBilgisi, telNo,imageName);
                hayvanList.add(tmp);
            }
            br.close();
        } catch (Exception ex) {

        }
    }

    public void animalAdd(Hayvan eklenecekvarlik) {
        hayvanList.add(eklenecekvarlik);
    }

    public void animalDelete(Hayvan silinecekvarlik) {
        hayvanList.remove(silinecekvarlik);
    }
    //****************************************************************************************************//

    //Kuruluş Dosya işlemleri
    public void writeCompanyFiles() throws IOException {

        Path filePath = Paths.get(fileNameKurulus);
        BufferedWriter bw = Files.newBufferedWriter(filePath);
        Iterator<Kurulus> iterator = kurulusList.iterator();
        while (iterator.hasNext()) {
            Kurulus readedFiles = iterator.next();

            bw.append(readedFiles.getEklenecek_TamIsim() + "^" + readedFiles.getYas() + "+" + readedFiles.getKurulus_Sektoru() + "%" + readedFiles.getNesnenin_Turu()
                    + "&" + readedFiles.getAdresBilgisi() + "/" + readedFiles.getTelNo()+"*"+readedFiles.getImageName());
            bw.newLine();
        }
        bw.close();

    }

    public void readCompanyFiles() throws IOException {

        kurulusList = FXCollections.observableArrayList();
        Path filePath = Paths.get(fileNameKurulus);

        BufferedReader br = Files.newBufferedReader(filePath);
        String temp;
        try {

            while ((temp = br.readLine()) != null) {
                String eklenecek_TamIsim = temp.substring(0, temp.indexOf("^"));
                String yas = temp.substring(temp.indexOf("^") + 1, temp.indexOf("+"));
                String kurulus_Sektoru = temp.substring(temp.indexOf("+") + 1, temp.indexOf("%"));
                String nesne_Turu = temp.substring(temp.indexOf("%") + 1, temp.indexOf("&"));
                String adresBilgisi = temp.substring(temp.indexOf("&") + 1, temp.indexOf("/"));
                String telNo = temp.substring(temp.indexOf("/") + 1, temp.indexOf("*") );
                String imageName= temp.substring(temp.indexOf("*") + 1, temp.length() );
                Kurulus tmp = new Kurulus(eklenecek_TamIsim, yas, kurulus_Sektoru, adresBilgisi, telNo,imageName);
                kurulusList.add(tmp);
            }
            br.close();
        } catch (Exception ex) {

        }

    }

    public void companyAdd(Kurulus eklenecekvarlik) {
        kurulusList.add(eklenecekvarlik);
    }

    public void companyDelete(Kurulus silinecekvarlik) {
        kurulusList.remove(silinecekvarlik);
    }

    //************************************************************************************************************//
//Ezcane Dosya işlemleri
    public void writePharmacyFiles() throws IOException {

        Path filePath = Paths.get(fileNameEczane);
        BufferedWriter bw = Files.newBufferedWriter(filePath);
        Iterator<NobetciEczaneler> iterator = eczaneList.iterator();
        while (iterator.hasNext()) {
            NobetciEczaneler readedFiles = iterator.next();

            bw.append(readedFiles.getIsim() + "^" + readedFiles.getEczane_NobetGunu() + "+" + readedFiles.getNesnenin_Turu() + "%" + readedFiles.getAdres_Bilgileri()
                    + "&" + readedFiles.getTel_NO()+"*"+readedFiles.getImageName());
            bw.newLine();
        }
        bw.close();

    }

    public void readPharmacyFiles() throws IOException {

        eczaneList = FXCollections.observableArrayList();
        Path filePath = Paths.get(fileNameEczane);

        BufferedReader br = Files.newBufferedReader(filePath);
        String temp;
        try {

            while ((temp = br.readLine()) != null) {
                String name = temp.substring(0, temp.indexOf("^"));
                String eczane_NobetGunu = temp.substring(temp.indexOf("^") + 1, temp.indexOf("+"));
                String nesnenin_Turu = temp.substring(temp.indexOf("+") + 1, temp.indexOf("%"));
                String adres_Bilgileri = temp.substring(temp.indexOf("%") + 1, temp.indexOf("&"));
                String tel_NO = temp.substring(temp.indexOf("&") + 1, temp.indexOf("*"));
                String imageName = temp.substring(temp.indexOf("*") + 1, temp.length());
                NobetciEczaneler tmp = new NobetciEczaneler(name, eczane_NobetGunu, nesnenin_Turu, adres_Bilgileri, tel_NO,imageName);
                eczaneList.add(tmp);
            }
            br.close();
        } catch (Exception ex) {

        }

    }

    public void pharmacyAdd(NobetciEczaneler eklenecekVarlik) {

        eczaneList.add(eklenecekVarlik);

    }

    public void pharmacyDelete(NobetciEczaneler silinecekvarlik) {
        eczaneList.remove(silinecekvarlik);
    }

    //************************************************************************************************//
    //  Taxi Dosya işlemleri
    public void writeTaxiFiles() throws IOException {

        Path filePath = Paths.get(fileNameTaxi);
        BufferedWriter bw = Files.newBufferedWriter(filePath);
        Iterator<TaxiDuragi> iterator = taxiList.iterator();
        while (iterator.hasNext()) {
            TaxiDuragi readedFiles = iterator.next();
            bw.append(readedFiles.getIsim() + "^" + readedFiles.getAktif_Taksi_Sayisi() + "+" + readedFiles.getNesnenin_Turu() + "%" + readedFiles.getAdres_Bilgileri()
                    + "&" + readedFiles.getTel_NO()+"*"+readedFiles.getImageName());
            bw.newLine();
        }
        bw.close();
    }

    public void readTaxiFiles() throws IOException {

        taxiList = FXCollections.observableArrayList();
        Path filePath = Paths.get(fileNameTaxi);

        BufferedReader br = Files.newBufferedReader(filePath);
        String temp;
        try {

            while ((temp = br.readLine()) != null) {
                String name = temp.substring(0, temp.indexOf("^"));
                String aktif_Taksi_Sayisi = temp.substring(temp.indexOf("^") + 1, temp.indexOf("+"));
                String nesnenin_Turu = temp.substring(temp.indexOf("+") + 1, temp.indexOf("%"));
                String adres_Bilgileri = temp.substring(temp.indexOf("%") + 1, temp.indexOf("&"));
                String tel_NO = temp.substring(temp.indexOf("&") + 1, temp.indexOf("*"));
                String imageName = temp.substring(temp.indexOf("*") + 1, temp.length());
                TaxiDuragi tmp = new TaxiDuragi(name, aktif_Taksi_Sayisi, nesnenin_Turu, adres_Bilgileri, tel_NO,imageName);
                taxiList.add(tmp);
            }
            br.close();
        } catch (Exception ex) {

        }

    }

    public void taxiAdd(TaxiDuragi eklenecekVarlik) {

        taxiList.add(eklenecekVarlik);

    }

    public void taxiDelete(TaxiDuragi silinecekvarlik) {
        taxiList.remove(silinecekvarlik);
    }

    //************************************************************************************************//
    //Agac Dosya işlemleri
    public void writeTreeFiles() throws IOException {

        Path filePath = Paths.get(fileNameAgac);
        BufferedWriter bw = Files.newBufferedWriter(filePath);
        Iterator<Agac> iterator = agacList.iterator();
        while (iterator.hasNext()) {
            Agac readedFiles = iterator.next();
            bw.append(readedFiles.getAgacin_Adi() + "^" + readedFiles.getAgacin_Durumu() + "+" + readedFiles.getVerimli() + "%" + readedFiles.getBoyu()
                    + "&" + readedFiles.getNesneTuru() + "#" + readedFiles.getYas() + "/" + readedFiles.getBitkiAdresi()+"*"+readedFiles.getImageName());
            bw.newLine();
        }
        bw.close();
    }

    public void readTreeFiles() throws IOException {

        agacList = FXCollections.observableArrayList();
        Path filePath = Paths.get(fileNameAgac);

        BufferedReader br = Files.newBufferedReader(filePath);
        String temp;
        try {

            while ((temp = br.readLine()) != null) {

                String name = temp.substring(0, temp.indexOf("^"));
                String agacin_Durumu = temp.substring(temp.indexOf("^") + 1, temp.indexOf("+"));
                String verimli = temp.substring(temp.indexOf("+") + 1, temp.indexOf("%"));
                String boyu = temp.substring(temp.indexOf("%") + 1, temp.indexOf("&"));
                String nesne_Turu = temp.substring(temp.indexOf("&") + 1, temp.indexOf("#"));
                String yas = temp.substring(temp.indexOf("#") + 1, temp.indexOf("/"));
                String adres = temp.substring(temp.indexOf("/") + 1, temp.indexOf("*"));
                String imageName = temp.substring(temp.indexOf("*") + 1, temp.length());
                Agac tmp = new Agac(agacin_Durumu, verimli, name, yas, boyu, nesne_Turu, adres,imageName);
                agacList.add(tmp);
            }
            br.close();
        } catch (Exception ex) {

        }

    }

    public void treeAdd(Agac eklenecekVarlik) {

        agacList.add(eklenecekVarlik);

    }

    public void treeDelete(Agac silinecekvarlik) {
        agacList.remove(silinecekvarlik);
    }

    //************************************************************************************************//
    //Cicek Dosya işlemleri
    public void writeFlowerFiles() throws IOException {

        Path filePath = Paths.get(fileNameCicek);
        BufferedWriter bw = Files.newBufferedWriter(filePath);
        Iterator<Cicek> iterator = cicekList.iterator();
        while (iterator.hasNext()) {
            Cicek writeintoFile = iterator.next();

            bw.append(writeintoFile.getAgacin_Adi() + "^" + writeintoFile.getYas() + "+" + writeintoFile.getBoyu() + "%" + writeintoFile.getRenk()
                    + "&" + writeintoFile.getTuru() + "#" + writeintoFile.getNesneTuru() + "/" + writeintoFile.getBitkiAdresi()+"*"+writeintoFile.getImageName());
            bw.newLine();
        }
        bw.close();
    }

    public void readFlowerFiles() throws IOException {

        cicekList = FXCollections.observableArrayList();
        Path filePath = Paths.get(fileNameCicek);

        BufferedReader br = Files.newBufferedReader(filePath);
        String temp;
        try {

            while ((temp = br.readLine()) != null) {

                String name = temp.substring(0, temp.indexOf("^"));
                String yas = temp.substring(temp.indexOf("^") + 1, temp.indexOf("+"));
                String boyu = temp.substring(temp.indexOf("+") + 1, temp.indexOf("%"));
                String renk = temp.substring(temp.indexOf("%") + 1, temp.indexOf("&"));
                String tur = temp.substring(temp.indexOf("&") + 1, temp.indexOf("#"));
                String nesne_Turu = temp.substring(temp.indexOf("#") + 1, temp.indexOf("/"));
                String adres = temp.substring(temp.indexOf("/") + 1, temp.indexOf("*"));
                String imageName = temp.substring(temp.indexOf("*") + 1, temp.length());

                Cicek tmp = new Cicek(name, yas, boyu, renk, tur, nesne_Turu, adres,imageName );
                cicekList.add(tmp);
            }
            br.close();
        } catch (Exception ex) {

        }
    }

    public void flowerAdd(Cicek eklenecekVarlik) {

        cicekList.add(eklenecekVarlik);

    }

    public void flowerDelete(Cicek silinecekvarlik) {
        cicekList.remove(silinecekvarlik);
    }
    //************************************************************************************************//

    // yukardaki tanımladıgımız ObservableListlerin getter ve setterleri
    public ObservableList<Hayvan> getHayvanList() {
        return hayvanList;
    }

    public void setHayvanList(ObservableList<Hayvan> hayvanList) {
        this.hayvanList = hayvanList;
    }

    public ObservableList<Kurulus> getKurulusList() {
        return kurulusList;
    }

    public void setKurulusList(ObservableList<Kurulus> kurulusList) {
        this.kurulusList = kurulusList;
    }

    public ObservableList<Agac> getAgacList() {
        return agacList;
    }

    public void setAgacList(ObservableList<Agac> agacList) {
        this.agacList = agacList;
    }

    public ObservableList<Cicek> getCicekList() {
        return cicekList;
    }

    public void setCicekList(ObservableList<Cicek> cicekList) {
        this.cicekList = cicekList;
    }

    public ObservableList<NobetciEczaneler> getEczaneList() {
        return eczaneList;
    }

    public void setEczaneList(ObservableList<NobetciEczaneler> eczaneList) {
        this.eczaneList = eczaneList;
    }

    public ObservableList<TaxiDuragi> getTaxiList() {
        return taxiList;
    }

    public void setTaxiList(ObservableList<TaxiDuragi> taxiList) {
        this.taxiList = taxiList;
    }

    public ObservableList<Insan> getPersonList() {
        return PersonList;
    }

    public void setPersonList(ObservableList<Insan> PersonList) {
        this.PersonList = PersonList;
    }

}
