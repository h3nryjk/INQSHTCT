package generation;

import java.util.Random;

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
	}
}
