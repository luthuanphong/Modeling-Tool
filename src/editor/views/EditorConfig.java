/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.views;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import editor.canvas.Clip;
import editor.canvas.SensorType;
import editor.utils.InitializeData;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author phongtl.hf
 */
public class EditorConfig extends Dialog<Object> {
    
    private FXMLLoader uiLoader;
    private InitializeData data;
    private Clip selectedClip;
    
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField minSensorSendingRate;
    @FXML
    private TextField maxSensorSendingRate;
    @FXML
    private TextField minSensorProcessingRate;
    @FXML
    private TextField maxSensorProcessingRate;
    @FXML
    private TextField minChannelSendingRate;
    @FXML
    private TextField maxChannelSendingRate;
    @FXML
    private TextField numberOfPackage;
    @FXML
    private TableView<Clip> sensorTable;
    @FXML
    private TableColumn<Clip,String> sensorId;
    @FXML
    private TableColumn<Clip,String> sensorName;
    @FXML
    private TableColumn<Clip,String> sensorType;
    @FXML
    private TableColumn<Clip,String> sensorToken;
    @FXML
    private TableColumn<Clip,String> sensorEnergy;
    @FXML
    private Label idSensor;
    @FXML
    private Label nameSensor;
    @FXML
    private ComboBox<String> typeSensor;
    @FXML
    private TextField tokenSensor;
    @FXML
    private TextField energySensor;
    @FXML
    private Button apply;
    /**
     * Dialog constructor used to set up basic information
     * @param data
     */
    public EditorConfig (InitializeData data) {
    	this.data = data;
        this.initObject();
        this.initStyle();
        try {
            this.LoadUI();
        } catch (IOException ex) {
            Logger.getLogger(EditorConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setEvent();
        
    }
    
    /**
     * Show dialog
     */
    public void Show () {
        //Scene scene = new Scene(this.uiLoader.getRoot());
        this.getDialogPane().setContent(this.uiLoader.getRoot());
        this.show(); 
        this.InitTextContent();
        this.InitBasicData();
        this.InitTableData();
        this.initDialogEvent();
    }
    
    /**
     * Initialize some usable object
     */
    private void initObject () {
        this.uiLoader = new FXMLLoader();
    }
    
    /**
     * Initialize dialog style
     */
    private void initStyle () {
        this.setTitle("Config");
    }
    
    /**
     * Load ui from FXML file
     * @throws IOException
     */
    private void LoadUI () throws IOException {
        this.uiLoader.setLocation(getClass().getResource("/res/Fxml/config.fxml"));
        this.uiLoader.setRoot(anchorPane);
        this.uiLoader.setController(this);
        this.uiLoader.load();
    }
    
    /**
     * Set up close dialog event 
     */
    private void setEvent () {
        this.getDialogPane().getButtonTypes().addAll(ButtonType.OK);
        this.setOnCloseRequest(new EventHandler<DialogEvent>() {
			
			@Override
			public void handle(DialogEvent event) {
				// TODO Auto-generated method stub
				EditorConfig.this.GetTextContent();
			}
		});
    }
    
    /**
     * 
     */
    private void initDialogEvent () {
    	this.sensorTable.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				EditorConfig.this.UpdateSelectContent();
			}
		});
    	
    	this.typeSensor.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				UpdateUIFromActionOFComboboxTypeSensor();
			}
		});
    	
    	this.apply.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				ApplyDataFromUItoSensor();
			}
		});
    }
    
    private void UpdateSelectContent () {
    	int index = this.sensorTable.getSelectionModel().getSelectedIndex();
    	this.selectedClip = data.getOriginalSensorClip().get(index);
    	this.idSensor.setText(selectedClip.getId());
    	this.nameSensor.setText(selectedClip.getName());
    	this.typeSensor.getSelectionModel().select(selectedClip.getSensorType());
    	
    	if(selectedClip.getSensorType().equals(SensorType.SOURCE)) {
    		this.tokenSensor.setText(selectedClip.getToken());
    	}else {
    		this.tokenSensor.editableProperty().set(false);
    	}
    	
    	this.energySensor.setText(selectedClip.getEnergy()+"");
    	
    }
    
    public void UpdateUIFromActionOFComboboxTypeSensor () {
    	String item = this.typeSensor.getSelectionModel().getSelectedItem();
    	if(item.equals(SensorType.SOURCE)) {
    		this.tokenSensor.setEditable(true);
    	}else {
    		this.tokenSensor.setEditable(false);
    	}
    }
    
    public void ApplyDataFromUItoSensor () {
    	String sensorType = this.typeSensor.getSelectionModel().getSelectedItem();
    	if(sensorType.equals(SensorType.SOURCE)) {
    		selectedClip.setSensorType(1);
    	} else if (sensorType.equals(SensorType.SINK)) {
    		selectedClip.setSensorType(2);
    	} else {
    		selectedClip.setSensorType(3);
    	}
    	
    	try {
    		int token = Integer.parseInt(this.tokenSensor.getText());
    		float energy = Float.parseFloat(this.energySensor.getText());
    		selectedClip.setToken(token);
    		selectedClip.setEnergy(energy);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	this.sensorTable.refresh();
    }
    
    /**
     * 
     */
    private void InitTableData () {
    	this.sensorTable.setItems(data.getSensorClip());
    	this.sensorId.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getId()));
    	this.sensorName.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getName()));
    	this.sensorType.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getSensorType()));
    	this.sensorToken.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getToken()));
    	this.sensorEnergy.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getEnergy()+""));
    	
    	this.sensorId.setSortable(false);
    	this.sensorName.setSortable(false);
    	this.sensorToken.setSortable(false);
    	this.sensorEnergy.setSortable(false);
    	this.sensorType.setSortable(false);
    }
    
    private void InitBasicData () {
    	this.typeSensor.setItems(FXCollections.observableArrayList(SensorType.SOURCE,SensorType.SINK,SensorType.INTERMEDIATE));
    }
    
    /**
     * Set up default content for text field
     */
    private void InitTextContent () {
    	this.minSensorSendingRate.setText(this.data.getMinSensorSendingRate());
    	this.minSensorProcessingRate.setText(this.data.getMinSensorProcessingRate());
    	this.minChannelSendingRate.setText(this.data.getMinChannelSendingRate());
    	this.maxSensorSendingRate.setText(this.data.getMaxSensorSendingRate());
    	this.maxSensorProcessingRate.setText(this.data.getMaxSensorProcessingRate());
    	this.maxChannelSendingRate.setText(this.data.getMaxChannelSendingRate());
    	this.numberOfPackage.setText(this.data.getNumberOfPackage());
    }
    
    /**
     * Get the content in text field before closing dialog
     */
    private void GetTextContent () {
    	this.data.setMinSensorSendingRate(this.minSensorSendingRate.getText());
    	this.data.setMinSensorProcessingRate(this.minSensorProcessingRate.getText());
    	this.data.setMinChannelSendingRate(this.minChannelSendingRate.getText());
    	this.data.setMaxSensorSendingRate(this.maxSensorSendingRate.getText());
    	this.data.setMaxSensorProcessingRate(this.maxSensorProcessingRate.getText());
    	this.data.setMaxChannelSendingRate(this.maxChannelSendingRate.getText());
    	this.data.setNumberOfPackage(this.numberOfPackage.getText());
    }
}
