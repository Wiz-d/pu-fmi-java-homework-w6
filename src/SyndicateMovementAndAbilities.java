import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SyndicateMovementAndAbilities {

    private static int nextNumber = 0;
    private static int previousNumber = 0;
    public static int[] previousCoordinates = new int[2];

    private static boolean isMovementPossible(int direction, String[][] arena) {
        int[] coordinates = Util.findUnitCoordinates(arena, "$");
        if (direction == 1) {
            nextNumber = Integer.parseInt(arena[coordinates[0]][coordinates[1] - 1]);
        }
        if (direction == 2) {
            nextNumber = Integer.parseInt(arena[coordinates[0]][coordinates[1] + 1]);
        }
        if (direction == 3) {
            nextNumber = Integer.parseInt(arena[coordinates[0] - 1][coordinates[1]]);
        }
        if (direction == 4) {
            nextNumber = Integer.parseInt(arena[coordinates[0] + 1][coordinates[1]]);
        }
        return (previousNumber < nextNumber && nextNumber % 2 == 0);
    }

    private static void getValueOfNextNumber(int[][] intArena,int direction,String[][] arena){
        int[] coordinates = Util.findUnitCoordinates(arena,"$");
        if (direction == 1) {
            nextNumber = intArena[coordinates[0]][coordinates[1] - 1] ;
        }
        if (direction == 2) {
            nextNumber = intArena[coordinates[0]][coordinates[1] + 1];
        }
        if (direction == 3) {
            nextNumber = intArena[coordinates[0] - 1][coordinates[1]];
        }
        if (direction == 4) {
            nextNumber = intArena[coordinates[0] + 1][coordinates[1]];
        }
    }


    private static void syndicateMovementFirstTurn(int[] coordinates, String[][] arena, int direction,int[][] intArena) {
        boolean isMovementPossible = isMovementPossible(direction, arena);
        if (direction == 1 && isMovementPossible) {
            previousNumber = intArena[coordinates[0]][coordinates[1] - 1];
            previousCoordinates[0] = coordinates[0];
            previousCoordinates[1] = coordinates[1];
            arena[coordinates[0]][coordinates[1] - 1] = "$";
        }
        if (direction == 2 && isMovementPossible) {
            previousNumber = intArena[coordinates[0]][coordinates[1] + 1];
            previousCoordinates[0] = coordinates[0];
            previousCoordinates[1] = coordinates[1];
            arena[coordinates[0]][coordinates[1] + 1] = "$";
        }
        if (direction == 3 && isMovementPossible) {
            previousNumber = intArena[coordinates[0] - 1][coordinates[1]];
            previousCoordinates[0] = coordinates[0];
            previousCoordinates[1] = coordinates[1];
            arena[coordinates[0] - 1][coordinates[1]] = "$";
        }
        if (direction == 4 && isMovementPossible) {
            previousNumber = intArena[coordinates[0] + 1][coordinates[1]];
            previousCoordinates[0] = coordinates[0];
            previousCoordinates[1] = coordinates[1];
            arena[coordinates[0] + 1][coordinates[1]] = "$";
        }

        arena[previousCoordinates[0]][previousCoordinates[1]] = String.valueOf(intArena[previousCoordinates[0]][previousCoordinates[1]]);

    }


    public static void syndicateMovement(String[][] arena, int turn, int[][] intArena) {
        int direction;
        int[] coordinates = Util.findUnitCoordinates(arena, "$");

        do {
            direction = Util.getDirectionOfMovement();
        } while (Util.isUnitGonnaMoveOutOfBounds(direction, coordinates));

        getValueOfNextNumber(intArena,direction,arena);

        boolean isMovementPossible = isMovementPossible(direction, arena);

        if (turn == 0) {
            syndicateMovementFirstTurn(coordinates, arena, direction,intArena);
        }

        if (isMovementPossible && turn > 0) {
            if (direction == 1) {
                previousNumber = intArena[coordinates[0]][coordinates[1] - 1];
                previousCoordinates[0] = coordinates[0];
                previousCoordinates[1] = coordinates[1];
                arena[coordinates[0]][coordinates[1] - 1] = "$";
            }
            if (direction == 2) {
                previousNumber = intArena[coordinates[0]][coordinates[1] + 1];
                previousCoordinates[0] = coordinates[0];
                previousCoordinates[1] = coordinates[1];
                arena[coordinates[0]][coordinates[1] + 1] = "$";
            }
            if (direction == 3) {
                previousNumber = intArena[coordinates[0] - 1][coordinates[1]];
                previousCoordinates[0] = coordinates[0];
                previousCoordinates[1] = coordinates[1];
                arena[coordinates[0] - 1][coordinates[1]] = "$";
            }
            if (direction == 4) {
                previousNumber = intArena[coordinates[0] + 1][coordinates[1]];
                previousCoordinates[0] = coordinates[0];
                previousCoordinates[1] = coordinates[1];
                arena[coordinates[0] + 1][coordinates[1]] = "$";
            }
        }

        arena[previousCoordinates[0]][previousCoordinates[1]] = String.valueOf(intArena[previousCoordinates[0]][previousCoordinates[1]]);


    }







    public static void syndicateSpell(int[][] intArena,String[][] arena){ //done
        Scanner scanner = new Scanner(System.in);
        int[] units = Util.findUnitCoordinates(arena,"$");

        System.out.println("square1Row:");
        int square1Row = scanner.nextInt();
        //bug roll is always selected as for col it works as intended
        while ( (square1Row >= units[1] + 5) || (square1Row <= units[1] - 5 ) ){
            System.out.println("error try again");
            square1Row = scanner.nextInt();
        }


        System.out.println("square1Col:");
        int square1Col = scanner.nextInt();

        while ( (square1Col >= units[0] +5 ) || (square1Col <= units[0] -5) ){
            System.out.println("error try again");
            square1Col = scanner.nextInt();
        }


        System.out.println("square2Row:");
        int square2Row = scanner.nextInt();

        while ( (square2Row >= units[1] + 5) || (square2Row <= units[1] - 5 ) ){
            System.out.println("error try again");
            square2Row = scanner.nextInt();
        }

        System.out.println("square2Col:");
        int square2Col = scanner.nextInt();

        while ( (square2Col >= units[0] +5 ) || (square2Col <= units[0] -5) ){
            System.out.println("error try again");
            square2Col = scanner.nextInt();
        }

        int temp = intArena[square1Row][square1Col];
        intArena[square1Row][square1Col] = intArena[square2Row][square2Col];
        intArena[square2Row][square2Col] = temp;

        String temp2 = arena[square1Row][square1Col];
        arena[square1Row][square1Col] =arena[square2Row][square2Col];
        arena[square2Row][square2Col] = temp2;

    }

}
