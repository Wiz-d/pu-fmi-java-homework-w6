import java.util.Scanner;

public class ShmandalfMovementAndAbilities {

    public static  int nextNumber = 0;
    public static int previousNumber = 0;
    public static int[] previousCoordinates = new int[2];

    private static boolean isMovementPossible(int direction, String[][] arena) {
        int[] coordinates = Util.findUnitCoordinates(arena, "%");
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
        return (previousNumber > nextNumber);
    }

    private static void getValueOfNextNumber(int[][] intArena,int direction,String[][] arena){
        int[] coordinates = Util.findUnitCoordinates(arena,"%");
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


    private static void shmandalfFirstMove(int[] coordinates, String[][] arena, int direction,int[][] intArena){
        if (direction == 1) {
            previousNumber = intArena[coordinates[0]][coordinates[1] - 1];
            previousCoordinates[0] = coordinates[0];
            previousCoordinates[1] = coordinates[1];
            arena[coordinates[0]][coordinates[1] - 1] = "%";
        }
        if (direction == 2) {
            previousNumber = intArena[coordinates[0]][coordinates[1] + 1];
            previousCoordinates[0] = coordinates[0];
            previousCoordinates[1] = coordinates[1];
            arena[coordinates[0]][coordinates[1] + 1] = "%";
        }
        if (direction == 3) {
            previousNumber = intArena[coordinates[0] - 1][coordinates[1]];
            previousCoordinates[0] = coordinates[0];
            previousCoordinates[1] = coordinates[1];
            arena[coordinates[0] - 1][coordinates[1]] = "%";
        }
        if (direction == 4) {
            previousNumber = intArena[coordinates[0] + 1][coordinates[1]];
            previousCoordinates[0] = coordinates[0];
            previousCoordinates[1] = coordinates[1];
            arena[coordinates[0] + 1][coordinates[1]] = "%";
        }

        arena[previousCoordinates[0]][previousCoordinates[1]] = String.valueOf(intArena[previousCoordinates[0]][previousCoordinates[1]]);
    }

    public static void shmandalfMovement(String[][] arena, int turn, int[][] intArena){
        int nextNumber = 0;
        int direction;
        int[] coordinates = Util.findUnitCoordinates(arena, "%");

        do {
            direction = Util.getDirectionOfMovement();
        } while (Util.isUnitGonnaMoveOutOfBounds(direction, coordinates));

        getValueOfNextNumber(intArena,direction,arena);

        boolean isMovementPossible = isMovementPossible(direction, arena);

        if (turn == 0) {
            shmandalfFirstMove(coordinates, arena, direction,intArena);
        }

        if (isMovementPossible && turn > 0) {
            if (direction == 1) {
                previousNumber = intArena[coordinates[0]][coordinates[1] - 1];
                previousCoordinates[0] = coordinates[0];
                previousCoordinates[1] = coordinates[1];
                arena[coordinates[0]][coordinates[1] - 1] = "%";
            }
            if (direction == 2) {
                previousNumber = intArena[coordinates[0]][coordinates[1] + 1];
                previousCoordinates[0] = coordinates[0];
                previousCoordinates[1] = coordinates[1];
                arena[coordinates[0]][coordinates[1] + 1] = "%";
            }
            if (direction == 3) {
                previousNumber = intArena[coordinates[0] - 1][coordinates[1]];
                previousCoordinates[0] = coordinates[0];
                previousCoordinates[1] = coordinates[1];
                arena[coordinates[0] - 1][coordinates[1]] = "%";
            }
            if (direction == 4) {
                previousNumber = intArena[coordinates[0] + 1][coordinates[1]];
                previousCoordinates[0] = coordinates[0];
                previousCoordinates[1] = coordinates[1];
                arena[coordinates[0] + 1][coordinates[1]] = "%";
            }
        }

        arena[previousCoordinates[0]][previousCoordinates[1]] = String.valueOf(intArena[previousCoordinates[0]][previousCoordinates[1]]);

    }

    public static void shmandalfSpell(int[][] intArena,String[][] arena){
        Scanner scanner = new Scanner(System.in);

        int square1Row,square1Col,square2Row,square2Col = 0;

        System.out.println("square 1 (x,y):");
        square1Row = scanner.nextInt();
        square1Col = scanner.nextInt();

        System.out.println("square 2 x,y");
        square2Row = scanner.nextInt();
        square2Col = scanner.nextInt();

        while ( (square1Row != square2Row) && (square1Col != square2Col) ){
            System.out.println("error");
            System.out.println("square 2 x,y");
            square2Row = scanner.nextInt();
            square2Col = scanner.nextInt();
        }

        int highCol,lowCol = 0;

        if (square1Row == square2Row) {
            if (square1Col > square2Col){
                highCol = square1Col;
                lowCol = square2Col;
            }
            else{
                highCol = square2Col;
                lowCol = square1Col;
            }
            for (int i = lowCol ; i < highCol ; i++){
                for (int j = lowCol; j < highCol -1 ; j++){
                    if (intArena[square1Row][j] > intArena[square1Row][j+1]){
                        int temp = intArena[square1Row][j];
                        intArena[square1Row][j] = intArena[square1Row][j+1];
                        intArena[square1Row][j+1] = temp;

                        String temp2 = arena[square1Row][j];
                        arena[square1Row][j] = arena[square1Row][j+1];
                        arena[square1Row][j+1] = temp2;
                    }
                }
            }
        }

        int highRow,lowRow = 0;

        if (square1Col == square2Col) {
            if (square1Row > square2Row){
                highRow = square1Row;
                lowRow = square2Row;
            }
            else{
                highRow = square2Row;
                lowRow = square1Row;
            }
            for (int i = lowRow ; i < highRow ; i++){
                for (int j = lowRow; j < highRow - 1; j++){
                    if (intArena[j][square1Col] > intArena[j+1][square1Col]){
                        int temp = intArena[j][square1Col];
                        intArena[j][square1Col] = intArena[j+1][square1Col];
                        intArena[j+1][square1Col] = temp;

                        String temp2 = arena[j][square1Col];
                        arena[j][square1Col] = arena[j+1][square1Col];
                        arena[j+1][square1Col] = temp2;
                    }
                }
            }
        }


    }




}
