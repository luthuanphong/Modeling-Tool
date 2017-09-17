package editor.tools;

import java.util.ArrayList;
import java.util.List;

import editor.canvas.Clip;
import editor.canvas.ClipType;
import editor.commands.Command;
import editor.commands.CommandMove;
import editor.utils.EditorInterface;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class ToolSelect implements Tool {

	// Offset
	protected List<Double> left = new ArrayList<Double>(), top = new ArrayList<Double>(),
			right = new ArrayList<Double>(), bottom = new ArrayList<Double>();
	protected double start_x, start_y;

	@Override
	public Command press(EditorInterface i, MouseEvent e) {
		start_x = e.getX();
		start_y = e.getY();
		if (e.isControlDown()) {
			i.getSelection().fullSelect(i.getBoard());
		} else {
			i.getSelection().select(i.getBoard(), start_x, start_y);
		}
		clear();
		for (Clip c : i.getSelection().getClips()) {
			if(c.getType() != ClipType.Arc) {
				left.add(start_x - c.getStart().getX());
				top.add(start_y - c.getStart().getY());
				right.add(c.getEnd().getX() - start_x);
				bottom.add(c.getEnd().getY() - start_y);
			}
		}
		return null;
	}

	@Override
	public void drag(EditorInterface i, MouseEvent e) {
		List<Clip> clips = i.getSelection().getClips();
		for (int index = 0; index < clips.size(); index++) {
			if(clips.get(index).getType() != ClipType.Arc) {
				clips.get(index).setStart(e.getX() - left.get(index), e.getY() - top.get(index));
				clips.get(index).setEnd(e.getX() + right.get(index), e.getY() + bottom.get(index));
			}
		}
	}

	@Override
	public Command release(EditorInterface i, MouseEvent e) {
		if (start_x == e.getX() && start_y == e.getY())
			return null;
		Command command = new CommandMove(i, start_x, start_y, e.getX(), e.getY(), left, top, right, bottom);
		return command;
	}

	@Override
	public void drawFeedback(EditorInterface i, GraphicsContext ctx) {
		i.getBoard().draw(ctx);
		i.getSelection().drawFeedback(ctx);
	}

	private void clear() {
		left.clear();
		top.clear();
		right.clear();
		bottom.clear();
	}
}