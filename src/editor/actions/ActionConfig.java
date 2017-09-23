package editor.actions;

import editor.views.EditorConfig;
import editor.views.EditorWindow;
import javafx.event.ActionEvent;

public class ActionConfig implements Action {
	
	private EditorWindow editor;
	private static EditorConfig config = new EditorConfig();
	
	public ActionConfig(EditorWindow editor) {
		this.editor = editor;
		config.setEditor(editor);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//new EditorConfig(this.editor.getData(),this.editor).Show();
		config.Show();
	}
}
