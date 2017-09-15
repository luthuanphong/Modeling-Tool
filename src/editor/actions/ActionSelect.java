package editor.actions;

import editor.tools.ToolSelect;
import editor.views.EditorWindow;
import javafx.event.ActionEvent;

public class ActionSelect implements Action {
	private EditorWindow editor;
	
	public ActionSelect(EditorWindow editor) {
		this.editor = editor;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		editor.setTool(new ToolSelect());
	}
}
