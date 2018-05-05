class Visual
{
    private int count = 0;
    private int maxN;
    private int m_N;
    private int m_max;
    private double width;
    
    public void draw()
    {
        StdDraw.line((maxN - m_N)/(double)maxN, 0.0, (maxN - m_N)/(double)maxN, count/(double)m_max);
        StdOut.println((maxN - m_N)/(double)maxN);
        m_N--;
    }
    public Visual(int N,int max)
    {
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        m_N = N;
        m_max = max;
        maxN = N;
        width = 1.0/N;
        StdDraw.setPenRadius(width);
    }

    public void increment()
    {
        count++;
        draw();
    }
    public void decrease()
    {
        count--;
        draw();
    }

    public Boolean isended()
    {
        if(m_N >= 0)
            return false;
        else
            return true;
    }
}
