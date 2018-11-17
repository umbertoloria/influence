package lwjgl.renderables;

public abstract class Entity implements Renderable, Updatable {

	public abstract void render();

	public abstract void update();

}
