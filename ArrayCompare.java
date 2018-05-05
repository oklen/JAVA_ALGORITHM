import java.util.Arrays;

public class ArrayCompare
{
    private int acurrent;
    private int bcurrent;
    private int cstore[];
    public ArrayCompare(int a[],int b[])
    {
        acurrent = 0;
        bcurrent = 0;
        int ccurrent = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        cstore = new int[a.length];
        while(acurrent < a.length && bcurrent < b.length)
        {
            if(a[acurrent] > b[bcurrent])
            {
                bcurrent++;
            }
            else if(a[acurrent] < b[bcurrent])
                {
                    acurrent++;
                }
            else
                {
                    cstore[ccurrent] = a[acurrent];
                    ccurrent++;
                    acurrent++;
                    bcurrent++;
                }
        }
        for(int i = 0; i < ccurrent; i++)
            {
                StdOut.println(cstore[i]);
            }
    }
}
