package editor.views;

import java.io.IOException;

import editor.utils.BackgroundCallBack;
import editor.utils.BackgroundRunner;
import editor.utils.Verify;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class EditorAnaly extends Dialog<Object> implements BackgroundCallBack {
	
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
	@FXML
	private TextArea result;
	
	private BackgroundRunner analyzer;	
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
				if(EditorAnaly.this.analyzer != null) {
					EditorAnaly.this.analyzer.stop();
					EditorAnaly.this.analyzer = null;
				}
				EditorAnaly.this.window.hide();
				EditorAnaly.this.close();
			}
		});
		this.cancel.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(EditorAnaly.this.analyzer != null) {
					EditorAnaly.this.analyzer.stop();
					EditorAnaly.this.analyzer = null;
				}
				EditorAnaly.this.window.hide();
				EditorAnaly.this.close();
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
			Analyze();
			break;
		default:
			break;
		}
	}
	
	private void Analyze () {
		analyzer = new BackgroundRunner(this);
		analyzer.start();
	}

	@Override
	public void TransferSignal(String value) {
		// TODO Auto-generated method stub		
		this.result.setText(value);
	}

	@Override
	public void UpdateProgressStatus() {
		// TODO Auto-generated method stub
		this.progress.setProgress(1.0f);
	}

	@Override
	public void UpdateButton() {
		// TODO Auto-generated method stub
		this.cancel.setText("OK");
	}

}
