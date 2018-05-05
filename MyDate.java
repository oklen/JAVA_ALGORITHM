public class MyDate
{
    private int day;
    private int month;
    private int year;
    private int amount;

    public MyDate(int date)
    {
        year = date/10000;
        month = (date % 10000) / 100;
        day = date % 100;
        amount = date;
    }

    public String toString()
    {
        return "Y:" + year + " M:" + month + " D:" + day;
    }

    public int compareTo(MyDate that)
    {
        if(this.amount > that.amount) return 1;
        if(this.amount < that.amount) return -1;
        return 0;
    }
}
