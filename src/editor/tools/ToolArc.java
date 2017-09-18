package editor.tools;

import editor.canvas.Clip;
import editor.canvas.ClipArc;
import editor.commands.Command;
import editor.commands.CommandAdd;
import editor.utils.EditorInterface;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

public class ToolArc implements Tool {
    
    private List<Point2D> arcPos;
    private Clip outputedClip;
    private Clip inputedClip;
    
    public ToolArc(){
        arcPos = new ArrayList<>();
    }
    
    @Override
    public Command press(EditorInterface i, MouseEvent e) {
        List<Clip> arc = new ArrayList<Clip>();
        Clip selectClip = getSelectedClip(i.getPlaceClip(), e.getX(), e.getY());
        if(selectClip != null){
            if (arcPos.isEmpty()) {
                arcPos.add(new Point2D(selectClip.getCenterX(),
                        selectClip.getCenterY()));
                outputedClip = selectClip;
            } else if (arcPos.size() == 1) {
                arcPos.add(new Point2D(selectClip.getCenterX(),
                        selectClip.getCenterY()));
                inputedClip = selectClip;
                ClipArc clip = new ClipArc(arcPos.get(0), arcPos.get(1));
                clip.setInputPlace(inputedClip);
                clip.setOutputPlace(outputedClip);
                arc.add(clip);
                outputedClip.getOutArc().add(clip);
                inputedClip.getInputArc().add(clip);
                arcPos.clear();
            }
        }
        Command command = new CommandAdd(i,arc);
        return command;
    } 
    
    private Clip getSelectedClip(List<Clip> place,double x,double y){
        for(Clip c : place){
            if(c.getStart().getX() <= x &&
                    x <= c.getEnd().getX() &&
                    c.getStart().getY() <= y && 
                    y <= c.getEnd().getY() ){
                return c;
            }
        }
        return null;
    }
}
