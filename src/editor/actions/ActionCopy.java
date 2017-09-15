package editor.actions;

import editor.utils.Clipboard;
import editor.views.EditorWindow;
import javafx.event.ActionEvent;

public class ActionCopy implements Action {
	private EditorWindow editor;

	public ActionCopy(EditorWindow editor) {
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Clipboard.getInstance().copyToClipboard(editor.getSelection().getClips());
	}
}
