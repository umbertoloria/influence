package persone;

import launcher.Launcher;
import lwjgl.renderables.Entity;
import lwjgl.stuff.Color;
import lwjgl.stuff.Draw;
import lwjgl.stuff.Vec2;

import java.util.ArrayList;
import java.util.Random;

public class Persona extends Entity {

	private String nome, cognome;
	private String nomeCompleto;
	private boolean maschio;
	private Carattere carattere;
	private Aspetto aspetto;
	private Persona partner;
	private ArrayList<Persona> amici = new ArrayList<>();

	private Color cl;
	private Vec2 pos;
	private double size;
	private Random r = Launcher.r;

	public Persona(String nome, String cognome, boolean maschio, Carattere carattere, Aspetto aspetto) {
		this.nome = nome;
		this.cognome = cognome;
		this.nomeCompleto = nome + " " + cognome;
		this.maschio = maschio;
		this.carattere = carattere;
		this.aspetto = aspetto;
		this.cl = Color.createFrom(nomeCompleto);
		this.pos = new Vec2(10 + r.nextInt(80), 10 + r.nextInt(80));
		this.size = (maschio ? 15 : 10) * (1 + (r.nextInt(31) / 100d));
		Launcher.gw.add(this);
	}

	public void render() {
		Draw.quad(pos.x(), pos.y(), size, size, cl);
		/*if (dir != null) {
			Draw.quad(dir.x(), dir.y(), 3, 3, cl);
		}*/
	}

	private Vec2 dir;

	private double speed = 10 + r.nextInt(6);

	public void update(double delta) {
		if (dir == null) {
			newDestination();
			speed++;
		} else {
			double distance = pos.distanceTo(dir);
			if (speed * delta < distance) {
				pos.move(pos.angleTo(dir), speed * delta);
			} else {
				pos.placeTo(dir);
				dir = null;
			}
		}
	}

	private void newDestination() {
		if (hasPartner()) {
			dir = (Vec2) partner.pos.clone();
		} else {
			dir = (Vec2) pos.clone();
			dir.move(r.nextDouble() * 360, 10);
		}
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public boolean isMaschio() {
		return maschio;
	}

	public boolean hasPartner() {
		return partner != null;
	}

	public void setPartner(Persona partner) {
		if (!hasPartner()) {
			this.partner = partner;
		}
	}

	public boolean isAmico(Persona forseAmico) {
		for (Persona amico : amici) {
			if (amico == forseAmico) {
				return true;
			}
		}
		return false;
	}

	public void addAmico(Persona nuovoAmico) {
		if (!isAmico(nuovoAmico)) {
			amici.add(nuovoAmico);
		}
	}

	public String toString() {
		return getClass().getName() + "[nomeCompleto=" + nomeCompleto + "]";
	}

	// Statics

	public static boolean compatibilitàRelazione(Persona a, Persona b) {
		return Carattere.punteggioRelazione(a.carattere, b.carattere)
				+ Aspetto.punteggioRelazione(a.aspetto, b.aspetto) > 5;
	}

	public static boolean compatibilitàAmicizia(Persona a, Persona b) {
		return Carattere.punteggioAmicizia(a.carattere, b.carattere) > 5;
	}

	public static boolean nuovaAmicizia(Persona a, Persona b) {
		boolean res = false;
		if (!a.isAmico(b)) {
			a.addAmico(b);
			res = true;
		}
		if (!b.isAmico(a)) {
			b.addAmico(a);
			res = true;
		}
		return res;
	}

	public static boolean fidanzamento(Persona a, Persona b) {
		if (!a.hasPartner() && !b.hasPartner()) {
			a.setPartner(b);
			b.setPartner(a);
			return true;
		}
		return false;
	}

	public static boolean fidanzati(Persona a, Persona b) {
		return a.partner == b && b.partner == a;
	}

	public static boolean amici(Persona a, Persona b) {
		return a.isAmico(b) && b.isAmico(a);
	}

}
