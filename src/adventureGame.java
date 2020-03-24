import java.util.Scanner;

public class adventureGame {
    public static void main(String[] args) {


    initGame();



// TODO: Ask if the user is ready to start. If they type in "yes", start the game.

// TODO: Ask the user for their name. Store this as a variable to personalize the adventure.

// TODO: A classic RPG will have the hero going through different scenarios and battling their enemies.
    // Display enemy stats and hero stats. Properties and values can be assigned by you.
    // For example: Health, Attack Points, etc.

// TODO: Decide on what actions your hero can take.
    // Attack (decreases enemyHealth)
    // Drink potion (adds to heroHealth)
    // Run? (ends the game)

// TODO: Keep asking for user input until the enemyHealth reaches 0, then end the game.











    }


    public static void initGame() {
        Scanner startGamePrompt = new Scanner(System.in);
        System.out.println("Do you want to play? [yes/NO]");
        String startGame = startGamePrompt.next();
        boolean startTheGame = startGame.equals("yes");
        if (startTheGame) {
            System.out.println("The game has been started.");
            getName();
        }
    }

    public static void getName() {
        Scanner getUserName = new Scanner(System.in);
        System.out.println("Enter user name.");
        String userNameInput = getUserName.next();
            userStats(userNameInput);
    }


    public static void userStats(String userNameInput) {
//        int health = (int) Math.floor((Math.random() * 5) + 15);
//        int attack = (int) Math.floor((Math.random() * 3) + 1);
        int health = 15;
        int attack = 3;
        int potionsLeft = 3;
        int monsterHealth = 20;
        int monsterAttack = 2;

        System.out.printf("Welcome %s.\n", userNameInput);
        System.out.printf("Your hero stats | Health: %s \\ Attack: %s |\n", health, attack);
        System.out.printf("Enemy stats | Health: %s \\ Attack: %s |\n\n", monsterHealth, monsterAttack);
        System.out.println("What would you like to do??");
        System.out.println("1: Attack // 2. Drink Potion // 3. Run");
        Scanner userDecision = new Scanner(System.in);
        String userDecided = userDecision.next();
        boolean attackMonster = userDecided.equals("1");
        boolean drinkPotion = userDecided.equals("2");
        boolean runAway = userDecided.equals("3");
        boolean throwPokeball = userDecided.equals("throwPokeball");

        if (attackMonster) {
            attack();
        } else if (drinkPotion) {
            drinkPoition();
        } else if (runAway) {
            run();
        } else if (throwPokeball) {
            throwPokeball();
        }


    }


    public static void attack() {
        System.out.println("You have attacked!");
    }
    public static void drinkPoition() {
        int potionAmount = (int) Math.floor((Math.random() * 4) + 1);
        System.out.printf("You have restored %s health.", potionAmount);
    }

    public static void run() {
        int chanceToFlee = (int) Math.floor((Math.random() * 100) + 1);
        if (chanceToFlee < 60) {
            System.out.println("Couldn't flee!");
        } else {
            System.out.println("...");
            System.out.println("Got away safely!");
        }
    }

    public static void throwPokeball() {
        int chanceToCapture = (int) Math.floor((Math.random() * 100) + 1);
        if (chanceToCapture < 33) {
            System.out.println("You've caught the monster!");
        } else {
            System.out.println("Oh no, the monster broke free!");
        }
    }


















}
