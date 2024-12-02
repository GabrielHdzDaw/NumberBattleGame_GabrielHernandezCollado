import java.util.Scanner;
import java.util.Random;

public class NumberBattleGame_GabrielHernandezCollado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random generator = new Random();

        byte playerHealth = 100;
        byte computerHealth = 100;
        byte lightAttackDamage = 10;
        byte mediumAttackDamage = 20;
        byte heavyAttackDamage = 40;
        boolean win = false;
        boolean defeat = false;

        byte playerChoice;

        String ascii = """
                 _   _                 _                 ____        _   _   _     \s
                | \\ | |_   _ _ __ ___ | |__   ___ _ __  | __ )  __ _| |_| |_| | ___\s
                |  \\| | | | | '_ ` _ \\| '_ \\ / _ \\ '__| |  _ \\ / _` | __| __| |/ _ \\
                | |\\  | |_| | | | | | | |_) |  __/ |    | |_) | (_| | |_| |_| |  __/
                |_|_\\_|\\__,_|_| |_| |_|_.__/ \\___|_|    |____/ \\__,_|\\__|\\__|_|\\___|
                """;
        System.out.println(ascii + "\nWelcome to Number Battle!\nYou and the computer start with 100 health points each." +
                "\nDefeat the computer by reducing its health to 0!\nOnly one shall remain standing!\nPrepare to fight!\n");

        while (!win && !defeat) {
            do {
                System.out.println("1. Light (80% success, 10 damage)");
                System.out.println("2. Medium (50% success, 20 damage)");
                System.out.println("3. Heavy (30% success, 40 damage)");
                System.out.print("Choose your attack: ");

                if (sc.hasNextByte()) {
                    playerChoice = sc.nextByte();
                    if (playerChoice < 1 || playerChoice > 3) {
                        System.out.println("You must enter 1, 2 or 3.");
                        playerChoice = -1;
                    }
                } else {
                    System.out.println("Invalid input. You need to enter a number.");
                    sc.next();
                    playerChoice = -1;
                }
            } while (playerChoice == -1);

            boolean success;
            switch (playerChoice) {
                case 1:
                    success = generator.nextInt(1, 101) >= 20;
                    if (success) {
                        computerHealth -= lightAttackDamage;
                        System.out.println("\nAttack successful! You dealt " + lightAttackDamage + " damage to the computer.\n");
                    } else {
                        System.out.println("\nAttack missed!\n");
                    }
                    break;
                case 2:
                    success = generator.nextInt(1, 101) >= 50;
                    if (success) {
                        computerHealth -= mediumAttackDamage;
                        System.out.println("\nAttack successful! You dealt " + mediumAttackDamage + " damage to the computer.\n");
                    } else {
                        System.out.println("\nAttack missed!\n");
                    }
                    break;
                case 3:
                    success = generator.nextInt(1, 101) >= 70;
                    if (success) {
                        computerHealth -= heavyAttackDamage;
                        System.out.println("\nAttack successful! You dealt " + heavyAttackDamage + " damage to the computer.\n");
                    } else {
                        System.out.println("\nAttack missed!\n");
                    }
                    break;
            }
            if (!(computerHealth <= 0)) {
                System.out.println("Computer's health: " + computerHealth + "\nYour health: " + playerHealth);
            }
            win = computerHealth <= 0;

            if (!win) {
                byte computerChoice = (byte) generator.nextInt(1, 4);
                switch (computerChoice) {
                    case 1:
                        System.out.println("\nThe computer attacks with a Light strike!");
                        success = generator.nextInt(100) >= 20;
                        if (success) {
                            playerHealth -= lightAttackDamage;
                            System.out.println("Attack successful! Computer deals " + lightAttackDamage + " damage to you.\n");
                        } else {
                            System.out.println("Attack missed!\n");
                        }
                        break;
                    case 2:
                        System.out.println("\nThe computer attacks with a Medium strike!");
                        success = generator.nextInt(100) >= 50;
                        if (success) {
                            playerHealth -= mediumAttackDamage;
                            System.out.println("Attack successful! Computer deals " + mediumAttackDamage + " damage to you.\n");
                        } else {
                            System.out.println("Attack missed!\n");
                        }
                        break;
                    case 3:
                        System.out.println("\nThe computer attacks with a Heavy strike!");
                        success = generator.nextInt(100) >= 70;
                        if (success) {
                            playerHealth -= heavyAttackDamage;
                            System.out.println("Attack successful! Computer deals " + heavyAttackDamage + " damage to you.\n");
                        } else {
                            System.out.println("Attack missed!\n");
                        }
                        break;
                }
                if (!(playerHealth <= 0)) {
                    System.out.println("Computer's health: " + computerHealth + "\nYour health: " + playerHealth + "\n");
                }

                defeat = playerHealth <= 0;
            }

        }
        playerHealth = playerHealth < 0 ? 0 : playerHealth;
        computerHealth = computerHealth < 0 ? 0 : computerHealth;
        System.out.println(win ? "Congratulations! You defeated the computer!\n" : "Game over! Computer wins!\n");
        System.out.println("Final health:\nPlayer: " + playerHealth + "\nComputer: " + computerHealth);
    }
}