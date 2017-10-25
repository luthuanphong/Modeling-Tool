package editor.canvas;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;

import java.util.concurrent.atomic.AtomicInteger;

public class ClipArc extends AbstractClip {
	
	private static AtomicInteger uniqueId = new AtomicInteger();
	
	private static int triangleLen = 8;
	
	public ClipArc(Point2D start, Point2D end) {
		super(start, end);
        this.setType(ClipType.Arc);
	}
	
	@Override
	public void decrementId() {
		// TODO Auto-generated method stub
		this.id = String.valueOf(uniqueId.decrementAndGet());
	}

	@Override
	public Clip copy() {
		return new ClipArc(getStart(), getEnd());
	}

	@Override
	public void draw(GraphicsContext ctx) {
		drawBackground(ctx);
		drawForeground(ctx);
		drawLabel(ctx);
	}
	
	private void drawLabel(GraphicsContext ctx) {
		this.id = this.getOutputPlace().getId() +"_"+this.getInputPlace().getId();
		this.name = this.id;
		ctx.setFill(Colors.NETBORDCOLOR);
		ctx.fillText(this.id, getCenterX()-15, getCenterY()-15, 100);
	}

	private void drawForeground(GraphicsContext ctx) {
		drawState(ctx);
		//ctx.strokeRect(getStart().getX(), getStart().getY(), getWidth() - 1, getHeight() - 1);
        ctx.strokeLine(getStart().getX(), getStart().getY(), getEnd().getX(), getEnd().getY()); 
        drawArrow(ctx, getStart().getX(), getStart().getY(), getCenterX(), getCenterY());
	}
	
	private void drawBackground(GraphicsContext ctx) {
		//ctx.setFill(Colors.NETCOLOR);
		//ctx.fillRect(getStart().getX(), getStart().getY(), getWidth(), getHeight());
	}
	
	
	private void drawArrow(GraphicsContext gc, double node1X, double node1Y, double node2X, double node2Y) {
	    double arrowAngle = Math.toRadians(45.0);
	    double arrowLength = 10.0;
	    double dx = node1X - node2X;
	    double dy = node1Y - node2Y;
	    double angle = Math.atan2(dy, dx);
	    double x1 = Math.cos(angle + arrowAngle) * arrowLength + node2X;
	    double y1 = Math.sin(angle + arrowAngle) * arrowLength + node2Y;

	    double x2 = Math.cos(angle - arrowAngle) * arrowLength + node2X;
	    double y2 = Math.sin(angle - arrowAngle) * arrowLength + node2Y;
	    gc.strokeLine(node2X, node2Y, x1, y1);
	    gc.strokeLine(node2X, node2Y, x2, y2);  
	}    
}
