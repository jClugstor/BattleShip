import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class PlayBoard {
    private char[][] board;
    private List<Ship> shipList;
    int amntShips;
    public PlayBoard(int boardLength, int amntShips){
        board = new char[10][boardLength];
        for(int i=0; i< 10;i++){
            for(int j=0; j<boardLength ; j++){
                board[i][j] = '#';
            }
        }
        shipList = new ArrayList<>(amntShips);

    }



    public char[][] getBoard() {
        return board;
    }
    public void initializeBoard(){

    }
    public boolean checkIfHit(int x,int y){
        for(Ship ship : shipList){
            for(Coordinate coordinate : ship.getCoordinates()){
                if((coordinate.getX() == x) && coordinate.getY() ==y){
                    return true;
                }
            }
        }
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
