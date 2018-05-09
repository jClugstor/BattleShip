import java.util.Scanner;
public class PlayBoard {
    private char[][] board;
    private Ship aircraftCarrier = new Ship(5);
    private Ship battleShip = new Ship(4);
    private Ship submarine = new Ship(3);
    private Ship tugBoat = new Ship(2);
    public PlayBoard(int n){
        board = new char[n][n];
        for(int i=0; i< n;i++){
            for(int j=0; j<n ; j++){
                board[i][j] = '#';
            }
        }

    }



    public char[][] getBoard() {
        return board;
    }
    public void initializeBoard(){
        aircraftCarrier.place(this,(int)(10*Math.random()),(int)(10*Math.random()));
        battleShip.place(this,(int)(10*Math.random()),(int)(10*Math.random()));
        submarine.place(this,(int)(10*Math.random()),(int)(10*Math.random()));
        tugBoat.place(this,(int)(10*Math.random()),(int)(10*Math.random()));
    }

    @Override
    public String toString() {
        String thing = "";
        for(int i=0; i<board.length;i++){
            for(int j =0; j<board[0].length;j++){
                thing+= board[i][j];
            }
            thing+= "\n";
        }
        return thing;
    }
}
