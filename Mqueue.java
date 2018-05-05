public class Mqueue
{
    public Comparable array[][];
    public int begin = 0;
    public int end;
    public Mqueue(Comparable a[])
    {
        array = new Comparable[a.length*2][1];
        for(int i = 0; i < a.length; i++)
            {
                Comparable cache[] = new Comparable[1];
                cache[0] = a[i];
                array[i]  = cache;
                //StdOut.println(array[i][0]);
            }
        end = a.length;
    }

    public void push(Comparable a[])
    {
        array[end++] = a;
        if((end - begin) * 2>array.length || end == array.length)
            {
                Comparable newarray[][] = new Comparable[array.length * 2][1];
                for(int i = begin; i < end; i++)
                    newarray[i-begin] = array[i];
                array = newarray;
                begin = 0;
                end = end-begin;
                begin = 0;
            }
    }

    public Comparable[] pop()
    {
        
        if((end-begin+1) < (array.length / 4))
            {
                Comparable newarray[][] = new Comparable[array.length/2][];
                for(int i = begin; i < end; i++)
                    {
                        newarray[i-begin] = array[i];
                    }
                array = newarray;
                end = end-begin;
                begin = 0;
            }
        return array[begin++];
    }
}
