package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Button extends GUIComponent {
	private String label;
	private boolean down;
	private boolean hover;
	
	public Button(String label) {
		this.label = label;
		down = false;
	}

	@Override
	public void handle(MouseEvent m) {
		down = false;
		hover = false;
		
		if(m.getX()>x && m.getY()>y && m.getX()<x+width && m.getY()<y+height) {
			hover = true;
			if(m.getButton() == MouseEvent.BUTTON1 && m.getID() == MouseEvent.MOUSE_PRESSED) {	
				listener.call();
				down = true;
			}
		}
	}
	
	@Override
	public void handle(KeyEvent k) {
		
	}

	@Override
	public void paint(Graphics g) {
		if(down == true) {
			g.setColor(new Color(50, 50, 50));
			g.fillRect(x, y, width, height);
		} else if(hover == true) {
			g.setColor(new Color(75, 75, 75));
			g.fillRect(x, y, width, height);
		} else {
			g.setColor(new Color(0, 0, 0));
			g.fillRect(x, y, width, height);
		}
		
		g.setColor(new Color(255, 255, 255));
		
		FontMetrics metrics = g.getFontMetrics();
		g.drawString(label, x+width/2-metrics.stringWidth(label)/2, y+metrics.getHeight()+(metrics.getHeight()-height/2));
	}
}
