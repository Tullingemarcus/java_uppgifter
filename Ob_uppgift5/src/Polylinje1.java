import java.util.Arrays;

public class Polylinje1 {
	// instansvariabler
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;
	// skaper en tom polylinje
	public Polylinje1 ()
	{
		this.horn = new Punkt[0];
	}
	// skaper en polylinje valda punkter som hörn
	public Polylinje1 (Punkt[] horn)
	{
		this.horn = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++) {
			this.horn[i] = new Punkt (horn[i]);
		}
	}
	// returnerar polylinjen som en sträng
	public String toString () {
		Punkt[] my_array = this.horn;
		StringBuilder point = new StringBuilder(Arrays.toString(my_array));
		String p = point.toString();
		return p;
	}
	// ger ut Punkten i form av ett objekt
	public Punkt[] getHorn () {
		return this.horn;
	}
	// returnerar färgen på polylinjen
	public String getFarg () {
		return this.farg;
	}
	// returnerar bredden på polylinjen
	public int getBredd () {
		return this.bredd;
	}	
	// ändrar färgen till en vald färg
	public void setFarg (String farg) {
		this.farg = farg;
	}
	// ändrar bredden till en vald bredd
	public void setBredd (int bredd) {
		this.bredd = bredd;
	}
	// returnerar längden på polylinjen som en double
	public double langd () {
		double dist = 0;
		for (int i = 1; i < horn.length; i++) {
			this.horn[i] = new Punkt (horn[i]);
			dist = dist + this.horn[i].avstand(this.horn[i - 1]);
		}
		return dist;
	}
	// lägger till en punkt längst bak i polylinjen
	public void laggTill (Punkt horn)
	{
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i = 0;
		for (i = 0; i < this.horn.length; i++) {
			h[i] = this.horn[i];
		}
		h[i] = new Punkt (horn);	
		this.horn = h;
	}
	// lägger till en punkt framför en vald punkt i polylinjen
	public void laggTillFramfor (Punkt horn, String hornNamn) {
		int length = this.horn.length + 1;
		Punkt[] my_array = new Punkt[length];
		for(int i = 0; i < this.horn.length; i++) {
			if(hornNamn == this.horn[i].getNamn()) {
				for(int j = 0; j < i; j++) {
					my_array[j] = this.horn[j];
				}
				my_array[i] = horn;
				i += 1;
				for(int j = i; j < length; j++) {
					my_array[i] = this.horn[j - 1];
					i += 1;
				}
				this.horn = my_array;
			} 
		}	
	}
	// tar bort en vald punkt i polylinjen
	public void taBort (String hornNamn) {
		int length = this.horn.length - 1;
		Punkt[] my_array = new Punkt[length];
		for(int i = 0; i < this.horn.length - 1; i++) {
			if(hornNamn == this.horn[i].getNamn()) {
				my_array[i] = this.horn[i + 1];
			}
			else {
				my_array[i] = this.horn[i];
			}
		}
		this.horn = my_array;
	}

	
}
