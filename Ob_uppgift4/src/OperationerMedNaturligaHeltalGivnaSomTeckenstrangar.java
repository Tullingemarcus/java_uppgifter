import java.util.*;    // Scanner 
import static java.lang.System.out; 
 
class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar 
{ 
    public static void main (String[] args) 
    { 
        out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n"); 
 
        // mata in två naturliga heltal 
        Scanner    in = new Scanner (System.in); 
        out.println ("två naturliga heltal:"); 
        String    tal1 = in.next (); 
        String    tal2 = in.next (); 
        out.println (); 
 
        // addera heltalen och visa resultatet 
        String    summa = addera (tal1, tal2); 
        visa (tal1, tal2, summa, '+'); 
        // subtrahera heltalen och visa resultatet 
        String    differens = subtrahera (tal1, tal2); 
        visa(tal1, tal2, differens, '-');
        in.close();
    } 
 
    // addera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras 
    // summa som en teckensträng. 
    public static String addera (String tal1, String tal2) 
    { 
    	// gör om strängarna till arrays 
    	StringBuilder sb1 = new StringBuilder(tal1);
		StringBuilder sb2 = new StringBuilder(tal2);
		
		// gör arraysen till samma längd
		int length1 = sb1.length();
		int length2 = sb2.length();
		for(int i = 0; i < (length2 - length1); i++) {
			sb1.insert(0, 0);
		}
		for(int i = 0; i < (length1 - length2); i++) {
			sb2.insert(0, 0);
		}
		int length = sb2.length();
		
		// räknar ut talet element för element
		int m = 0;
		StringBuilder total_summa = new StringBuilder(0);
		for(int i = length; i > 0; i--) {
			int n1 = Character.getNumericValue(sb1.charAt(i - 1));  
			int n2 = Character.getNumericValue(sb2.charAt(i - 1));
			
			int sum = n1 + n2 + m;
			m = 0;
			if(sum >= 10) {
				m = 1;
			}
			StringBuilder sb_add = new StringBuilder(Integer.toString(sum));
			total_summa.insert(0, sb_add.charAt(sb_add.length() - 1));
		}
		if(m == 1) {
			total_summa.insert(0, 1);
		}
		String resultat = total_summa.toString();
		return resultat;
    } 
 
    // subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerar 
    // deras differens som en teckensträng. 
    // Det första heltalet är inte mindre än det andra heltalet. 
    public static String subtrahera (String tal1, String tal2) 
    { 
    	// gör om strängarna till arrays 
    	StringBuilder sb1 = new StringBuilder(tal1);
		StringBuilder sb2 = new StringBuilder(tal2);
		
		// kollar om det är en ogiltig subtraktion
		if(sb1.length() < sb2.length() || sb1.charAt(0) < sb2.charAt(0)  && sb1.length() == sb2.length()) {
			out.println("Inte giltiga tal för subtraction");
			System.exit(0);
		}
		
		// gör arraysen till samma längd
		int length1 = sb1.length();
		int length2 = sb2.length();
		for(int i = 0; i < (length2 - length1); i++) {
			sb1.insert(0, 0);
		}
		for(int i = 0; i < (length1 - length2); i++) {
			sb2.insert(0, 0);
		}
		int length = sb2.length();
		
		// räknar ut talet element för element
		int m = 0;
		StringBuilder total_differens = new StringBuilder(0);
		for(int i = length; i > 0; i--) {
			int n1 = Character.getNumericValue(sb1.charAt(i - 1));  
			int n2 = Character.getNumericValue(sb2.charAt(i - 1));
			int dif = n1 - n2 - m;
			m = 0;
			if(dif < 0) {
				m = 1;
				dif = 10 + dif;
			}
			StringBuilder sb_add = new StringBuilder(Integer.toString(dif));
			total_differens.insert(0, sb_add.charAt(sb_add.length() - 1));
		}
		while(total_differens.charAt(0) == '0' && total_differens.length() > 1) {
			total_differens.deleteCharAt(0);
		}
		String resultat = total_differens.toString();
		return resultat;
    } 
 
    // visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation 
    // utförd i samband med hetalen 
 public static void visa (String tal1, String tal2, String resultat, char operator) 
    { 
        // sätt en lämplig längd på heltalen och resultatet 
        int    len1 = tal1.length (); 
        int    len2 = tal2.length (); 
        int    len  = resultat.length (); 
        int    maxLen = Math.max (Math.max (len1, len2), len); 
        tal1 = sattLen (tal1, maxLen - len1); 
        tal2 = sattLen (tal2, maxLen - len2); 
        resultat = sattLen (resultat, maxLen - len); 
 
        // visa heltalen och resultatet 
        out.println ("  " + tal1); 
        out.println ("" + operator + " " + tal2); 
        for (int i = 0; i < maxLen + 2; i++) 
            out.print ("-"); 
        out.println (); 
        out.println ("  " + resultat + "\n"); 
 } 
 
    // sattLen lägger till ett angivet antal mellanslag i början av en given sträng 
 public static String sattLen (String s, int antal) 
 { 
        StringBuilder    sb = new StringBuilder (s); 
        for (int i = 0; i < antal; i++) 
            sb.insert (0, " "); 
 
        return sb.toString (); 
 } 
}