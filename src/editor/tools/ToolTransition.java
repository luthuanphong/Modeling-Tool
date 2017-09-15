package editor.tools;

import java.util.ArrayList;
import java.util.List;

import editor.canvas.Clip;
import editor.canvas.ClipTransition;
import editor.commands.Command;
import editor.commands.CommandAdd;
import editor.utils.EditorInterface;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

public class ToolTransition implements Tool {

	@Override
	public Command press(EditorInterface i, MouseEvent e) {
		List<Clip> tmp = new ArrayList<Clip>();
		Point2D center = new Point2D(e.getX(), e.getY());

		tmp.add(new ClipTransition(center));
		Command command = new CommandAdd(i, tmp);

		return command;
	}

}
