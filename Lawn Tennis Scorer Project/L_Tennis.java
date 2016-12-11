import java.util.*;
public class L_Tennis
{
    private static String plyr1="",plyr2="";//store name of players 
    private static int g1=0,g2=0;// store current game's score   
    private static int set=3;// number of sets  
    private static int s_s[] = new int[3];// store  set's score
    private static int s_p[] = new int[3];// store player's score
    static Scanner sc = new Scanner(System.in);
    static help h = new help();
    static loading lo = new loading();
    public static void Score()throws InterruptedException
    {
        lo.main();
        for(int i=0;i<3;i++)
            s_s[i]=0;
        L_Tennis ob = new L_Tennis();
        Score_board sb =new Score_board();
        int ad1=0,ad2=0,Pt=0,pT=0,J=0;
        String hg="\n\t\n\t\n\tDon't Know how this works or a rookie to tennis.\nType \"Help\"\nELSE Type anything";
        for(int i=0;i<hg.length();i++)
        {
            System.out.print(hg.charAt(i));
            Thread.sleep(20);
        }
        System.out.println();
        String a = sc.next();
        if(a.equalsIgnoreCase("Help"))
            h.main();
        if(set!=0)
        {
            lo.main();
            System.out.println("Enter the name of two players.");
            plyr1=sc.next();
            plyr2=sc.next();
        }
        else
            System.out.println("\f");
        plyr1=plyr1.toUpperCase();
        plyr2=plyr2.toUpperCase();
        int G1=0,G2=0;
        for(int i=0;i<set;i++)
        {
            boolean loop=true;
            boolean game=true;
            int Ad1=0,Ad2=0;
            int t1=0,t2=0;
            for(int j=1;loop&&game;j++)
            {
                Ad1=0;Ad2=0;
                g1=0;g2=0;
                int pt1=0,pt2=0;
                for(int l=0;l<2;l++)
                    s_p[l]=0;
                for(int k=1;true;k++)
                {
                    sb.main(plyr1,plyr2,set,s_p,s_s,Ad1,Ad2,pt1,pt2,j,t1,t2);
                    String in="";
                    String m="Type player number then what has he done which is :-\nIf the player has missed type 'm'\nIf the player has double fault type 'f'\nIf the player has done ace type 'a'\nIf the player has hit with double bounce then type 'd'";
                    for(int l=0;l<m.length();l++)
                    {
                        System.out.print(m.charAt(l));
                        Thread.sleep(1);
                    }
                    System.out.println();
                    in=sc.next();
                    for(;!(in.length()>2);)
                    {
                        if(!(in.length()>=2))
                        {
                            System.out.println("Wrong input please type again.");
                            in=sc.next();
                        }
                        else 
                            break;
                    }
                    if(in.charAt(0)=='1')//plyr 2 winning
                    {
                        char ch = in.charAt(1);
                        if(ch=='m'||ch=='a'||ch=='f'||ch=='d')//for
                        {
                            if(s_p[1]==30)//if score of plyr2 is 30
                            {
                                s_p[1]=40;
                                ++pt2;
                            }
                            else
                            {
                                s_p[1]+=15;
                                ++pt2;
                            }
                        }
                        else 
                        {
                            --k;
                            continue;
                        }
                    }
                    else if(in.charAt(0)=='2')//plyr 1 winning
                    {
                        char ch = in.charAt(1);
                        if(ch=='m'||ch=='a'||ch=='f'||ch=='d')//for anything
                        {
                            if(s_p[0]==30)//if score of plyr1 is 30
                            {
                                s_p[0]=40;
                                ++pt1;
                            }
                            else
                            {
                                s_p[0]+=15;
                                ++pt1;
                            }
                        }
                        else 
                        {
                            --k;
                            continue;
                        }
                    }
                    boolean t=false;
                    boolean f=false;
                    if(s_p[1]-s_p[0]==15)//ad
                        t=true;
                    else if(s_p[0]-s_p[1]==15)
                        f=true;
                    if(s_p[0]>40&&f)//ad of 1
                    {
                        Ad1=1;
                    }
                    else if(s_p[1]>40&&t)//ad of 2
                        Ad2=1;
                    else if((s_p[0]==s_p[1]))//ad of none ad=0
                    {
                        Ad1=0;
                        Ad2=0;
                    }
                    if(Ad1==1&&pt1==2)
                    {
                        ++g1;
                        break;
                    }
                    else if(Ad2==1&&pt2==2)
                    {
                        ++g2;
                        break;
                    }
                    if(pt1>=2||pt2>=2||s_p[0]==s_p[1])
                    {
                        pt1=0;pt2=0;
                    }
                    if(s_p[1]==40&&(s_p[0]==15||s_p[0]==0))//if score of plyr 2 is 40 and plyr 1 is 0 or 15 then plyr 2 wins
                    {
                        ++g2;
                        break;
                    }
                    else if(s_p[1]-s_p[0]>=15&&s_p[1]>=40&&Ad2==0)
                    {
                        ++g2;
                        break;
                    }
                    if(s_p[0]==40&&(s_p[1]==15||s_p[1]==0))//if score of plyr 1 is 40 and plyr 2 is 0 or 15 then plyr 2 wins
                    {
                        ++g1;
                        break;
                    }
                    else if(s_p[0]-s_p[1]>=15&&s_p[0]>=40&&Ad1==0)
                    {
                        ++g1;
                        break;
                    }
                    if(g2>=1||g1>=1)
                        break;
                }
                G1+=g1;G2+=g2;
                t1+=g1;t2+=g2;
                if(j>=6&&(G1-G2>=2||G2-G1>=2))
                {
                    game=false;
                    loop=false;
                }
                ad1=Ad1;
                ad2=Ad2;
                Pt=pt1;
                pT=pt2;
                J=j;
            }
            if(g1>g2)
                s_s[i]=1;
            if(g2>g1)
                s_s[i]=2;
        }
        int o=0,t1=0;
        for(int i=0;i<4;i++)

        {
            if(s_s[i]==1)
                ++o;
            else if(s_s[i]==2)
                ++t1;
        }
        if(o-t1>=1)
            System.out.println("\f\t\t\t\t\t\t\t\t\t\n\n\n"+plyr1+" HAS WON!!!!!!"); 
        else if(t1-o>=1)
            System.out.println("\f\t\t\t\t\t\t\t\t\t\n\n\n"+plyr2+" HAS WON!!!!!!"); 
    }
}