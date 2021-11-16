
import java.util.*;     // Scanner, Locale 
 
class Temperaturer 
{ 
    public static void main (String[] args) 
    { 
        System.out.println ("TEMPERATURER\n"); 
     
        // inmatningsverktyg 
        Scanner in = new Scanner (System.in); 
        in.useLocale (Locale.US); 
 
        // mata in uppgifter om antalet veckor och antalet mätningar 
        System.out.print ("antalet veckor: "); 
        int    antalVeckor = in.nextInt (); 
        System.out.print ("antalet mätningar per vecka: "); 
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
 
        // den minsta, den största och medeltemperaturen – veckovis 
        double[]    minT = new double[antalVeckor + 1]; 
        double[]    maxT = new double[antalVeckor + 1]; 
        double[]    sumT = new double[antalVeckor + 1]; 
        double[]    medelT = new double[antalVeckor + 1]; 
        // koden ska skrivas här 
        for (int vecka = 1; vecka <= antalVeckor; vecka++) 
        { 
        	maxT[vecka] = t[vecka][1];
        	minT[vecka] = t[vecka][1];
        	sumT[vecka] = 0;
        	
        	System.out.println("vecka" + vecka);
        	
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++) {
            	sumT[vecka] = t[vecka][matning] + sumT[vecka];
            	medelT[vecka] = sumT[vecka] / antalMatningarPerVecka;
                if (t[vecka][matning] > maxT[vecka]) {
                	maxT[vecka] = t[vecka][matning];
                }
                if (t[vecka][matning] <= minT[vecka]) {
                	minT[vecka] = t[vecka][matning];
                }  
                
            }
            
            System.out.println("avg " + medelT[vecka]);
            System.out.println("highest " + maxT[vecka]);
            System.out.println("lowest " + minT[vecka] + "\n");
            
        } 
        
        
        
        // visa den minsta, den största och medeltemperaturen för varje vecka 
        // koden ska skrivas här 
 
        // den minsta, den största och medeltemperaturen - hela mätperioden 
        double    minTemp = minT[1]; 
        double    maxTemp = maxT[1]; 
        double 	  medelTemp = 0;
        double    totsum = 0;
        // koden ska skrivas här 

        for (int vecka = 1; vecka <= antalVeckor; vecka++) 
        { 
        	totsum = medelT[vecka] + totsum;
        	medelTemp = totsum/antalVeckor;
        	if (maxT[vecka] > maxTemp) {
        		maxTemp = maxT[vecka];
        	}
        	if (minT[vecka] <= minTemp) {
        		minTemp = minT[vecka];
        	}

        } 
        
        // visa den minsta, den största och medeltemperaturen i hela mätperioden 
        System.out.println("medel: " + medelTemp);
        System.out.println("max: " + maxTemp);
        System.out.println("min: " + minTemp);
        
        
        
        in.close();
    } 
}