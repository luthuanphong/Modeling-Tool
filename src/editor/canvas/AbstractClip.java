package editor.canvas;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public abstract class AbstractClip implements Clip {
	
	private Point2D start, end, center,input,output;
	private Color color = Colors.NETBORDCOLOR;
	private boolean selected = false, hovered = false;
	private String label, id;
        private ClipType type;
        private List<Clip> inputArc;
        private List<Clip> outputArc;

	public AbstractClip() {
	}

	public AbstractClip(Point2D start, Point2D end) {
		setStart(start);
		setEnd(end);
	}

	public AbstractClip(Point2D center) {
		setCenter(center);
		setSize(32, 32);
                inputArc = new ArrayList<>();
                outputArc = new ArrayList<>();
                
	}

	@Override
	public String getLabel() {
		return label;
	}
	
	@Override
	public void setLabel(String label) {
		this.label = label;
	}
	
	@Override
	public String getId() {
		return this.id;
	}
	
	@Override
	public Point2D getStart() {
		if (start == null) {
			start = Point2D.ZERO;
		}
		return start;
	}

	@Override
	public Point2D getEnd() {
		if (end == null) {
			end = Point2D.ZERO;
		}
		return end;
	}

	@Override
	public void setStart(double x, double y) {          
		start = new Point2D(x, y);                
	}

	@Override
	public void setEnd(double x, double y) {
		end = new Point2D(x, y);
	}

	@Override
	public Point2D getCenter() {
		if (center == null) {
			center = Point2D.ZERO;
		}
		if (center.getX() != getCenterX() || center.getY() != getCenterY()) {
			center = new Point2D(getCenterX(), getCenterY());
		}
		return center;
	}

	@Override
	public boolean hasSelected() {
		return this.selected;
	}

	@Override
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Override
	public boolean hasHovered() {
		return this.hovered;
	}

	@Override
	public void setHovered(boolean hovered) {
		this.hovered = hovered;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

    @Override
    public ClipType getType() {
        return this.type;
    }

    @Override
    public void setType(ClipType type) {
        this.type = type;
    }

    @Override
    public List<Clip> getInputArc() {
        return this.inputArc;
    }

    @Override
    public List<Clip> getOutArc() {
        return this.outputArc;
    }

    @Override
    public Point2D getInputPoint() {
        return new Point2D(getCenterX() - getWidth()/2, getCenterY());
    }

    @Override
    public Point2D getOutPoint() {
        return new Point2D(getCenterX() + getWidth()/2, getCenterY());
    }
    
}
