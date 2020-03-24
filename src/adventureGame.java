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


//choose if they want to play: y/n
//choose y
//ask name
//welcome username
//stats of you and monster
        //hero stats: health 15 attack 3
        //monster stats: health 20 attack 2
//what would you like to do? 1.attack 2.drink potion 3.run away (secret option: throwPokeball)
    //1. attack
        //function decrement monsterHealth in loop by random number (between 1-5)
        //hero loses attack point
        //monster attacks---->lose attack point and hero looses health in loop by random number (between 1-5)
    //2. drink potion
        //Health goes up by random number (between 1-5) within loop
        //Potion level goes down by one.
        //monster attacks---->lose attack point and hero looses health in loop by random number (between 1-5)
    //3. run away
        //random number is less than 60 couldn't flee and monster attacks---->lose attack point and hero looses health in loop by random number (between 1-5)
        //random number is more than 60 you got away---->game ends
    //4. throwPokeball
        //random number < 33 you catch the monster, and you win---->game ends
        //random number > 33 monster gets away and attacks--->lose attack point and hero looses health in loop by random number (between 1-5)
//Show stats
//Loop back to: What would you like to do?
//Hero reaches 0 health == "You lose"
//Hero
//Monster reaches 0 health == "You win"


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
        // Greets username by their input //
        System.out.printf("Welcome %s.\n", userNameInput);
        // Once the user puts in their name, it goes to the game functionality //
            userStats();
    }

    // Game functionality, might have to refactor && rename //
    public static void userStats() {
//        int health = (int) Math.floor((Math.random() * 5) + 15);  // To be used later, generates random health from 15 to 20.
//        int attack = (int) Math.floor((Math.random() * 3) + 1);   // To be used later, generates random attacks from 1 to 3.
        int health = 15;
        int attack = 3;
        int potionsLeft = 3;
        int monsterHealth = 20;
        int monsterAttack = 2;



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
            monsterHealth -= 3;
            attack();
        } else if (drinkPotion) {
            // Calls the drink potion method if the user enters 2.
            drinkPotion();
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
        System.out.println("You have attacked for 3 damage!");

        monsterAttack();
    }

    // Drink potion method logic
    public static void drinkPotion() {
        int potionAmount = (int) Math.floor((Math.random() * 4) + 1);
        System.out.printf("You have restored %s health.", potionAmount);
        monsterAttack();
    }

    // Run away method logic
    public static void run() {
        int chanceToFlee = (int) Math.floor((Math.random() * 100) + 1); // Random number generated if user can flee or not.
        // Logic to see if the user can flee or not //
        if (chanceToFlee < 60) {
            System.out.println("Couldn't flee!");
            monsterAttack();
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
            monsterAttack();
        }
    }

    public static void monsterAttack(){
        System.out.println("Monster attacks you for 2 damage");
        userStats();
    }

    //loop of attack

    //loop of potion

    //loop of run away

    //loop of poke ball




}
