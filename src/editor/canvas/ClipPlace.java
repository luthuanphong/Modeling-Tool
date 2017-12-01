package editor.canvas;

import java.util.concurrent.atomic.AtomicInteger;

import editor.views.EditorWindow;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
//import pt_petrinet.Place;

public class ClipPlace extends AbstractClip {
		
	public ClipPlace(Point2D center) {
		super(center);
        this.setType(ClipType.Place);
        id = String.valueOf(EditorWindow.uniqueId.getAndIncrement());
        name = id;
	}
	
	public ClipPlace(Point2D start , Point2D end) {
		// TODO Auto-generated constructor stub
		super(start,end);
        this.setType(ClipType.Place);
        id = String.valueOf(EditorWindow.uniqueId.getAndIncrement());
	}
	
	public ClipPlace(Point2D start , Point2D end,String ident) {
		// TODO Auto-generated constructor stub
		super(start,end);
        this.setType(ClipType.Place);
        id = ident;
        EditorWindow.uniqueId.set(Integer.parseInt(ident));
	}
	
	public ClipPlace(Point2D center, String ident) {
		super(center);
        this.setType(ClipType.Place);
        id = ident;
        name = id;
        EditorWindow.uniqueId.set(Integer.parseInt(ident)+1);
	}

	@Override
	public Clip copy() {
		return new ClipPlace(getCenter());
	}

	@Override
	public void draw(GraphicsContext ctx) {
		drawBackground(ctx);
		drawForeground(ctx);
		drawLabel(ctx);
		drawToken(ctx);
	}

	@Override
	public boolean isSelected(double x, double y) {
		// Radius
		double rx = getWidth() / 2;
		double ry = getHeight() / 2;

		// Context center coordinates
		double cx = getStart().getX() + rx;
		double cy = getStart().getY() + ry;

		// Pythagore formula checking inside
		return (Math.pow((x - cx) / rx, 2.0) + Math.pow((y - cy) / ry, 2.0)) <= 1;
	}

	private void drawLabel(GraphicsContext ctx) {
            ctx.setFill(Colors.NETBORDCOLOR);
            ctx.fillText(this.id, getCenterX(),getCenterY() - getHeight()/2-5,100);
            
	}

	@Override
	public void decrementId() {
		id = String.valueOf(EditorWindow.uniqueId.decrementAndGet());
	}

	private void drawForeground(GraphicsContext ctx) {
		drawState(ctx);
		//ctx.strokeOval(getStart().getX(), getStart().getY(), getWidth() - 1, getHeight() - 1);
	}

	private void drawBackground(GraphicsContext ctx) {
		if(this.getSensorType().equals(SensorType.SOURCE)) {
			//ctx.setFill(Colors.SENSORSOURCE);
			ctx.drawImage(Icons.SourceSensor, getStart().getX(), getStart().getY(),32,32);
		} else if (this.getSensorType().equals(SensorType.SINK)) {
			//ctx.setFill(Colors.SENSORSINK);
			ctx.drawImage(Icons.SinkSensor, getStart().getX(), getStart().getY(),32,32);
		} else {
			//ctx.setFill(Colors.NETCOLOR);
			ctx.drawImage(Icons.IntermediateSensor, getStart().getX(), getStart().getY(),32,32);
		}
		//ctx.setFill(Colors.NETCOLOR);
		//ctx.fillOval(getStart().getX(), getStart().getY(), getWidth(), getHeight());
	}

	private void drawToken(GraphicsContext ctx) {
	}
}
