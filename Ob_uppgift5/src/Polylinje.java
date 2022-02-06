

import java.util.Arrays; // StringBuilder

public class Polylinje
{
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;
	// skaper en tom polylinje
	public Polylinje ()
	{
		this.horn = new Punkt[0];
	}
	// skaper en polylinje valda punkter som hörn
	public Polylinje (Punkt[] horn)
	{
		this.horn = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++) {
			this.horn[i] = new Punkt (horn[i]);
		}
	}
	// returnerar polylinjen som en sträng
	public String toString () {
		Punkt[] newPunkt = this.horn;
		StringBuilder point = new StringBuilder(Arrays.toString(newPunkt));
		String p = point.toString();
		return p + " " + farg + " " + bredd;
	}
	// ger en kopia av en specifik punkt
	public Punkt[] getHorn () {
		Punkt[] newPunkt = new Punkt[this.horn.length];
		for(int i = 0; i < this.horn.length; i++) {
			newPunkt[i] = new Punkt(this.horn[i]);
		}
		return newPunkt;
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
		Punkt[] newPunkt = new Punkt[this.horn.length + 1];
		int i = 0;
		for (i = 0; i < this.horn.length; i++) {
			newPunkt[i] = this.horn[i];
		}
		newPunkt[i] = new Punkt (horn);	
		this.horn = newPunkt;
	}
	// lägger till en punkt framför en vald punkt i polylinjen
	public void laggTillFramfor (Punkt horn, String hornNamn) {
		int length = this.horn.length + 1;
		Punkt[] newPunkt = new Punkt[length];
		int j = 0;
		for(int i = 0; i < this.horn.length; i++) {
			if(hornNamn != this.horn[i].getNamn() || j == 1) {
				newPunkt[i] = this.horn[i - j];
			}
			else {
				newPunkt[i] = horn;
				j += 1;
				//System.out.println(my_array[i]);
			}
		}	
		newPunkt[length - 1] = this.horn[length - 2];
		this.horn = newPunkt;
	}
	// tar bort en vald punkt i polylinjen
	public void taBort (String hornNamn) {
		int length = this.horn.length - 1;
		Punkt[] newPunkt = new Punkt[length];
		for(int i = 0; i < this.horn.length - 1; i++) {
			if(hornNamn == this.horn[i].getNamn()) {
				newPunkt[i] = this.horn[i + 1];
			}
			else {
				newPunkt[i] = this.horn[i];
			}
		}
		this.horn = newPunkt;
	}

	// en nästlad klass
	public class PolylinjeIterator {
		// instansvariabel
		private int aktuell = -1;
		// 
		public PolylinjeIterator ()
		{
			if (Polylinje.this.horn.length > 0) {
				aktuell = 0;
			}
		}
		// kollar om det finns punkter i polylinjen
		public boolean finnsHorn ()
		{
			return aktuell != -1;
		}
		// ger ut den nuvarande punkten i polylinjen
		public Punkt horn () throws java.util.NoSuchElementException
		{
			if (!this.finnsHorn ()) {
				throw new java.util.NoSuchElementException (
						"slut av iterationen");
			}
			Punkt horn = Polylinje.this.horn[aktuell];
			return horn;
		}
		// går fram en punkt i polylinjen
		public void gaFram ()
		{
			if (aktuell >= 0 && aktuell < Polylinje.this.horn.length - 1) {
				aktuell++;
			}
			
			else {
				aktuell = -1;
			}
		}
	}
}