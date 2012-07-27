package midi;

import java.util.ArrayList;

import javax.sound.midi.MidiChannel;

public class Track {
	private ArrayList<Note> notes;
	
	private MidiChannel mc;
	private int velocity;
	
	public Track(MidiChannel mc) {
		notes = new ArrayList<Note>();
		this.mc = mc;
	}
	
	public void addNote(Note n) {
		notes.add(n);
	}
	
	public Note getNote(int index) {
		return notes.get(index);
	}
	
	public int size() {
		return notes.size();
	}
	
	public void play() {
		for(Note n: notes) {
			n.play(mc, velocity);
		}
	}
}
