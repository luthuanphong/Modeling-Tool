package editor.canvas;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class ClipGroup extends AbstractClip implements Composite {

	private List<Clip> clips = new ArrayList<Clip>();
	private List<ClipGroup> clipGroup = new ArrayList<ClipGroup>();
	private Point2D start = new Point2D(Double.MAX_VALUE, Double.MAX_VALUE);
	private Point2D end = Point2D.ZERO;

	@Override
	public List<Clip> getClips() {
		return clips;
	}

	public List<ClipGroup> getClipGroup() {
		return clipGroup;
	}

	@Override
	public void addClip(Clip toAdd) {
		clips.add(toAdd);
		setGroupRect(toAdd.getStart(), toAdd.getEnd());
	}

	public void addClipGroup(ClipGroup toAdd) {
		clipGroup.add(toAdd);
		setGroupRect(toAdd.getStart(), toAdd.getEnd());
	}

	@Override
	public void removeClip(Clip toRemove) {
		clips.remove(toRemove);
		for (Clip c : clips) {
			setGroupRect(c.getStart(), c.getEnd());
		}
	}

	public void removeClipGroup(ClipGroup toRemove) {
		clipGroup.remove(toRemove);
		for (ClipGroup c : clipGroup) {
			setGroupRect(c.getStart(), c.getEnd());
		}
	}

	@Override
	public void setStart(double x, double y) {
		clips.forEach(clip -> clip.move(-this.getStart().getX() + x, -this.getStart().getY() + y));
		clipGroup.forEach(group -> group.move(-this.getStart().getX() + x, -this.getStart().getY() + y));
		
		this.setStart(x, y);
	}

	@Override
	public void setEnd(double x, double y) {
		this.setEnd(x, y);
	}

	private void setGroupRect(Point2D cstart, Point2D cend) {
		double left, top, right, bottom;
		
		left = cstart.getX() < start.getX() ? cstart.getX() : start.getX();
		top = cstart.getY() < start.getY() ? cstart.getY() : start.getY();
		right = cend.getY() > end.getY() ? cend.getY() : end.getY();
		bottom = cend.getY() > end.getY() ? cend.getY() : end.getY();
		
		start = new Point2D(left, top);
		end = new Point2D(right, bottom);
	}

	@Override
	public void move(double dx, double dy) {
		clips.forEach(clip -> clip.move(dx, dy));
		clipGroup.forEach(group -> group.move(dx, dy));

		this.setStart(this.getStart().getX() + dx, this.getStart().getY() + dy);
		this.setEnd(this.getEnd().getX() + dx, this.getEnd().getY() + dy);
	}

	@Override
	public ClipGroup copy() {
		ClipGroup tmp = new ClipGroup();
		for (Clip c : clips)
			tmp.addClip(c.copy());
		for (ClipGroup cg : clipGroup)
			tmp.addClipGroup(cg.copy());
		return tmp;
	}

	@Override
	public void draw(GraphicsContext ctx) {
		for (Clip c : clips)
			c.draw(ctx);
		for (ClipGroup cg : clipGroup)
			cg.draw(ctx);
	}
}
