package editor.canvas;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;

public class Board {
	private List<Clip> clips = new ArrayList<Clip>();
        private List<Clip> placeClips = new ArrayList<Clip>();
        private List<Clip> arcClips = new ArrayList<Clip>();

	public List<Clip> getClips() {
		return clips;
	}
        
        public List<Clip> getPlaceClip(){
            return placeClips;
        }
        
        public List<Clip> getArcClip(){
            return arcClips;
        }

	public void addClip(Clip toAdd) {
		clips.add(toAdd);
                switch(toAdd.getType()){
                    case Place:
                        placeClips.add(toAdd);
                        break;
                    case Arc:
                        arcClips.add(toAdd);
                        break;
                }
	}

	public void removeClip(Clip toRemove) {	
		clips.remove(toRemove);
	}

	public void addClip(List<Clip> toAdd) {
		clips.addAll(toAdd);
	}

	public void removeClip(List<Clip> toRemove) {
		clips.removeAll(toRemove);
	}
	
	public void clear() {
		clips.clear();
	}

	public void draw(GraphicsContext ctx) {
		ctx.setFill(Colors.BOARD);
		ctx.fillRect(0, 0, ctx.getCanvas().getWidth(), ctx.getCanvas().getHeight());		
		clips.forEach(clip -> clip.draw(ctx));
	}
}
