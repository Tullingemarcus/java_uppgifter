import java.util.*;

public class ValjPolylinje {
	public static final Random rand = new Random ();
	public static final int ANTAL_POLYLINJER = 4;
	public static void main (String[] args)
	{
		// skapa ett antal slumpm�ssiga polylinjer
		Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
		for (int i = 0; i < ANTAL_POLYLINJER; i++) {
			polylinjer[i] = slumpPolylinje ();
		}
		// visa polylinjerna
		for (int i = 0; i < ANTAL_POLYLINJER; i++) {
			System.out.println(polylinjer[i]);
			System.out.println(polylinjer[i].getFarg());
			System.out.println(polylinjer[i].langd());
			System.out.println();
		}
		// best�m den kortaste av de polylinjer som �r gula
		double kortaste = Double.MAX_VALUE;
		Polylinje gul = null;
		for(int i = 0; i < ANTAL_POLYLINJER; i++) {
			if(polylinjer[i].getFarg().equals("Gul") && kortaste > polylinjer[i].langd()) {
				kortaste = polylinjer[i].langd();
				gul = polylinjer[i];
			}
		}
		if(gul == null) {
			System.out.println("inga gula linjer");
		}
		// visa den valda polylinjen
		else {
			System.out.println("kortaste gula polylinjen: " + gul.langd() + " "+ gul);
		}
	}
	// slumpPunkt returnerar en punkt med ett slumpm�ssigt namn, som �r en stor bokstav i
	// det engelska alfabetet, och slumpm�ssiga koordinater.
	public static Punkt slumpPunkt ()
	{
		String n = "" + (char) (65 + rand.nextInt (26));
		int x = rand.nextInt (11);
		int y = rand.nextInt (11);
		return new Punkt (n, x, y);
	}
	// slumpPolylinje returnerar en slumpm�ssig polylinje, vars f�rg �r antingen bl�, eller r�d
	// eller gul. Namn p� polylinjens h�rn �r stora bokst�ver i det engelska alfabetet. Tv� h�rn
	// kan inte ha samma namn.
	public static Polylinje slumpPolylinje ()
	{
		// skapa en tom polylinje, och l�gg till h�rn till den
		Polylinje polylinje = new Polylinje ();
		int antalHorn = 2 + rand.nextInt (7);
		int antalValdaHorn = 0;
		while (antalValdaHorn < antalHorn)
		{
			polylinje.laggTill(slumpPunkt());
			antalValdaHorn += 1; 
		}
		boolean[] valdaNamn = new boolean[26];
		
		// ett och samma namn kan inte f�rekomma flera g�nger
		Punkt valdPunkt = null;
		Polylinje list = new Polylinje();
		char valtChar = 0;
		int j = 0;
		for(int i = 0; i < antalHorn; i++) {
			valdPunkt = (j == 0)?polylinje.getHorn()[i] : valdPunkt;
			valtChar = valdPunkt.getNamn().charAt(0);
			if(valdaNamn[Character.getNumericValue(valtChar) - 10] == true) {
				valdPunkt = slumpPunkt();
				i = i - 1;
				j = 1;
			}
			if(valdaNamn[Character.getNumericValue(valtChar) - 10] == false) {
				valdaNamn[Character.getNumericValue(valtChar) - 10] = true;
				valdPunkt = polylinje.getHorn()[i];
				j = 0;
			}
			list.laggTill(valdPunkt);
		}
		polylinje = list;
		// s�tt f�rg
		String[] farger = {"R�d", "Gul", "Bl�"};
		polylinje.setFarg(farger[rand.nextInt(3)]);
		return polylinje;
	}
}
