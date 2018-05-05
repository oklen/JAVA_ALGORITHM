public class QUICKFIND
{
    public int id[];
    public int count;
    public QUICKFIND(int N)
    {
        id = new int[N];
        count = N;
        for(int i = 0; i< N; i++)
            id[i] = i;
    }

    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }
    public int find(int p)
    {
        return id[p];
    }

    public void union(int p,int q)
    {
        int oldroot = id[q];
        for(int i = 0; i < id.length; i++)
            if(id[i] == oldroot)
                id[i] = id[p];
        count--;
    }
}
