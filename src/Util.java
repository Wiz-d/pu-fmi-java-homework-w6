import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Util {

//    public static int[][] convertArrayToInt(String[][] arena){
//
//        int[][] newArena = new int[BoardCreation.NUMBER_OF_COLS][BoardCreation.NUMBER_OF_ROWS];
//
//        for (int i = 0;i<BoardCreation.NUMBER_OF_COLS;i++){
//            for(int j=0;j<BoardCreation.NUMBER_OF_ROWS;j++){
//                newArena[i][j] = Integer.parseInt(arena[i][j]);
//            }
//        }
//        return newArena;
//    }

    public static int[] findUnitCoordinates(String[][] arena,String desiredUnit){
        int[] coordinates = new int[2];

        for(int row=0;row<12;row++){
            for(int col=0;col<18;col++){
                if(arena[col][row].equals(desiredUnit)) {
                    coordinates[0] = col;
                    coordinates[1] = row;
                }
            }
        }
        return coordinates;
    }

    public static boolean isUnitGonnaMoveOutOfBounds(int direction,int[] coordinates){
        if (coordinates[0] == 0 && direction == 3){
            return true;
        }
        if (coordinates[0] == 17 && direction == 4){
            return true;
        }
        if (coordinates[1] == 0 && direction == 1){
            return true;
        }
        return coordinates[1] == 11 && direction == 2;
    }

    public static String[][] convertArrayToString(int[][] arena){

        String[][] arenaString = new String[BoardCreation.NUMBER_OF_COLS][BoardCreation.NUMBER_OF_ROWS];

        for(int col=0;col<BoardCreation.NUMBER_OF_COLS;col++){
            for(int row=0;row<BoardCreation.NUMBER_OF_ROWS;row++){
                arenaString[col][row] = String.valueOf(arena[col][row]);
            }
        }

        return arenaString;
    }

    public static String[] randomizeElements(String[] array) {
        Random random = new Random();
        int randomPosition;
        String temp;

        for (int i = array.length - 1; i > 0; i--) {
            randomPosition = random.nextInt(array.length);
            temp = array[randomPosition];
            array[randomPosition] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static void printStringBoard(String[][] arena) {
        System.out.println("------------------------------------------------------------------------");
        for (int row = 0; row < 12; row++) {
            for (int col = 0; col < 18; col++) {
                System.out.printf("%4s", arena[col][row]);
            }

            System.out.println();
        }

        System.out.println("------------------------------------------------------------------------");
        System.out.println();
    }

    public static int getDirectionOfMovement(){
        String direction;
        int directionNumber=0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Въведете посока за вървене (wasd)");
        direction = scanner.nextLine();
        char firstLetter = direction.toLowerCase().charAt(0);

        if(firstLetter == 'w'){
            directionNumber = 1;
        }
        if(firstLetter == 's'){
            directionNumber = 2;
        }
        if(firstLetter == 'a'){
            directionNumber = 3;
        }
        if(firstLetter == 'd'){
            directionNumber = 4;
        }

        return directionNumber;
    }

    public static void printMenuList(){
        System.out.println("Pick an option");
        System.out.println("1. Move syndicate");
        System.out.println("2. Move gnome");
        System.out.println("3. Move shmandalf");
        System.out.println("4. Use syndicate spell");
        System.out.println("5. Use gnome spell");
        System.out.println("6. Use shmandalf spell");
    }

    public static boolean isGameWon(String[][] arena) {

        for (int col = 8; col <= 9; col++) {
            for (int row = 5; row <= 6; row++) {
                if (arena[col][row].equals("#") || arena[col][row].equals("%") || arena[col][row].equals("$"))
                    return true;
            }
        }

        return false;
    }


}




