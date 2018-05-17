import java.util.ArrayList;
import java.util.List;
public class PlayBoard {
    private char[][] board;
    private List<Ship> shipList;
    private int amntShips;
    public PlayBoard(int boardLength,int boardHeight, int amntShips){
        board = new char[boardHeight][boardLength];
        for(int i=0; i< boardHeight;i++){
            for(int j=0 ; j<boardLength ; j++){
                board[i][j] = '~';
            }
        }
        this.amntShips = amntShips;
        shipList = new ArrayList<>(amntShips);
        this.initialize();
        System.out.println(shipList.size());



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
    private void initialize(){
        boolean collision;
        for(int i =0; i < amntShips; i++){
            shipList.add(new Ship(((int) (6 * Math.random()))+1,this));
            collision = collision(i,shipList.get(i));
            while (collision){
                shipList.set(i, new Ship(((int) (6 * Math.random()))+1, this));
                collision = collision(i,shipList.get(i));
            }
        }
    }
    private boolean collision(int n, Ship ship){
        for(int i =0; i < n-1; i++){
           for(int j =0; j<ship.getCoordinates().size();j++){
               if(shipList.get(i).getCoordinates().contains(ship.getCoordinates().get(j))){
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
            thing += "\n";
        }
        return thing;
    }
}
