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
		
		ca = new CellularAutomaton(rule, 64, 64, (long)(generator.nextDouble()*Math.pow(2, 64)));
		ca.erase(3);
		ca.erase(6);
		ca.erase(7);
	}
	
	public Track generate(MidiInterface midi, int channel) {
		Track t = new Track(midi, channel);
		
		for(int i=0; i<64; i++) {
			boolean row[] = ca.getRow(i);
			Chord c = new Chord();
			c.set(Note.A, 8, 8, row);
			t.addChord(c);
		}
		
		return t;
	}
}
