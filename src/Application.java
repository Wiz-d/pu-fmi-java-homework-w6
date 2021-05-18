import java.util.Scanner;

public class Application {
    public static int counter=0;

    public static void gameLoop(String[][] arenaString, int[][] intArena) {
        Scanner scanner = new Scanner(System.in);
        Util.printStringBoard(arenaString);
        System.out.println("New round.");
        int answer=0;
        for(int i=0;i<4;i++) {
            switch (i) {
                case 1: {
                    System.out.println("Choose move(1) or magic(2) for syndicate");
                    answer = scanner.nextInt();
                    if(answer == 1)
                    SyndicateMovementAndAbilities.syndicateMovement(arenaString, counter, intArena);
                    if(answer == 2)
                    SyndicateMovementAndAbilities.syndicateSpell(intArena,arenaString);
                }
                case 2: {
                    System.out.println("Choose move(1) or magic(2) for gnome");
                    answer = scanner.nextInt();
                    if(answer == 1)
                    GnomeMovementAndAbilities.gnomeMovement(arenaString, intArena);
                    if(answer == 2)
                        GnomeMovementAndAbilities.gnomeSpell(intArena,arenaString);
                }
                case 3: {
                    System.out.println("Choose move(1) or magic(2) for shmandalf");
                    answer = scanner.nextInt();
                    if(answer == 1)
                    ShmandalfMovementAndAbilities.shmandalfMovement(arenaString, counter, intArena);
                    if(answer == 2) ShmandalfMovementAndAbilities.shmandalfSpell(intArena,arenaString);
                }
            }
        }
        counter++;
        if(counter == 15){
            System.out.println("You didn't reach the middle in 15 rounds game over!");
            System.exit(1);
        }
        if(Util.isGameWon(arenaString)){
            System.out.println("");
        }
        gameLoop(arenaString,intArena);
    }

    public static void main(String[] args) {
        int[][] arena = new int[BoardCreation.NUMBER_OF_COLS][BoardCreation.NUMBER_OF_ROWS];
        BoardCreation.fillWithRandoms(arena);
        String[][] arenaString = Util.convertArrayToString(arena);
        BoardCreation.createBuildings(arenaString);
        HeroCreation.createHeroes(arenaString);
        gameLoop(arenaString,arena);
    }


}
