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
		char[] tekst = "ABCDEFGHIJ".toCharArray();
		System.out.println(tekst);
		rotasjon(tekst, 3);
		System.out.println(tekst);
		rotasjon(tekst, -2);
		System.out.println(tekst);
	}

	// Oppgave 1, issue 1
	public static int maks(int[] a){
		if(a.length == 0){
			throw new NoSuchElementException("Tabllen kan ikke være tom");
		}

		int temp = 0;

		for(int i=0;i<a.length-1;i++){
			if(a[i] > a[i+1]){
				temp = a[i];
				a[i] = a[i+1];
				a[i+1] = temp;
			}
		}

		return a[a.length-1];
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

	// Oppgave 3, issue 3
	public static int antallUlikeSortert(int[] a){
		return 1;
	}

	// Oppgave 4, issue 4
	public static int antallUlikeUsortert(int[] a){
		return 1;
	}

	// Oppgave 5, issue 5
	public static void rotasjon(char[] a){
		if(a.length < 2){
			return;
		}

		char k = a[a.length-1];

		for(int i=a.length-1;i>=1;i--){
			a[i] = a[i-1];
		}

		a[0] = k;
	}

	// Oppgave 6, issue 6
	public static void rotasjon(char[] a, int k){
		int n = a.length;

		if(n<2){
			return;
		}

		char[] tmp = new char[Math.abs(k)];
		int c = 0;

		// Mot høyre
		if(k>0) {
			for (int i = n-k; i<n; i++) {
				tmp[c++] = a[i];
			}

			for (int i = n-k-1; i >= 0; i--) {
				a[k+i] = a[i];
				if(i < k){
					a[i] = tmp[i];
				}
			}
		// Mot venstre
		} else if(k<0){
			k = Math.abs(k);

			for(int i=0; i<k; i++){
				tmp[i] = a[i];
			}

			for(int i=0; i<=n-k-1; i++){
				a[i] = a[k+i];
			}

			for(int i=0; i<tmp.length; i++){
				a[n-i-1] = tmp[k-i-1];
			}
		}
	}

	// Oppgave 7a, issue 7
	public static String flett(String s, String t){ return "Ikke implementert"; }

	// Oppgave 7b, issue 8
	public static String flett(String... s){ return "Ikke implementert"; }

	// Oppgave 8a, issue 9
	public static int[] tredjeMaks(int[] a){ return new int[] {}; }

	// Oppgave 8b, issue 10
	public static void tredjeMaksTest(){}

	// Oppgave 9, issue 11
	public static int[] kMinst(int[] a, int k){ return new int[]{}; }

	// Oppgave 10, issue 12
	public static boolean inneholdt(String a, String b){ return false; }
}
