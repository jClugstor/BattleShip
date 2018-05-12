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

    }
}
