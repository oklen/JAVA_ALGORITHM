public class QUICKUNION
{
    int id[];
    int size[];
    int count;
    int cost = 0;
    public QUICKUNION(int N)
    {
        StdOut.println("Get Print " + N);
        id = new int[N];
        size = new int[N];
        count =  N;
        for(int i = 0; i < N; i++)
            {
                id[i] = i;
            }
        for(int i = 0; i < N; i++)
            {
                size[i] = 1;
            }
    }

    public int find(int n)
    {
        int cache = n;
        while(id[cache] != cache) {cache = id[cache];cost++;}
        return cache;
    }

    public boolean connected(int p , int q)
    {
        return find(p) == find(q);
    }

    public int union(int p, int q)
    {
        int proot = find(p);
        int qroot = find(q);
        if( proot == qroot)
            {
                int mcache = cost;
                cost = 0;
                return mcache;
                    };

        if(size[proot] > size[qroot])
            {
                id[qroot] = proot;
                size[proot]+=size[qroot];
                id[q] = proot;
            }
        else
            {
                id[proot] = qroot;
                size[qroot]+=size[proot];
                id[p] = qroot;
            }
        cost+=4;
        count--;
        int mcache = cost;
        cost = 0;
        return mcache;
    }

}
