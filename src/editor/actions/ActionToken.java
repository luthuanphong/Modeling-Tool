package editor.actions;

import editor.views.EditorRun;
import editor.views.EditorWindow;
import javafx.event.ActionEvent;

public class ActionToken implements Action {
	private EditorWindow editor;

	public ActionToken(EditorWindow editor) {
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//editor.setTool(new ToolToken());
		new EditorRun(this.editor.getData()).Show();
	}
}
