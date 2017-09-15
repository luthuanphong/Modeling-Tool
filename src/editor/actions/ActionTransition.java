package editor.actions;

import editor.tools.ToolTransition;
import editor.views.EditorWindow;
import javafx.event.ActionEvent;

public class ActionTransition implements Action {
	private EditorWindow editor;

	public ActionTransition(EditorWindow editor) {
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		editor.setTool(new ToolTransition());
	}
}
