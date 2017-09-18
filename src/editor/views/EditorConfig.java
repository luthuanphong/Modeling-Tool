/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.views;

import java.awt.SystemColor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.stage.StageStyle;

/**
 *
 * @author phongtl.hf
 */
public class EditorConfig extends Dialog<Object> {
    
    private FXMLLoader uiLoader;
    
    @FXML
    private AnchorPane anchorPane;
    
    public EditorConfig () {
        this.initObject();
        this.initStyle();
        try {
            this.LoadUI();
        } catch (IOException ex) {
            Logger.getLogger(EditorConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setEvent();
    }
    
    public void Show () {
        //Scene scene = new Scene(this.uiLoader.getRoot());
        this.getDialogPane().setContent(this.uiLoader.getRoot());
        this.show(); 
    }
    
    private void initObject () {
        this.uiLoader = new FXMLLoader();
    }
    
    private void initStyle () {
        this.setTitle("Config");
    }
    
    private void LoadUI () throws IOException {
        this.uiLoader.setLocation(getClass().getResource("/res/Fxml/config.fxml"));
        this.uiLoader.setRoot(anchorPane);
        this.uiLoader.load();
    }
    
    private void setEvent () {
        this.getDialogPane().getButtonTypes().addAll(ButtonType.CLOSE);
    }
    
    private void Close () {
        this.setResult(Boolean.TRUE);
        this.close();
    }
}
