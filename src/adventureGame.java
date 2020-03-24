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

    // Initializes the game, it's being called on from the main //
    public static void initGame() {
        Scanner startGamePrompt = new Scanner(System.in);
        System.out.println("Do you want to play? [yes/NO]");
        String startGame = startGamePrompt.next();
        boolean startTheGame = startGame.equals("yes");
        if (startTheGame) {
            System.out.println("The game has been started.");
            // If user agrees to play, get user name //
            getName();
        }
    }

    // Prompts user to put in their username //
    public static void getName() {
        Scanner getUserName = new Scanner(System.in);
        System.out.println("Enter user name.");
        String userNameInput = getUserName.next();
        // Once the user puts in their name, it goes to the game functionality //
            userStats(userNameInput);
    }


    // Game functionality, might have to refactor && rename //
    public static void userStats(String userNameInput) {
//        int health = (int) Math.floor((Math.random() * 5) + 15);  // To be used later, generates random health from 15 to 20.
//        int attack = (int) Math.floor((Math.random() * 3) + 1);   // To be used later, generates random attacks from 1 to 3.
        int health = 15;
        int attack = 3;
        int potionsLeft = 3;
        int monsterHealth = 20;
        int monsterAttack = 2;

     // Greets username by their input //
        System.out.printf("Welcome %s.\n", userNameInput);

     // Displays the hero stats dynamically. No need to change anything here //
        System.out.printf("Your hero stats | Health: %s \\ Attack: %s |\n", health, attack);

    // Displays the monster stats dynamically. No need to change anything here //
        System.out.printf("Enemy stats | Health: %s \\ Attack: %s |\n\n", monsterHealth, monsterAttack);

    // Prompt user what they want to do //
        System.out.println("What would you like to do??");
        System.out.println("1: Attack // 2. Drink Potion // 3. Run");

    // Scanner picks up the users decision //
        Scanner userDecision = new Scanner(System.in);
        String userDecided = userDecision.next();

    // Scanner logic on what action to take next
        boolean attackMonster = userDecided.equals("1");
        boolean drinkPotion = userDecided.equals("2");
        boolean runAway = userDecided.equals("3");
    // Secret input
        boolean throwPokeball = userDecided.equals("throwPokeball");

        // Scanner calls for user input
        if (attackMonster) {
            // Calls the attack method if user enters 1.
            attack();
        } else if (drinkPotion) {
            // Calls the drink potion method if the user enters 2.
            drinkPoition();
        } else if (runAway) {
            // Calls the run away method if the user enters 3.
            run();
        } else if (throwPokeball) {
            // Calls the throw pokeball method if the user enters throwPokeball
            throwPokeball();
        }


    }

    // Attack method logic
    public static void attack() {
        System.out.println("You have attacked!");
    }

    // Drink potion method logic
    public static void drinkPoition() {
        int potionAmount = (int) Math.floor((Math.random() * 4) + 1);
        System.out.printf("You have restored %s health.", potionAmount);
    }

    // Run away method logic
    public static void run() {
        int chanceToFlee = (int) Math.floor((Math.random() * 100) + 1); // Random number generated if user can flee or not.
        // Logic to see if the user can flee or not //
        if (chanceToFlee < 60) {
            System.out.println("Couldn't flee!");
        } else {
            System.out.println("...");
            System.out.println("Got away safely!");
        }
    }

    // ThrowPokeball logic
    public static void throwPokeball() {
        int chanceToCapture = (int) Math.floor((Math.random() * 100) + 1); // Random number generated if the user catches the monster or not
        // Logic to see if the user catches the monster or not
        if (chanceToCapture < 33) {
            System.out.println("You've caught the monster!");
        } else {
            System.out.println("Oh no, the monster broke free!");
        }
    }


















}
