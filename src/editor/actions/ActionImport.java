package editor.actions;

import editor.views.EditorWindow;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class ActionImport implements Action {
private EditorWindow editor;
	
	public ActionImport(EditorWindow editor) {
		this.editor = editor;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new EditorWindow(new Stage());
	}
}
