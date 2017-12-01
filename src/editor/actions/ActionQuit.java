package editor.actions;

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
		this.editor.uniqueId.set(1);
		this.editor.getStage().close();
	}
}
