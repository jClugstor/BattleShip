import java.util.List;
public class Ship {
    private int length;
    private List<Coordinate> coordinates;
    private String orientation;
    public Ship(int length,PlayBoard board){
        double orientation = Math.random();
        if(orientation > .50){
            this.orientation = "vertical";
        }
        else{
            this.orientation = "horizontal";
        }
        this.length = length;
        place(board);
    }
    public void place(PlayBoard board){
        int x = (int)(Math.random()*board.getBoard()[0].length) , y = (int)(Math.random()*board.getBoard().length);
        if(this.orientation.equals("vertical")){
            while(y+length > board.getBoard().length){
                y = (int)(Math.random()*board.getBoard().length);
            }
            if(y+length < board.getBoard().length){
                for(int i =0; i < length;i++){
                    coordinates.set(i,new Coordinate(x,i+y));
                }
            }
        }
        if(this.orientation.equals("horizontal")){
            while(x+length > board.getBoard()[0].length){
                x= (int)(Math.random()*board.getBoard()[0].length);
            }
            if(x+length < board.getBoard()[0].length){
                for(int i =0; i < length; i++){
                    coordinates.set(i,new Coordinate(x+i,y));
                }
            }
        }
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }
}
