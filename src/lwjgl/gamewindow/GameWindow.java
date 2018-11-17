package lwjgl.gamewindow;

import lwjgl.renderables.Entity;
import lwjgl.renderables.Renderable;
import lwjgl.renderables.Updatable;
import lwjgl.stuff.Camera;
import lwjgl.stuff.LWJGLWindow;

import java.util.ArrayList;

public class GameWindow extends LWJGLWindow {

	private ArrayList<Entity> entities = new ArrayList<>();
	public static final int WIDTH = 1600;
	public static final double PROPS = 16 / 10d;
	public static final int HEIGHT = (int) (WIDTH / PROPS);

	public GameWindow(Camera c) {
		super(WIDTH, HEIGHT, "Influence", c);
	}

	public void add(Entity e) {
		entities.add(e);
	}

	public void render() {
		for (Renderable entity : entities) {
			entity.render();
		}
	}

	public void update() {
		for (Updatable entity : entities) {
			entity.update();
		}
	}

}
