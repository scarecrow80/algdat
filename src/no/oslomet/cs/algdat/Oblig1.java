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
        int antallOmbyttinger = 0;



    }





}


