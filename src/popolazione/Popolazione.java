package popolazione;

import interessi.Amicizia;
import interessi.Socialità;
import launcher.Launcher;
import lwjgl.renderables.Updatable;
import persone.Aspetto;
import persone.Carattere;
import persone.Persona;

import java.util.ArrayList;

public class Popolazione implements Updatable {

	private String[] nomi_m = {"Roberto", "Alessio", "Michele", "Daniele", "Emanuele", "Donato", "Alessandro",
			"Francesco", "Antonio"};
	private String[] nomi_f = {"Sara", "Alessia", "Michela", "Daniela", "Emanuela", "Dominique", "Alessandra",
			"Francesca", "Lucia"};
	private String[] cognomi = {"Loria", "D'Urso", "Panichella", "Martino", "Napoli"};

	private ArrayList<Persona> persone = new ArrayList<>();
	private Socialità socialità = new Socialità(persone);
	private Amicizia amicizia = new Amicizia(persone);

	public Popolazione() {

		Persona ul = new Persona("Umberto", "Loria", true,
				new Carattere(4, 7, 3, 7),
				new Aspetto(7));

		Persona sd = new Persona("Serena", "D'Urso", false,
				new Carattere(6, 6, 5, 6),
				new Aspetto(7));

		Persona.amici(ul, sd);
		Persona.fidanzamento(ul, sd);
		persone.add(ul);
		persone.add(sd);
		Launcher.gw.add(this);
	}

	private String[] generateNames(boolean maschio, int genIndex) {
		String[] res = new String[2];
		String[] nomi = maschio ? nomi_m : nomi_f;
		boolean busy;
		for (String nome : nomi) {
			for (String cognome : cognomi) {
				busy = false;
				for (Persona persona : persone) {
					if (persona.getNome().equalsIgnoreCase(nome) && persona.getCognome().equalsIgnoreCase(cognome)) {
						busy = true;
						break;
					}
				}
				if (!busy) {
					res[0] = nome;
					res[1] = cognome;
					return res;
				}
			}
		}
		return res;
	}

	public void update(double delta) {
		socialità.update(delta);
		amicizia.update(delta);
	}

}
