package editor.utils;

import editor.canvas.Board;
import editor.canvas.Clip;
import java.util.List;

public interface EditorInterface {
	public Board getBoard();
	public Selection getSelection();
        public List<Clip> getPlaceClip();
}
