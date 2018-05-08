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
                board[n][j] = '#';
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
    public static void main(String[] args){

    }

}
