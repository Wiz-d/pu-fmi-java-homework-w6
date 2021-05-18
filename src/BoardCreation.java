import java.util.Random;

public class BoardCreation {

    static final int NUMBER_OF_COLS = 18;
    static final int NUMBER_OF_ROWS = 12;
    static final int MAX_RANDOM_VALUE = NUMBER_OF_COLS*NUMBER_OF_ROWS+1;
    static final String OFFICE_MARKER = "X";

    private static int getUniqueRandomForArray(int[][] arena) {
        int randomValue;

        do {
            randomValue = getRandom();
        } while (alreadyExists(arena, randomValue));

        return randomValue;
    }


    private static int getRandom() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_VALUE);
    }


    private static boolean alreadyExists(int[][] arena, int number) {
        for (int row = 0; row < 12; row++) {
            for (int col = 0; col < 18; col++) {
                if (arena[col][row] == number) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void fillWithRandoms(int[][] arena) {
        for (int row = 0; row < 12; row++) {
            for (int col = 0; col < 18; col++) {
                arena[col][row] = getUniqueRandomForArray(arena);
            }
        }
    }

    public static void createBuildings(String[][] arena){

        for (int col=8;col<=9;col++){
            for(int row=5;row<=6;row++){
                arena[col][row] = OFFICE_MARKER;
            }
        }

    }


}
