package editor.utils;

import java.util.ArrayList;
import java.util.List;

import editor.canvas.Board;
import editor.canvas.Clip;
import editor.canvas.ClipPlace;
import editor.canvas.ClipTransition;
import editor.canvas.Colors;
import javafx.scene.canvas.GraphicsContext;

public class Selection {
	private List<Clip> selections = new ArrayList<Clip>();
	
	public void select(Board board, double x, double y) {
		clear();
		for (Clip c : board.getClips()) {
			if (c.isSelected(x, y)) {		
				selections.add(c);
				break;
			}
		}
	}

	public void multiSelect(Board board, double x, double y) {		
		for (Clip c : board.getClips()) {
			if (c.isSelected(x, y)) {
				if (selections.contains(c)) {
					selections.remove(c);
				} else {
					selections.add(c);
				}
				break;
			}
		}
	}

	public void fullSelect(Board board) {
		for (Clip c : board.getClips()) {
			selections.add(c);
		}
	}

	public void clear() {
		selections.clear();
	}

	public List<Clip> getClips() {
		return selections;
	}

	public void drawFeedback(GraphicsContext ctx) {
		ctx.setStroke(Colors.SELECTED);
		for (Clip c : selections) {
			if (c instanceof ClipTransition) {
				ctx.strokeRect(c.getStart().getX(), c.getStart().getY(), c.getWidth() - 1, c.getHeight() - 1);
			}
			if (c instanceof ClipPlace) {
				ctx.strokeOval(c.getStart().getX(), c.getStart().getY(), c.getWidth() - 1, c.getHeight() - 1);
			}
		}
	}
}
