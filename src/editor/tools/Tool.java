package editor.tools;

import editor.commands.Command;
import editor.utils.EditorInterface;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public interface Tool {
	default public Command press(EditorInterface i, MouseEvent e) {
		return null;
	}

	default public void drag(EditorInterface i, MouseEvent e) {
	};

	default public Command release(EditorInterface i, MouseEvent e) {
		return null;
	}

	default public void move(EditorInterface i, MouseEvent e) {
	}

	default public void drawFeedback(EditorInterface i, GraphicsContext ctx) {
	};
}
