
import java.util.*;

public class HangmanTwo{
    //Instance Variables
    Scanner sc;
    int[] word;
    boolean[] guessed;
    int hp;
    boolean solved;
    String words;
    //Main
    public static void main(String Args[])
    {
        String word = "";
        Scanner Scannerr = new Scanner(System.in);
        System.out.println("Player One Please Enter a word/phrase");
        word = Scannerr.nextLine();
        System.out.print("\f");
        HangmanTwo game=new HangmanTwo(word);
        game.run();
    }
    //Constructor
    public HangmanTwo(String w){
        sc = new Scanner(System.in);
        words=w;
        word = wordConvert(w);  //Read in the word
        guessed = new boolean[26];  //Already Guessed Letters
        hp = 7; //Guesses Left
        solved = false;
    }
    //Main method
    public void run(){  //Play the game of hangman
        boolean loop = true;//Variable to determine whether to loop
        while(loop){    //Main loop
            clear();
            printHangman();
            printWord();
            if(hp > 0 && solved == false){
                getGuess();
            }
            else{
                loop = false;
            }
        }
        //Print correct endgame
        if(solved){
            System.out.println("\n----PLAYER 2 WINS----");
        }else{
            System.out.println("\n---PLAYER 1 WINS---\n The Word is "+ words.toUpperCase());
        }
    }

    public void spec()
    {
        System.out.println("X                     HANGMAN                    X");
        System.out.println("X                                                X");
        System.out.println("X       please adjust the screen so that X's     X");
        System.out.println("X       are on the sides of your screen          X");
        System.out.println("X       You will have to guess a word            X");
        System.out.println("X       By guessing the letters in it            X");
        System.out.println("X       You can only have 7 wrong guesses        X");
        System.out.println("X       before the stick figure is hanged        X");
        System.out.println("X                                                X");
        System.out.println("X                                                X");
        System.out.println("X       Type y if you are ready to save him      X");
        Scanner sc=new Scanner (System.in);
        String y=sc.nextLine();
        y=y.toLowerCase();
        if (y.equals("y"))
        {    clear();
        }
        else  while(!(y.equals("y")))
            {
                System.out.println("Type y if you are ready to save him");
                y=sc.nextLine();   

        }    
    } 

    public void clear(){System.out.println("\f");}

    public void printHangman(){
        switch (hp) {
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
        if(hp > 0){System.out.println("["+hp+" guesses remaining]\n"+wordBank());}
    }

    public String wordBank(){
        String out = "[LETTER BANK]: ";
        for(int i = 0; i < 26; i++){
            if(guessed[i] == false){
                out += ((char)(i + 65));   //'A' == 65
            }
        }
        return out;
    }

    public void printWord(){
        //Loop through the array 'word'
        solved = true;
        for (int i = 0; i < word.length; i++) {
            //Check if letter has been guessed
            if(word[i] > 25 || word[i] < 0){
                System.out.print((char)(word[i] + 97));
            }else if(guessed[word[i]] == true){
                System.out.print((char)(word[i] + 65));   //'A' == 65;
            }else{
                System.out.print("-"); 
                solved = false;
            }
        }
    }

    public void getGuess(){ //TODO: Check to see if letter guessed is in the latin alphabet
        //Get UI for the letter to search for
        System.out.print("\nEnter your guess: ");
        String fullGuess = sc.nextLine().toLowerCase();
        //Condense down to 1 char
        if (fullGuess==null)
            getGuess();
        char guess=fullGuess.charAt(0);

        //Check if it has been guessed
        int intGuess = (int)guess - 97;

        if(intGuess > 25 || intGuess < 0){
        }else if(guessed[intGuess] == true){  //Convert out to indexes using 'a' == 97
            System.out.println("You've already guessed this letter.");
            getGuess();
        }else{
            //Loop through the word and see if guess is found
            for(int i = 0; i < word.length; i++){
                if(intGuess == word[i]){    //Guess is in word
                    hp++;
                    break;
                }
            }
            hp--;
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