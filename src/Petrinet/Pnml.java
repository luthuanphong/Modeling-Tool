package Petrinet;

public class Pnml {
	private Petrinet petrinet = new Petrinet(null);		

	public Petrinet getPetrinet() {
		return petrinet;
	}

	public void setPetrinet(Petrinet petrinet) {
		this.petrinet = petrinet;
	}
	
	@Override
	public String toString() {
		return petrinet.toString();
	}
}
