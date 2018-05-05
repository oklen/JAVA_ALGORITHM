public class josephus
{
    private int size;
    private int M;
    private Node first;
    private Node last;
    private class Node
    {
        public Node next;
        public int number;
    }
    public josephus(int N, int m_M)
    {
        first = new Node();
        last = first;
        last.number = 0;
        size = 1;
        M = m_M;
        for(int i =1 ;i < N; i++)
            {
                Node current = new Node();
                last.next = current;
                last = current;
                last.number = i;
                size++;
            }
        last.next = first;
        eliminate();
    }
    public void eliminate()
    {
        Node current = last;
        while(size > 1)
            {
                for(int i = 0;i<M -1;i++)
                    {
                        current = current.next;
                    }
                StdOut.print(current.next.number + " ");
                current.next = current.next.next;
                size--;
            }
        StdOut.println(current.number);
    }
}
