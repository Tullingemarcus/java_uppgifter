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
	// returnerar x värdet från punkten 
	public int getX() {
		return this.x;
	}
	// returnerar y värdet från punkten 
	public int getY() {
		return this.y;
	}
	// returnerar namnet från punkten 
	public String getNamn() {
		return this.n;
	}
	// returnerar avståndet mellan två punkter
	double avstand(Punkt p) {	
		double px = this.x - p.x;
		double py = this.y - p.y;
		px = Math.pow(px, 2);
		py = Math.pow(py, 2);
		double dist = Math.sqrt(px + py);
		return dist;
	}
	// kollar om två punkters värde är samma och returnerar true eller false
	boolean equals(Punkt p) {
		return this.x == p.x && this.y == p.y;
	}
	// ändrar x värdet till given parameter
	public void setX(int x) {
		this.x = x;
	}
	// ändrar y värdet till given parameter
	public void setY(int y) {
		this.y = y;
	}
	// kopierar punkten p
	public Punkt(Punkt p) {
		this.n = p.n;
		this.x = p.x;
		this.y = p.y;
	}
	// returnerar punkten som en sträng
	public String toString() {
		Object[] my_array = {n, x, y};
		return Arrays.toString(my_array);
	}
	
}
