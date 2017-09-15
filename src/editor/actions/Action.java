package editor.actions;

import javafx.event.ActionEvent;

public interface Action {
	default public void actionPerformed(ActionEvent e) {
	};
}
