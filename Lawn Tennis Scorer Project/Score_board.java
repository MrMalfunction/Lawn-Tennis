public class Score_board
{
    protected static void main(String plyr1,String plyr2,int set,int s_p[],int s_s[],int Ad1,int Ad2,int pt1,int pt2,int g,int g1,int g2)throws InterruptedException
    {
        Com com = new Com();
        System.out.println("\f                                      Score-Board                                                 ");
        for(int i=1;i<=set;i++)
        {
            System.out.print("\t\tSet "+i);
            Thread.sleep(5);
        }
        System.out.print("\tCurrent set's game scores");
        System.out.println("\t\tGame "+g);
        System.out.print(plyr1+"\t");
        for(int i=0;i<set;i++)
        {
            if(s_s[i]==1)
            {
                System.out.print("\t1\t");
                Thread.sleep(5);
            }
            else
            {
                System.out.print("\t0\t");
                Thread.sleep(5);
            }
        }
        System.out.print("\t\t\t"+g1);
        if(Ad1==1)
        {
            System.out.println("\t\tAd");
            Thread.sleep(5);
        }
        else
        {
            if(s_p[0]<=40)
                System.out.print("\t\t"+s_p[0]);
            else
                System.out.print("\t\t"+s_p[0]+"(40)");
            System.out.println();
            Thread.sleep(5);
        }
        System.out.print(plyr2+"\t");
        for(int i=0;i<set;i++)
        {
            if(s_s[i]==2)
            {
                System.out.print("\t1\t");
                Thread.sleep(5);
            }
            else 
            {
                System.out.print("\t0\t");
                Thread.sleep(5);
            }
        }
        System.out.print("\t\t\t"+g2);
        if(Ad2==1)
        {
            System.out.println("\t\tAd");
            Thread.sleep(5);
        }
        else
        {
            if(s_p[1]<=40)
                System.out.print("\t\t"+s_p[1]);
            else
                System.out.print("\t\t"+s_p[1]+"(40)");
            System.out.println();
            Thread.sleep(5);
        }
        com.main(s_p);
        System.out.println();
    }
}