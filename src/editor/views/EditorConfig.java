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
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author phongtl.hf
 */
public class EditorConfig extends Dialog<Object> {
    
    private FXMLLoader uiLoader;
    private InitializeData data;
    private Clip selectedSensorClip;
    private Clip selectedChannelClip;
    private EditorWindow editor;
    
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
    private TextField sensorMaxbufferSize;
    @FXML
    private TextField sensorMaxQueueSize;
    @FXML
    private TextField channelMaxBufferSize;
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
    @FXML
    private Label channeId;
    @FXML
    private Label channelName;
    @FXML
    private ComboBox<Clip> sensorFrom;
    @FXML
    private ComboBox<Clip> sensorTo;
    @FXML
    private TableView<Clip> channelTable;
    @FXML
    private TableColumn<Clip,String> channelIdCol;
    @FXML
    private TableColumn<Clip,String> channelNameCol;
    @FXML
    private TableColumn<Clip, String> sensorFromCol;
    @FXML
    private TableColumn<Clip,String> sensorToCol;
    @FXML
    private Button channelApply;
    
    /**
     * 
     */
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
    
    /** 
     * Dialog constructor used to set up basic information
     * @param data
     */
    public EditorConfig (InitializeData data,EditorWindow editor) {
    	this.editor = editor;
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
    
    public void setEditor (EditorWindow editor) {
    	this.data = editor.getData();
    	this.editor = editor;
    }
    
    /**
     * Show dialog
     */
    public void Show () {
        //Scene scene = new Scene(this.uiLoader.getRoot());
        this.getDialogPane().setContent(this.uiLoader.getRoot());
        this.show(); 
        this.InitCommonContent();
        this.InitComboboxData();
        this.InitSensorTableData();
        this.InitChannelTableData();
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
        this.setTitle(EditorWindow.APP_NAME+" - Config");
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
				EditorConfig.this.editor.updateBoard();
			}
		});
    }
    
    /**
     * Initialize user interface event 
     */
    private void initDialogEvent () {
    	// Initialize sensor table view click event
    	this.sensorTable.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				EditorConfig.this.UpdateSelectSensorContent();
			}
		});
    	
    	// Initialize sensor combobox selection event
    	this.typeSensor.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				UpdateUIFromActionOFComboboxTypeSensor();
			}
		});
    	
    	// Sensor apply new information event
    	this.apply.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ApplyDataFromUItoSensor();
			}
		});
    	
    	// Initialize channel table view click event
    	this.channelTable.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				EditorConfig.this.UpdateSelectedChannelContent();
			}
		});
        this.channelApply.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                        EditorConfig.this.ApplyDataFromUIToChannel();
                }
            });
        this.minSensorSendingRate.addEventHandler(KeyEvent.KEY_TYPED, numeric_Validation(10));
    	this.minSensorProcessingRate.addEventHandler(KeyEvent.KEY_TYPED, numeric_Validation(10));
    	this.minChannelSendingRate.addEventHandler(KeyEvent.KEY_TYPED, numeric_Validation(10));
    	this.maxSensorSendingRate.addEventHandler(KeyEvent.KEY_TYPED, numeric_Validation(10));
    	this.maxSensorProcessingRate.addEventHandler(KeyEvent.KEY_TYPED, numeric_Validation(10));
    	this.maxChannelSendingRate.addEventHandler(KeyEvent.KEY_TYPED, numeric_Validation(10));
    	this.numberOfPackage.addEventHandler(KeyEvent.KEY_TYPED, numeric_Validation(10));
    	this.sensorMaxbufferSize.addEventHandler(KeyEvent.KEY_TYPED, numeric_Validation(10));
    	this.sensorMaxQueueSize.addEventHandler(KeyEvent.KEY_TYPED, numeric_Validation(10));
    	this.channelMaxBufferSize.addEventHandler(KeyEvent.KEY_TYPED, numeric_Validation(10));
    	this.tokenSensor.addEventHandler(KeyEvent.KEY_TYPED, numeric_Validation(10));
    	this.energySensor.addEventHandler(KeyEvent.KEY_TYPED, numeric_Validation(10));
    }
    
    /**
     * Show selected sensor content to UI
     */
    private void UpdateSelectSensorContent () {
    	int index = this.sensorTable.getSelectionModel().getSelectedIndex();
    	if (index != -1 ) {
	    	this.selectedSensorClip = data.getOriginalSensorClip().get(index);
	    	this.idSensor.setText(selectedSensorClip.getId());
	    	this.nameSensor.setText(selectedSensorClip.getName());
	    	this.typeSensor.getSelectionModel().select(selectedSensorClip.getSensorType());
	    	this.tokenSensor.setText(selectedSensorClip.getToken());
	    	if(selectedSensorClip.getSensorType().equals(SensorType.SOURCE)) {
	    		this.tokenSensor.setText(selectedSensorClip.getToken());
	    	}else {
	    		this.tokenSensor.editableProperty().set(false);
	    	}
	    	
	    	this.energySensor.setText(selectedSensorClip.getEnergy()+"");
    	}
    }
    
    /**
     * 
     */
    private void ApplyDataFromUIToChannel () {
        
        Clip outputPlace = this.sensorFrom.getSelectionModel().getSelectedItem();
        Clip inputPlace = this.sensorTo.getSelectionModel().getSelectedItem();
        this.selectedChannelClip.setOutputPlace(outputPlace);
        this.selectedChannelClip.setInputPlace(inputPlace);
        this.channelTable.refresh();
    }
    
    /**
     * Show selected channel content to Ui
     */
    private void UpdateSelectedChannelContent () {
    	int index = this.channelTable.getSelectionModel().getSelectedIndex();
    	if (index != -1 ) {
    		this.selectedChannelClip = data.getOriginalChannelClip().get(index);
    		this.channeId.setText(selectedChannelClip.getId());
    		this.channelName.setText(selectedChannelClip.getName());
                this.sensorFrom.getSelectionModel().select(
                        this.selectedChannelClip.getOutputPlace());
                this.sensorTo.getSelectionModel().select(
                        this.selectedChannelClip.getInputPlace());
    	}
    }
    
    /**
     * Update ui for text field if sensor type is source
     * Sensor type is source open the text field
     * Sink or intermediate disable the text field
     */
    private void UpdateUIFromActionOFComboboxTypeSensor () {
    	String item = this.typeSensor.getSelectionModel().getSelectedItem();
    	if (item == null) {
    		return ;
    	}
    	if(item.equals(SensorType.SOURCE)) {
    		this.tokenSensor.setEditable(true);
    	}else {
    		this.tokenSensor.setEditable(false);
    	}
    }
    
    /**
     * Apply sensor information change and show it to UI
     */
    private void ApplyDataFromUItoSensor () {
    	String sensorType = this.typeSensor.getSelectionModel().getSelectedItem();
    	if(sensorType.equals(SensorType.SOURCE)) {
    		selectedSensorClip.setSensorType(1);
    	} else if (sensorType.equals(SensorType.SINK)) {
    		selectedSensorClip.setSensorType(2);
    	} else {
    		selectedSensorClip.setSensorType(3);
    	}
    	
    	try {
    		int token = Integer.parseInt(this.tokenSensor.getText());
    		float energy = Float.parseFloat(this.energySensor.getText());
    		selectedSensorClip.setToken(token);
    		selectedSensorClip.setEnergy(energy);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	this.sensorTable.refresh();
    }
    
    /**
     * Initialize sensor table data
     */
    private void InitSensorTableData () {
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
    
    /**
     * Initialize channel table data
     */
    private void InitChannelTableData () {
    	
    	this.channelTable.setItems(data.getChannelClip());
    	this.channelIdCol.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getId()));
    	this.channelNameCol.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getName()));
    	this.sensorFromCol.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getOutputPlace().getId()));
    	this.sensorToCol.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getInputPlace().getId()));
    	
    	this.channelIdCol.setSortable(false);
    	this.channelNameCol.setSortable(false);
    	this.sensorFromCol.setSortable(false);
    	this.sensorToCol.setSortable(false);
    }
    
    private void InitComboboxData () {
    	//Init sensor type combobox
    	this.typeSensor.setItems(FXCollections.observableArrayList(SensorType.SOURCE,SensorType.SINK,SensorType.INTERMEDIATE));
    	
    	this.sensorFrom.setItems(data.getSensorClip());
    	this.sensorFrom.setConverter(new StringConverter<Clip>() {
			
			@Override
			public String toString(Clip object) {
				// TODO Auto-generated method stub
				return object.getId();
			}
			
			@Override
			public Clip fromString(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		});
    	
    	this.sensorTo.setItems(data.getSensorClip());
    	this.sensorTo.setConverter(new StringConverter<Clip>() {
			
			@Override
			public String toString(Clip object) {
				// TODO Auto-generated method stub
				return object.getId();
			}
			
			@Override
			public Clip fromString(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		});
    }
    
    /**
     * Set up default content for text field . Example is sensor sending rate , processing rate sensor energy
     */
    private void InitCommonContent () {
    	this.minSensorSendingRate.setText(this.data.getMinSensorSendingRate());
    	this.minSensorProcessingRate.setText(this.data.getMinSensorProcessingRate());
    	this.minChannelSendingRate.setText(this.data.getMinChannelSendingRate());
    	this.maxSensorSendingRate.setText(this.data.getMaxSensorSendingRate());
    	this.maxSensorProcessingRate.setText(this.data.getMaxSensorProcessingRate());
    	this.maxChannelSendingRate.setText(this.data.getMaxChannelSendingRate());
    	this.numberOfPackage.setText(this.data.getNumberOfPackage());
    	this.sensorMaxbufferSize.setText(this.data.getSensorMaxBufferSize());
    	this.sensorMaxQueueSize.setText(this.data.getSensorMaxQueueSize());
    	this.channelMaxBufferSize.setText(this.data.getChannelMaxBufferSize());
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
    	this.data.setSensorMaxBufferSize(this.sensorMaxbufferSize.getText());
    	this.data.setSensorMaxQueueSize(this.sensorMaxQueueSize.getText());
    	this.data.setChannelMaxBufferSize(this.channelMaxBufferSize.getText());
    }
    
    /* Numeric Validation Limit the  characters to maxLengh AND to ONLY DigitS *************************************/
    private EventHandler<KeyEvent> numeric_Validation(final Integer max_Lengh) {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                TextField txt_TextField = (TextField) e.getSource();                
                if (txt_TextField.getText().length() >= max_Lengh) {                    
                    e.consume();
                }
                if(e.getCharacter().matches("[0-9.]")){ 
                    if(txt_TextField.getText().contains(".") && e.getCharacter().matches("[.]")){
                        e.consume();
                    }else if(txt_TextField.getText().length() == 0 && e.getCharacter().matches("[.]")){
                        e.consume(); 
                    }
                }else{
                    e.consume();
                }
            }
        };
    }    
    
}
