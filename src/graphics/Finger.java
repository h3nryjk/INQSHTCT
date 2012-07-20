package graphics;

import java.awt.Color;
import java.awt.Graphics;

public class Finger {
	private int x;
	private int y;
	private int w;
	private int h;
	private int length;
	private int offset;
	
	private boolean pressed;
	
	public Finger(int x, int y, int w, int h, int length, int offset) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.length = length;
		this.offset = offset;
		pressed = false;
	}
	
	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(200, 175, 150));
		g.fillRect(x, y+h, w, length);
		
		g.setColor(new Color(225, 200, 175));
		if(pressed) {
			g.fillRect(x, y+offset, w, h);
			g.setColor(new Color(225, 225, 225));
			g.fillRect(x+10, y+offset, w-20, h-10);
		} else {
			g.fillRect(x, y, w, h);
			g.setColor(new Color(225, 225, 225));
			g.fillRect(x+10, y, w-20, h-10);
		}
	}
}
