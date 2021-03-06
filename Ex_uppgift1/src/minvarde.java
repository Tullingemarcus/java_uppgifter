
public class minvarde {

	public static void main(String[] args) {
		int[] element = {73, 65, 23, 63, 87, 54, 46, 64, 45, 63, 66, 21, 66, 32, 84, 17, 4, 67, 32};
		System.out.println(min(element));
		System.out.println("andra algoritmen");
		System.out.println(min1(element));
	}
	
	// min returnerar det minsta elementet i en sekventiell samling.
	// Om samlingen ?r tom, kastas ett undantag av typen IllegalArgumentException.
	public static int min (int[] element) throws IllegalArgumentException
	{
		if (element.length == 0)
			throw new IllegalArgumentException ("tom samling");
		// h?r ihop med sp?rutskriften 2:
		// int antalVarv = 1;
		int[] sekvens = element;
		int antaletPar = sekvens.length / 2;
		int antaletOparadeElement = sekvens.length % 2;
		int antaletTankbaraElement = antaletPar + antaletOparadeElement;
		int[] delsekvens = new int[antaletTankbaraElement];
		int i = 0;
		int j = 0;
		while (antaletPar > 0)
		{
			// skilj ur en delsekvens med de t?nkbara elementen
			i = 0;
			j = 0;
			while (j < antaletPar)
			{
				delsekvens[j++] = (sekvens[i] < sekvens[i + 1])? sekvens[i] : sekvens[i + 1];
				i += 2;
			}
			if (antaletOparadeElement == 1)
				delsekvens[j] = sekvens[i];
			// utg? nu ifr?n delsekvensen
			sekvens = delsekvens;
			antaletPar = antaletTankbaraElement / 2;
			antaletOparadeElement = antaletTankbaraElement % 2;
			antaletTankbaraElement = antaletPar + antaletOparadeElement;
			
			// sp?rutskrift 1 ? f?r att f?lja sekvensen
			// System.out.println (java.util.Arrays.toString (sekvens));
			
			// sp?rutskrift 2 - f?r att avsluta loopen i f?rv?g
			// (f?r att kunna se vad som h?nder i b?rjan)
			// if (antalVarv++ == 10)
			// System.exit (0);
		}
		
		// sekvens[0] ?r det enda ?terst?ende t?nkbara elementet
		// - det ?r det minsta elementet
		return sekvens[0];
	}
	public static int min1 (int[] element) throws IllegalArgumentException
	{
		if (element.length == 0)
			throw new IllegalArgumentException ("tom samling");
		int min = element[0];
		for(int i = 0; i < element.length; i++) {
			min = (min > element[i])? element[i] : min;
		}
		return min;
	}
}
