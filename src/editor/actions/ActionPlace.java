package editor.actions;

import editor.tools.ToolPlace;
import editor.views.EditorWindow;
import javafx.event.ActionEvent;

public class ActionPlace implements Action {
	private EditorWindow editor;
	
	public ActionPlace(EditorWindow editor) {
		this.editor = editor;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		editor.setTool(new ToolPlace());
	}
}
