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

import midi.MidiInterface;
import midi.Note;
import midi.Track;

import sprite.Sprite;

import game.Game;
import generation.TrackGenerator;
import graphics.ChordButtonHandler;
import graphics.Finger;
import graphics.Fretboard;
import gui.Button;
import gui.GUIListener;
import gui.GUIManager;
import gui.TextBox;


public class MainWindow extends Game {
	private static final long serialVersionUID = 1L;
	
	private GUIManager gui;
	
	private ChordButtonHandler chords;
	
	private Finger[] fingers;
	private Fretboard fretboard;
	
	private boolean pick;
	
	private int score;
	
	private int currentChord;
	
	private MidiInterface midi;
	private Track melody;
	private Track percussion;
	
	private Random random;
	
	int red = 125;
	int green = 125;
	int blue = 125;
	
	int c = 1;
	
	public MainWindow(int w, int h) {
		super(w, h);
		
		midi = new MidiInterface();
		
		midi.setInstrument(29, 0);
		melody = new Track(midi, 0);
		melody.setVelocity(100);
		
		percussion = new Track(midi, 9);
		percussion.setVelocity(75);
		
		TrackGenerator mgen = new TrackGenerator(new Random(), 30, Note.A, 12);
		melody = mgen.generate(midi, 0);
		
		TrackGenerator pgen = new TrackGenerator(new Random(), 30, Note.A, 12);
		percussion = pgen.generate(midi, 9);
		
		gui = new GUIManager();
		
		chords = new ChordButtonHandler(144, 144+64+32, 144+2*(64+32), 144+3*(64+32));
		chords.setMaxHeight(h);
		chords.addChord(15);
		
		currentChord = 7;
		
		fingers = new Finger[4];
		for(int i=0; i<fingers.length; i++) {
			fingers[i] = new Finger(144+i*(64+32), h-64-48, 64, 64, 32, 16);
		}
		
		fretboard = new Fretboard(50, 0, w-100, w-400, h);
		
		pick = false;
		
		random = new Random();
		random.setSeed(1283761234);
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(new Color(255, 128, 128));
		g2d.fillRect(0, 0, 640, 480);
		
		// Show fretboard
		fretboard.show(g2d);
		
		chords.draw(g2d);
		
		for(Finger f: fingers) {
			f.draw(g2d);
		}
		
		g2d.setColor(Color.white);
		g2d.drawString("Score: " + score, 0, g2d.getFontMetrics().getHeight()+2);
		
		gui.draw(g2d);
	}

	@Override
	public void loop() {
		melody.play();
		
		percussion.play();
		
		chords.handle();
		
		if(chords.size() > 0) {
			for(int i=0; i<fingers.length; i++) {
				chords.getCurrentButton(i).setPressed(false);
				
				if(fingers[i].isPressed()) {
					if(fingers[i].getRect().intersects(chords.getCurrentButton(i).getRect())) {
						chords.getCurrentButton(i).setPressed(true);
					}
				}
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		gui.handle(arg0);
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
			case KeyEvent.VK_1: fingers[0].setPressed(true); break;
			case KeyEvent.VK_2: fingers[1].setPressed(true); break;
			case KeyEvent.VK_3: fingers[2].setPressed(true); break;
			case KeyEvent.VK_4: fingers[3].setPressed(true); break;
			
			case KeyEvent.VK_ENTER: 
				if(pick == false && currentChord != 0) {
					int pattern = 0;
					if(fingers[0].isPressed()) {
						pattern|=1;
					}
					if(fingers[1].isPressed()) {
						pattern|=2;
					}
					if(fingers[2].isPressed()) {
						pattern|=4;
					}
					if(fingers[3].isPressed()) {
						pattern|=8;
					}
					if(currentChord == pattern) {
						score++;
						currentChord = 0;
					}
				}
				pick = true; 
				break;
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
