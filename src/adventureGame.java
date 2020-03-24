import java.util.Scanner;
import java.util.Random;

public class adventureGame {
    public static void main(String[] args) {

        Scanner prompt = new Scanner(System.in);
        System.out.println("Do you want to play? [y/N]");
        String playGameResponse = prompt.nextLine();
        boolean userWantedToPlay = playGameResponse.equals("y");
        boolean userDidntWantedToPlay = playGameResponse.equals("N");


        if (userWantedToPlay) {
            System.out.println("Enter username:");
            String userName = prompt.nextLine();
            System.out.println("Welcome to the dungeon, " + userName + "!");
            playGame();
        } else if (userDidntWantedToPlay){
            System.out.println("#############    #           #    ##############");
            System.out.println("#             #    #       #      #");
            System.out.println("#             #      #   #        #");
            System.out.println("#             #       # #         #");
            System.out.println("##############         #          ##########");
            System.out.println("#             #        #          #");
            System.out.println("#             #        #          #");
            System.out.println("#             #        #          #");
            System.out.println("#############          #          ##############");




        }



    }

    public static void playGame() {
        // System Objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        // Game Variables
        String[] enemies = {"Orc Warrior", "Undead Rogue", "Troll Shaman", "Tauren Druid"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        // Player variables
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; // percentage

        boolean running = true;

        GAME:
        while (running) {
            System.out.println("---------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# A wild " + enemy + " appeared! #\n");

            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");

                String input = in.nextLine();
                if (input.equals("1")) {
                    int damageDealth = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealth;
                    health -= damageTaken;

                    System.out.println("\t> You strike the " + enemy + " for " + damageDealth + " damage." );
                    System.out.println("\t> " + enemy + " strikes you back for " + damageTaken + " damage.\n");


                    if (health < 1) {
                        System.out.println("\t> You are too weak to continue!");
                        break;
                    }
                } else if (input.equals("2")) {
                    if(numHealthPotions > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drink a health potion and recover " + healthPotionHealAmount + " health.");
                        System.out.println("\t> You now have " + health + " HP.");
                        System.out.println("\t> You have " + numHealthPotions + " health potions remaining.\n");
                    } else {
                        System.out.println("\t> You have no health potons left!");
                    }
                } else if (input.equals("3")) {
                    System.out.println("\t> You run away from " + enemy + "!");
                    continue GAME;
                } else {
                    System.out.println("\t> Invalid command.");
                }
            }

            if(health < 1) {
                System.out.println("You have fainted.");
                break;
            }

            System.out.println("---------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" # You have " + health + " HP left. # ");
            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println(" # The " + enemy + " dropped a health potion! # ");
                System.out.println(" # You now how " + numHealthPotions + " health potion(s). # ");
            }
            System.out.println("---------------------------------------------");
            System.out.println("What would you like to do?");
            System.out.println("1. Continue Fighting.");
            System.out.println("2. Exit dungeon.");

            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command!");
                input = in.nextLine();
            }

            if(input.equals("1")) {
                System.out.println("You continue on your adventure!");
            } else if (input.equals("2")) {
                System.out.println("You exit the dungeon.");
                break;
            }
        }
        System.out.println("##########################");
        System.out.println("# Thank you for playing! #");
        System.out.println("##########################");
    }
}
