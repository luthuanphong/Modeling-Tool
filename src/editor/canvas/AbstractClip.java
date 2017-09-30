package editor.canvas;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public abstract class AbstractClip implements Clip {
	
	private Point2D start, end, center;
	private Color color = Colors.NETBORDCOLOR;
	private boolean selected = false, hovered = false;
    private ClipType type;
    private List<Clip> inputArc;
    private List<Clip> outputArc;
    private Clip inputPlace;
    private Clip outputPlace;
    protected String label, id;
    protected int sensorType = 3;
    private float energy = 100.0f;
    private int Token = 0;

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
    
    @Override
    public Clip getInputPlace() {
    	// TODO Auto-generated method stub
    	return this.inputPlace;
    }
    
    @Override
    public Clip getOutputPlace() {
    	// TODO Auto-generated method stub
    	return this.outputPlace;
    }
    
    @Override
    public void setInputPlace(Clip inputPlace) {
    	// TODO Auto-generated method stub
    	this.inputPlace = inputPlace;
        this.setEnd(this.inputPlace.getCenterX(), this.inputPlace.getCenterY());
    }
    
    @Override
    public void setOutputPlace(Clip outputPlace) {
    	// TODO Auto-generated method stub
    	this.outputPlace = outputPlace;
        this.setStart(this.outputPlace.getCenterX(), this.outputPlace.getCenterY());
    }
    
    @Override
    public void setName(String value) {
    	// TODO Auto-generated method stub
    	this.id = value;
    }
    
    @Override
    public String getName() {
    	// TODO Auto-generated method stub
    	return this.id;
    }
    
    @Override
    public void setSensorType(int value) {
    	// TODO Auto-generated method stub
    	this.sensorType = value;
    }
    
    @Override
    public String getSensorType() {
    	// TODO Auto-generated method stub
    	switch (this.sensorType) {
		case 1:
			return SensorType.SOURCE;			
		case 2:
			return SensorType.SINK;
		case 3:
			return SensorType.INTERMEDIATE;
		default:
			return "";
		}
    }
    
    @Override
    public void setEnergy(float value) {
    	// TODO Auto-generated method stub
    	this.energy = value;
    }
    
    @Override
    public float getEnergy() {
    	// TODO Auto-generated method stub
    	return this.energy;
    }
    
    @Override
    public void setToken(int value) {
    	// TODO Auto-generated method stub
    	this.Token = value;
    }
    
    @Override
    public String getToken() {
    	// TODO Auto-generated method stub
    	return String.valueOf(this.Token);
    }
    
    @Override
    public void setId(String Id) {
    	// TODO Auto-generated method stub
    	this.id = Id;
    }
}

