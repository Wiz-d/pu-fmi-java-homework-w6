import java.util.Random;

public class HeroCreation {

    private static boolean doesNumberExist(int[] array,int randomNumber){
        for(int i=0;i<array.length;i++){
            if(array[i] == randomNumber){
                return true;
            }
        }
        return false;
    }

    private static int createUniqueCoordinates(int[] coordinates){
        Random random = new Random();
        int randomNumber;

        do{
            randomNumber = random.nextInt(5);
            if(randomNumber == 0)
                randomNumber++;
        }while (doesNumberExist(coordinates,randomNumber));


        return randomNumber;
    }

    private static void getCoordinates(int[] coordinates){
        for(int i = 0;i<coordinates.length;i++){
            coordinates[i] = createUniqueCoordinates(coordinates);
        }
    }

    public static void createHeroes(String[][] arena){
        int[] coordinates = new int[4];
        getCoordinates(coordinates);
        String[] symbols = {"#","$","%","@"};
        Util.randomizeElements(symbols);
        for(int i=0;i<4;i++){
            if(coordinates[i] == 1)
                arena[0][0] = symbols[i];
            if(coordinates[i] == 2)
                arena[17][0] = symbols[i];
            if(coordinates[i] == 3)
                arena[0][11] = symbols[i];
            if(coordinates[i] == 4)
                arena[17][11] = symbols[i];
        }
    }
}
