public class Com
{
    protected static void main(int s_p[])
    {
        EnglishNumberToWords c = new EnglishNumberToWords();
        System.out.print("The Score is:-  ");
        for(int i=0;i<s_p.length-1;i++)
        {
            if(s_p[i]==0)
                System.out.print(" Love ");
            else if(s_p[i]==s_p[i+1]&&(s_p[i]>=40&&s_p[i+1]>=40))
            {
                System.out.print(" Deuce ");
                break;
            }
            else
            {
                if(i==0)
                {
                    System.out.print("Player 1:");
                    System.out.print(c.convert(s_p[i])+"   ");
                }
                else 
                {
                    System.out.print("Player 2:");
                    System.out.print(c.convert(s_p[i])+"   ");
                }
            }
            if(i==1)
                break;
        }
        System.out.println();
        System.out.println();
    }
}