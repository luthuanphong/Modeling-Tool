package editor.canvas;

import java.util.concurrent.atomic.AtomicInteger;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
//import pt_petrinet.Place;

public class ClipPlace extends AbstractClip {
	
	private static AtomicInteger uniqueId = new AtomicInteger();
	//private Place place;
	private String label = "";
	
	private int token = 0;
	

	public ClipPlace(Point2D center) {
		super(center);
        this.setType(ClipType.Place);
        id = String.valueOf(uniqueId.getAndIncrement());
		//Place place = new Place(id, label, token);
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
		id = String.valueOf(uniqueId.decrementAndGet());
	}

	private void drawForeground(GraphicsContext ctx) {
		drawState(ctx);
		ctx.strokeOval(getStart().getX(), getStart().getY(), getWidth() - 1, getHeight() - 1);
	}

	private void drawBackground(GraphicsContext ctx) {
		ctx.setFill(Colors.NETCOLOR);
		ctx.fillOval(getStart().getX(), getStart().getY(), getWidth(), getHeight());
	}

	private void drawToken(GraphicsContext ctx) {
	}
}
