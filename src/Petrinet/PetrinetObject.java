package Petrinet;

public class PetrinetObject {

	private String id;
	private String label;

	protected PetrinetObject(String id, String label) {
		setId(id);
		setLabel(label);
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getId() {
		return this.id;
	}

	public String getLabel() {
		return this.label;
	}

	@Override
	public String toString() {
		return "Id: " + id + " | Label: " + label + " |";
	}
}
