/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

/**
 *
 * @author sarthak sethi
 */
public class Board {
    private char board[][];
    char p1symbol,p2symbol;
    int count;
    private int boardsize;
    public static final int PLAYER_1_WINS = 1;
    public static final int PLAYER_2_WINS = 2;
    public static final int DRAW = 3;
    public static final int INCOMPLETE = 4;
    public static final int INVALID = 5;

    public Board(char p1symbol, char p2symbol, int boardsize) { 
        board = new char[boardsize][boardsize];
        for(int i=0;i<boardsize;i++){
            for(int j=0;j<boardsize;j++){
                board[i][j]=' ';
            }
        }
        this.p1symbol = p1symbol;
        this.p2symbol = p2symbol;
        this.boardsize = boardsize;
    }

    public int move(char symbol, int x, int y) { 
        
        if(x<0 || x>=boardsize || y<0 || y>=boardsize || board[x][y]!=' ')
            return INVALID;
        board[x][y]=symbol; 
       count++;
        if(board[x][0] == board[x][1] && board[x][0] == board[x][2]){
			return symbol == p1symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
        if(board[0][y] == board[1][y] && board[0][y] == board[2][y]){
		return symbol == p1symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
        // First Diagonal
		if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]){
			return symbol == p1symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
		// Second Diagonal
		if(board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]){
			return symbol == p1symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
                if(count == boardsize*boardsize)
                    return DRAW; // sab bhar gyaa and kuch nhi hua or
                
                return  INCOMPLETE;              
    }

    void print() {
        System.out.println("---------------");
		for(int i =0; i < boardsize; i++){
			for(int j =0; j < boardsize; j++){
				System.out.print("| " + board[i][j] + " |");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("---------------");
    }
    
    
}
