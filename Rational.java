class Rational
{
    private int numerator;
    private int denominator;
    private int signature = 1;

    public int getNumerator()
    {
        return numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public Rational(int up,int down)
    {
        if(up*down < 0)
            signature = -1;
        int common = gcd(Math.abs(up),Math.abs(down));
        numerator =up/common;
        denominator =down/common;
    }

    public int gcd(int p, int q)
    {
        if(q == 0) return p;
        int r = p % q;
        return gcd(q,r);
    }

    public Rational plus(Rational b)
    {
        int numerator_p = numerator*b.getDenominator() + b.getNumerator()*denominator;
        int denominator_p = denominator*b.getDenominator();
        return new Rational(numerator_p, denominator_p);

    }

    public Rational minus(Rational b)
    {
        int numerator_p = numerator*b.getDenominator() - b.getNumerator()*denominator;
        int denominator_p = denominator*b.getDenominator();
        return new Rational(numerator_p, denominator_p);
    }

    public Rational times(Rational b)
    {
        int numerator_p = numerator * b.getNumerator();
        int denominator_p = denominator * b.getDenominator();
        return new Rational(numerator_p, denominator_p);
    }

    public Rational divide(Rational b)
    {
        int numerator_p = numerator * b.getDenominator();
        int denominator_p = denominator * b.getNumerator();
        return new Rational(numerator_p, denominator_p);
    }

    public String toString()
    {
        return numerator + "/" + denominator;
    }
}
