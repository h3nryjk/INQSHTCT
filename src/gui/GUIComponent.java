package gui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class GUIComponent {
	protected GUIListener listener;
	
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	
	public GUIComponent() {
		listener = new GUIListener() {
			@Override
			public void call() {

			}
		};
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void setBounds(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, width, height);
	}
	
	public void draw(Graphics g) {
		paint(g);
	}
	
	public void setGUIListener(GUIListener l) {
		this.listener = l;
	}
	
	public abstract void paint(Graphics g);
	public abstract void handle(MouseEvent m);
	public abstract void handle(KeyEvent k);
}
