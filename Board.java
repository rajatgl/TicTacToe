import java.io.*;
import java.util.*;
public class Board{
  private char[] board;
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
    this.playerChoice=Character.toUpperCase(temp);
    this.computerChoice=complementChoice(this.playerChoice);
  }

  private boolean isInputValid(char input){
    return Character.toUpperCase(input)=='X'||Character.toUpperCase(input)=='O';
  }

  private char complementChoice(char input){
    return input=='X'?'O':'X';
  }

  public char getPlayerChoice(){
    return this.playerChoice;
  }

  public char getComputerChoice(){
    return this.computerChoice;
  }

  //use case 3
  public void showBoard(){
    //ignoring 0th element of the board
    int offset = 1;
    System.out.println("\nShowing the Board:\n");
    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++){
          System.out.print(" "+board[i*3+j+offset]+" ");
          if(j<2) System.out.print("|"); else System.out.print(" ");
      }
      if(i<2) System.out.println("\n---+---+---"); else System.out.println();
    }
  }

  //use case 4
  public void makeUserMove(){
    System.out.println("Please enter the index you want to occupy (choose between 1-9):");
    Scanner sc = new Scanner(System.in);
    int temp = sc.nextInt();
    //Loop until user enters a valid index
    while(temp<1||temp>9||board[temp]!='-'){
      if(temp<1||temp>9)
        System.out.println("\nPlease enter a valid index to occupy (choose between 1-9):");
      else
        System.out.println("\nPlease enter a valid index to occupy (index you chose is already occupied):");
      temp=sc.nextInt();
    }
    //Place the user choice on the board
    placeUserMove(temp);
    this.showBoard();
  }

  //use case 5
  public void placeUserMove(int index){
    board[index]=this.getPlayerChoice();
  }

  //use case 6
  public void startGame(){
    int userChoice=chooseTossOutcome();
    int tossValue=toss();
    if(tossValue==userChoice){
      //User won the toss. Play him first.
      System.out.println("\nGreat! You won the toss.");
      makeUserMove();
    }
    else{
      System.out.println("\nOops, you lost the toss. Computer should play first.");
      makeComputerMove();
    }
  }

  public int chooseTossOutcome(){
    System.out.println("\nTIME FOR TOSS! Please choose HEAD or TAIL. Enter 1 for HEAD and 2 for TAIL.");
    Scanner sc=new Scanner(System.in);
    int temp=sc.nextInt();
    while(temp!=1&&temp!=2){
      System.out.println("Please choose HEAD or TAIL. Enter 1 for HEAD and 2 for TAIL.");
      temp=sc.nextInt();
    }
    return temp;
  }

  public int toss(){
    Random random = new Random();
    //1 for HEAD and 2 for TAIL
    return random.nextInt()%2+1;
  }

  //use case 7
  public void makeComputerMove(){
    int choice = new Random().nextInt()%9+1;
    while(board[choice]!='-'){
      choice = new Random().nextInt()%9+1;
    }
    placeComputerMove(choice);
    this.showBoard();
  }

  public void placeComputerMove(int index){
    board[index]=this.getComputerChoice();
  }

  public static void main(String[] args){
      Board board = new Board();
      board.initializeBoard();
      board.inputPlayerChoice();
      System.out.println("\nPlayer Choice: " + board.getPlayerChoice() + " Computer Choice: " + board.getComputerChoice());
      board.showBoard();
      board.startGame();
  }
}
