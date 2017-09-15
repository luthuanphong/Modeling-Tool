package editor.actions;

import editor.tools.ToolArc;
import editor.views.EditorWindow;
import javafx.event.ActionEvent;

public class ActionArc implements Action {
	private EditorWindow editor;

	public ActionArc(EditorWindow editor) {
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		editor.setTool(new ToolArc());
	}
}
