import game.Game;
import game.GameWindow;


public class Main extends GameWindow {
	private static final long serialVersionUID = 1L;
	private static Main m;

	public Main(Game g) {
		super(g, false);
	}
	
	public static void main(String[] args) {
		Game g = new MainWindow(640, 480);
		m = new Main(g);
	}
}
