package editor.views;

import java.io.IOException;

import editor.utils.InitializeData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import Converter.Converter;
import Converter.UnicastConverter;
import Converter.BroadcastConverter;
public class EditorRun extends Dialog<Object> {

	private InitializeData data;
	@FXML
	private AnchorPane root;
	@FXML
	private RadioButton unicast;
	@FXML
	private RadioButton broadcast;
	@FXML
	private Button run;
	
	private ToggleGroup buttonGroup;
	
	private FXMLLoader load;
	
	private Converter converter;
	
	public EditorRun (InitializeData data) {
		this.data = data;
		load = new FXMLLoader();
		load.setLocation(getClass().getResource("/res/Fxml/run.fxml"));
		load.setRoot(root);
		load.setController(this);
		try {
			load.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.buttonGroup = new ToggleGroup();
		this.initEvent();
	}
	
	public void Show() {
		this.getDialogPane().setContent(this.load.getRoot());
		this.show();
	}
	
	private void initEvent () {
		this.unicast.setToggleGroup(this.buttonGroup);
		this.broadcast.setToggleGroup(this.buttonGroup);
		this.unicast.setSelected(true);
		this.run.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				EditorRun.this.Run();
			}
		});
		this.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
	}
	
	private void Run() {
		if(this.unicast.isSelected()) {
			this.converter = new UnicastConverter(this.data.getTopologyData());
		} else {
			this.converter = new BroadcastConverter(this.data.getTopologyData());
		}
		this.converter.outputPnmlFile("C:\\Users\\FredLu\\Desktop\\");
		this.converter.outputProcessFile("C:\\Users\\FredLu\\Desktop\\");
		this.converter.outputMinimizeProcessFile("C:\\Users\\FredLu\\Desktop\\");
	}
}
