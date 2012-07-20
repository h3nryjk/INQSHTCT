import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;

import sprite.Sprite;

import game.Game;
import graphics.Finger;
import graphics.Fretboard;
import gui.Button;
import gui.GUIListener;
import gui.GUIManager;


public class MainWindow extends Game {
	private static final long serialVersionUID = 1L;
	
	private GUIManager gui;
	private Button btnTest;
	
	private Finger[] fingers;
	private Fretboard fretboard;
	
	private boolean pick;
	
	private int score;
	
	private Synthesizer synth;
	private MidiChannel[] mc;
	private ShortMessage myMsg;
	private Soundbank soundbank;
	private Instrument[] instr;
	
	private Random random;
	
	int red = 125;
	int green = 125;
	int blue = 125;
	
	int c = 1;
	
	public MainWindow(int w, int h) {
		super(w, h);
		
		gui = new GUIManager();
		btnTest = new Button("Test");
		btnTest.setBounds(0, 0, 50, 25);
		btnTest.setGUIListener(new GUIListener() {
			public void call() {
				System.out.println("Click!");
			}
		});
		gui.add(btnTest);
		
		fingers = new Finger[4];
		for(int i=0; i<fingers.length; i++) {
			fingers[i] = new Finger(144+i*(64+32), h-64-48, 64, 64, 32, 16);
		}
		
		fretboard = new Fretboard(50, 0, w-100, w-400, h);
		
		pick = false;
		
		random = new Random();
		random.setSeed(1283761234);

		try {
			synth = MidiSystem.getSynthesizer();
			synth.open();
			myMsg = new ShortMessage();
			soundbank = synth.getDefaultSoundbank();
			instr = soundbank.getInstruments();
			
			int i=29;
			
			synth.loadInstrument(instr[i]);
			
			mc = synth.getChannels();
			mc[c].programChange(instr[i].getPatch().getProgram());
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(new Color(255, 128, 128));
		g2d.fillRect(0, 0, 640, 480);
		
		// Show fretboard
		fretboard.show(g2d);
		
		for(Finger f: fingers) {
			f.draw(g2d);
		}
		
		gui.draw(g2d);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	@Override
	public void loop() {
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		gui.handle(arg0);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		gui.handle(arg0);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		gui.handle(arg0);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		gui.handle(arg0);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		
	}

	@Override
	public void keyDown(int keyID) {
		switch(keyID) {
			case KeyEvent.VK_ENTER: pick = true; break;
		
			case KeyEvent.VK_1: fingers[0].setPressed(true); break;
			case KeyEvent.VK_2: fingers[1].setPressed(true); break;
			case KeyEvent.VK_3: fingers[2].setPressed(true); break;
			case KeyEvent.VK_4: fingers[3].setPressed(true); break;
		}
	}

	@Override
	public void keyUp(int keyID) {
		switch(keyID) {
			case KeyEvent.VK_ENTER: pick = false; break;
		
			case KeyEvent.VK_1: fingers[0].setPressed(false); break;
			case KeyEvent.VK_2: fingers[1].setPressed(false); break;
			case KeyEvent.VK_3: fingers[2].setPressed(false); break;
			case KeyEvent.VK_4: fingers[3].setPressed(false); break;
		}
	}
}
