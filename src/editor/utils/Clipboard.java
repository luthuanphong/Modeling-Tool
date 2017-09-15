package editor.utils;

import java.util.ArrayList;
import java.util.List;

import editor.canvas.Clip;

public class Clipboard {
	private List<Clip> copies = new ArrayList<Clip>();
	private List<ClipboardListener> cibles = new ArrayList<ClipboardListener>();
	private static Clipboard clip = new Clipboard();

	public static Clipboard getInstance() {
		return clip;
	}

	public void copyToClipboard(List<Clip> clips) {
		clear();
		for (Clip c : clips) {
			if (!copies.contains(c))
				copies.add(c.copy());
		}
		if (!isEmpty())
			for (ClipboardListener cl : cibles)
				cl.clipboardChanged();
	}

	public List<Clip> copyFromClipboard() {
		List<Clip> tmp = new ArrayList<Clip>();
		for (Clip c : copies) {
			tmp.add(c.copy());
		}
		return tmp;
	}

	public void clear() {
		copies.clear();
	}

	public boolean isEmpty() {
		return copies.isEmpty();
	}

	public void addListener(ClipboardListener listener) {
		cibles.add(listener);
	}

	public void removeListener(ClipboardListener listener) {
		cibles.remove(listener);
	}
}
