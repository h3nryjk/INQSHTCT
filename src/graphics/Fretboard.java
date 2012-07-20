package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import sprite.Sprite;

public class Fretboard {
	private int x;
	private int y;
	private int width;
	private int upperWidth;
	private int height;
	
	public Fretboard(int x, int y, int width, int upperWidth, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.upperWidth = upperWidth;
		this.height = height;
	}
	
	public void show(Graphics g) {
		Polygon p = new Polygon();
		p.addPoint(x, y+height);
		p.addPoint(x+width, y+height);
		p.addPoint(x+upperWidth+(width-upperWidth)/2, y);
		p.addPoint(x+(width-upperWidth)/2, y);
		g.setColor(new Color(125, 75, 50));
		g.fillPolygon(p);
	}
}
