public class mMatrixLibrary
{
    public static double dot(double x[] , double y[])
    {
        double result = 0.0;
        for (int i = 0; i < x.length ; i ++)
            {
                result+= x[i] * y[i];
            }
        return result;
    }

    public static double[][] mult(double a[][], double b[][])
    {
        double result[][]= new double[b.length][b[0].length];
        for(int i =0;i < a.length;i++)
            for(int j = 0; j < b.length; j ++)
                {
                    double currentvalue = 0.0;
                for ( int k = 0; k < a[0].length ; k++)
                    {
                        currentvalue += a[i][k] * b[k][j];
                    }
                result[i][j] = currentvalue;
                }
        return result;
    }

    public static double[] mult(double a[][], double b[])
    {
        double result[] = new double[b.length];
        for(int i = 0; i< a.length; i ++)
            {
                result[i] = 0.0;
                for(int j =0; j < b.length ; j++)
                {
                    result[i]+= a[i][j]*b[j];
                }
            }
        return result;
    }

    public static void td()
    {
        int SIDES = 6;
        double[] dist = new double[2*SIDES+1];
        for(int i = 1; i <= SIDES; i++)
            for(int j = 1; j <= SIDES; j++)
                dist[i+j] += 1.0;
        for(int k = 2; k <= 2*SIDES ; k++)
            {
                dist[k] /= 36.0;
                StdOut.println(" the " + k + " is " + dist[k]);
            }
    }
}
