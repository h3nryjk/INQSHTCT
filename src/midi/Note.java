package midi;

import javax.sound.midi.MidiChannel;

public class Note {
	public static final int C = 24;
	public static final int Cs = 25;
	public static final int D = 26;
	public static final int Ds = 27;
	public static final int E = 28;
	public static final int F = 29;
	public static final int Fs = 30;
	public static final int G = 31;
	public static final int Gs = 32;
	public static final int A = 33;
	public static final int As = 34;
	public static final int B = 35;
	
	private int code = C;
	private int length = 100;
	
	public Note(int code, int octave) {
		this.code = code + octave * 12;
	}
	
	public void set(int code, int octave) {
		this.code = code + octave * 12;
	}
	
	public void set(int code, int octave, int length) {
		this.code = code + octave * 12;
		this.length = length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public int get() {
		return code;
	}
	
	public int getLength() {
		return length;
	}
	
	public void play(MidiChannel mc, int velocity) {
		mc.noteOn(code, velocity);
	}
}
