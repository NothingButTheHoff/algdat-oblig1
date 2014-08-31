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
		System.out.println(inneholdt("FOR", "RABARBRA"));
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

    //OPPGAVE 4 oblig
    public static int antallUlikeUsortert(int[] a){
		//hvis lengde == 0 return 0;
        if (a.length < 1) {
			return 0;
		}

		int antall = a.length;

		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++){
				if (a[j] == a[i]){
					antall--;
					break;
				}
			}
		}

		return antall;
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


    //OPPGAVE 8a oblig
    public static int[] tredjeMaks(int[] a){
        if (a.length < 3) {
            throw new IllegalArgumentException("Arrayet er for kort!");
        }
        else if( a == null){
            throw new NullPointerException("Array kan ikke være null");
        }
        else{
            int posM   = 0;
            int posNM  = 1;
            int posNNM = 2;
            //sjekker og sorterer de tre første verdiene i arrayet
            if (a[2] > a[1] && a[2] > a[0]) {
                posM   = 2;
                if (a[1] > a[0]){
                    posNM  = 1;
                    posNNM = 0;
                }
                else{
                    posNM  = 0;
                    posNNM = 1;
                }
            }
            else if(a[1] > a[0] && a[1] > a[2]){
                posM   = 1;
                if (a[2] > a[0]){
                    posNM  = 2;
                    posNNM = 0;
                }
                else{
                    posNM  = 0;
                    posNNM = 2;
                }
            }
            else if(a[0] > a[1] && a[0] > a[2]) {
                posM   = 0;
                if (a[2] > a[1]) {
                    posNM  = 2;
                    posNNM = 1;
                }
                else{
                    posNM  = 1;
                    posNNM = 2;
                }
            }

            //etter sorteringen
            int maks   = a[posM];
            int nMaks  = a[posNM];
            int nnMaks = a[posNNM];


            for (int i = 3; i < a.length; i++){
                if (a[i] > maks){
                    nnMaks = nMaks;
                    nMaks  = maks;
                    maks = a[i];

                    posNNM = posNM;
                    posNM = posM;
                    posM = i;
                }
                if (a[i] > nMaks && a[i] < maks){
                    nnMaks = nMaks;
                    nMaks = a[i];
                    posNNM = posNM;
                    posNM = i;
                }


                if (a[i] > nnMaks && a[i] < nMaks){
                    nnMaks = a[i];
                    posNNM = i;
                }
            }//end of loop

            return new int[] {posM, posNM, posNNM};

        }
    }// end of tredjemaks()



    //Oppgave 8b oblig
    public static void tredjeMaksTest(){

        //permutasjoner av de tre første verdiene
        int[][] test1 = { {1,2,3},{1,3,2},{3,2,1},{3,1,2},{2,3,1},{2,1,3} };
        int[][] test2 = { {2,1,0},{1,2,0},{0,1,2},{0,2,1},{1,0,2},{2,0,1} };
        //sjekk alle permutasjoner
        for (int i = 0;i < test1.length; i ++){
            if (! Arrays.equals(tredjeMaks(test1[i]), test2[i])){
                System.out.println("Feil i metoden tredjeMaks(). Returnerer feil indekser!");
            }
        }

        //sjekk for null tabeller
        try {
            tredjeMaks(null);
        }
        catch (Exception e) {
            if (!(e instanceof NullPointerException)){
                System.out.println("Kodefeil: Feil unntak for en tom tabell!");
            }
        }


        //sjekk for feil tabellformat, i dette tilfelle et tomt array
        int[] a = {};

        try {
            tredjeMaks(a);
        }catch (Exception e){
            if (!(e instanceof IllegalArgumentException)){
                System.out.println("Feil! Mangler håndtering av feil tabellformat");
            }
        }
    } // end of tredjeMaksTest()



    // Oppgave 9, issue 11
	public static int[] kMinst(int[] a, int k){
		if(k < 1 || k > a.length){
			throw new IllegalArgumentException("k("+k+") kan ikke være mindre enn 1 eller større enn lengden av a = ("+a.length+")");
		}

		int[] r = new int[k];

		for(int i=0;i<k;i++){
			r[i] = a[i];
		}

		Arrays.sort(r);

		for(int i=k;i<a.length;i++){
			if(a[i] < r[k-1]){
				for(int j=k-1;j>0;j--){
					if(a[i] >= r[j]){
						r[j+1] = a[i];
						break;
					} else {
						r[j] = r[j-1];
					}
				}
				if(a[i] < r[0]) {
					r[0] = a[i];
				}
			}
		}

		return r;
	}

	// Oppgave 10, issue 12
	public static boolean inneholdt(String a, String b){
		int[] x = new int[36];
		int[] y = new int[36];

		for(char c : a.toCharArray()){
			int i = Character.getNumericValue(c);
			x[i]++;
		}

		for(char c: b.toCharArray()){
			int i = Character.getNumericValue(c);
			y[i]++;
		}

		for(int i=0;i<x.length;i++){
			if(x[i] > 0){
				if(y[i] < x[i]){
					return false;
				}
			}
		}

		return true;
	}
}
