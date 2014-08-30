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
		int[] minst = {3,2,8,5,6,10,4,9,1,7};
		int[] r = kMinst(minst, 2);
		int[] r1 = kMinst(minst, minst.length);
		int[] r3 = kMinst(minst, 3);
		int[] r4 = kMinst(minst, 4);
		int[] r5 = kMinst(minst, 5);
		System.out.println(Arrays.toString(r));
		System.out.println(Arrays.toString(r3));
		System.out.println(Arrays.toString(r4));
		System.out.println(Arrays.toString(r5));
		System.out.println(Arrays.toString(r1));
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
        //sjekk om a er sortert stigende
        int x = 0;
        int antall = 0;

        for (int i = 0; i < a.length; i++){
            if ( a[i] >= x){
                if (a[i]!= x){
                    antall++;
                }
                x = a[i];
            }
            else{
                throw new IllegalStateException("Arrayet er ikke sortert stigende");
            }
        }
        return antall;
        //returner antall ulike verdier
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

		k %= n;

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
	public static String flett(String s, String t){
		char[] txt = new char[s.length()+t.length()];

		char[] a = s.toCharArray();
		char[] b = t.toCharArray();

		int ac = 0;
		int bc = 0;
		int j = 0;

		for(int i=0; i < Math.max(s.length(), t.length()); i++){
			if(ac < s.length()){
				txt[j++] = a[ac++];
			}
			if(bc < t.length()){
				txt[j++] = b[bc++];
			}
		}

		return String.valueOf(txt);
	}

	// Oppgave 7b, issue 8
	public static String flett(String... s){
		String r = "";
		int l = 0;

		for(String x : s){
			l += x.length();
		}

		int[] c = new int[s.length];

		for (int i=0;i<l;i++){
			for(int j=0;j<s.length;j++){
				if(c[j] < s[j].length()){
					r += s[j].toCharArray()[c[j]];
					c[j]++;
				}
			}
		}

		return r;
	}

	// Oppgave 8a, issue 9
	public static int[] tredjeMaks(int[] a){ return new int[] {}; }

	// Oppgave 8b, issue 10
	public static void tredjeMaksTest(){}

	// Oppgave 9, issue 11
	public static int[] kMinst(int[] a, int k){
		if(k < 1 || k > a.length){
			throw new IllegalArgumentException("k("+k+") kan ikke være mindre enn 1 eller større enn lengden av a = ("+a.length+")");
		}

		int[] verdier = new int[k];
		System.arraycopy(a, 0, verdier, 0, k);


		// Sorter
		Arrays.sort(verdier);

		for(int i=k;i<a.length;i++){
			for(int j=k-1;j>=0;j--){
				if(a[i] < verdier[j]){
					verdier[j] = a[i];
					Arrays.sort(verdier); // Flaskehals
					break;
				}
			}
		}

		return verdier;
	}

	// Oppgave 10, issue 12
	public static boolean inneholdt(String a, String b){ return false; }
}
