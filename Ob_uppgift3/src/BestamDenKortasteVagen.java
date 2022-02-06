/**********************************************
Det här programmet skriver ut den kortaste vägen 
mellan två stationer och vilka stationer som behövs passeras
**********************************************/

import java.util.*;
public class BestamDenKortasteVagen {

	public static void main(String[] args) {
		// längderna mellan stationerna
		double[] a = {1, 4, 8};
		double[][] b = {{19, 6, 8, 8}, {4, 1, 9, 12}, {7, 6, 2, 4}};
		double[] c = {7, 9, 23, 6};
		// den kortaste längden som man behöver ta
		// och vilka stationer man behöver passera
		double langd = DenKortasteVagen.langd(a, b, c);
		int[] stationer = DenKortasteVagen.mellanstationer(a, b, c);
		// utskrifter
		System.out.println(langd);
		System.out.println(Arrays.toString(stationer));
		System.out.println("mellanstation i zon Z2 är u"+stationer[0]);
		System.out.println("mellanstation i zon Z3 är v" + stationer[1]);
	}
}
