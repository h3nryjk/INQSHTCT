package graphics;

import java.awt.Color;
import java.awt.Graphics;

import midi.Chord;

public class ChordArray {
	private int pattern;
	private int y;
	
	private ChordButton buttons[];
	
	public ChordArray(int pattern, int x1, int x2, int x3, int x4) {
		buttons = new ChordButton[4];
		
		this.pattern = pattern;
		
		y = 0;
		buttons[0] = new ChordButton(new Color(200, 200, 125), new Color(150, 150, 100), x1, 64, 64);
		buttons[1] = new ChordButton(new Color(200, 125, 200), new Color(150, 100, 150), x2, 64, 64);
		buttons[2] = new ChordButton(new Color(125, 200, 200), new Color(100, 150, 150), x3, 64, 64);
		buttons[3] = new ChordButton(new Color(125, 200, 125), new Color(100, 125, 100), x4, 64, 64);
	
		for(ChordButton b: buttons) {
			b.setY(y);
		}
	}
	
	public void parseChord(Chord c) {
		
	}
	
	public ChordButton getButton(int index) {
		return buttons[index];
	}
	
	public boolean get(int index) {
		return ((pattern&(int)Math.pow(2, index)) > 0);
	}
	
	public int getPattern() {
		return pattern;
	}
	
	public void move(int deltaY) {
		y+=deltaY;
		for(ChordButton b: buttons) {
			b.move(deltaY);
		}
	}
	
	public void setY(int y) {
		this.y = y;
		for(ChordButton b: buttons) {
			b.setY(y);
		}
	}
	
	public int getY() {
		return y;
	}
	
	public void setPressed(int index, boolean pressed) {
		buttons[index].setPressed(pressed);
	}
	
	public void draw(Graphics g) {
		for(int i=0; i<buttons.length; i++) {
			if((pattern&(int)Math.pow(2, i)) > 0) {
				buttons[i].draw(g);
			}
		}
	}
}
