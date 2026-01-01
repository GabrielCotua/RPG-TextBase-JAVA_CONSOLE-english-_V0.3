import java.util.Scanner;

public class Battle {
  private Scanner decision = new Scanner(System.in);
  private String action;
  private Player player;
  private Enemy enemy;

  public Battle(Player player, Enemy enemy) { // constructor needed to start the battle system
    this.player = player;
    this.enemy = enemy;
  }

  public void BattleCamp() { // static method where fight system is build
 
    boolean move = false;
    System.out.println("\nOh no! A feared " + enemy.getName() + " challenged you to a fight!\n");
    while (player.getIsAlive() && enemy.getIsAlive()) { // if both still alive
      System.out.println("----------------------------------");
      System.out.println("   What are you going to do?");
      System.out.println("[a] Attack | [h] Heal | [s] Stats");
      System.out.println("----------------------------------");
      action = decision.nextLine(); // player action
      if (action.equalsIgnoreCase("a")) {
        plaAttack();
        move = true;
      }
      if (action.equalsIgnoreCase("s")) { // if the player wants to see the stats, would not resive any hit from enemy
        move = false;
        player.stats();
        enemy.Stats();
        System.out.println("\n-----------------------");
        System.out.println("What are you going to do?");
        System.out.println("  [a] Attack | [h] Heal");
        System.out.println("-------------------------");
        action = decision.nextLine();
        if (action.equalsIgnoreCase("a")) {
          plaAttack(); 
          move = true;
        } if (action.equalsIgnoreCase("h")) {
          plaHeal(); 
          move = false;
        }
      } if (action.equalsIgnoreCase("h")) {
        plaHeal(); 
        move = false;
      }
      if(move){
      System.out.println("--------------------");
      System.out.println("Now is enemy turn...");
      System.out.println("--------------------");
      if (Main.Dice() >= 4) {
        eneAttack(); 
      } else {
        eneHeal(); 
        }
      }
    }
  }

  public void plaHeal() { // system to heal the player, and do not over heal
    int num = Main.Dice();
    System.out.println("++++++++++++++++++++++++++++++++++++++++++");
    if (player.getHealth() < player.getMaxHealth() && player.getHealth() - player.getMaxHealth() <= num) {
      System.out.println("\n" + player.getUsername() + " got healed " + num + " hp!\n");
      player.setHealth(player.getHealth() + num);
    } else {
      System.out.println("\nYou already have enough hp, so " + player.getUsername() + " decides that is not worth it");
    }
    System.out.println("++++++++++++++++++++++++++++++++++++++++++\n");
  }

  public void plaAttack() { // player has 20% of failing an attack
    System.out.println("++++++++++++++++++++++++++++++++++++++++++");
    if (Main.Dice() > 2) {
      AtaqueEfectivo(); 
      enemy.setHealth(enemy.getHealth() - player.getDamage());
      if (enemy.getHealth() <= 0) {
        enemy.setIsAlive(false);
        System.out.println("\nYou defeated " + enemy.getName() + "!\n");
      } else {
        System.out.println("\nThe enemy " + enemy.getName() + " got " + player.getDamage() + " points of damage!\n");
        System.out.println("\nEnemy hp left: " + enemy.getHealth() + "/" + enemy.getMaxHealth() + "\n");
      }
    } else {
      AtaqueFailed(); 
    }
    System.out.println("++++++++++++++++++++++++++++++++++++++++++\n");
  }

  public void eneHeal() { // enemy can heal but cannot go over max heal
    int num = Main.Dice();
    System.out.println("******************************************");
    if (enemy.getHealth() < enemy.getMaxHealth() && enemy.getHealth() - enemy.getMaxHealth() <= num) {
      System.out.println("\n¡The " + enemy.getName() + " got healed " + num + " hp!\n");
      enemy.setHealth(enemy.getHealth() + num);
      System.out.println("\nEnemy hp: " + enemy.getHealth() + "/" + enemy.getMaxHealth() + "\n");
    } else {
      System.out.println("\nThe enemy " + enemy.getName() + " already have enough hp, so, decides to save it for later!\n");
    }
    System.out.println("******************************************\n");
  }

  public void eneAttack() {
    System.out.println("******************************************");
    if (Main.Dice() > 3) { // enemy has about 30% of failling the attack
      AtaqueEfectivo(); 
      player.setHealth(player.getHealth() - enemy.getDamage());
      if (player.getHealth() <= 0) {
        player.setIsAlive(false);
        System.out.println("\n" + enemy.getName() + " defeated you!");
      } else {
        System.out.println("\n" + enemy.getName() + " deals you " + enemy.getDamage() + " damage point!\n");
        System.out.println("\nPlayer hp: " + player.getHealth() + "/" + player.getMaxHealth() + "\n");
      }
    } else {
      AtaqueFailed(); 
    }
    System.out.println("******************************************\n");
  }

  public void AtaqueEfectivo() { // gives a random mesage when the player or enemy acerts an attack
    int num = Main.Dice();
    switch (num) {
      case 1:
        System.out.println("\nWhat a Hit!\n");
        break;
      case 2:
        System.out.println("\nAn awesome hit!\n");
        break;
      case 3:
        System.out.println("\nYou got this!\n");
        break;
      case 4:
        System.out.println("\nShow who leads!\n");
        break;
      case 5:
        System.out.println("\nWow, what a strength!\n");
        break;
      case 6:
        System.out.println("\nLook at that damage!\n");
        break;
      default: // if for any reason, Dice() gives a number bigger or smaller than 6, it will
               // result in the following message.
        System.out.println("\nThat had to hurt!\n");
        break;
    }
  }

  public void AtaqueFailed() { // show a random message to player or enemy when fail an attack
    int num = Main.Dice();
    switch (num) {
      case 1:
        System.out.println("\nWas so close! (Missed)\n");
        break; // stop the sequence
      case 2:
        System.out.println("\nAttack failed! (Missed)\n");
        break;
      case 3:
        System.out.println("\nWhere are you looking at? (Missed)\n");
        break;
      case 4:
        System.out.println("\nEnemy is at the other way! (Missed)\n");
        break;
      case 5:
        System.out.println("\nTry it again! (Missed)\n");
        break;
      case 6:
        System.out.println("\n What are you doing? the enemy is just infront of you! (Missed)\n");
        break;
      default: // if for any reason, Dice() gives a number bigger or smaller than 6, it will result in the following message.
        System.out.println("\nWhat are you waiting for? (Missed)\n");
        break;
    }
  }
}