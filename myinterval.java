class myinterval
{
    private double mmin;
    private double mmax;
    public myinterval(double min,double max)
    {
        mmin = min;
        mmax = max;
    }

    public double min()
    {
        return mmin;
    }

    public double max()
    {
        return mmax;
    }
    public void intersect(myinterval m2)
    {
        if(m2.min() > mmin && m2.min() < mmax)
            {
                StdOut.println("[ " +  m2.min() + ", " + m2.max() + "]" + " and " + "[ " + mmin+ ", " + mmax + "]" + " is insected");
                return;
            }
        if(m2.max() < mmax && m2.max() > mmin)
            {
                StdOut.println("[ " +  m2.min() + ", " + m2.max() + "]" + " and " + "[ " + min()+ ", " + max() + "]" + " is insected");
                return;
            }
    }
   

    public static char stringbeginat(String a,int begin ,int index)
    {
        return a.charAt((index + begin) % a.length());
    }

    public static int indexOf(String a, char findwho, int lastpos)
    {
        if(lastpos == a.length())
            return -1;
        for(int i = lastpos+1; i < a.length();i++)
            {
                if(findwho == a.charAt(i))
                    return i;
            }
        return -1;
    }

    public static void judget_circular(String input,String input2)
    {
                int lastpos = -1;
        while (myinterval.indexOf(input,input2.charAt(0),lastpos) != -1)
            {
                int begin = myinterval.indexOf(input,input2.charAt(0),lastpos);
                Boolean allwell = true;
                for(int i = 0; i < input.length();i++)
                    {
                        if(input2.charAt(i) != myinterval.stringbeginat(input, begin, i))
                            {
                                allwell = false;
                                break;
                            }
                    }
                if(allwell)
                    {
                        StdOut.println("They are the circular string");
                        System.exit(0);
                    }
                lastpos = myinterval.indexOf(input, input2.charAt(0),lastpos);
            }
    }
}
