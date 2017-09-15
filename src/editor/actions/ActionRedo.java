package editor.actions;

import editor.commands.CommandStack;
import editor.views.EditorWindow;
import javafx.event.ActionEvent;

public class ActionRedo implements Action {
	private EditorWindow editor;

	public ActionRedo(EditorWindow editor) {
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CommandStack stack = editor.getCommandStack();
		if (!stack.isRedoEmpty()) {
			stack.redo();
			editor.updateBoard();
		}	
	}
}
