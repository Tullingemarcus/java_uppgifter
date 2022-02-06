import java.util.*; // Scanner, locale
public class operationer_med_strängar {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);
		
		String a = in.nextLine();
		String b = in.nextLine();

		System.out.println(addera(a, b));
		System.out.println(subtrahera(a, b));
		System.out.println("stop");
		in.close();
	}
	
	public static String addera(String a, String b) {
		StringBuilder sb1 = new StringBuilder(a);
		StringBuilder sb2 = new StringBuilder(b);
		
		int length1 = sb1.length();
		int length2 = sb2.length();
		
		for(int i = 0; i < (length2 - length1); i++) {
			sb1.insert(0, 0);
		}
		for(int i = 0; i < (length1 - length2); i++) {
			sb2.insert(0, 0);
		}
		
		int u = 0;
		int length = sb2.length();
		StringBuilder t_string = new StringBuilder(0);
		for(int i = 0; i < length; i++) {
			int s = (sb1.charAt(length - (i + 1)) - 48) + (sb2.charAt(length - (i + 1)) - 48) + u;
			StringBuilder sb_add = new StringBuilder(Integer.toString(s));
			t_string.insert(0, sb_add.charAt(sb_add.length() - 1));
			u = 0;
			if(sb_add.length() == 2) {
				u = 1;
			}
		}
		if(u == 1) {
			t_string.insert(0, 1);
		}
		String t = t_string.toString();
		return t;
	}

	public static String subtrahera(String a, String b) {
		StringBuilder sb1 = new StringBuilder(a);
		StringBuilder sb2 = new StringBuilder(b);
		
		int length1 = sb1.length();
		int length2 = sb2.length();
		
		for(int i = 0; i < (length2 - length1); i++) {
			sb1.insert(0, 0);
		}
		for(int i = 0; i < (length1 - length2); i++) {
			sb2.insert(0, 0);
		}
		
		int u = 0;
		int length = sb2.length();
		StringBuilder t_string = new StringBuilder(0);
		for(int i = 0; i < length; i++) {
			int s = (sb1.charAt(length - (i + 1)) - 48) - (sb2.charAt(length - (i + 1)) - 48) - u;
			StringBuilder sb_add = new StringBuilder(Integer.toString(s));
			u = 0;
			int x = sb_add.charAt(sb_add.length() - 1) - 48;
			if(sb_add.length() > 1) {
				u = 1;
				x = 10 - x;
			}
			String g = Integer.toString(x);
			sb_add = new StringBuilder(g);
			t_string.insert(0, sb_add.charAt(sb_add.length() - 1));
		}
		while(t_string.charAt(0) == 48) {
			t_string.deleteCharAt(0);
		}
		String t = t_string.toString();
		return t;
	}

}
