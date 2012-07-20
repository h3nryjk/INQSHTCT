package gui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GUIManager {
	private ArrayList<GUIComponent> components;
	
	public GUIManager() {
		components = new ArrayList<GUIComponent>();
	}
	
	public void add(GUIComponent c) {
		components.add(c);
	}
	
	public void handle(MouseEvent m) {
		for(GUIComponent c: components) {
			c.handle(m);
		}
	}
	
	public void handle(KeyEvent k) {
		for(GUIComponent c: components) {
			c.handle(k);
		}
	}
	
	public void draw(Graphics g) {
		for(GUIComponent c: components) {
			c.paint(g);
		}
	}
}
