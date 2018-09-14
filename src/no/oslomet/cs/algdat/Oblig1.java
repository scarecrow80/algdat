package no.oslomet.cs.algdat;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    public static void main(String[] args) {

        //Koden for å generere array er hentet fra Week1 kildekoder

        // Bestem lengden av arrayet vi skal lage og genererer arrayet
        int[] a = Oblig1.randomArray2(10);

        // Printer ut arrayet
        printArray(a);

        // Kjører metoden maks
        maks(a);
        System.out.println("Arrayet etter maksmetoden har kjørt: " + Arrays.toString(a));

        // Kjører metoden ombyttinger
        ombyttinger(a);

        // Kjører antallUlikeSortert
        antallUlikeUsortert(a);



    }

    /**
     * Funksjon som lager et array med tilfeldige tall mellom
     * 1 og num_values uten duplikater
     *
     * @param num_values Lengden på arrayet
     * @return Array med lengde num_values
     */
    public static int[] randomArray2(int num_values) {
        System.out.println("randomArray2 lager et array");
        int values[] = new int[num_values];

        //Fyll arrayet med tallene 1 til 10
        for (int i = 0; i < num_values; ++i) {
            values[i] = i + 1;
        }

        //Loop gjennom arrayet, og bytt random
        for (int i = num_values - 1; i > 0; --i) {
            // Trekk et tilfeldig tall mellom 0 og i
            int k = (int) (Math.random() * i);

            //bytt tallene k og i
            int temp = values[i];
            values[i] = values[k];
            values[k] = temp;
        }

        return values;
    }

    /**
     * Funksjon som skriver ut et array til skjerm
     *
     * @param a Arrayet å skrive ut
     */
    public static void printArray(int[] a) {
        System.out.print("[");
        if (a.length > 0) {
            System.out.print(a[0]);
        }
        for (int i = 1; i < a.length; ++i) {
            System.out.print(", " + a[i]);
        }
        System.out.println("]");
    }

    // Oppgave 1
    public static int maks(int[] a )
    {
        if (a.length == 0)
        {
            throw new NoSuchElementException("Arrayet er tomt");
        }

        int temp;

        for (int i = 0; i < a.length -1; i++)
        {
            if (a[i] > a[i + 1])
            {
                temp = a[i + 1];
                a[i + 1] = a[i];
                a[i] = temp;
            }
        }return a[a.length - 1];

    }

    public static int ombyttinger(int a[] )
    {
        if (a.length == 0)
        {
            throw new NoSuchElementException("Arrayet er tomt");
        }

        int antallOmbyttinger = 0;
        int temp;

        for (int i = 0; i < a.length - 1; i++)
        {
            if (a[i] > a[i + 1])
            {
                temp = a[i + 1];
                a[i + 1] = a[i];
                a[i] = temp;
                antallOmbyttinger++;
                System.out.println("Loops etter maksmetoden har kjørt: " + antallOmbyttinger);
            }
        }return antallOmbyttinger;
    }

    // Oppgave 2
    public static int antallUlikeSortert(int[] a)
    {
        if (a.length == 0)
        {
            return 0;
        }

        for (int i = 0; i < a.length -1; i++)
        {
            if (a[i] > a[i + 1]) throw new IllegalStateException("Arrayet er ikke sortert!");
        }

        int antall = 1;
        int temp = a[0];

        for (int i = 1; i < a.length; i++)
        {
            if (a[i] != temp)
            {
                temp = a[i];
                antall++;
            }
        }return antall;
    }

    // Oppgave 3
    public static int antallUlikeUsortert(int[] a)
    {
        if (a.length == 0)
        {
            return 0;
        }

        int antall = 1;

        for (int i = 1; i < a.length; i++)
        {
            for (int j = i - 1; j >= 0; j--)
            {
                if (a[i] == a[j])
                {
                    break;
                }
                if (j == 0)
                {
                    antall++;
                }
            }
        }return antall;
    }

}


