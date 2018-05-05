public class MergeSort
{
    private Comparable aux[];
    private int size = 2;
    public MergeSort(Comparable a[])
    {
        aux = new Comparable[a.length];
        int i = 0;
        for(Comparable el:a)
            aux[i++] = el;
    }

    public  void Sort(Comparable a[],int begin, int end)
    {
        if(begin != end)
        {
        merge2210(a,begin,end);
        for(Comparable element: a)
            StdOut.print(element + " ");StdOut.println("");}
    }

    public void Sort2(Comparable a[], int begin , int end)
    {
        for(int i = 0; i < a.length ; i++)
            {
                StdOut.print(a[i] + " ");
            }
        while(size/2 < a.length)
            {
                StdOut.println(size);
                for(int i = 0; i < a.length + size; i+=(size))
                    {
                        merge2(a,i,Math.min(i+size-1, a.length-1));
                    }
                for(int i = 0; i < a.length ; i++)
                    {
                        StdOut.print(a[i] + " ");
                    aux[i]= a[i];}
                StdOut.println("");
                size*=2;
            }
    }

    public void merge2(Comparable array[],int begin , int end)
    {
        int mid = 0;
        //if(end == aux.length -1)
        mid = begin + (size-1)/2;
        // else
        //      mid = (begin + end) /2;
        int i = begin;
        int j = mid + 1;
        int Count= begin;
        while(Count <=  end)
            {
                //StdOut.println(i + " " + j + " " + end);
                if (i >= mid +1 && mid != begin) array[Count] = aux[j++];
                else if ( j >= end+1) array[Count] = aux[i++];
                else if(less(aux[i],aux[j]))
                    array[Count] = aux[j++];
                else if(less(aux[j],aux[i]))
                    array[Count]= aux[i++];
                Count++;
            }
    }

    public  boolean less(Comparable a, Comparable b)
    {
        return Integer.parseInt(a.toString()) - Integer.parseInt(b.toString()) > 0;
    }

    public  void exch(Comparable array[],int x, int y)
    {
        Comparable cache;
        cache = array[x];
        array[x] = array[y];
        array[y] = cache;
    }

    public void merge(Comparable array[],int low,int hi)
    {
        if(hi <= low) return;

        // for(int i = low; i <= hi; i++)
        //     {
        //         aux[i] = array[i];
        //     }
        int mid = low + (hi - low)/2;
        int i = low;
        int j = mid+1;
        Sort(array,low,mid);
        Sort(array,mid+1,hi);
        int Count = low -1;
        // while(++Count <= hi )
        //     {
        //         if(i == mid+1)
        //             {
        //                 array[Count] = aux[j++];
        //             }
        //         else if( j == hi+1)
        //             array[Count] = aux[i++];
        //         else if(less(aux[i],aux[j]))
        //             {
        //                 array[Count] = aux[j++];
        //             }
        //         else if(less(aux[j],aux[j]))
        //                 array[Count] = aux[i++];
        //     }
        // for(int ix = low; ix <= hi; ix++)
        //     {
        //         aux[ix] = array[ix];
        //     }
        while( i < j && j <= hi)
            {
                StdOut.println("hi:" + hi);
                StdOut.println("i:" + i + " " + "j:" + j
                               +" array[i]:"+array[i] + " array[j]:" +
                               array[j]);
                if(less(array[i],array[j]))
                    {
                        exch(array,i,j);
                        for(int k = j ; k > i + 1; k--)
                            exch(array,k,k-1);
                        j++;
                        i++;
                    }
                else if(less(array[j], array[i]))
                    i++;
            }}

        public void merge2210(Comparable array[] , int low , int hi)
        {
            if(hi <= low)
                return;
            int mid = low + (hi - low)/2;
            int i = low;
            int j = mid+1;
            Sort(array,low,mid);
            Sort(array,mid+1,hi);
            int Count = low -1;

            for(int k = low; k < mid+1;k++)
                aux[k] = array[k];

            while(++Count <= hi)
                {
                    if(i > mid && mid!=low) array[Count] = array[j++];
                    else if( j > hi) array[Count] = aux[i++];
                    else if(less(aux[i],array[j]))
                        array[Count] = array[j++];
                    else if(less(array[j],array[i]))
                        array[Count] = aux[i++];
                }
        }
    
}
