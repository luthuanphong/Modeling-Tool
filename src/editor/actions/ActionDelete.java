package editor.actions;

import editor.views.EditorWindow;
import javafx.event.ActionEvent;

public class ActionDelete implements Action {
	private EditorWindow editor;

	public ActionDelete(EditorWindow editor) {
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		editor.getBoard().removeClip(editor.getSelection().getClips());
		editor.updateBoard();
	}
}
