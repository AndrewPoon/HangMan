import java.util.Scanner;
public class MileStone2
{
    public static void main (String args[])
    {
        Scanner sc=new Scanner (System.in);
        System.out.print("Type a word:");
        String word=sc.next();
        word=word.toLowerCase();
        int len=word.length();
        String []blanks=new String [len];
        for (int i=0;i<blanks.length;i++)
        {
            blanks[i]="_ ";
        }    
        String []letters=new String [26];
        int rightcounter=0;
        int wrongcounter=0;
        int blank=len;
        int counter=0;
        boolean z=false;
        for (int i=0;wrongcounter!=9&&rightcounter!=len;i++)
            {
               while(blank>0)
               {
                   System.out.print(blanks[i]);
                   blank--;
               }    
              System.out.print("Guess a letter: ");
              letters[i]=sc.next();
              for (int j=0;j<len&&wrongcounter<9;j++)
                {
                    while ((i!=j&&letters[i].equals(letters[j]))||letters[i].length()>1)
                    {
                        System.out.print("Repeating letters, guess another one:");
                        letters[i]=sc.next();
                    }    
                     if (word.substring(j,j+1).equals(letters[i]))
                    {
                        rightcounter++;
                        z=true;
                        blanks[i]=letters[j];
                    }    
                    else if (j==len-1&&z==false)
                      {
                          wrongcounter++;
                      }   
                     else if (wrongcounter==8)
                     {
                     System.out.println("You Lose!");   
                     wrongcounter++;
                    }
                }   
              counter++;
              z=false;
              blank=len;
            }
            System.out.println("The word is: "+word);
            System.out.println(rightcounter+" out of "+counter);
   
        } 
        
   

    
    }
