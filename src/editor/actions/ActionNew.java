package editor.actions;

import editor.views.EditorWindow;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

public class ActionNew implements Action {	
	private EditorWindow editor;

	public ActionNew(EditorWindow editor) {
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (userChoice() == ButtonType.OK) {
			new EditorWindow(new Stage());
			new ActionQuit(editor).actionPerformed(e);
		} else {
			new EditorWindow(new Stage());
			new ActionQuit(editor).actionPerformed(e);
		}
	}

	private ButtonType userChoice() {
		ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
		ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

		DialogPane dialogPane = new FixedOrderButton();
		dialogPane.getButtonTypes().setAll(yes, no);
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
