package midi;

public class Instrument {
	private int id;
	
	public Instrument(int id) {
		this.setId(id);
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
