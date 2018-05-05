public class eggthrow1
{
    private int N;
    private int M;
    public eggthrow1(int mN, int mF)
    {
        N = mN;
        M = mF;
        int Count = 1;
        while(!broken(Count))
            Count*=2;
        int high = Count;
        int low = Count /2;
        while(high > low)
            {
                int middle = (high + low)/2;
                if(broken(middle))
                    high = middle;
                else
                    low = middle + 1;
            }
        StdOut.println("The floor should be " + (low));
    }

    public boolean broken(int Count)
    {
        if(Count >= M)
            return true;
        else
            return false;
    }
}
