class doublelist<Item> //implements Iterable<Item>
{
    private Node<Item> first;
    private Node<Item> last;
    private int size;
    public doublelist(int N)
    {
        first = new Node<Item>();
        last = first;
        size= 1;
        for(int i =1 ; i< N;i++)
            {
                Node<Item> current = new Node<Item>();
                last.next = current;
                current.back = last;
                last = current;
                size++;
            }
    }

    public void insert_at_begin(Item word)
    {
        Node<Item> newbegin = new Node<Item>();
        newbegin.next = first;
        first.back = newbegin;
        newbegin.item = word;
        first = newbegin;
    }

    public void insert_at_end(Item word)
    {
        Node<Item> newend = new Node<Item>();
        newend.back = last;
        last.next = newend;
        newend.item = word;
        last = newend;
    }

    public void remove_first()
    {
        first = first.next;
    }

    public void remove_end()
    {
        last = last.back;
        last.next = null;
    }
    public void insert_before(int n,Item word)
    {
        Node<Item> current;
        current = first;
        for(int i = 0; i< (n - 1);i++)
            {
                current = current.next;
            }
        Node<Item> newnode = new Node<Item>();
        newnode.next = current.next;
        current.next = newnode;
        newnode.item = word;
    }

    public void insert_after(int n,Item word)
    {
        Node<Item> current;
        current = first;
        for(int i = 0; i < n;i++)
            current = current.next;
        Node<Item> newnode = new Node<Item>();
        newnode.next = current.next;
        current.next = newnode;
        newnode.item = word;
    }

    public void remove_at(int n)
    {
        Node<Item> current = first;
        for(int i = 0 ; i < (n -1); i++)
            current = current.next;
        current.next = current.next.next;
    }
    
    private class Node<Item>
    {
        Node<Item> next;
        Node<Item> back;
        Item item;
    }
}
