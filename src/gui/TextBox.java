package gui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class TextBox extends GUIComponent {
	private String text;
	private int cursor;
	private int limit;
	
	public TextBox() {
		text = "";
		limit = -1;
		cursor = 0;
	}
	
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public void handle(MouseEvent m) {
		
	}

	@Override
	public void handle(KeyEvent k) {
		char c = k.getKeyChar();
		int code = k.getKeyCode();
		if(c == '\b') {
			if(cursor > 0) {
				cursor--;
				text = new String(text.substring(0, cursor));
				System.out.println(text);
			}
		} else if(c >= ' ') {
			if(limit == -1 || text.length() < limit) {
				String s1 = text.substring(0, cursor);
				String s2 = text.substring(cursor, text.length());
				s1+=c;
				text = s1 + s2;
				cursor++;
			}
		}
		System.out.println(cursor);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(0, 0, 0));
		g.fillRect(x, y, width, height);
		
		FontMetrics metrics = g.getFontMetrics();
		
		g.setColor(new Color(255, 255, 255));
		g.drawString(text, x, y+metrics.getHeight()+(height/2-metrics.getHeight()/2));
		
		g.drawLine(x+metrics.stringWidth(text.substring(0, cursor)), y+(height/2-metrics.getHeight()/2), x+metrics.stringWidth(text.substring(0, cursor)), y+metrics.getHeight()+(height/2-metrics.getHeight()/2));
	}
}
