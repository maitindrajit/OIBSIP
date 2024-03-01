package Oasis_Infobyte;


//Indrajit Maiti

//OasisInfobyte


import java.util.*;
import java.util.Scanner;


public class Number_Guessing_Game {
//creating the main class for the Game
	
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);//Scanner class for input
        System.out.println("You want to play the game.....If yes press 1 else press 0"); // taking input if U want to play or not
        int count = 0; //count variable will count the no of times u have Guessed
        int s = sc.nextInt();
        while (true) {
            while (s == 1) {
                GuessGame g = new GuessGame();
                boolean b = false;
                // this while loop will keep on taking input until  u press 0 
                while (!b) {
                    g.takeUserInput();
                    b = g.isCorrectNumber();

                }
                count++;
                System.out.println("Total no of round played:....  " + count); // shows the round played
                System.out.println("*********************************************************************************************************************************************************");
                System.out.println("You want to play the game.....If yes press 1 else press 0"); // asks u want to play more or not

                s = sc.nextInt();
            }// if u give 0 then, the game is over
            while (s == 0) {
                System.out.println("Thank You See you next Time ");
                System.exit(0);

            } // if u give neither 0 nor 1 then it will ask to choose the right option
            while (s != 0 && s != 1) {
                System.out.println("Choose right option");
                s = sc.nextInt();
            }
        }
    }
}


// creating the class for the Guess game
class GuessGame {

    public int num;
    public int inputNumber;
    public int noOfGuesses = 00;

    public int getNoOfGuesses() {

        return noOfGuesses;
    }

    public void setNoOfGuesses(int noOfGuesses) {
        this.noOfGuesses = noOfGuesses;
    }
// here the computer will take it's number randomly 
    GuessGame() {
        Random rand = new Random();
        this.num = rand.nextInt(100);
    }
//here it will ask the user to guess the number
    void takeUserInput() {
        System.out.println("Guess the number");
        Scanner sc = new Scanner(System.in);
        inputNumber = sc.nextInt();
    }

    Boolean isCorrectNumber() {
             // In this loop it will check the user value is correct or not 
    		// If it is lower it will state the number is higher than this and 
    		//If it is higher it will state the number is lower than this
    		//Also it will state if u Exceed than 7 times , i.e. u guessed wrong more than 7 times
        noOfGuesses++;
        if (inputNumber == num && noOfGuesses <= 7) {
            System.out.format("Yes you guessed it right, it was %d\nYou guessed it in %d attempts", num, noOfGuesses);
            System.out.println(" ");

            return true;
        } else if (noOfGuesses == 7) {                    
            System.out.println("No of Attempts is over You lost the Game ");
            return true;
        } else if (inputNumber < num && noOfGuesses < 7) {
            System.out.println("Guess higher than this");
        } else if (inputNumber > num && noOfGuesses < 7) {
            System.out.println("Guess lower than this");
        }

        return false;
    }

}