package editor.canvas;

import java.util.concurrent.atomic.AtomicInteger;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
//import pt_petrinet.Transition;

public class ClipTransition extends AbstractClip {

	private static AtomicInteger uniqueId = new AtomicInteger();
	//private Transition transition;
	private String label = "";
	private String id = String.valueOf(uniqueId.getAndIncrement());

	public ClipTransition(Point2D center) {
		super(center);
                this.setType(ClipType.Transition);
		//transition = new Transition(id, label);
	}

	@Override
	public Clip copy() {
		return new ClipTransition(getCenter());
	}

	@Override
	public void draw(GraphicsContext ctx) {
		drawBackground(ctx);
		drawForeground(ctx);
		drawLabel(ctx);
	}

	@Override
	public void decrementId() {
		id = String.valueOf(uniqueId.decrementAndGet());
	}

	private void drawLabel(GraphicsContext ctx) {
	}

	private void drawForeground(GraphicsContext ctx) {
		drawState(ctx);
		ctx.strokeRect(getStart().getX(), getStart().getY(), getWidth() - 1, getHeight() - 1);
	}

	private void drawBackground(GraphicsContext ctx) {
		ctx.setFill(Colors.NETCOLOR);
		ctx.fillRect(getStart().getX(), getStart().getY(), getWidth(), getHeight());
	}

}
