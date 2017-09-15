package editor.actions;

import editor.utils.Clipboard;
import editor.views.EditorWindow;
import javafx.event.ActionEvent;

public class ActionPaste implements Action {
	private EditorWindow editor;

	public ActionPaste(EditorWindow editor) {
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		editor.getBoard().addClip(Clipboard.getInstance().copyFromClipboard());
		editor.updateBoard();
	}
}
