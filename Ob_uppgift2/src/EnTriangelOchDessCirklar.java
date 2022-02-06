/**********************************************************
 Det h�r programmet tar in tre sidor och som sedans anv�nds f�r att ber�kna
 en triangels inskrivna och omskrivna cirkels radie
 **********************************************************/

import java.util.*; //Scanner Locale
public class EnTriangelOchDessCirklar {

	public static void main(String[] args) {
		//inmatningsverktygen
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);
		
		//Inmatning av v�rden
		System.out.println("sida1: ");
		double sida1 = in.nextInt();
		System.out.println("sida2: ");
		double sida2 = in.nextInt();
		System.out.println("sida3: ");
		double sida3 = in.nextInt();
		
		//v�rdena f�r metoderna skrivs ut
		System.out.println("yttre radien �r: " + Triangel.omskrivna_radien(sida1, sida2, sida3));
		System.out.println("innre radien �r: " + Triangel.inskrivna_radien(sida1, sida2, sida3));
		in.close();	
	}
}
