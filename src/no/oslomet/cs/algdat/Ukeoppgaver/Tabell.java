package no.oslomet.cs.algdat;

public class Tabell {

    // Oppgave 1 i 1.2.1
    public static int min(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til)
            throw new IllegalArgumentException("Illegalt intervall");

            int m = fra;                // index til minste verdi i a[fra:til>
            int minverdi = a[fra];      // minste verdi ib a[fra:til>

        for (int i = fra + 1; i < til; i++) if (a[i] < minverdi)
        {
            m = i;                      // indeks til minste verdi oppdateres
            minverdi = a[m];            // minste verdi oppdateres
        }

        return m;                       // posisjonen til minste verdi i a[fra:til>
    }

    public static int min(int[] a)      // bruker hele tabellen
    {
        return min(a,0,a.length);   // kaller metoden over
    }
}
