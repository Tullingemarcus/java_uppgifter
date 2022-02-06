import java.util.*;    // Scanner 
import static java.lang.System.out; 
 
class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar 
{ 
    public static void main (String[] args) 
    { 
        out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n"); 
 
        // mata in tv� naturliga heltal 
        Scanner    in = new Scanner (System.in); 
        out.println ("tv� naturliga heltal:"); 
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
 
    // addera tar emot tv� naturliga heltal givna som teckenstr�ngar, och returnerar deras 
    // summa som en teckenstr�ng. 
    public static String addera (String tal1, String tal2) 
    { 
    	// g�r om str�ngarna till arrays 
    	StringBuilder sb1 = new StringBuilder(tal1);
		StringBuilder sb2 = new StringBuilder(tal2);
		
		// g�r arraysen till samma l�ngd
		int length1 = sb1.length();
		int length2 = sb2.length();
		for(int i = 0; i < (length2 - length1); i++) {
			sb1.insert(0, 0);
		}
		for(int i = 0; i < (length1 - length2); i++) {
			sb2.insert(0, 0);
		}
		int length = sb2.length();
		
		// r�knar ut talet element f�r element
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
 
    // subtrahera tar emot tv� naturliga heltal givna som teckenstr�ngar, och returnerar 
    // deras differens som en teckenstr�ng. 
    // Det f�rsta heltalet �r inte mindre �n det andra heltalet. 
    public static String subtrahera (String tal1, String tal2) 
    { 
    	// g�r om str�ngarna till arrays 
    	StringBuilder sb1 = new StringBuilder(tal1);
		StringBuilder sb2 = new StringBuilder(tal2);
		
		// kollar om det �r en ogiltig subtraktion
		if(sb1.length() < sb2.length() || sb1.charAt(0) < sb2.charAt(0)  && sb1.length() == sb2.length()) {
			out.println("Inte giltiga tal f�r subtraction");
			System.exit(0);
		}
		
		// g�r arraysen till samma l�ngd
		int length1 = sb1.length();
		int length2 = sb2.length();
		for(int i = 0; i < (length2 - length1); i++) {
			sb1.insert(0, 0);
		}
		for(int i = 0; i < (length1 - length2); i++) {
			sb2.insert(0, 0);
		}
		int length = sb2.length();
		
		// r�knar ut talet element f�r element
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
 
    // visa visar tv� givna naturliga heltal, och resultatet av en aritmetisk operation 
    // utf�rd i samband med hetalen 
 public static void visa (String tal1, String tal2, String resultat, char operator) 
    { 
        // s�tt en l�mplig l�ngd p� heltalen och resultatet 
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
 
    // sattLen l�gger till ett angivet antal mellanslag i b�rjan av en given str�ng 
 public static String sattLen (String s, int antal) 
 { 
        StringBuilder    sb = new StringBuilder (s); 
        for (int i = 0; i < antal; i++) 
            sb.insert (0, " "); 
 
        return sb.toString (); 
 } 
}