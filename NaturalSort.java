public class NaturalSort
{
    private Comparable array[];
    private int lastarrayfind = 1;
    public NaturalSort(Comparable a[])
        {
            array = a;
        }

    public static boolean less(Comparable a,Comparable b)
        {
            return (Integer.parseInt(a.toString())-Integer.parseInt(b.toString()))<0;
        }

    public int howmany()
    {
        int count = 0;
        for(int i = 1;i<array.length ; i++)
            {
                if(less(array[i-1], array[i]))
                    {
                        count++;
                        while(i<array.length && less(array[i-1], array[i]))
                            i++;
                    }
                if(count == 2)
                    break;
            }
        return count;
    }

    public Comparable[] findarray()
    {
        int j = 0;
        int k = 0;
        for(int i = lastarrayfind; i < array.length; i++)
            {
                if(less(array[i-1],array[i]))
                    {
                        j = i-1;
                        while(i < array.length &&  less(array[i-1],array[i]))
                            i++;
                        k = i;
                        lastarrayfind = k + 1;
                        break;
                    }
            }
        Comparable newarray[] = new Comparable[k - j];
        for(int i = j ; i < k ; i++)
            {
                newarray[i-j] = array[i];
                array[i] = "-1";
            }
        return newarray;
    }

    public void rearray(Comparable addarray[])
    {
        Comparable newarray[]= new Comparable[array.length];
        int i2 = 0;
        int j = 0;
        while(i2 < array.length)
            {
                if(Integer.parseInt(array[i2].toString()) != -1)
                    newarray[j++] = array[i2];
                i2++;
            }
        array = newarray;
        for(int i = j ; i < array.length; i++)
            array[i] = addarray[i-j];
        lastarrayfind = 1;
    }

    public void sort()
    {
        while(true)
        {int number = howmany();
            StdOut.println(number);
        if(number == 2)
            {
                Comparable a1[] = findarray();
                Comparable a2[] = findarray();
                for(int i = 0 ; i < a1.length ; i++)
                    StdOut.print(a1[i] + "  ");
                StdOut.println(" <-a1 ");
                for(int i = 0 ; i < a2.length ; i++)
                    StdOut.print(a2[i] + "  ");
                StdOut.println(" <-a2 ");
                rearray(BottomQueueMergeSort.Merge(a1,a2));
            }
        if(number == 1)
            {
                Comparable a[]= findarray();
                if(a.length == array.length) break;
                rearray(a);
                int i = 1;
                int j = 0;
                while(i < array.length &&  less(array[i-1],array[i]))
                    i++;
                if(i == array.length)
                    i--;
                Comparable a2[] = new Comparable[i+1];
                while(i >= 0)
                    a2[j++] = array[i--];
                array = a;
                break;
            }
        }
        for(int i = 0 ; i < array.length ; i++)
            StdOut.print(array[i] + " ");
        StdOut.println(" ");
    }

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
                else if(!less(a[aindex],b[bindex]))
                    {
                        result[index++] = a[aindex++];
                    }
                else 
                    result[index++] = b[bindex++];
            }
        return result;
    }
}
