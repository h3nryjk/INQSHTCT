package gui;

public class State<E> {
	private E previous;
	private E current;
	
	public State(E previous, E current) {
		this.setPrevious(previous);
		this.setCurrent(current);
	}

	public void set(E previous, E current) {
		this.setPrevious(previous);
		this.setCurrent(current);
	}
	
	public void setPrevious(E previous) {
		this.previous = previous;
	}

	public E getPrevious() {
		return previous;
	}

	public void setCurrent(E current) {
		this.current = current;
	}

	public E getCurrent() {
		return current;
	}
}
