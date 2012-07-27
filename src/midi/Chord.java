package midi;

import java.util.ArrayList;

import javax.sound.midi.MidiChannel;

public class Chord {
	private ArrayList<Note> notes;
	
	public Chord() {
		notes = new ArrayList<Note>();
	}
	
	public void set(int startNote, boolean notes[]) {
		for(int i=0; i<notes.length; i++) {
			if(notes[i]) {
				this.notes.add(new Note(startNote+i));
			}
		}
	}
	
	public void set(int startNote, int endNote, int offset, boolean notes[]) {
		int end = endNote;
		if(endNote-startNote > notes.length) {
			end = notes.length;
		}
			
		for(int i=0; i<end; i++) {
			if(notes[i+offset]) {
				this.notes.add(new Note(startNote+i+offset));
			}
		}
	}
	
	public void addNote(Note n) {
		notes.add(n);
	}
	
	public void play(MidiInterface m, int channel, int velocity) {
		for(Note n: notes) {
			n.play(m.getChannel(channel), velocity);
		}
	}
	
	public void play(MidiChannel mc, int channel, int velocity) {
		for(Note n: notes) {
			n.play(mc, velocity);
		}
	}
}
