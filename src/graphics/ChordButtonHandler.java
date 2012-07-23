package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class ChordButtonHandler {
	private ArrayList<ChordArray> buttons;
	private int maxHeight;
	
	private int x1, x2, x3, x4;
	
	public ChordButtonHandler(int x1, int x2, int x3, int x4) {
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		
		buttons = new ArrayList<ChordArray>();
		
		maxHeight = 600;
	}
	
	public void addChord(int pattern) {
		buttons.add(new ChordArray(pattern, x1, x2, x3, x4));
	}
	
	public ChordButton getCurrentButton(int index) {
		return buttons.get(0).getButton(index);
	}
	
	public ChordArray getCurrentArray() {
		return buttons.get(0);
	}
	
	public int size() {
		return buttons.size();
	}
	
	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}
	
	public void handle() {
		for(int i=0; i<buttons.size(); i++) {
			buttons.get(i).move(1);
			if(buttons.get(i).getY() > maxHeight) {
				buttons.remove(i);
			}
		}
	}
	
	public void draw(Graphics g) {
		for(ChordArray button: buttons) {
			button.draw(g);
		}
	}
}
