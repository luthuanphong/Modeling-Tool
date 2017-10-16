package Petrinet;

public class Arc extends PetrinetObject {

	private Transition transition;
	private Place place;
	private int weight;
	private Direction direction;

	public Arc(String id, String label, Transition t, Place p, int w) {
		super(id, label);
		this.transition = t;
		this.place = p;
		this.weight = w;
		this.direction = Direction.TRANSITION_TO_PLACE;
		t.addOutgoing(this);
	}

	public Arc(String id, String label, Place p, Transition t, int w) {
		super(id, label);
		this.transition = t;
		this.place = p;
		this.weight = w;
		this.direction = Direction.PLACE_TO_TRANSITION;
		t.addIncoming(this);
	}

	public Place getPlace() {
		return place;
	}

	public Transition getTransition() {
		return transition;
	}

	public void setWeight(int w) {
		this.weight = w;
	}

	public int getWeight() {
		return this.weight;
	}

	public boolean isEnabled() {
		if (this.direction == Direction.PLACE_TO_TRANSITION) {
			if (this.place.getToken() >= this.weight) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + " Place: " + place.getId() + " | Weight: " + weight;
	}

}
