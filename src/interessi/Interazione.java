package interessi;

import lwjgl.renderables.Updatable;
import persone.Persona;

import java.util.ArrayList;

public abstract class Interazione implements Updatable {

	private ArrayList<Persona> persone;

	public Interazione(ArrayList<Persona> persone) {
		this.persone = persone;
	}

	public void add(Persona p) {
		persone.add(p);
	}

	public void update(double delta) {
		for (int i = 0; i < persone.size(); i++) {
			for (int j = i + 1; j < persone.size(); j++) {
				interazione(persone.get(i), persone.get(j), delta);
			}
		}
	}

	public abstract void interazione(Persona a, Persona b, double delta);

}
