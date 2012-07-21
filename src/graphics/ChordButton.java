package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ChordButton {
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	private boolean pressed;
	
	private Color color;
	private Color pressedColor;
	
	public ChordButton(Color color, Color pressedColor, int x, int width, int height) {
		this.color = color;
		this.pressedColor = pressedColor;
		this.x = x;
		this.width = width;
		this.height = height;
		pressed = false;
		y = 0;
	}
	
	public int getY() {
		return y;
	}
	
	public void move(int deltaY) {
		y+=deltaY;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, width, height);
	}
	
	public void draw(Graphics g) {
		if(pressed) {
			g.setColor(pressedColor);
		} else {
			g.setColor(color);
		}
		g.fillRect(x, y, width, height);
	}
}
