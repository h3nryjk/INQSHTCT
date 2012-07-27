package midi;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class MidiInterface {
	private Synthesizer synthesizer;
	
	public MidiInterface() {
		try {
			synthesizer = MidiSystem.getSynthesizer();
			synthesizer.open();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public MidiChannel getChannel(int index) {
		return synthesizer.getChannels()[index];
	}
	
	public Instrument getInstrument(int index) {
		return synthesizer.getDefaultSoundbank().getInstruments()[index];
	}
	
	public void setInstrument(Instrument i, int channel) {
		getChannel(channel).programChange(i.getPatch().getProgram());
	}
	
	public void setInstrument(int instrument, int channel) {
		getChannel(channel).programChange(getInstrument(instrument).getPatch().getProgram());
	}
	
	public void playNote(Note n, int channel, int velocity) {
		n.play(getChannel(channel), velocity);
	}
}
