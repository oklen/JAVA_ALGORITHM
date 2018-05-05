import java.util.Iterator;

public class ResizingQueueOfString<Item> implements Iterable<Item>
{
    private Item strs[];
    private int last = 0;
    private int begin = 0;
    public int size = 0;
    private int maxsize;
    public ResizingQueueOfString(int N) {strs = (Item[])new Object[N];maxsize= N;};
    public void push(Item str)
    {
        strs[last++] = str;
        size++;
        if(last == maxsize-1 && maxsize-1 != size)
            {
                for(int i = begin;i < last;i++)
                    strs[i-begin] = strs[i];
                begin = 0;
                last = last-begin;
            }
        if(size == maxsize -1)
            {
                Item newstrs[] = (Item[])new Object[maxsize*2];
                for(int i = 0;i < maxsize -1;i++)
                    {
                        newstrs[i] = strs[i];
                    }
                maxsize*=2;
                strs = newstrs;
            }
    }

    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {
        private int current = begin;

        public boolean hasNext()
        { return current != last;}
        public void remove() {}
        public Item next()
        {
            return strs[current++];
        }
    }
    public Item pop()
    {
        size--;
        if(size < maxsize/2+1);
        {
            Item newstrs[] = (Item[])new String[maxsize/2 +1];
            for(int i = 0;i<(last - begin);i++)
                {
                    newstrs[i] = strs[i+begin];
                }
            maxsize/=2;
            maxsize+=1;
        }
        return strs[begin++];
    }
}
