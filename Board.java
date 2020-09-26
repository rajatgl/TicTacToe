public class Board{

  private char[] board;
  private final int BOARD_SIZE = 3;

  public Board(){

    board = new char[10];
  }

  public void initializeBoard(){

    for(int i=0;i<10;i++){
      board[i] = '-';
    }
  }

  public void printBoard(){

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
      board.printBoard();
  }
}
