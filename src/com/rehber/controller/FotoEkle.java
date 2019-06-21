
package com.rehber.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;



public abstract  class FotoEkle {
    public abstract void onClik_image_save(ActionEvent event)throws IOException;
    
}
