class mPoint2D
{
    private double m_x;
    private double m_y;
    public mPoint2D(double x,double y)
    {
        m_x = x;
        m_y = y;
    }
    public double x()
    {
        return m_x;
    }

    public double y()
    {
        return m_y;
    }

    public static double distance(mPoint2D p1,mPoint2D p2)
    {
        return Math.sqrt((p1.x() - p2.x())*(p1.x() - p2.x()) +
                         (p1.y() - p2.y())*(p1.y() - p2.y()));
    }
}
