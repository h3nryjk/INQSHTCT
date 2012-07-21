package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class ChordButtonHandler {
	private ArrayList<ChordButton> buttons;
	private int maxHeight;
	
	private int x1, x2, x3, x4;
	
	public ChordButtonHandler(int x1, int x2, int x3, int x4) {
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		
		buttons = new ArrayList<ChordButton>();
		maxHeight = 600;
	}
	
	public void addChord(int pattern) {
		if((pattern & 1) > 0) {
			buttons.add(new ChordButton(new Color(200, 200, 125), new Color(150, 150, 100), x1, 64, 64));
		}
		if((pattern & 2) > 0) {
			buttons.add(new ChordButton(new Color(200, 125, 200), new Color(150, 100, 150), x2, 64, 64));
		}
		if((pattern & 4) > 0) {
			buttons.add(new ChordButton(new Color(125, 200, 200), new Color(100, 150, 150), x3, 64, 64));
		}
		if((pattern & 8) > 0) {
			buttons.add(new ChordButton(new Color(125, 200, 125), new Color(100, 125, 100), x4, 64, 64));
		}
	}
	
	public ChordButton getButton(int index) {
		return buttons.get(index);
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
		for(ChordButton button: buttons) {
			button.draw(g);
		}
	}
}
