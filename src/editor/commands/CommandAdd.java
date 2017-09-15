package editor.commands;

import java.util.List;

import editor.canvas.Clip;
import editor.utils.EditorInterface;

public class CommandAdd implements Command {

	private EditorInterface editor;
	private List<Clip> toAdd;

	public CommandAdd(EditorInterface editor, List<Clip> toAdd) {
		this.editor = editor;
		this.toAdd = toAdd;
	}

	@Override
	public void execute() {
		toAdd.forEach(c -> editor.getBoard().addClip(c));
	}

	@Override
	public void undo() {
		toAdd.forEach(c -> editor.getBoard().removeClip(c));
	}

}
