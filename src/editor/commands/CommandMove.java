package editor.commands;

import java.util.List;

import editor.canvas.Clip;
import editor.canvas.ClipType;
import editor.utils.EditorInterface;

public class CommandMove implements Command {

	private EditorInterface editor;
	private double x, y, ex, ey;
	private List<Double> left, top, right, bottom;
		
	public CommandMove(EditorInterface editor, double x, double y, double ex, double ey, List<Double> left,
			List<Double> top, List<Double> right, List<Double> bottom) {		
		this.editor = editor;
		this.x = x;
		this.y = y;
		this.ex = ex;
		this.ey = ey;
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}

	@Override
	public void execute() {
		List<Clip> clips = editor.getSelection().getClips();
		for (int i = 0; i < clips.size(); i++) {
                    if(clips.get(i).getType() == ClipType.Place){
			clips.get(i).setStart(ex - left.get(i), ey - top.get(i));
			clips.get(i).setEnd(ex + right.get(i), ey + bottom.get(i));
                        
                        for(Clip c : clips.get(i).getInputArc()){
                            //c.setEnd(clips.get(i).getInputPoint().getX(),
                                   // clips.get(i).getInputPoint().getY());
                        	c.setEnd(clips.get(i).getCenterX(),clips.get(i).getCenterY());
                        }
                        
                        for(Clip c : clips.get(i).getOutArc()){
                            //c.setStart(clips.get(i).getOutPoint().getX(),
                                    //clips.get(i).getOutPoint().getY());
                        	c.setStart(clips.get(i).getCenterX(),clips.get(i).getCenterY());
                        }
                    }else if(clips.get(i).getType() == ClipType.Transition){
                        
                    }
		}
	}

	@Override
	public void undo() {
		List<Clip> clips = editor.getSelection().getClips();
		for (int i = 0; i < clips.size(); i++) {
			clips.get(i).setStart(x - left.get(i), y - top.get(i));
			clips.get(i).setEnd(x + right.get(i), y + bottom.get(i));
		}
	}

}
