package launcher;

import lwjgl.gamewindow.GameWindow;
import lwjgl.stuff.Camera;
import popolazione.Popolazione;

import java.util.Random;

public class Launcher {

	public static Camera camera = new Camera(100);
	public static GameWindow gw = new GameWindow(camera);
	public static Popolazione p;
	public static Random r = new Random();

	public static void main(String[] args) {
		p = new Popolazione();
		gw.run();
	}

}
