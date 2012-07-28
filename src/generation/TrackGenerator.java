package generation;

import java.util.Random;

import midi.Chord;
import midi.MidiInterface;
import midi.Note;
import midi.Track;

import ca.CellularAutomaton;

public class TrackGenerator {
	private Random generator;
	private CellularAutomaton ca;
	private int startNote;
	private int endNote;
	
	public TrackGenerator(Random generator, int rule, int startNote, int endNote) {
		this.generator = generator;
		this.startNote = startNote;
		this.endNote = endNote;
		
		int range = endNote - startNote;
		if(range > 64) {
			range = 64;
		}
		
		long seed = 0;
		do {
			seed = (long)(generator.nextLong());
		} while(seed == 0);
		ca = new CellularAutomaton(rule, 64, 64, seed);
		System.out.println(seed);
		ca.erase(3);
		ca.erase(6);
		ca.erase(7);
	}
	
	public Track generate(Track track) {
		Track t = track;
		
		for(int i=0; i<64; i++) {
			boolean row[] = ca.getRow(i);
			Chord c = new Chord();
			c.set(Note.A, 12, 8, row);
			t.addChord(c);
		}
		
		return t;
	}
	
	public CellularAutomaton getCA() {
		return ca;
	}
}
