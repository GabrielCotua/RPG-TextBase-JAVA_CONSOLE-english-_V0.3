
/**
*Date: 05/21/2023
*Author: Gabriel Cotua
*School: EPHS
*/
import java.util.*;

public class Main { // everything executes here
  private static Scanner scan = new Scanner(System.in);
  private static String clase = "";
  private static String username = "";

  public static int Dice() { // gives a random number from 1 to 6 including 6
    int random;
    random = (int) (Math.random() * 6 + 1);
    return random;
  }

  public static int randomNum() { // gives a random number from 5 to 15 including it
    int random;
    random = (int) (Math.random() * 10 + 5);
    return random;
  }

  public static void main(String[] args) { // main method
    int num = 1;
    while (num > 0) { // while player do not selec class, this will remain
      System.out.println("Hello player, What is your name?: ");
      username = scan.nextLine(); // user input 
      System.out.println("\nHi! " + username + " please choose your class");
      System.out.println("[t] for Tank");
      System.out.println("[m] for Magician");
      System.out.println("[w] for Warrior");
      clase = scan.nextLine(); // user input
      while (!clase.equalsIgnoreCase("t") && !clase.equalsIgnoreCase("m") && !clase.equalsIgnoreCase("w")) {
        System.out.println("Please choose a class");
        clase = scan.nextLine(); // user input
      }
      num--; // finishes loop
    }
    if (clase.equalsIgnoreCase("t")) { // assign the tank class and starts an encounter
      GameStart();
    }
    if (clase.equalsIgnoreCase("m")) { // assign the Mage class and starts an encounter
      GameStart();
    }
    if (clase.equalsIgnoreCase("w")) { // assign the Warrior class and start an encounter
      GameStart();
    }
  }

  public static void GameStart() { // starts the game environment
    Player player = new Player(clase, username);
    Enemy enemy;
    Room[] dungeon = new Room[randomNum()]; // create a dungeon with random length
    boolean prevEmpty = true;
    for (int i = 0; i < dungeon.length; i++) { // fill in the room 
      dungeon[i] = new Room(); // fill the array with room instances 
      dungeon[i] = dungeon[i].createRoom(player, prevEmpty); // adjust those room instances
      prevEmpty = !dungeon[i].getFight(); // checks if last was empty, to force a fight at the next one
    }

    System.out.println("\n\n\n\nYou do not remember nothing about how you arrived here but suddendly you hear a voice inside your head.");
    System.out.println("\n-Wake up!-");
    System.out.println("-Wake up " + username + " we have to get out of here as soon as possible-");
    System.out.println("-Come on! lets move on! there is an exit at the end of this Dungeon.-\n\n");
    System.out.println("Without understanding anything that is happening, you decide to go and enter to the next room that ");

  for (int index = 0; index < dungeon.length && player.getIsAlive(); index++) {
      if (dungeon[index].getFight()) { // if the room contains a fight
        enemy = new Enemy(player);
        System.out.print(dungeon[index].getDescription());
        
        Battle battle = new Battle(player, enemy); // creates an battle instance
        battle.BattleCamp(); // to later use it and start the battle camp
        System.out.println("You earned " + enemy.getXp() + " xp from " + enemy.getName());
        player.setXp(enemy.getXp());
        player.CheckNewLevel();
        System.out.println("\n\n\n");
        System.out.println("You are at the room " + (index+1) + " out of " + (dungeon.length) + " You got this!\n\n");
        
      } else { //otherwise
        System.out.println("\n\n\n"+dungeon[index].getDescription()+"\n\n\n");
        System.out.println("Last room was alone so you moved on. And now you are at room " + (index+1) + " out of " + (dungeon.length) + " You got this!\n\n");
      }
    }
    
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
    System.out.println("//////////////////////");
    System.out.println("   CONGRATULATIONS !  ");
    System.out.println("     YOU DID IT !     ");
    System.out.println("//////////////////////");
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
  }
}