package midi;

import java.util.ArrayList;

import javax.sound.midi.MidiChannel;

import timer.Timer;

public class Track {
	private ArrayList<Chord> chords;
	
	private MidiInterface midi;
	private int velocity;
	private int channel;
	private Chord currentChord;
	private int delay;
	private Timer timer;
	
	public Track(MidiInterface midi) {
		chords = new ArrayList<Chord>();
		this.midi = midi;
		this.velocity = 100;
		this.channel = 0;
		this.delay = 500;
		timer = new Timer();
		timer.start(delay);
	}
	
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	public void addChord(Chord c) {
		chords.add(c);
		System.out.println("add " + chords.size());
	}
	
	public Chord getChord(int index) {
		return chords.get(index);
	}
	
	public int size() {
		return chords.size();
	}
	
	public boolean newChord() {
		return timer.done();
	}
	
	public Chord getCurrentChord() {
		return currentChord;
	}
	
	public void play() {
		if(!chords.isEmpty() && timer.done()) {
			midi.getChannel(channel).allNotesOff();
			
			currentChord = chords.get(0);
			chords.remove(0);
			currentChord.play(midi, channel, velocity);
			timer.start(delay);
		}
	}
}
