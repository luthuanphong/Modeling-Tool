package editor.actions;

import editor.views.EditorWindow;
import javafx.event.ActionEvent;

public class ActionZoomOut implements Action {
	
	private EditorWindow editor;
	
	public ActionZoomOut(EditorWindow editor) {
		// TODO Auto-generated constructor stub
		this.editor = editor;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.editor.ZoomOut();
	}
}
