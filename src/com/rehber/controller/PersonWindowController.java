package com.rehber.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.rehber.entity.Agac;
import com.rehber.entity.Cicek;
import com.rehber.entity.Hayvan;
import com.rehber.entity.Insan;
import com.rehber.entity.Kurulus;
import com.rehber.entity.NobetciEczaneler;
import com.rehber.entity.TaxiDuragi;
import com.rehber.fileOperations.FileOperations;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

public class PersonWindowController implements Initializable, interfacecontroller {

    private static PersonWindowController instance = new PersonWindowController();

    public PersonWindowController() {

    }

    public static PersonWindowController getInstance() {
        return instance;
    }

//------------Human
    @FXML
    private AnchorPane anchorHuman;

    @FXML
    private ImageView ivHuman;

    @FXML
    private JFXButton btnIptal;

    @FXML
    private Button btnGeri;

    @FXML
    private ListView<Insan> lvHumanList;

    @FXML
    private TextArea taHuman;
    

    //-----.animal
    @FXML
    private AnchorPane anchorHayvanList;

    @FXML
    private ImageView ivAnimal;

    @FXML
    private ListView<Hayvan> lvAnimalList;

    @FXML
    private TextArea taAnimal;

    //------Flower
    @FXML
    private ImageView ivFlower;

    @FXML
    private ListView<Cicek> lvFlowerList;

    @FXML
    private TextArea taFlower;

    //------Company
    @FXML
    private ImageView ivCompany;

    @FXML
    private ListView<Kurulus> lvCompanyList;

    @FXML
    private TextArea taCompany;

    //---Taxi
    @FXML
    private ImageView ivTaxi;

    @FXML
    private ListView<TaxiDuragi> lvTaxiList;

    @FXML
    private TextArea taTaxi;

    //---pharmacy
    @FXML
    private ImageView ivPharmacy;

    @FXML
    private ListView<NobetciEczaneler> lvPharmacyList;

    @FXML
    private TextArea taPharmacy;

    //--tree
    @FXML
    private ImageView ivTree;

    @FXML
    private ListView<Agac> lvTreeList;

