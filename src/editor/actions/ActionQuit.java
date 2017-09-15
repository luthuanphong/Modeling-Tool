package editor.actions;

import editor.EditorMain;
import editor.utils.Clipboard;
import editor.views.EditorWindow;
import javafx.event.ActionEvent;

public class ActionQuit implements Action {
	private EditorWindow editor;
	
	public ActionQuit(EditorWindow editor) {
		this.editor = editor;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Clipboard.getInstance().removeListener(editor);
		EditorMain.getStage().close();
	}
}
