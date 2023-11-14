package Enemy;

public class EnemySummon {
    private int SummonX;
    private int SummonY;

    public void setSumXY(int x ,int y)
    {
        SummonX = x;
        SummonY = y;
    }
    
    public int ReX()
    {
        return SummonX;
    }

    public int ReY()
    {
        return SummonY;
    }

   
}
