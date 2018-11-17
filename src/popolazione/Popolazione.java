package popolazione;

import launcher.Launcher;
import persone.Persona;

import java.util.ArrayList;

public class Popolazione {

	private String[] nomi_m = {"Umberto", "Alessio", "Michele", "Daniele", "Emanuele", "Donato", "Alessandro",
			"Francesco", "Antonio"};
	private String[] nomi_f = {"Serena", "Alessia", "Michela", "Daniela", "Emanuela", "Dominique", "Alessandra",
			"Francesca", "Lucia"};
	private String[] cognomi = {"Loria", "D'Urso", "Panichella", "Martino", "Napoli"};

	private ArrayList<Generazione> generazioni = new ArrayList<>();

	public Popolazione() {
		generazioni.add(new Generazione());

		String[] names = generateNames(true, 0);
		Persona maschio = new Persona(names[0], names[1], true);

		names = generateNames(false, 0);
		Persona femmina = new Persona(names[0], names[1], false);

		generazioni.get(0).populate(maschio);
		generazioni.get(0).populate(femmina);

		Launcher.gw.add(maschio);
		Launcher.gw.add(femmina);
	}

	public String[] generateNames(boolean maschio, int genIndex) {
		String[] res = new String[2];
		String[] nomi = maschio ? nomi_m : nomi_f;
		for (String nome : nomi) {
			for (String cognome : cognomi) {
				if (!generazioni.get(genIndex).exists(nome, cognome, true)) {
					res[0] = nome;
					res[1] = cognome;
					return res;
				}
			}
		}
		return res;
	}

}
