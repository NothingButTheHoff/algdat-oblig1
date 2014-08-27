package no.acme.algdat.oblig1;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Even Holthe <s189124@stud.hioa.no>
 * Per Erik Finstad <sXXXXXX@stud.hioa.no>
 *
 */
public class Oblig1
{
    public static void main(String[] args){
		int a[] = { 15,5,4,8,12,3,6,13,17,2,12,10,17,5,13,5,9,20,11 };
		sortering(a);
		System.out.println(Arrays.toString(a));
	}

	// Oppgave 1, issue 1
	public static int maks(int[] a){
		if(a.length == 0){
			throw new NoSuchElementException("Tabllen kan ikke være tom");
		}

		int[] tall = a;

		int temp = 0;

		for(int i=0;i<tall.length-1;i++){
			if(tall[i] > tall[i+1]){
				temp = tall[i];
				tall[i] = tall[i+1];
				tall[i+1] = temp;
			}
		}

		return tall[tall.length-1];
	}

	// Oppgave 2, issue 2
	public static void sortering(int[] a){
		if(a.length < 2) {
			return;
		}

		int temp = 0;

		for(int i=a.length;i>0;i--){
			for(int j=0; j<i-1; j++){
				if(a[j] > a[j+1]){
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
}
