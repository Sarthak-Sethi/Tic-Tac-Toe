
package tic.tac.toe;

import java.util.Scanner;

public class TicTacToe {
 private Player player1, player2;
 private Board board;
 public void startgAME(){
     Scanner s = new Scanner(System.in);
     player1 = takeplayerinput(1);
     player2 = takeplayerinput(2);
     
     while(player1.getSymbol()==(player2.getSymbol()))
     {
         System.out.println("Symbol already taken please choose another");
         char symbol = s.next().charAt(0);
         player2.setSymbol(symbol);
     }
     Board board = new Board(player1.getSymbol(), player2.getSymbol(), 3);
     int status = board.INCOMPLETE;
     boolean player1turn = true;
     while(status == board.INCOMPLETE || status == board.INVALID) {
     if(player1turn){
         System.out.println("Player "+player1.getName()+"turn");
         System.out.println("ENTER X:");
         int x = s.nextInt();
         System.out.println("ENTER Y :");
         int y = s.nextInt();
          status = board.move(player1.getSymbol(),x,y);
         if(status != board.INVALID){
             player1turn  = false;
             board.print();
         }
         else
             System.out.println("inavlid try again");
         
     }
     else{
          System.out.println("Player "+player2.getName()+"turn");
         System.out.println("ENTER X:");
         int x = s.nextInt();
         System.out.println("ENTER Y :");
         int y = s.nextInt();
          status = board.move(player2.getSymbol(),x,y);
         if(status != board.INVALID){
               player1turn = true;
               board.print();
         }
         else
             System.out.println("invalid try again");
         
     }
     }
     if(status == board.PLAYER_1_WINS)
         System.out.println(" player 1 won");
     else if(status == board.PLAYER_2_WINS)
         System.out.println("player 2 wins");
     else
         System.out.println(" draw");
 }
    public static void main(String[] args) {
      TicTacToe t = new TicTacToe();
      t.startgAME();
       
    }

    private Player takeplayerinput(int num) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Name for player"+num);
        String name = s.nextLine();
        System.out.println("Enter symbol for "+num);
        char symbol = s.next().charAt(0);
        Player p = new Player(name, symbol);
        return p;
        
        
    }
}
