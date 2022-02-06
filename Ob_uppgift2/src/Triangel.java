/**********************************************************
I det här programmet kan man göra uträkningar som är relaterade
till trianglar. De uträkningar som går att göra är
arean, omkretsen, bisektrisen, den omskrivna och den inskrivan cirkeln
**********************************************************/

public class Triangel {
	
	//beräknar arean
	//metoden tar emot variablarna height och side
	public static double area(double side, double height) {
		double area = height * side / 2;
		return area;
	}
	
	//beräknar bisektrisen
	//metoden tar emot variablarna för de två sidorna och vinkeln emellan dem
	public static double bis(double sida1, double sida2, double vinkel) {
		vinkel = Math.PI * vinkel / 180;
		double p = 2 * sida1 * sida2 * Math.cos (vinkel / 2); 
	    double bisektris = p / (sida1 + sida2);
		return bisektris;
	}
	
	//beräknar omkretsen
	//metoden tar emot variablar för tre sidor
	public static double omk(double sida1, double sida2, double sida3) {
		double omkrets = sida1 + sida2 + sida3;
		return omkrets;
	}
	
	//denna metod gör beräkningarna för den inskrivna cirkeln
	//funktionen tar in de tre sidorna
	public static double inskrivna_radien(double sida1, double sida2, double sida3) {
		double s = (sida1 + sida2 + sida3) / 2;
		double radie = Math.sqrt((s - sida1) * (s - sida2) * (s - sida3) / s); 
		return radie;
	}
	
	// beräkningarna för den omskrivna cirkeln
	// funktionen tar de tre sidorna
	public static double omskrivna_radien(double sida1, double sida2, double sida3) {
		double s = (sida1 + sida2 + sida3) / 2;
		double t = 4 * Math.sqrt(s * (s - sida1) * (s - sida2) * (s - sida3));
		double radie = (sida1 * sida2 * sida3) / t;
		return radie;
	}
}
