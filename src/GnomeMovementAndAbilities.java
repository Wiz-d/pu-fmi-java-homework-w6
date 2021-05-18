import java.util.Scanner;

public class GnomeMovementAndAbilities {


    public static int uniqueVal = 0;
    public static int[] previousCoordinates = new int[2];

    private static boolean isAverageOutsideOfBorder(int[] newCoordinates){
        if(newCoordinates[0]+3>17 || newCoordinates[1]+3>11){
            return true;
        }
        return newCoordinates[0] - 3 < 0 || newCoordinates[1] - 3 < 0;
    }

    private static int[] getNewCoordinate(int direction, String[][] arena) {

        int[] coordinates = Util.findUnitCoordinates(arena, "#");
        int[] newCoordinates = new int[2];

        if (direction == 1) {
            newCoordinates[0] = coordinates[0];
            newCoordinates[1] = coordinates[1]-1;
        }

        if (direction == 2) {
            newCoordinates[0] = coordinates[0];
            newCoordinates[1] = coordinates[1]+1;
        }

        if (direction == 3) {
            newCoordinates[0] = coordinates[0]-1;
            newCoordinates[1] = coordinates[1];
        }

        if (direction == 4) {
            newCoordinates[0] = coordinates[0]+1;
            newCoordinates[1] = coordinates[1];
        }

        return newCoordinates;
    }

    private static int calculateAverage(int direction,int[][] intArena,String[][] arena){
        int average = 0;
        int sum = 0;
        int[] coordinates = Util.findUnitCoordinates(arena,"#");
        int[] newCoordinates = getNewCoordinate(direction,arena);

        if(!isAverageOutsideOfBorder(newCoordinates)){
            for(int row=newCoordinates[1];row<newCoordinates[1]+3;row++){
                for(int col=newCoordinates[0];col<newCoordinates[0]+3;col++){
                    if(arena[col][row].equals("#"))
                        continue;
                    sum =+ intArena[col][row];

                }
            }

            average = sum/8;

        }

        final int colLimiter = 18;
        final int rowLimiter = 12;
        int numbersSummed=0;

        if(isAverageOutsideOfBorder(newCoordinates)){
            for(int row=newCoordinates[1];row<rowLimiter;row++){
                for(int col=newCoordinates[0];col<colLimiter;col++){
                    if(arena[col][row].equals("#"))
                        continue;
                        sum =+ intArena[col][row];
                        numbersSummed++;

                }
            }

            average=sum/numbersSummed;

        }


        return average;
    }

    private static boolean isMovementPossible(int average,int[] newCoordinates,int[][] intArena) {
        return (intArena[newCoordinates[0]][newCoordinates[1]]>average);
    }




    public static void gnomeMovement(String[][] arena, int[][] intArena) {
        int direction;
        int[] coordinates = Util.findUnitCoordinates(arena, "#");

        do {
            direction = Util.getDirectionOfMovement();
        } while (Util.isUnitGonnaMoveOutOfBounds(direction, coordinates));

        int[] newCoordinates = getNewCoordinate(direction,arena);
        int average = calculateAverage(direction,intArena,arena);
        boolean isMovementPossible = isMovementPossible(average,newCoordinates,intArena);

        if(direction == 1 && isMovementPossible){
            previousCoordinates[0] = coordinates[0];
            previousCoordinates[1] = coordinates[1];
            arena[coordinates[0]][coordinates[1] - 1] = "#";
        }

        if(direction == 2 && isMovementPossible){
            previousCoordinates[0] = coordinates[0];
            previousCoordinates[1] = coordinates[1];
            arena[coordinates[0]][coordinates[1] + 1] = "#";
        }

        if(direction == 3 && isMovementPossible){
            previousCoordinates[0] = coordinates[0];
            previousCoordinates[1] = coordinates[1];
            arena[coordinates[0] - 1][coordinates[1]] = "#";
        }

        if(direction == 4 && isMovementPossible){
            previousCoordinates[0] = coordinates[0];
            previousCoordinates[1] = coordinates[1];
            arena[coordinates[0] + 1][coordinates[1]] = "#";
        }

        arena[previousCoordinates[0]][previousCoordinates[1]] = String.valueOf(intArena[previousCoordinates[0]][previousCoordinates[1]]);

    }



    public static void gnomeSpell (int[][] intArena,String[][] arena){
        Scanner scanner = new Scanner(System.in);

        int answer = 0;
        int square1Row,square1Col = 0;
        int square2Row,square2Col = 0;
        int square3Row,square3Col = 0;

        System.out.println("How many squares");
        answer = scanner.nextInt();
        switch (answer){
            case 2:
                System.out.println("square1 x,y:");
                square1Row = scanner.nextInt();
                square1Col = scanner.nextInt();
                System.out.println("square2 x,y:");
                square2Row = scanner.nextInt();
                square2Col = scanner.nextInt();

                intArena[square1Row][square1Col] = intArena[square1Row][square1Col] + intArena[square2Row][square2Col];
                intArena[square2Row][square2Col] = uniqueVal--;

                arena[square1Row][square1Col] = String.valueOf(intArena[square1Row][square1Col]);
                arena[square2Row][square2Col] = String.valueOf(uniqueVal--);

                uniqueVal--;
                break;
            case 3:
                System.out.println("square1 x,y:");
                square1Row = scanner.nextInt();
                square1Col = scanner.nextInt();
                System.out.println("square2 x,y:");
                square2Row = scanner.nextInt();
                square2Col = scanner.nextInt();
                System.out.println("square3 x,y:");
                square3Row = scanner.nextInt();
                square3Col = scanner.nextInt();

                intArena[square1Row][square1Col] = intArena[square1Row][square1Col] + intArena[square2Row][square2Col] + intArena[square3Row][square3Col];
                intArena[square2Row][square2Col] = uniqueVal--;
                intArena[square3Row][square3Col] = uniqueVal--;

                arena[square1Row][square1Col] = String.valueOf(intArena[square1Row][square1Col]);
                arena[square2Row][square2Col] = String.valueOf(uniqueVal--);
                arena[square3Row][square3Col] = String.valueOf(uniqueVal--);

                uniqueVal--;
        }


    }



}
