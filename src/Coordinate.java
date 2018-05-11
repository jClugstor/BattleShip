public class Coordinate {
    private int x ,y;
    private boolean isHit;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }
    public boolean getHit(){
        return isHit;
    }
}
