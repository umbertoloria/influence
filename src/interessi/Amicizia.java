package interessi;

import persone.Persona;

import java.util.ArrayList;

public class Amicizia extends Interazione {

	public Amicizia(ArrayList<Persona> persone) {
		super(persone);
	}

	public void interazione(Persona a, Persona b, double delta) {
		if (Persona.amici(a, b)) {
			System.out.println("amici");
		}
	}

}
