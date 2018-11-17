package persone;

import launcher.Launcher;
import lwjgl.renderables.Entity;
import lwjgl.stuff.Color;
import lwjgl.stuff.Draw;

import java.util.Random;

public class Persona extends Entity {

	private String nome, cognome;
	private String nomeCompleto;
	private boolean maschio;
	private Color cl;
	private double x, y, size;
	private Random r = Launcher.r;

	public Persona(String nome, String cognome, boolean maschio) {
		this.nome = nome;
		this.cognome = cognome;
		this.maschio = maschio;
		this.nomeCompleto = nome + " " + cognome;
		this.cl = Color.createFrom(nomeCompleto);
		this.x = 10 + r.nextInt(80);
		this.y = 10 + r.nextInt(80);
		this.size = (maschio ? 15 : 10) * (1 + (r.nextInt(31) / 100d));
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

	public void render() {
		Draw.quad(x, y, size, size, cl);
	}

	public void update() {
	}
}
