package midi;

import java.util.ArrayList;

import javax.sound.midi.MidiChannel;

public class Track {
	private ArrayList<Note> notes;
	
	private MidiChannel mc;
	private int velocity;
	
	public Track() {
		
	}
	
	public void play() {
		for(Note n: notes) {
			n.play(mc, velocity);
		}
	}
}
