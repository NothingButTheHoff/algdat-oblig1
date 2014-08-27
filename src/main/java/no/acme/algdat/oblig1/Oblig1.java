package no.acme.algdat.oblig1;

import java.util.NoSuchElementException;

/**
 * Even Holthe <s189124@stud.hioa.no>
 * Per Erik Finstad <sXXXXXX@stud.hioa.no>
 *
 */
public class Oblig1
{
    public static void main(String[] args){
		int a[] = { 10, 9, 99, 8, 11, 9, 8, 5, 4, 3, 2, 1 };
		System.out.println("Det største tallet i arrayet er: "+maks(a));
    }

	// Oppgave 1, issue 1
	public static int maks(int[] a){
		if(a.length == 0){
			throw new NoSuchElementException("Tabllen kan ikke være tom");
		}

		int[] tall = a;

		int n0, n1 = 0;

		for(int i=0;i<tall.length-1;i++){
			if(tall[i] > tall[i+1]){
				n0 = tall[i];
				n1 = tall[i+1];
				tall[i] = n1;
				tall[i+1] = n0;
			}
		}

		return tall[tall.length-1];
	}
}
