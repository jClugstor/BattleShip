public class Ship {
    private int length;
    private int[][] positions;
    private String orientation;
    public Ship(int length){
        this.length = length;
    }
    public void place(PlayBoard board,int x,int y){
        if(this.orientation.equals("vertical")){
            if(y+length > board.getBoard().length){
                for(int i =0; i < length;i++){
                    positions[i][0]=x;
                    positions[i][1]=i+y;
                }
            }
        }
        if(this.orientation.equals("horizontal")){
            if(x+length > board.getBoard()[0].length){
                for(int i =0; i < length; i++){
                    positions[i][0]=x+i;
                    positions[i][1]=y;
                }
            }
        }
    }

}
