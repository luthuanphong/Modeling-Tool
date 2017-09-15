package editor.actions;

import editor.commands.CommandStack;
import editor.views.EditorWindow;
import javafx.event.ActionEvent;

public class ActionUndo implements Action {
	private EditorWindow editor;

	public ActionUndo(EditorWindow editor) {
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CommandStack stack = editor.getCommandStack();
		if (!stack.isUndoEmpty()) {
			stack.undo();
			editor.updateBoard();
		}	
	}
}
