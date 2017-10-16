package Petrinet;

public class Place extends PetrinetObject {

	private int token;

	public Place(String id, String label, int token) {
		super(id, label);
		setToken(token);
		//System.out.println("Place created: " + toString());
	}

	public int getToken() {
		return this.token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return this.getId()+":"+this.getToken();
	}
}
