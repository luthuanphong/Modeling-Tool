package Petrinet;

import java.util.ArrayList;

public class Transition extends PetrinetObject {

	private ArrayList<Arc> incoming = new ArrayList<Arc>();
	private ArrayList<Arc> outgoing = new ArrayList<Arc>();

	public Transition(String id, String label) {
		super(id, label);
		//System.out.println("Transition created: " + toString());
	}

	public ArrayList<Arc> getIncoming() {
		return this.incoming;
	}

	public ArrayList<Arc> getOutgoing() {
		return this.outgoing;
	}

	public void addIncoming(Arc arc) {
		incoming.add(arc);
	}

	public void addOutgoing(Arc arc) {
		outgoing.add(arc);
	}

	public boolean isEnabled() {
		for (Arc arc: incoming) {
			if (!arc.isEnabled()) {
				return false;
			}
		}
		return true;
	}

	public void fire() {
		// Only call this method when the trasition is surely enabled
		for (Arc arc: incoming) {
			Place p = arc.getPlace();
			p.setToken(p.getToken() - arc.getWeight());
		}
		for (Arc arc: outgoing) {
			Place p = arc.getPlace();
			p.setToken(p.getToken() + arc.getWeight());
		}
	}

	/**
	 * Reset the petrinet's state to the one before firing
	 */
	public void defire() {
		// Only call this method after a fire action
		for (Arc arc: incoming) {
			Place p = arc.getPlace();
			p.setToken(p.getToken() + arc.getWeight());
		}
		for (Arc arc: outgoing) {
			Place p = arc.getPlace();
			p.setToken(p.getToken() - arc.getWeight());
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("\nIncoming Arcs: ");
		for (Arc a : incoming) {
			sb.append(a).append("\n");
		}
		sb.append("Outgoing Arcs: ");
		for (Arc a : outgoing) {
			sb.append(a).append("\n");
		}
		return sb.toString();
	}
}
