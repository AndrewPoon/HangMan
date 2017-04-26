
import java.util.*;
public class Hangman{
    //Instance Variables
    Scanner sc;
    int[] word;
    boolean[] guessed;
    int GuessesLeft;
    boolean solved;
    String words;
    String [] letterGuessed;
    //Constructor
    public Hangman(String w){
        sc = new Scanner(System.in);
        words=w;
        word = wordConvert(w);  //Read in the word
        guessed = new boolean[26];  //Already Guessed Letters
        GuessesLeft = 7; //Guesses Left
        solved = false;
        letterGuessed=new String[26];
    }
    //Main method
    public void run(){  //Play the game of hangman
        boolean loop = true;//Variable to determine whether to loop
        while(loop){    //Main loop
            clear();
            printHangman();
            printWord();
            if(GuessesLeft > 0 && solved == false){
                getGuess();
            }
            else{
                loop = false;
            }
        }
        //Print correct endgame
        if(solved){
            System.out.println("\n----YOU WON----");
        }else{
            System.out.println("\n---GAME OVER---\n The Word is "+ words);
        }
    }
    public void clear(){System.out.print("\f");}//clear the screen
    
    public void printHangman(){
        switch (GuessesLeft)//change image based on GuessesLeft
        {
            case 0:
                System.out.println("    _____      ");
                System.out.println("   |     |     ");
                System.out.println("   |     O     ");
                System.out.println("   |   / | \\  ");
                System.out.println("   |     |     ");
                System.out.println("   |    / \\   ");
                break;
            case 1:
                System.out.println("    _____      ");
                System.out.println("   |     |     ");
                System.out.println("   |     O     ");
                System.out.println("   |   / | \\  ");
                System.out.println("   |     |     ");
                System.out.println("   |    /      ");
                break;
            case 2:
                System.out.println("    _____      ");
                System.out.println("   |     |     ");
                System.out.println("   |     O     ");
                System.out.println("   |   / | \\  ");
                System.out.println("   |     |     ");
                System.out.println("   |           ");
                break;
            case 3:
                System.out.println("    _____      ");
                System.out.println("   |     |     ");
                System.out.println("   |     O     ");
                System.out.println("   |   / | \\  ");
                System.out.println("   |           ");
                System.out.println("   |           ");
                break;
            case 4:
                System.out.println("    _____      ");
                System.out.println("   |     |     ");
                System.out.println("   |     O     ");
                System.out.println("   |   / |     ");
                System.out.println("   |           ");
                System.out.println("   |           ");
                break;
            case 5:
                System.out.println("    _____      ");
                System.out.println("   |     |     ");
                System.out.println("   |     O     ");
                System.out.println("   |   /       ");
                System.out.println("   |           ");
                System.out.println("   |           ");
                break;
            case 6:
                System.out.println("    _____      ");
                System.out.println("   |     |     ");
                System.out.println("   |     O     ");
                System.out.println("   |           ");
                System.out.println("   |           ");
                System.out.println("   |           ");
                break;
            case 7:
                System.out.println("    _____      ");
                System.out.println("   |           ");
                System.out.println("   |           ");
                System.out.println("   |           ");
                System.out.println("   |           ");
                System.out.println("   |           ");
                break;
        }
        if(GuessesLeft > 0){System.out.println("["+GuessesLeft+" guesses remaining]");}
    }

    public void printWord(){
        //Loop through the array 'word'
        solved = true;
        int x=0;
        for (int i = 0; i < word.length; i++) {
            //Check if letter has been guessed
            if(guessed[word[i]] == true){
                System.out.print((char)(word[i] + 65) + " ");   //'A' == 65;
            }
             else{
                System.out.print("- "); 
                solved = false;
            }
 
           
        }
    }

    public void getGuess(){ 
        //Get UI for the letter to search for
        System.out.print("\nEnter your guess: ");
        String fullGuess = sc.nextLine();
        fullGuess=fullGuess.toLowerCase();
      if (fullGuess==null)
      {
         getGuess();
       }   
           
        
        
        //Condense down to 1 char
        char guess=fullGuess.charAt(0);
        //Check if it has been guessed
        int intGuess = (int)guess - 97;
        if (intGuess<0)//ACSII character under 97 are not valid 
        {    System.out.println("invalid letters.");
             getGuess();
        }    
        else if(guessed[intGuess] == true){  //Convert out to indexes using 'a' == 97
            System.out.println("You've already guessed this letter.");
           getGuess();
        }else{
            //Loop through the word and see if guess is found
            for(int i = 0; i < word.length; i++){
                if(intGuess == word[i]){    //Guess is in word
                    GuessesLeft++;
                    break;
                }
            }
            GuessesLeft--;
            guessed[intGuess] = true;
        }
    }

    public int[] wordConvert(String in){
        //Prep variables
        in = in.toLowerCase();
        int[] output = new int[in.length()];
        //Loop through and convert into numbers
        for (int i = 0; i < in.length(); i++) {
            char x = in.charAt(i);
            output[i] = (int)x - 97;    //Convert char out to integer index ('a' == 97)
        }

        return output;
    }
}