    @FXML
    private TextArea taTree;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //lvHumanList.refresh();
        try {
            lvHumanList.getItems().setAll(FileOperations.getInstance().getPersonList());
            lvHumanList.getSelectionModel().selectFirst();

        } catch (Exception e) {
        }
        try {
            lvAnimalList.getItems().setAll(FileOperations.getInstance().getHayvanList());
            lvAnimalList.getSelectionModel().selectFirst();
        } catch (Exception e) {
        }
        try {
            lvCompanyList.getItems().setAll(FileOperations.getInstance().getKurulusList());
            lvCompanyList.getSelectionModel().selectFirst();
        } catch (Exception e) {
        }
        try {
            lvPharmacyList.getItems().setAll(FileOperations.getInstance().getEczaneList());
            lvPharmacyList.getSelectionModel().selectFirst();
        } catch (Exception e) {
        }
        try {
            lvTaxiList.getItems().setAll(FileOperations.getInstance().getTaxiList());
            lvTaxiList.getSelectionModel().selectFirst();
        } catch (Exception e) {
        }
        try {
            lvTreeList.getItems().setAll(FileOperations.getInstance().getAgacList());
            lvTreeList.getSelectionModel().selectFirst();
        } catch (Exception e) {
        }
        try {
            lvFlowerList.getItems().setAll(FileOperations.getInstance().getCicekList());
            lvFlowerList.getSelectionModel().selectFirst();
        } catch (Exception e) {
        }

    }

    public void listViewSecilenInsan() {

        Insan secilenVarlik = lvHumanList.getSelectionModel().getSelectedItem();
        if (secilenVarlik != null) {
            taHuman.setText(secilenVarlik.toStringInsan());
            Image image = new Image("file:///" + System.getProperty("user.dir") + "/uploadphotos/" + secilenVarlik.getImageName());
            ivHuman.setImage(image);
        }
    }

    public void listViewSecilenHayvan() {
        Hayvan secilenVarlik = lvAnimalList.getSelectionModel().getSelectedItem();
        if (secilenVarlik != null) {
            taAnimal.setText(secilenVarlik.toStringHayvan());
            Image image = new Image("file:///" + System.getProperty("user.dir") + "/uploadphotos/" + secilenVarlik.getImageName());
            ivAnimal.setImage(image);

        }
    }

    public void listViewSecilenKurulus() {
        Kurulus secilenVarlik = lvCompanyList.getSelectionModel().getSelectedItem();
        if (secilenVarlik != null) {
            taCompany.setText(secilenVarlik.toStringKurulus());
            Image image = new Image("file:///" + System.getProperty("user.dir") + "/uploadphotos/" + secilenVarlik.getImageName());
            ivCompany.setImage(image);
        }
    }

    public void listViewSecilenAgac() {
        Agac secilenVarlik = lvTreeList.getSelectionModel().getSelectedItem();
        if (secilenVarlik != null) {
            taTree.setText(secilenVarlik.toStringAgac());
            Image image = new Image("file:///" + System.getProperty("user.dir") + "/uploadphotos/" + secilenVarlik.getImageName());
            ivTree.setImage(image);
        }
    }

    public void listViewSecilenCicek() {
        Cicek secilenVarlik = lvFlowerList.getSelectionModel().getSelectedItem();
        if (secilenVarlik != null) {
            taFlower.setText(secilenVarlik.toStringCicek());
            Image image = new Image("file:///" + System.getProperty("user.dir") + "/uploadphotos/" + secilenVarlik.getImageName());
            ivFlower.setImage(image);
        }

    }

    public void listViewSecilenEczane() {
        NobetciEczaneler secilenVarlik = lvPharmacyList.getSelectionModel().getSelectedItem();
        if (secilenVarlik != null) {
            taPharmacy.setText(secilenVarlik.toStringEczane());
            Image image = new Image("file:///" + System.getProperty("user.dir") + "/uploadphotos/" + secilenVarlik.getImageName());
            ivPharmacy.setImage(image);
        }
    }

    public void listViewSecilenTaxi() {
        TaxiDuragi secilenVarlik = lvTaxiList.getSelectionModel().getSelectedItem();
        taTaxi.setText(secilenVarlik.toStringTaxi());
        Image image = new Image("file:///" + System.getProperty("user.dir") + "/uploadphotos/" + secilenVarlik.getImageName());
        ivTaxi.setImage(image);
    }

    @FXML
    public void updateHumanShow(ActionEvent event) throws IOException {
        Insan secilenVarlik = lvHumanList.getSelectionModel().getSelectedItem();
        if (secilenVarlik == null) {

            JOptionPane.showMessageDialog(null, "Bir kisi secmelisiniz !");
        } else {
            FXMLLoader.load(getClass().getResource("/fxml/EditHuman.fxml"));
            Stage primaryStage = new Stage();

            primaryStage.initOwner(this.anchorHuman.getScene().getWindow());
            primaryStage.initModality(Modality.WINDOW_MODAL);
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/EditHuman.fxml"));

            primaryStage.setTitle("Guncelle");
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.showAndWait();
            updateHumanList();

        }
    }

    @FXML
    public void updateAnimalShow(ActionEvent event) throws IOException {
        Hayvan secilenVarlik = lvAnimalList.getSelectionModel().getSelectedItem();
        if (secilenVarlik == null) {

            JOptionPane.showMessageDialog(null, "Bir kisi secmelisiniz !");
        } else {
            FXMLLoader.load(getClass().getResource("/fxml/EditAnimal.fxml"));
            Stage primaryStage = new Stage();

            primaryStage.initOwner(this.anchorHayvanList.getScene().getWindow());
            primaryStage.initModality(Modality.WINDOW_MODAL);
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/EditAnimal.fxml"));

            primaryStage.setTitle("Guncelle");
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.showAndWait();
            updateAnimalList();

        }
    }
    @FXML
    private AnchorPane anchorCompanyList;

    @FXML
    public void updateCompanyShow(ActionEvent event) throws IOException {
        Kurulus secilenVarlik = lvCompanyList.getSelectionModel().getSelectedItem();
        if (secilenVarlik == null) {

            JOptionPane.showMessageDialog(null, "Bir kisi secmelisiniz !");
        } else {
            FXMLLoader.load(getClass().getResource("/fxml/EditCompany.fxml"));
            Stage primaryStage = new Stage();

            primaryStage.initOwner(this.anchorCompanyList.getScene().getWindow());
            primaryStage.initModality(Modality.WINDOW_MODAL);
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/EditCompany.fxml"));

            primaryStage.setTitle("Guncelle");
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.showAndWait();
            updateCompanyList();

        }
    }
    @FXML
    private AnchorPane anchorFlowerList;

    @FXML
    public void updateFlowerShow(ActionEvent event) throws IOException {
        Cicek secilenVarlik = lvFlowerList.getSelectionModel().getSelectedItem();
        if (secilenVarlik == null) {

            JOptionPane.showMessageDialog(null, "Bir kisi secmelisiniz !");
        } else {
            FXMLLoader.load(getClass().getResource("/fxml/EditFlower.fxml"));
            Stage primaryStage = new Stage();

            primaryStage.initOwner(this.anchorFlowerList.getScene().getWindow());
            primaryStage.initModality(Modality.WINDOW_MODAL);
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/EditFlower.fxml"));

            primaryStage.setTitle("Guncelle");
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.showAndWait();
            updateFlowerList();
        }
    }

    @FXML
    private AnchorPane anchorPharmacyList;

    @FXML
    public void updatePharmacyShow(ActionEvent event) throws IOException {
        NobetciEczaneler secilenVarlik = lvPharmacyList.getSelectionModel().getSelectedItem();
        if (secilenVarlik == null) {

            JOptionPane.showMessageDialog(null, "Bir kisi secmelisiniz !");
        } else {
            FXMLLoader.load(getClass().getResource("/fxml/EditPharmacy.fxml"));
            Stage primaryStage = new Stage();

            primaryStage.initOwner(this.anchorPharmacyList.getScene().getWindow());
            primaryStage.initModality(Modality.WINDOW_MODAL);
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/EditPharmacy.fxml"));

            primaryStage.setTitle("Guncelle");
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.showAndWait();
            updatePharmacyList();
        }
    }
    @FXML
    private AnchorPane anchorTaxiList;

    @FXML
    public void updateTaxiShow(ActionEvent event) throws IOException {
        TaxiDuragi secilenVarlik = lvTaxiList.getSelectionModel().getSelectedItem();
        if (secilenVarlik == null) {

            JOptionPane.showMessageDialog(null, "Bir kisi secmelisiniz !");
        } else {
            FXMLLoader.load(getClass().getResource("/fxml/EditTaxi.fxml"));
            Stage primaryStage = new Stage();

            primaryStage.initOwner(this.anchorTaxiList.getScene().getWindow());
            primaryStage.initModality(Modality.WINDOW_MODAL);
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/EditTaxi.fxml"));

            primaryStage.setTitle("Guncelle");
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.showAndWait();
            updateTaxiList();
        }
    }
    @FXML
    private AnchorPane anchorTreeList;

    @FXML
    public void updateTreeShow(ActionEvent event) throws IOException {
        Agac secilenVarlik = lvTreeList.getSelectionModel().getSelectedItem();
        if (secilenVarlik == null) {

            JOptionPane.showMessageDialog(null, "Bir kisi secmelisiniz !");
        } else {
            FXMLLoader.load(getClass().getResource("/fxml/EditTree.fxml"));
            Stage primaryStage = new Stage();

            primaryStage.initOwner(this.anchorTreeList.getScene().getWindow());
            primaryStage.initModality(Modality.WINDOW_MODAL);
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/EditTree.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.showAndWait();
            updateTreeList();
        }
    }

    public void deleteHuman() {

        Insan secilenVarlik = lvHumanList.getSelectionModel().getSelectedItem();
        FileOperations.getInstance().personDelete(secilenVarlik);
        if (secilenVarlik == null) {

            JOptionPane.showMessageDialog(null, "Bir kisi secmelisiniz !");
        } else {
            taHuman.setText("silme işlemi başarıyla gerçekleştirildi");
            fotografSil(secilenVarlik.getImageName());
            ivHuman.setImage(null);
            System.out.println("Human Deleted.");
            updateHumanList();
        }
    }

    public void deleteTree() {

        Agac secilenVarlik = lvTreeList.getSelectionModel().getSelectedItem();
        FileOperations.getInstance().treeDelete(secilenVarlik);
        if (secilenVarlik == null) {

            JOptionPane.showMessageDialog(null, "Bir kisi secmelisiniz !");
        } else {
            fotografSil(secilenVarlik.getImageName());
            taTree.setText("silme işlemi başarıyla gerçekleştirildi");
            System.out.println("Tree Deleted.");
            ivTree.setImage(null);
            updateTreeList();
        }
    }

    public void deleteFlower() {

        Cicek secilenVarlik = lvFlowerList.getSelectionModel().getSelectedItem();
        FileOperations.getInstance().flowerDelete(secilenVarlik);
        if (secilenVarlik == null) {
            JOptionPane.showMessageDialog(null, "Bir kisi secmelisiniz !");
        } else {
            fotografSil(secilenVarlik.getImageName());
            ivFlower.setImage(null);
            taFlower.setText("silme işlemi başarıyla gerçekleştirildi");
            System.out.println("Flower Deleted.");
            updateFlowerList();
        }
    }

    public void deleteTaxi() {

        TaxiDuragi secilenVarlik = lvTaxiList.getSelectionModel().getSelectedItem();
        FileOperations.getInstance().taxiDelete(secilenVarlik);
        if (secilenVarlik == null) {
            JOptionPane.showMessageDialog(null, "Bir kisi secmelisiniz !");
        } else {
            fotografSil(secilenVarlik.getImageName());
            taTaxi.setText("silme işlemi başarıyla gerçekleştirildi");
            ivTaxi.setImage(null);
            System.out.println("Taxi Deleted.");
            updateTaxiList();
        }
    }

    public void deletePharmacy() {

        NobetciEczaneler secilenVarlik = lvPharmacyList.getSelectionModel().getSelectedItem();
        FileOperations.getInstance().pharmacyDelete(secilenVarlik);
        if (secilenVarlik == null) {
            JOptionPane.showMessageDialog(null, "Bir kisi secmelisiniz !");
        } else {
            fotografSil(secilenVarlik.getImageName());
            taPharmacy.setText("silme işlemi başarıyla gerçekleştirildi");
            ivPharmacy.setImage(null);
            System.out.println("Pharmacy Deleted.");
            updatePharmacyList();
        }
    }

    public void deleteAnimal() {

        Hayvan secilenVarlik = lvAnimalList.getSelectionModel().getSelectedItem();
        FileOperations.getInstance().animalDelete(secilenVarlik);
        if (secilenVarlik == null) {
            JOptionPane.showMessageDialog(null, "Bir kisi secmelisiniz !");
        } else {
            fotografSil(secilenVarlik.getImageName());
            taAnimal.setText("silme işlemi başarıyla gerçekleştirildi");
            ivAnimal.setImage(null);
            System.out.println("Animal Deleted.");
            updateAnimalList();
        }
    }

    public void deleteCompany() {

        Kurulus secilenVarlik = lvCompanyList.getSelectionModel().getSelectedItem();
        FileOperations.getInstance().companyDelete(secilenVarlik);
        if (secilenVarlik == null) {
            JOptionPane.showMessageDialog(null, "Bir kisi secmelisiniz !");
        } else {
            fotografSil(secilenVarlik.getImageName());
            taCompany.setText("silme işlemi başarıyla gerçekleştirildi");
            ivCompany.setImage(null);
            System.out.println("Company Deleted.");
            updateCompanyList();
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
    @Override
    public void close() {
        Stage stage;
        stage = (Stage) btnIptal.getScene().getWindow();
        stage.close();
    }

    //*******************************************************************/////////////////////
    //Update List
    public void updateHumanList() {
        lvHumanList.getItems().clear();
        lvHumanList.getItems().setAll(FileOperations.getInstance().getPersonList());
    }

    public void updateTreeList() {
        lvTreeList.getItems().clear();
        lvTreeList.getItems().setAll(FileOperations.getInstance().getAgacList());

    }

    public void updateFlowerList() {
        lvFlowerList.getItems().clear();
        lvFlowerList.getItems().setAll(FileOperations.getInstance().getCicekList());
    }

    public void updateTaxiList() {
        lvTaxiList.getItems().clear();
        lvTaxiList.getItems().setAll(FileOperations.getInstance().getTaxiList());
    }

    public void updatePharmacyList() {
        lvPharmacyList.getItems().clear();
        lvPharmacyList.getItems().setAll(FileOperations.getInstance().getEczaneList());
    }

    public void updateAnimalList() {
        lvAnimalList.getItems().clear();
        lvAnimalList.getItems().setAll(FileOperations.getInstance().getHayvanList());
    }

    public void updateCompanyList() {
        lvCompanyList.getItems().clear();
        lvCompanyList.getItems().setAll(FileOperations.getInstance().getKurulusList());

    }

//***********************************************************************///////////////////////
////////////////////////////////EKLE PENCERELERI////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
//Add sayfasinin degiskenleri
//------------------------
//Addinsan 
    @FXML
    private AnchorPane anchorInsan;

    @FXML
    public void insan(ActionEvent event) throws IOException {

        anchorInsan = FXMLLoader.load(getClass().getResource("/fxml/AddInsan.fxml"));
        Stage primaryStage = new Stage();

        primaryStage.initOwner(this.anchorHuman.getScene().getWindow());
        primaryStage.initModality(Modality.WINDOW_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddInsan.fxml"));

        primaryStage.setTitle("insan Peceresi");
        Scene scene = new Scene(anchorInsan);
        scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.showAndWait();
        //adil
        updateHumanList();
    }

//------------------------
    //Add Kurulus
    @FXML
    public void kurulus(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initOwner(this.anchorCompanyList.getScene().getWindow());
        primaryStage.initModality(Modality.WINDOW_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddKurulus.fxml"));
        primaryStage.setTitle("Kurulus Peceresi");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.showAndWait();
        updateCompanyList();
    }

    //Add Hayvan
    @FXML
    public void hayvan(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initOwner(this.anchorHayvanList.getScene().getWindow());
        primaryStage.initModality(Modality.WINDOW_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddHayvan.fxml"));
        primaryStage.setTitle("Hayvan Peceresi");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.showAndWait();
        updateAnimalList();
    }

    //-------------------------
    @FXML
    public void agac(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initOwner(this.anchorTreeList.getScene().getWindow());
        primaryStage.initModality(Modality.WINDOW_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddAgac.fxml"));
        primaryStage.setTitle("Agac Peceresi");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.showAndWait();
        updateTreeList();
    }
    //-------------------------

    //Add Cicek
    @FXML
    public void cicek(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initOwner(this.anchorFlowerList.getScene().getWindow());
        primaryStage.initModality(Modality.WINDOW_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddCicek.fxml"));
        primaryStage.setTitle("Cicek Peceresi");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.showAndWait();
        updateFlowerList();
    }

    //-------------------------
    //Add Eczane
    @FXML
    public void eczane(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initOwner(this.anchorPharmacyList.getScene().getWindow());
        primaryStage.initModality(Modality.WINDOW_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddEczane.fxml"));
        primaryStage.setTitle("Eczane Peceresi");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.showAndWait();
        updatePharmacyList();
    }
    //-------------------

    //Add Taxi Duragi
    @FXML
    private AnchorPane taksiAnchor;

    @FXML
    public void taxi(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initOwner(this.anchorTaxiList.getScene().getWindow());
        primaryStage.initModality(Modality.WINDOW_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddTaxiDuragi.fxml"));
        primaryStage.setTitle("TaksiDuragi Peceresi");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.showAndWait();
        updateTaxiList();
    }

    //-------------------------
    ToggleGroup group = new ToggleGroup();

    ////////////////////arama//////////////////
    @FXML
    private TextField tfBul;

    @FXML
    private JFXTextArea taBul;

    public void personFind() {
        String findTel = tfBul.getText();
        int control = 5;

        int size = FileOperations.getInstance().getPersonList().size();

        for (int i = 0; i < size; i++) {

            if (FileOperations.getInstance().getPersonList().get(i).getTelNo().equals(findTel)) {
                taBul.setText(FileOperations.getInstance().getPersonList().get(i).toStringInsan());
                control = 6;
                break;
            } else {
                taBul.setText("\n\n\nBu numaraya Kayıtlı biri yok.");

            }
        }
        size = FileOperations.getInstance().getEczaneList().size();
        if (control != 6) {

            for (int i = 0; i < size; i++) {
                if (FileOperations.getInstance().getEczaneList().get(i).getTel_NO().equals(findTel)) {
                    taBul.setText(FileOperations.getInstance().getEczaneList().get(i).toStringEczane());
                    control = 7;
                    break;
                } else {
                    taBul.setText("\n\n\nBu numaraya Kayıtlı biri yok.");

                }
            }
        }

        size = FileOperations.getInstance().getTaxiList().size();
        if (control != 6 && control != 7) {
            for (int i = 0; i < size; i++) {
                if (FileOperations.getInstance().getTaxiList().get(i).getTel_NO().equals(findTel)) {
                    taBul.setText(FileOperations.getInstance().getTaxiList().get(i).toStringTaxi());
                    control = 8;
                    break;
                } else {
                    taBul.setText("\n\n\nBu numaraya Kayıtlı biri yok.");

                }
            }
        }
        size = FileOperations.getInstance().getHayvanList().size();
        if (control != 6 && control != 7 && control != 8) {
            for (int i = 0; i < size; i++) {
                if (FileOperations.getInstance().getHayvanList().get(i).getTelNo().equals(findTel)) {
                    taBul.setText(FileOperations.getInstance().getHayvanList().get(i).toStringHayvan());
                    control = 9;
                    break;
                } else {
                    taBul.setText("\n\n\nBu numaraya Kayıtlı biri yok.");

                }
            }
        }
        size = FileOperations.getInstance().getKurulusList().size();
        if (control != 6 && control != 7 && control != 8 && control != 9) {
            for (int i = 0; i < size; i++) {
                if (FileOperations.getInstance().getKurulusList().get(i).getTelNo().equals(findTel)) {
                    taBul.setText(FileOperations.getInstance().getKurulusList().get(i).toStringKurulus());
                    control = 10;
                    break;
                } else {
                    taBul.setText("\n\n\nBu numaraya Kayıtlı biri yok.");

                }
            }
        }
        size = FileOperations.getInstance().getCicekList().size();
        if (control != 6 && control != 7 && control != 8 && control != 9 && control != 10) {
            for (int i = 0; i < size; i++) {
                if (FileOperations.getInstance().getCicekList().get(i).getAgacin_Adi().equals(findTel)) {
                    taBul.setText(FileOperations.getInstance().getCicekList().get(i).toStringCicek());
                    control = 11;
                    break;
                } else {
                    taBul.setText("\n\n\nBu numaraya Kayıtlı biri yok.");

                }
            }
        }
        size = FileOperations.getInstance().getAgacList().size();
        if (control != 6 && control != 7 && control != 8 && control != 9 && control != 10 && control != 11) {
            for (int i = 0; i < size; i++) {
                if (FileOperations.getInstance().getAgacList().get(i).getAgacin_Adi().equals(findTel)) {
                    taBul.setText(FileOperations.getInstance().getAgacList().get(i).toStringAgac());
                    control = 5;
                    break;
                } else {
                    taBul.setText("\n\n\nBu numaraya Kayıtlı biri yok.");

                }
            }
        }
    }

    @FXML
    public void kapat() {
        Stage stage;
        stage = (Stage) btnGeri.getScene().getWindow();
        stage.close();
    }

    @Override
    public boolean isNumber(String tmp) {
        try {
            Integer.parseInt(tmp);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
