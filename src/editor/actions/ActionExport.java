package editor.actions;

import editor.views.EditorWindow;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class ActionExport implements Action {
	private EditorWindow editor;

	public ActionExport(EditorWindow editor) {
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new EditorWindow(new Stage());
	}
}
