
public class PolylinjeTest {

	public static void main(String[] args) {
		// skapar punkter
		Punkt A = new Punkt("A", 0, 0);
		Punkt B = new Punkt("B", 3, 4);
		Punkt C = new Punkt("C", 9, 12);
		Punkt D = new Punkt("D", 15, 20);
		Punkt E = new Punkt("D", 15, 20);
		
		// g�r en array av punkterna och g�r dem till en polylinje
		Punkt[] array = {A, B, D, E};
		Polylinje p = new Polylinje(array);
		
		// skriver ut polylinjen
		System.out.println("-------------------------------------");
		System.out.println(p);
		System.out.println(p.getHorn()[0]);
		System.out.println();
		
		// �ndrar f�rgen till bl� och skriver ut den
		System.out.println("-------------------------------------");
		p.setFarg("bl�");
		System.out.println(p.getFarg());
		
		// l�gger till C och skriver ut l�ngden och den nya polylinjen
		System.out.println("-------------------------------------");
		p.laggTill(C);
		System.out.println(p.langd());
		System.out.println(p);
		
		// skriver ut namnet p� punkten A
		System.out.println("-------------------------------------");
		System.out.println(A.getNamn());
		
		// l�gger till punkt C framf�r punkten med namnet D
		System.out.println("-------------------------------------"
				+ "			h�ra");
		p.laggTillFramfor(C, "Z");
		System.out.println(p);
		//p.laggTillFramfor(A, "Z");
		//System.out.println(p);
		
		// tar bort punkten med namnet D
		System.out.println("-------------------------------------"
				+ "           h�ra ");
		p.taBort("Z");
		System.out.println(p);
		
		Polylinje1 p2 = new Polylinje1(array);
		System.out.println("-------------------------------------");
		p2.getHorn()[1] = D;
		System.out.println(p2.getHorn()[1]);
		System.out.println();
		System.out.println("-------------------------------------");
		Polylinje.PolylinjeIterator pi = p.new PolylinjeIterator();
		while(pi.finnsHorn()) {
			System.out.println(pi.horn());
			pi.gaFram();
		}
	}

}
