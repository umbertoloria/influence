package lwjgl.stuff;

import static org.lwjgl.opengl.GL11.*;

public class Color {

	private float r, g, b, a = 1f;

	public Color(float r, float g, float b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public Color(float r, float g, float b, float a) {
		this(r, g, b);
		this.a = a;
	}

	public void apply() {
		glColor4f(r, g, b, a);
	}

	// Mappa dei valori
	// A B C D E F G H I J K L M N O P Q R S T U V W X Y Z a b c d e f g h i j k l m n o p q r s t u v w x y z
	// 1 2 3 4 5 6 7 8 9 10111213141516171819202122232425262728293031323334353637383940414243444546474849505152
	public static Color createFrom(String str) {
		int val = 0;
		for (char c : str.toCharArray()) {
			if ('a' <= c && c <= 'z') {
				val += 27 + (c - 'a');
			} else if ('A' <= c && c <= 'Z') {
				val += 1 + (c - 'A');
			}
		}
		val = (int) (val / (double) str.length());
		System.out.println(val);
		// FIXME: 29 e 31 stesso colore

		// 52 tutte le lettere maiuscole e minuscole
		int c = (int) (0xffffff / 52d * val);

		float r = (c & 0xff0000) << 24;
		float g = (c & 0x00ff00) << 16;
		float b = (c & 0x0000ff) << 8;

		return new Color(r, g, b);
	}

}
