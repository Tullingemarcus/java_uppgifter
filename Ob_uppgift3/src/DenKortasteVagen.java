/**********************************************
Det h�r programmets syfte �r att g�ra utr�kningar f�r
kortaste v�gen mellan tv� stationer
**********************************************/
public class DenKortasteVagen {
	
    // mellanstationer returnerar en vektor med de mellanstationer som finns p� den kortaste 
    // v�gen. Ordningsnummer av den f�rsta mellanstationen finns p� index 0, och ordningsnummer 
    // av den andra mellanstationen p� index 1 i vektorn.
	public static int[] mellanstationer(double[] a, double[][] b, double[] c) {
		int ni = 3;
		int nj = 4;
		int[] stationer = {0, 0};
		double shortest = a[0] + b[0][0] + c[0];	
		for(int i = 1; i <= ni; i++) {
			for(int j = 1; j <= nj; j++) {
				double lenght = a[i-1] + b[i-1][j-1] + c[j-1];
				if(lenght < shortest) {
					shortest = lenght;
					stationer[0] = i;
					stationer[1] = j;
				}
			}
		}
		return stationer;
	}
    // langd returnerar l�ngden av den kortaste v�gen. 
	public static double langd(double[] a, double[][] b, double[] c) {
		int ni = 3;
		int nj = 4;
		double shortest = a[0] + b[0][0] + c[0];	
		for(int i = 1; i <= ni; i++) {
			for(int j = 1; j <= nj; j++) {
				double lenght = a[i-1] + b[i-1][j-1] + c[j-1];
				if(lenght < shortest) {
					shortest = lenght;
				}
			}
		}
		return shortest;
	}
}
