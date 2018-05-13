import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to BattleShip");
        System.out.println("How long should the board be?");
        int length = input.nextInt();
        System.out.println("How many ships?");
        int shipAmount = input.nextInt();
        PlayBoard board = new PlayBoard(length,shipAmount);
        System.out.println("Board initialized.");
        while(true){
            System.out.println(board);
            System.out.println("Enter X Coordinate");
            int Xcoord = input.nextInt();
            System.out.println("Enter Y Coordinate");
            int Ycoord = input.nextInt();
            if(board.checkIfHit(Xcoord,Ycoord)){
                System.out.println("Hit!");
                board.setHitOrMiss(Xcoord,Ycoord);
            }
            else{
                System.out.println("Miss!");
                board.setHitOrMiss(Xcoord,Ycoord);
            }
            System.out.println(board.getShipList());
        }
    }
}
