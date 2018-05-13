import java.util.ArrayList;
import java.util.List;
public class PlayBoard {
    private char[][] board;
    private List<Ship> shipList;
    int amntShips;
    public PlayBoard(int boardLength, int amntShips){
        board = new char[10][boardLength];
        for(int i=0; i< 10;i++){
            for(int j=0 ; j<boardLength ; j++){
                board[i][j] = '~';
            }
        }
        shipList = new ArrayList<>(amntShips);


    }
    public char[][] getBoard() {
        return board;
    }

    public boolean checkIfHit(int x,int y){
        for(Ship ship : shipList){
            for(Coordinate coordinate : ship.getCoordinates()){
                if((coordinate.getX() == x) && (coordinate.getY() == y)){
                    return true;
                }
            }
        }
        return false;
    }
    public void initialize(){
        boolean collision = false;
        for(int i =0; i < shipList.size(); i++){
            while(collision) {
                shipList.set(i, new Ship((int) (4 * Math.random()), this));
                collision = collision(i,shipList.get(i));
            }
        }
    }
    private boolean collision(int n, Ship ship){
        for(int i =0; i< n; i++){
           for(int j = 0; j < shipList.get(i).getCoordinates().size(); j++){
               int otherX = shipList.get(i).getCoordinates().get(j).getX(),otherY = shipList.get(i).getCoordinates().get(i).getY();
               int shipX = ship.getCoordinates().get(i).getX(), shipY = ship.getCoordinates().get(i).getY();
               if((otherX == shipX) && (otherY == shipY)){
                   return true;
               }
           }
        }
        return false;
    }
    public void setHitOrMiss(int x, int y){
        if(checkIfHit(x,y)){
            board[y][x] = 'O';
            shipWithCoordinate(x,y).getCoordinate(x,y).setHit(true);
        }
        else{
            board[y][x] = 'X';
        }
    }
    public Ship shipWithCoordinate(int x, int y){
        for(Ship ship : shipList){
            for(Coordinate coord : ship.getCoordinates()){
                if((coord.getX() == x) && (coord.getY() == y)){
                    return ship;
                }
            }
        }
        return null;
    }
    public boolean checkIfWin(){
        for(Ship ship:shipList){
            for(Coordinate coord : ship.getCoordinates()){
                if (!coord.getHit()){
                    return false;
                }
            }
        }
        return true;
    }

    public List<Ship> getShipList() {
        return shipList;
    }

    @Override
    public String toString() {
        String thing = "";
        for(int i=0; i<board.length;i++){
            for(int j =0; j<board[0].length;j++){
                thing+= board[i][j] + " ";
            }
            thing+= "\n";
        }
        return thing;
    }
}
