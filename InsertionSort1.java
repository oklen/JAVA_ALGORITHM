public class InsertionSort1
{
    public static void sort(Comparable a[])
    {
        StdOut.println("The Lenghth is: " + a.length);
        int N = a.length;
        for (int i = 0; i < N ; i++)
            {
                int min = i;
                for(int j = i + 1; j < N; j++)
                    if(less(a[j],a[min])) min = j;
                show(a);
                exch(a,i,min);
            }
    }

    public static void sort2(Comparable a[])
    {
        int N = a.length;
        for(int i = 1; i < N; i++)
            {
                int j = i;
                while(j > 0 && less(a[j-1],a[j]))
                    {
                        exch(a, j-1, j);
                        j--;
                    }
            }
        show(a);
    }
    
    private static boolean less(Comparable v,Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable a[], int i, int j)
    {
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

    public static void show(Comparable a[])
    {
        for(int i = 0; i< a.length; i ++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable a[])
    {
        for(int i = 1; i < a.length ; i++)
            {
                if(less(a[i], a[i - 1]))
                    return false;
            }
        return true;
    }


}
