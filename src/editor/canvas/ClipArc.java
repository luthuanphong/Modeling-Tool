package editor.canvas;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import java.util.concurrent.atomic.AtomicInteger;

public class ClipArc extends AbstractClip {
	
	private static AtomicInteger uniqueId = new AtomicInteger();
	
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
		ctx.fillText(this.id, getCenterX()-10, getCenterY()-10, 100);
	}

	private void drawForeground(GraphicsContext ctx) {
		drawState(ctx);
		//ctx.strokeRect(getStart().getX(), getStart().getY(), getWidth() - 1, getHeight() - 1);
                ctx.strokeLine(getStart().getX(), getStart().getY(), getEnd().getX(), getEnd().getY());
	}
	
	private void drawBackground(GraphicsContext ctx) {
		//ctx.setFill(Colors.NETCOLOR);
		//ctx.fillRect(getStart().getX(), getStart().getY(), getWidth(), getHeight());
	}
	
}
