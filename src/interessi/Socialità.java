package interessi;

import persone.Persona;

import java.util.ArrayList;

public class Socialità extends Interazione {

	public Socialità(ArrayList<Persona> persone) {
		super(persone);
	}

	public void interazione(Persona a, Persona b, double delta) {
		if (Persona.compatibilitàRelazione(a, b)) {
			if (!a.hasPartner() && !b.hasPartner()) {
				if (Persona.fidanzamento(a, b)) {
					System.out.println("fidanzamento tra " + a + " " + b);
				}
			}
		}
		if (Persona.compatibilitàAmicizia(a, b)) {
			if (Persona.nuovaAmicizia(a, b)) {
				System.out.println("amicizia tra " + a + " " + b);
			}
		}
	}

}
