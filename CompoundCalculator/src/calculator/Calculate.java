package calculator;

public class Calculate
{
    public  static double calculateResults(double principal, double interest, int year, int time)
    {
        return principal*Math.pow(( 1 + (interest/time)) , (time*year) );
    }
}
