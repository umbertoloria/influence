package persone;

public class Aspetto {

	private int bellezza;

	public Aspetto(int bellezza) {
		setBellezza(bellezza);
	}

	public static int punteggioRelazione(Aspetto a, Aspetto b) {
		int legame = 0;
		legame += 5 - Math.abs(a.getBellezza() - b.getBellezza());
		return legame;
	}

	public int getBellezza() {
		return bellezza;
	}

	public void setBellezza(int bellezza) {
		if (1 <= bellezza && bellezza <= 10) {
			this.bellezza = bellezza;
		}
	}
}
