import java.util.*;
public class main
{  
    
    public static void main (String args[])
    {
        //random choose a word before the game run
        Random randy=new Random();
        String [] bank1=new String[]{"one","two","three","four","five","six","seven","eight","nine","ten"};
        String [] bank2=new String []{"banana","apple","grape","orange","tomato","tangerine","dragonfruit","watermelon","mango","pear"};
        String [] bank3=new String []{"police","fireman","paramedic","teacher","doctor","accountant","nurse","salesman","zookeeper","lumberjack"};
        String [] bank4=new String []{"pasta","beef","rice","bread","fish","pork","goat","chicken","cheese","fries"};
        String [] bank5=new String [] {"basketball","baseball","hockey","cricket","badminton","swimming","soccer","football","volleyball","tennis"};
        int num=randy.nextInt(5);
        String word="";
        int num2=-1;
        switch (num)
        {
            case 0:
             num2=randy.nextInt(10);
            word=bank1[num2];
            break;
             case 1:
             num2=randy.nextInt(10);
            word=bank2[num2];
            break;
             case 2:
             num2=randy.nextInt(10);
            word=bank3[num2];
            break;
             case 3:
             num2=randy.nextInt(10);
            word=bank4[num2];
            break;
             case 4:
            num2=randy.nextInt(10);
            word=bank5[num2];
            break;
        
        
        
        }
        //running the specs
        spec();
        mainMenu(word);
        
    }   
   
    public static void spec()
    {
        System.out.println("X                                                X");
        System.out.println("X                                                X");
        System.out.println("X       please adjust the screen so that X's     X");
        System.out.println("X       are on the sides of your screen          X");
        System.out.println("X                                                X");
        System.out.println("X                                                X");
        System.out.println("X                                                X");
        System.out.println("X                                                X");
        System.out.println("X                                                X");
        System.out.println("X                                                X");
        System.out.println("X       Type y if you are ready                  X");
        Scanner sc=new Scanner(System.in);
        String y=sc.nextLine();
        y=y.toLowerCase();
        if (y.equals("y"))//make sure the user understand the instruction
        {    clear();
        }
        else  while(!(y.equals("y")))
                {
                 System.out.println("Type y if you are ready to save him");
                 y=sc.nextLine();   
        
                } 
                
    }    
    public  static void clear(){System.out.println("\f");}//clear the screen
    public  static void mainMenu(String word)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("X                     HANGMAN                    X");
        System.out.println("X                                                X");
        System.out.println("X       Type 1 for a single player game          X");
        System.out.println("X       Type 2 for a 2 player game               X");
        System.out.println("X       Type 3 for instruction                   X");
        System.out.println("X       Type 4 to exit                           X");
        System.out.println("X                                                X");
        System.out.println("X                                                X");
        System.out.println("X                                                X");
        System.out.println("X                                                X");
        System.out.println("X                                                X");
        int num=sc.nextInt();
        switch(num)
            {
                case 1:
                Hangman game= new Hangman(word);
                game.run();
                break;
                case 2:
               word = "";
               System.out.print("\f");
               Scanner Scannerr = new Scanner(System.in);
               System.out.println("Player One Please Enter a word/phrase");
               word = Scannerr.nextLine();
               HangmanTwo game2=new HangmanTwo(word);
               game2.run();
                break;
                case 3:
                instruction();
                break;
                case 4:
                System.exit(0);
                
            }    
        
    }    
    public static void instruction()
    {
        Scanner sc=new Scanner (System.in);
        clear();
        System.out.println("                Instruction                       ");
        System.out.println("       You will have to guess a letter in         ");
        System.out.println("       a word and if you guessed it wrong,        ");
        System.out.println("       the hangmam will have one more part.       ");
        System.out.println("       the man have only 7 parts, so if           ");
        System.out.println("       all 7 parts of the man is shown,           ");
        System.out.println("       you lose.                                  ");
        System.out.println("       You win by guessing all the correct        ");
        System.out.println("       in the word.                               ");
        System.out.println("                                                  ");
        
        
    }    
}
