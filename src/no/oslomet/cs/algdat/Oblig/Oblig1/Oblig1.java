package Oblig1;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    //Hjelpemetoder

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int min(int[] a, int fra, int til)
    {
        if (fra < 0 || til > a.length || fra >= til)
            throw new IllegalArgumentException("Ulovlig intervall");

        int m = fra;
        int minVerdi = a[fra];

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] < minVerdi)
            {
                m = i;
                minVerdi = a[m];
            }
        }return m;
    }

    public static int min(int[] a)
    {
        return min(a, 0, a.length);
    }

    // Oppgave 1
    // I et array med n verdier vil det bli gjort n-1 sammenligninger
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

    // Det vil bli gjort flest ombyttinger når det høyeste tallet ligger først i arrayet.
    // Det vil bli gjort flest ombyttinger når det høyeste tallet ligger sist i arrayet eller arrayet er
    // sortert stigende så det høyeste ligger sist.
    // I gjennomsnitt vil det bli summen av (n-1) / n.
    // Denne metoden er dermed vesentlig dårligere enn de maks-metodene vi har sett på tidligere.

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

    // Oppgave 4
    public static void delsortering(int[] a)
    {
        int partall = 0;

        for (int i = 0; i < a.length; i++)
        {
            if (a[i] % 2 != 0)
            {
                bytt(a, i, partall);
                partall++;
            }
        }
        Arrays.sort(a, 0, partall);
        Arrays.sort(a, partall, a.length);
    }

    // Oppgave 5
    public static void rotasjon(char[] a)
    {
        if (a.length > 1)
        {
            char temp = a[a.length -1];
            System.arraycopy(a, 0, a, 1, a.length - 1);
            a[0] = temp;
        }
    }

    // Oppgave 6
    public static void rotasjon(char[] a, int k)
    {
        if (a.length > 1)
        {
            k = ((k % a.length) + a.length) % a.length;
            char[] b = Arrays.copyOf(a, a.length);
            System.arraycopy(b, a.length - k, a, 0, k);
            System.arraycopy(b, 0, a, k, a.length -k);
        }
    }

    // Oppgave 7a
    public static String flett(String s, String t)
    {
        String flette = "";

        if (s == "") return t;
        if (t == "") return s;

        int sLengde = s.length();
        int tLengde = t.length();

        if (sLengde > tLengde)
        {
            for (int i = 0; i < tLengde; i++)
            {
                flette += s.charAt(i);
                flette += t.charAt(i);
            }
            flette += s.substring(tLengde, sLengde);
        }

        else if (sLengde < tLengde)
        {
            for (int i = 0; i < sLengde; i++)
            {
                flette += s.charAt(i);
                flette += t.charAt(i);
            }
            flette += t.substring(sLengde, tLengde);
        }

        else
        {
            for (int i = 0; i < sLengde; i++)
            {
                flette += s.charAt(i);
                flette += t.charAt(i);
            }
        }return flette;

    }

    // Oppgave 7b
    public static String flett(String... s)
    {
        String flette = "";
        int max = 0;

        for (String value : s)
        {
            if (value.length() > max)
            {
                max = value.length();
            }
        }
        for (int i = 0; i < max; i++)
        {
            for (String value : s)
            {
                if (value.length() > i)
                {
                    flette += value.charAt(i);
                }
            }
        }return flette;

    }

    // Oppgave 8
    public static int[] indekssortering(int[] a)
    {
        int[] b = Arrays.copyOf(a, a.length);
        int[] index = new int[a.length];

        for (int i = 0; i < b.length; i++)
        {
            int j = min(b);
            index[i] = j;
            b[j] = Integer.MAX_VALUE;
        }return index;
    }

    //Oppgave 9
    public static int[] tredjeMin(int[] a)
    {
        if (a.length < 3)
            throw new NoSuchElementException("Arrayet må ha minimum 3 verdier!");

        int[] b = indekssortering(Arrays.copyOfRange(a, 0, 3));

        int indexMinst = b[0];
        int indexNestMinst = b[1];
        int indexTredjeMinst = b[2];

        int minstVerdi = a[indexMinst];
        int nestMinstVerdi = a[indexNestMinst];
        int tredjeMinstVerdi = a[indexTredjeMinst];

        for (int i = 3; i < a.length; i++)
        {
            if (a[i] < tredjeMinstVerdi)
            {
                if (a[i] < nestMinstVerdi)
                {
                        if(a[i] < minstVerdi)
                        {
                            tredjeMinstVerdi = nestMinstVerdi;
                            nestMinstVerdi = minstVerdi;
                            minstVerdi = a[i];

                            b[2] = b[1];
                            b[1] = b[0];
                            b[0] = i;
                        }
                        else
                        {
                            tredjeMinstVerdi = nestMinstVerdi;
                            nestMinstVerdi = a[i];

                            b[2] = b[1];
                            b[1] = i;
                        }
                }
                else
                {
                    tredjeMinstVerdi = a[i];
                    b[2] = i;
                }
            }
        }return b;
    }

    // Oppgave 10
    public static boolean inneholdt(String a, String b)
    {
        int[][] c = new int[29][2];
        int charInt;

        boolean riktig = true;

        for (int i = 0; i < b.length(); i++)
        {
            charInt = b.charAt(i) - 'A';

            if (charInt >= b.length())
            {
                if (b.charAt(i) == 'Æ')
                {
                    c[26][0] = c[26][0] + 1;
                }
                else if (b.charAt(i) == 'Ø')
                {
                    c[27][0] = c[27][0] + 1;
                }
                else if (b.charAt(i) == 'Å')
                {
                    c[28][0] = c[28][0] + 1;
                }
            }
            else
            {
                c[charInt][0] = c[charInt][0] + 1;
            }
        }

        for (int i = 0; i < a.length(); i++)
        {
            charInt = a.charAt(i) - 'A';

            if (charInt >= a.length())
            {
                if (a.charAt(i) == 'Æ')
                {
                    c[26][1] = c[26][1] + 1;
                }
                else if (a.charAt(i) == 'Ø')
                {
                    c[27][1] = c[27][1] + 1;
                }
                else if (a.charAt(i) == 'Å')
                {
                    c[28][1] = c[28][1] + 1;
                }
            }
            else
            {
                c[charInt][1] = c[charInt][1] + 1;
            }
        }

        for (int[] d : c)
        {
            if (d[0] < d[1])
            {
                riktig = false;
                break;
            }
        }
        return riktig;
    }
}


