package popolazione;

import lwjgl.renderables.Updatable;
import persone.Persona;

import java.util.ArrayList;

public class Generazione implements Updatable {

	private ArrayList<Persona> persone = new ArrayList<>();

	public void populate(Persona p) {
		persone.add(p);
	}

	public boolean exists(String nome, String cognome, boolean maschio) {
		for (Persona persona : persone) {
			if (persona.isMaschio() == maschio) {
				if (persona.getNome().equals(nome) && persona.getCognome().equals(cognome)) {
					return true;
				}
			}
		}
		return false;
	}

	public void update(double delta) {
		for (Persona persona : persone) {
			persona.update(delta);
		}
	}
}
