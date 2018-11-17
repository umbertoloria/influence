package lwjgl.stuff;

import lwjgl.gamewindow.GameWindow;

import static org.lwjgl.opengl.GL11.*;

public class Camera {

	private double zoom;
	private double sx, sy;
	private double ox, oy;

	public Camera(double zoom) {
		this.zoom = zoom;

		int ww = GameWindow.WIDTH;
		int wh = GameWindow.HEIGHT;
		double aspRatio = (double) ww / wh;

		if (aspRatio > 1) {
			this.sx = 2d / (aspRatio * zoom);
			this.sy = -2d / zoom;
		}
		// FIXME: completare anche con lo schermo più alto che largo.

		this.ox = -zoom / 2;
		this.oy = -zoom / 2;
	}

	public void enable() {
		glPushMatrix();
		glScaled(sx, sy, 1);
		glTranslated(ox, oy, 0);
	}

	public void disable() {
		glPopMatrix();
	}

	public double getZoom() {
		return zoom;
	}

}
