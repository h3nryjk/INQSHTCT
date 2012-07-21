package graphics;

import java.awt.Graphics;

public class ChordArray {
	private int pattern;
	
	private ChordButton buttons[];
	
	public ChordArray(int pattern) {
		buttons = new ChordButton[4];
	}
	
	public ChordButton getButton(int index) {
		return buttons[index];
	}
	
	public boolean get(int index) {
		return ((pattern&(int)Math.pow(2, index)) > 0);
	}
	
	public void draw(Graphics g) {
		for(ChordButton button: buttons) {
			button.draw(g);
		}
	}
}
