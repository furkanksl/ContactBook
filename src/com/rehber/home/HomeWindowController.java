package com.rehber.home;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.rehber.fileOperations.FileOperations;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

public class HomeWindowController implements Initializable {

    @FXML
    private JFXListView<String> lvLastCalls;

    @FXML
    private AnchorPane anchor;
 
    @FXML
    private Button btnIptal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

      
    }
       

    @FXML
    public void ListOfHuman(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initOwner(this.anchor.getScene().getWindow());
        primaryStage.initModality(Modality.WINDOW_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ListHuman.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());
        primaryStage.setTitle("Insan Listesi");
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.show();

    }

    @FXML
    public void ListOfAnimal(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initOwner(this.anchor.getScene().getWindow());
        primaryStage.initModality(Modality.WINDOW_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ListAnimal.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());
        primaryStage.setTitle("hayvan Listesi");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }

    @FXML
    public void ListOfCompany(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initOwner(this.anchor.getScene().getWindow());
        primaryStage.initModality(Modality.WINDOW_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ListCompany.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());
        primaryStage.setTitle("Kurulus Listesi");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }

    @FXML
    public void ListOfTree(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initOwner(this.anchor.getScene().getWindow());
        primaryStage.initModality(Modality.WINDOW_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ListTree.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());
        primaryStage.setTitle("Ağaç Listesi");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }

    @FXML
    public void ListOfFlower(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initOwner(this.anchor.getScene().getWindow());
        primaryStage.initModality(Modality.WINDOW_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ListFlower.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());
        primaryStage.setTitle("Çiçek Listesi");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }

    @FXML
    public void ListOfTaxi(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initOwner(this.anchor.getScene().getWindow());
        primaryStage.initModality(Modality.WINDOW_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ListTaxi.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());
        primaryStage.setTitle("Taxi Listesi");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }

    @FXML
    public void ListOfPharmacy(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initOwner(this.anchor.getScene().getWindow());
        primaryStage.initModality(Modality.WINDOW_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ListPharmacy.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());
        primaryStage.setTitle("Eczane Listesi");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }

    //Silme Kısmı
    //*****************************************
    @FXML
    public void close(ActionEvent event) throws IOException {

        Platform.exit();

    }
    @FXML
    public void close1() {
    Stage stage;
    stage = (Stage) btnIptal.getScene().getWindow();
    stage.close();
    }


    @FXML
    public void bagis(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initOwner(this.anchor.getScene().getWindow());
        primaryStage.initModality(Modality.WINDOW_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Donate.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    //**************************************************************
    //Arama Kısmı
    @FXML
    private JFXButton btnAra;

    @FXML
    public void SearchPerson(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initOwner(this.anchor.getScene().getWindow());
        primaryStage.initModality(Modality.WINDOW_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Search.fxml"));
       
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());
       
        primaryStage.setScene(scene);
        primaryStage.setTitle("BUL");
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }
}
