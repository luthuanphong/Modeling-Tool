package editor.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandStack {

	private List<Command> undo = new ArrayList<Command>();
	private List<Command> redo = new ArrayList<Command>();
	
	public void addCommand(Command command) {
		undo.add(command);
		redo.clear();
	}
	
	public void undo() {
		Command command = undo.remove(undo.size() - 1);
		command.undo();
		redo.add(command);
	}

	public void redo() {
		Command command = redo.remove(redo.size() - 1);
		command.execute();
		undo.add(command);
	}
	
	public boolean isUndoEmpty() {
		return undo.isEmpty();
	}

	public boolean isRedoEmpty() {
		return redo.isEmpty();
	}
}
