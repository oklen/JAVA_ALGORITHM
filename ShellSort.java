public class ShellSort
{

    public static void Sort(Comparable array[])
    {
        int h = 1;
        while( h < array.length/3) h=3*h+1;
        
        StdOut.println(array.length);
        while(true)
            {
                for(int i = 0; i < array.length; i++)
            {
                for(int j = i; j+h  < array.length; j+=h)
                {
                    StdOut.println("Sort " + array[j] + " " + array[j + h] );
                    if(less(array[j],array[j+h])) exch(array,j,j+h);
                }
            }
                StdOut.println("h:" + h);
                if(h==1)
                    break;
                h= h/3+1;
            }
    }

    public static boolean less(Comparable a,Comparable b)
    {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable a[],int b,int c)
    {
        Comparable cache = a[b];
        a[b] = a[c];
        a[c] = cache;
    }

    public static void show( Comparable array[])
    {
        StdOut.println("Show Result:");
        for(int i = 0; i < array.length; i++)
            StdOut.print(array[i] + " ");
    }
}
