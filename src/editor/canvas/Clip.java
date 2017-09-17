package editor.canvas;

import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public interface Clip {
	// Drawing
	public void draw(GraphicsContext ctx);

	default public void drawState(GraphicsContext ctx) {
		ctx.setStroke(Colors.NETBORDCOLOR);
		if (hasSelected() == true) {
			ctx.setStroke(Colors.SELECTED);
		} else if (hasHovered() == true) {
			ctx.setStroke(Colors.POINTING);
		}
	}

	// Infos
	public String getLabel();
	
	public void setLabel(String label);
	
	public String getId();
	
	default public void decrementId() {		
	}
	
	// Geometry
	public Point2D getStart();

	public Point2D getEnd();
	
	public Point2D getCenter();

	public void setStart(double x, double y);

	public void setEnd(double x, double y);

	default public void setStart(Point2D start) {
		setStart(start.getX(), start.getY());
	}

	default public void setEnd(Point2D end) {
		setEnd(end.getX(), end.getY());
	}

	default public void setCenter(double x, double y) {
		move(x - getCenter().getX(), y - getCenter().getY());
	}

	default public void setCenter(Point2D center) {
		setCenter(center.getX(), center.getY());
	}

	default public double getCenterX() {
		return (getStart().getX() + getEnd().getX()) / 2;
	}

	default public double getCenterY() {
		return (getStart().getY() + getEnd().getY()) / 2;
	}
	
	default public double getWidth() {
		return Math.abs(getEnd().getX() - getStart().getX());
	}

	default public double getHeight() {
		return Math.abs(getEnd().getY() - getStart().getY());
	}
	
	default public void setSize(double width, double height) {
		Point2D clipCenter = getCenter();
		setEnd(getStart().getX() + width, getStart().getY() + height);
		setCenter(clipCenter.getX(), clipCenter.getY());
	}

	default public void move(double dx, double dy) {
		setStart(getStart().getX() + dx, getStart().getY() + dy);
		setEnd(getEnd().getX() + dx, getEnd().getY() + dy);
	}

	default public boolean isSelected(double x, double y) {
		double left = Math.min(getStart().getX(), getEnd().getX());
		double top = Math.min(getStart().getY(), getEnd().getY());
		double right = left + getWidth();
		double bottom = top + getHeight();
		return (x >= left && x <= right) && (y >= top && y <= bottom);
	}

	// State
	public boolean hasSelected();

	public void setSelected(boolean selected);

	public boolean hasHovered();

	public void setHovered(boolean hovered);
	
	default public void toggleState(String state) {
		switch (state) {
		case "Selected":
			setSelected(true);
			setHovered(false);
			break;
		case "Pointed":
			setSelected(false);
			setHovered(true);
			break;
		case "Normal":
			setSelected(false);
			setHovered(false);
		}
	}
        
	// Colors
	public void setColor(Color color);

	public Color getColor();

	// Cloning
	public Clip copy();
        
    public ClipType getType();
        
    public void setType(ClipType type);
        
    public List<Clip> getInputArc();
        
    public List<Clip> getOutArc();
        
    public Point2D getInputPoint();
        
    public Point2D getOutPoint();
    
    public Clip getInputPlace();
    
    public Clip getOutputPlace();
    
    public void setInputPlace(Clip inputPlace);
    
    public void setOutputPlace(Clip outputPlace);
}
