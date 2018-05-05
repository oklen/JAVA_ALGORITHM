public class binarySearch
{
    public static int add_number(int a , int b)
    {
        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char) ('a' + 4));
        return a+b;
    }
    public static int[][] translate(int matrix[][])
    {
        for(int i =0; i < matrix.length; i++)
            for (int j =0; j <matrix[0].length ; j++)
                {
                    if(j == matrix[0].length - 1)
                        StdOut.println(matrix[i][j]);
                    else
                        StdOut.print(matrix[i][j]);
                }
        System.out.println("====TRANSLATE===");
        int result[][] = new int[matrix[0].length][matrix.length];
        for(int i =0; i < matrix.length; i++)
            for (int j =0; j < matrix[0].length; j++)
                {
                    result[j][i] = matrix[i][j];
                }
        for(int i =0; i < result.length; i++)
            for (int j =0; j <result[0].length ; j++)
                {
                    if(j == result[0].length - 1)
                        StdOut.println(result[i][j]);
                    else
                        StdOut.print(result[i][j]);
                }
        return result;
    }
    public static void count_appear(int [] array)
    {
        int result[] = new int[array.length];
        for(int i = 0; i< array.length; i++)
            {
                result[array[i]]++;
            }
        int i = 0;
        while(i < array.length)
            {
                StdOut.print(result[i]);
                i++;
            }
    }
    public static long F(int N)
    {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N -1) + F(N - 2);
    }
    public static long F2(int N)
    {
        if (N == 0) return 0;
        if (N ==1 | N == 2) return 1;
        return 0;
    }

    public static double binomial(int n,int k, double p, double array[][])
    {
        if(n ==0 && k==0) return 1.0;
        if(n < 0 || k < 0) return 0.0;
        if (array[n][k] != -1.0)
            return array[n][k];
        array[n][k] = (1-p)*binomial(n-1,k,p,array) + p*binomial(n-1,k-1,p,array);
        StdOut.println("calculate n:" + n + " " + "k:" + k + " " + array[n][k]);
        return array[n][k];
    }

    public static void Random_connection(int N, double p)
    {
        double space = Math.PI*2 / N;
        StdDraw.setPenRadius(0.01);
        StdDraw.setXscale(-1.2, 1.2);
        StdDraw.setYscale(-1.2,1.2);
        for(int i = 0; i < N ; i++)
            {
                double x = Math.cos(i*space);
                double y = Math.sin(i*space);
                StdDraw.point(x, y);
                if(StdRandom.random() < p && i < N -1)
                    StdDraw.line(x, y, Math.cos(space*(i+1)), Math.sin(space*(i+1)));
            }
    }
}
