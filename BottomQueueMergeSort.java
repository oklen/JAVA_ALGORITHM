public class BottomQueueMergeSort
{
    private Mqueue mqueue;
    public static Comparable[] Merge(Comparable a[],Comparable b[])
    {
        int aindex = 0;
        int bindex = 0;
        int index = 0;
        Comparable result[] = new Comparable[a.length + b.length];
        while(index < result.length)
            {
                if(aindex == a.length) {
                    result[index++] = b[bindex++];}
                else if(bindex == b.length) {
                    result[index++] = a[aindex++];

                }
                else if(less(a[aindex],b[bindex]))
                    {
                        result[index++] = a[aindex++];
                    }
                else 
                        result[index++] = b[bindex++];
            }
        return result;
    }

    public static boolean less(Comparable a,Comparable b)
    {
        return( Integer.parseInt(a.toString()) - Integer.parseInt(b.toString())) < 0;
    }

    public BottomQueueMergeSort(Comparable array[])
    {
        for(int i = 0; i < array.length ; i++)
            StdOut.print(array[i] + " ");
        StdOut.println(" ");
        mqueue = new Mqueue(array);
    }

    public void sort()
    {
        while(mqueue.end - mqueue.begin > 1)
            {
                mqueue.push(Merge(mqueue.pop(),mqueue.pop()));
            }
        for(Comparable a:mqueue.array[mqueue.begin])
            StdOut.print(a + " ");
        StdOut.println("");
    }
}
