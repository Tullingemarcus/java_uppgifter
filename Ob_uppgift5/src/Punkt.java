import java.util.*; // Math, StringBuilder
public class Punkt {
	private int x;
	private int y;
	private String n;
	// skapar en punkt med givna parametrar
	public Punkt(String n, int x, int y) {
		this.x = x;
		this.y = y;
		this.n = n;
	}
	// returnerar x v�rdet fr�n punkten 
	public int getX() {
		return this.x;
	}
	// returnerar y v�rdet fr�n punkten 
	public int getY() {
		return this.y;
	}
	// returnerar namnet fr�n punkten 
	public String getNamn() {
		return this.n;
	}
	// returnerar avst�ndet mellan tv� punkter
	double avstand(Punkt p) {	
		double px = this.x - p.x;
		double py = this.y - p.y;
		px = Math.pow(px, 2);
		py = Math.pow(py, 2);
		double dist = Math.sqrt(px + py);
		return dist;
	}
	// kollar om tv� punkters v�rde �r samma och returnerar true eller false
	boolean equals(Punkt p) {
		return this.x == p.x && this.y == p.y;
	}
	// �ndrar x v�rdet till given parameter
	public void setX(int x) {
		this.x = x;
	}
	// �ndrar y v�rdet till given parameter
	public void setY(int y) {
		this.y = y;
	}
	// kopierar punkten p
	public Punkt(Punkt p) {
		this.n = p.n;
		this.x = p.x;
		this.y = p.y;
	}
	// returnerar punkten som en str�ng
	public String toString() {
		Object[] my_array = {n, x, y};
		return Arrays.toString(my_array);
	}
	
}
