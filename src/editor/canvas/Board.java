package editor.canvas;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;

public class Board {
	private final List<Clip> clips = new ArrayList<>();
        private final List<Clip> placeClips = new ArrayList<>();
        private final List<Clip> arcClips = new ArrayList<>();
        private final ObservableList<Clip> sensorClip = FXCollections.observableArrayList();
        private final ObservableList<Clip> channelClip = FXCollections.observableArrayList();

	public List<Clip> getClips() {
		List<Clip> temp = new ArrayList<>();
		temp.addAll(arcClips);
		temp.addAll(placeClips);
		return temp;
	}
        
    public List<Clip> getPlaceClip(){
    	return placeClips;
    }
        
    public List<Clip> getArcClip(){
        return arcClips;
    }
    
    public ObservableList<Clip> getSensorClip () {
    	return this.sensorClip;
    }
    
    public ObservableList<Clip> getChannelClip () {
    	return this.channelClip;
    }

	public void addClip(Clip toAdd) {
		clips.add(toAdd);
                switch(toAdd.getType()){
                    case Place:
                        placeClips.add(toAdd);
                        sensorClip.add(toAdd);
                        break;
                    case Arc:
                        arcClips.add(toAdd);
                        channelClip.add(toAdd);
                        break;
                    default:
			break;
                }
	}

	public void removeClip(Clip toRemove) {	
		clips.remove(toRemove);
		switch (toRemove.getType()) {
		case Place:
			placeClips.remove(toRemove);
			sensorClip.remove(toRemove);
			break;
		case Arc:
			arcClips.remove(toRemove);
			channelClip.remove(toRemove);
			break;
		default:
			break;
		}
	}

	public void addClip(List<Clip> toAdd) {
		clips.addAll(toAdd);
	}

	public void removeClip(List<Clip> toRemove) {
		clips.removeAll(toRemove);
                for(Clip c : toRemove){
                    switch(c.getType()){
                        case Place :
                            placeClips.remove(c);
                            sensorClip.remove(c);
                            break;
                        case Arc:
                            arcClips.remove(c);
                            channelClip.remove(c);
                            break;
                        default :
                            break;
                    }
                }
	}
	
	public void clear() {
		clips.clear();
        arcClips.clear();
        placeClips.clear();
        sensorClip.clear();
        channelClip.clear();
	}

	public void draw(GraphicsContext ctx) {
		ctx.setFill(Colors.BOARD);
		ctx.fillRect(0, 0, ctx.getCanvas().getWidth(), ctx.getCanvas().getHeight());		
		//clips.forEach(clip -> clip.draw(ctx));
		arcClips.forEach(clip -> clip.draw(ctx));
		placeClips.forEach(clip -> clip.draw(ctx));
	}
}
