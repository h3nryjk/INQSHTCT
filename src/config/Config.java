package config;

import java.awt.event.KeyEvent;

public class Config {
	private Config instance;
	
	private static int keyOne;
	private static int keyTwo;
	private static int keyThree;
	private static int keyFour;
	private static int keyPick;
	
	private Config() {
		keyOne = KeyEvent.VK_1;
		keyTwo = KeyEvent.VK_2;
		keyThree = KeyEvent.VK_3;
		keyFour = KeyEvent.VK_4;
		keyPick = KeyEvent.VK_ENTER;
	}
	
	private Config getInstance() {
		if(instance == null) {
			instance = new Config();
		}
		return instance;
	}
	
	public void setKeyOne(int code) {
		getInstance().keyOne = code;
	}
	
	public void setKeyTwo(int code) {
		getInstance().keyTwo = code;
	}
	
	public void setKeyThree(int code) {
		getInstance().keyThree = code;
	}
	
	public void setKeyFour(int code) {
		getInstance().keyFour = code;
	}
}
