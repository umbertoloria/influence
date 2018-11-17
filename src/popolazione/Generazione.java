package popolazione;

import persone.Persona;

import java.util.ArrayList;

public class Generazione {

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

}
