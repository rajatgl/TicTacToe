import java.io.*;
import java.util.*;

public class Board{

  private char[] board;
  private final int BOARD_SIZE = 3;

  //Player Letter Choices
  private char playerChoice;
  private char computerChoice;

  public Board(){

    board = new char[10];
  }

  //use case 1
  public void initializeBoard(){

    for(int i=0;i<10;i++){
      this.board[i] = '-';
    }
  }

  //use case 2
  public void inputPlayerChoice(){

    Scanner sc = new Scanner(System.in);
    char temp = ' ';

    while(!isInputValid(temp)){

      System.out.print("Please enter your choice, do you choose X or O? ");
      temp = sc.next().charAt(0);
    }

    this.playerChoice = Character.toUpperCase(temp);
    this.computerChoice = complementChoice(this.playerChoice);
  }

  private boolean isInputValid(char input){

    return Character.toUpperCase(input) == 'X' || Character.toUpperCase(input) == 'O';
  }

  private char complementChoice(char input){

    return input == 'X' ? 'O' : 'X';
  }

  public char getPlayerChoice(){
    return this.playerChoice;
  }

  public char getComputerChoice(){
    return this.computerChoice;
  }

  public void printBoard(){

    //ignoring 0th element of the board
    int offset = 1;

    for(int i=0;i<BOARD_SIZE;i++){

      for(int j=0;j<BOARD_SIZE;j++){
          System.out.print(board[i*BOARD_SIZE + j + offset] + " ");
      }

      System.out.println();
    }
  }

  public static void main(String[] args){

      Board board = new Board();
      board.initializeBoard();
      board.inputPlayerChoice();

      System.out.println("\nPlayer Choice: " + board.getPlayerChoice() + " Computer Choice: " + board.getComputerChoice());
  }
}
