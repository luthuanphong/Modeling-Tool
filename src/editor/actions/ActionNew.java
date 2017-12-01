package editor.actions;

import java.io.File;

import editor.utils.DataExport;
import editor.views.EditorWindow;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class ActionNew implements Action {	
	private EditorWindow editor;
	private FileChooser choser;
	
	public ActionNew(EditorWindow editor) {
		this.editor = editor;
		this.choser = new FileChooser();
		this.choser.getExtensionFilters().add(new ExtensionFilter("Topology files", "*.topo"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ButtonType type = userChoice();
		if (type == ButtonType.YES) {
			File selectedFilePath = this.choser.showSaveDialog(this.editor.getStage());
			if(selectedFilePath != null) {
			DataExport.Export(selectedFilePath.getAbsolutePath(),
					this.editor.getBoard().getPlaceClip(), 
					this.editor.getBoard().getArcClip(),
					this.editor);
			}
		}
		
		new EditorWindow(new Stage());
		new ActionQuit(editor).actionPerformed(e);
	
	}

	private ButtonType userChoice() {
		DialogPane dialogPane = new FixedOrderButton();
		dialogPane.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
		dialogPane.setContentText("Do you want to save this session?");

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Open New File Confirmation");
		alert.setDialogPane(dialogPane);

		return alert.showAndWait().get();
	}

	private static class FixedOrderButton extends DialogPane {
		@Override
		protected Node createButtonBar() {
			ButtonBar buttonBar = (ButtonBar) super.createButtonBar();
			buttonBar.setButtonOrder(ButtonBar.BUTTON_ORDER_NONE);
			return buttonBar;
		}
	}
}
