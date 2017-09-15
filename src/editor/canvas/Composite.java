package editor.canvas;

import java.util.List;

public interface Composite extends Clip {
	public List<Clip> getClips();

	public void addClip(Clip toAdd);

	public void removeClip(Clip toRemove);
}
