package persone;

public class Carattere {

	private int felicità;
	private int autostima;
	private int popolarità;
	private int introversia;

	public Carattere(int felicità, int autostima, int popolarità, int introversia) {
		setFelicità(felicità);
		setAutostima(autostima);
		setPopolarità(popolarità);
		setIntroversia(introversia);
	}

	public static int punteggioRelazione(Carattere a, Carattere b) {
		int legame = 0;
		legame += 5 - Math.abs(a.getPopolarità() - b.getPopolarità());
		legame += 3 - Math.abs(a.getIntroversia() - b.getIntroversia());
		return legame;
	}

	public static int punteggioAmicizia(Carattere a, Carattere b) {
		int legame = 0;
		if (a.getPopolarità() > 6 || b.getPopolarità() > 6) {
			legame += a.getPopolarità() - 6;
			legame += b.getPopolarità() - 6;
		}
		legame += 3 - Math.abs(a.getIntroversia() - b.getIntroversia());
		return legame;
	}

	public int getFelicità() {
		return felicità;
	}

	public void setFelicità(int felicità) {
		if (1 <= felicità && felicità <= 10) {
			this.felicità = felicità;
		}
	}

	public int getAutostima() {
		return autostima;
	}

	public void setAutostima(int autostima) {
		if (1 <= autostima && autostima <= 10) {
			this.autostima = autostima;
		}
	}

	public int getPopolarità() {
		return popolarità;
	}

	public void setPopolarità(int popolarità) {
		if (1 <= popolarità && popolarità <= 10) {
			this.popolarità = popolarità;
		}
	}

	public int getIntroversia() {
		return introversia;
	}

	public void setIntroversia(int introversia) {
		this.introversia = introversia;
	}

}
