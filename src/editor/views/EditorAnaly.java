package editor.views;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class EditorAnaly extends Dialog<Object> {
	
	private Window window;
	private FXMLLoader loader;
	@FXML
	private AnchorPane root;
	@FXML
	private Label status;
	@FXML
	private ProgressBar progress;
	@FXML
	private Button cancel;
	
	public EditorAnaly () {
		loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/res/Fxml/analyze.fxml"));
		loader.setRoot(root);
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.window = this.getDialogPane().getScene().getWindow();
		this.window.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				EditorAnaly.this.window.hide();
			}
		});
	}
	
	public void Show() {
		this.getDialogPane().setContent(this.loader.getRoot());
		this.show();
		this.progress.setProgress(-1.0f);
	}
	
	public void setStatus (int statusCode) {
		switch (statusCode) {
		case 0:		
			this.status.setText("Create data...");
			break;
		case 1:
			this.status.setText("Analyzing...");
			break;
		default:
			break;
		}
	}
	
	private void Analyze () {
		
	}

}
