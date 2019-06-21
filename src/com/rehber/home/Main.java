package com.rehber.home;


import com.rehber.fileOperations.FileOperations;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void init() throws Exception {

        try {
            FileOperations.getInstance().readPersonFiles();
        } catch (Exception e) {
        }
        try {
            FileOperations.getInstance().readAnimalFiles();
        } catch (Exception e) {
        }
        try {
            FileOperations.getInstance().readCompanyFiles();
        } catch (Exception e) {
        }
        try {
            FileOperations.getInstance().readPharmacyFiles();
        } catch (Exception e) {
        }
        try {
            FileOperations.getInstance().readTaxiFiles();
        } catch (Exception e) {
        }
        try {
            FileOperations.getInstance().readTreeFiles();
        } catch (Exception e) {
        }
        try {
            FileOperations.getInstance().readFlowerFiles();
        } catch (Exception e) {
        }

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Resimli Rehber Ve Adres Defteri");
        scene.getStylesheets().add(getClass().getResource("/stylesheet/Css.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        //RecentCalls recentCalls = new RecentCalls();
        //  recentCalls.getRecentCalls();
        //FileOperations.getInstance().callAdd("aa");
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {

        FileOperations.getInstance().writePersonFiles();
        FileOperations.getInstance().writeAnimalFiles();
        FileOperations.getInstance().writeCompanyFiles();
        FileOperations.getInstance().writePharmacyFiles();
        FileOperations.getInstance().writeTaxiFiles();
        FileOperations.getInstance().writeTreeFiles();
        FileOperations.getInstance().writeFlowerFiles();
        System.out.println("dosyaya yaziliyor..");
    }

}
