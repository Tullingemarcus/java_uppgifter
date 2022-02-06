
import java.util.*;     // Scanner, Locale 
 
class Temperaturer 
{ 
    public static void main (String[] args) 
    { 
        System.out.println ("TEMPERATURER\n"); 
     
        // inmatningsverktyg 
        Scanner in = new Scanner (System.in); 
        in.useLocale (Locale.US); 
 
        // mata in uppgifter om antalet veckor och antalet m�tningar 
        System.out.print ("antalet veckor: "); 
        int    antalVeckor = in.nextInt (); 
        System.out.print ("antalet m�tningar per vecka: "); 
        int    antalMatningarPerVecka = in.nextInt (); 
 
        // plats att lagra temperaturer 
        double[][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1]; 
 
        // mata in temperaturerna 
        for (int vecka = 1; vecka <= antalVeckor; vecka++) 
        { 
            System.out.println ("temperaturer - vecka " + vecka + ":"); 
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++) 
                t[vecka][matning] = in.nextDouble (); 
        } 
        System.out.println (); 
 
        // visa temperaturerna 
        System.out.println ("temperaturerna:"); 
        for (int vecka = 1; vecka <= antalVeckor; vecka++) 
        { 
        	System.out.println("vecka" + vecka);
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++) 
                System.out.print (t[vecka][matning] + " "); 
            System.out.println (); 
        } 
        System.out.println (); 
 
        // den minsta, den st�rsta och medeltemperaturen � veckovis 
        double[]    minT = new double[antalVeckor + 1]; 
        double[]    maxT = new double[antalVeckor + 1]; 
        double[]    sumT = new double[antalVeckor + 1]; 
        double[]    medelT = new double[antalVeckor + 1]; 
        
        //en loop f�r att r�nka ut medeltemperaturen, 
        //maxtemperaturen och minimumtemperaturen f�r varje vecka
        for (int vecka = 1; vecka <= antalVeckor; vecka++) 
        { 
        	//maxT, minT och sumT definieras
        	maxT[vecka] = t[vecka][1];
        	minT[vecka] = t[vecka][1];
        	sumT[vecka] = 0;
        	
        	//visar vilken vecka som visas
        	System.out.println("vecka" + vecka);
        	
        	//r�knar ut medeltemperaturen, maxtemperaturen och mintemperaturen p� en specifik vecka
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++) {
            	//r�knar ut summan av temperaturerna p� en vecka
            	sumT[vecka] = t[vecka][matning] + sumT[vecka];
            	
            	//r�knar ut maxtemperaturen och mintemperaturen f�r en specifik vecka
                if (t[vecka][matning] > maxT[vecka]) {
                	maxT[vecka] = t[vecka][matning];
                }
                if (t[vecka][matning] <= minT[vecka]) {
                	minT[vecka] = t[vecka][matning];
                }                 
            }
            
         //r�knar ut medeltemperaturen av summan
         medelT[vecka] = sumT[vecka] / antalMatningarPerVecka;
            
         // visa den minsta, den st�rsta och medeltemperaturen f�r varje vecka 
         System.out.println("avg " + medelT[vecka]);
         System.out.println("highest " + maxT[vecka]);
         System.out.println("lowest " + minT[vecka] + "\n");      
        } 
        
        // den minsta, den st�rsta och medeltemperaturen - hela m�tperioden 
        double    minTemp = minT[1]; 
        double    maxTemp = maxT[1]; 
        double 	  medelTemp = 0;
        double    totsum = 0;
        for (int vecka = 1; vecka <= antalVeckor; vecka++) 
        { 
        	//summan av medeltemperaturerna
        	totsum = medelT[vecka] + totsum;
        	//utr�nkinga av medeltemperaturen under hela perioden
        	medelTemp = totsum / antalVeckor;
        	
        	//utr�kning av maxv�rde och minimum v�rde under hela perioden
        	if (maxT[vecka] > maxTemp) {
        		maxTemp = maxT[vecka];
        	}
        	if (minT[vecka] <= minTemp) {
        		minTemp = minT[vecka];
        	}
        } 
        
        // visa den minsta, den st�rsta och medeltemperaturen i hela m�tperioden 
        System.out.println("medel: " + medelTemp);
        System.out.println("max: " + maxTemp);
        System.out.println("min: " + minTemp);
        
        in.close();
    } 
}