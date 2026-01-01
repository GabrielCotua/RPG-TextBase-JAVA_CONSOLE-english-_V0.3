public class Enemy extends Entity{ // creates a enemy depending on player level
  private int health;
  private int maxHealth;
  private int damage;
  private int level;
  private String name;
  private int xp;
  private boolean isAlive = true;
  private String[] enemyNames = { null, "Slime", "Monster", "Worewolf", "Skeleton", "Ghost", "Zombie" };
  // list to get different enemy names every game

  public Enemy(Player player) { // creates an enemy on base of player level
    this.name = enemyNames[Main.Dice()];
    this.level = player.getLevel();
    if (level == 1) {
      this.damage = 5;
      this.maxHealth = 20;
      this.health = 20;
      this.xp = 5;
    } else if (level == 2) {
      this.damage = 7;
      this.maxHealth = 21;
      this.health = 21;
      this.xp = 7;
    } else if (level == 3) {
      this.damage = 10;
      this.maxHealth = 22;
      this.health = 22;
      this.xp = 10;
    } else {

      this.damage = player.getDamage() - 3;
      this.maxHealth = player.getHealth() + 3;
      this.health = player.getHealth() + 3;
      this.xp = player.getDamage();
    }
  }
  public void Stats(){
      System.out.println("\n\n [Enemy Stats] \n");
      System.out.println("Name: " + this.name);
      System.out.println("Level: " + this.level);
      System.out.println("Hp: " + this.health + "/" + this.maxHealth);
      System.out.println("Attack: " + this.damage);
  }

  public int getHealth() { // gives enemy actual hp
    return this.health;
  }

  public void setHealth(int he) { // set hp when gets hurt
    this.health = he;
  }

  public int getDamage() { // gives attack damage stat
    return this.damage;
  }

  public boolean getIsAlive() { // check life status
    return this.isAlive;
  }

  public void setIsAlive(boolean dead) { // set it to dead
    this.isAlive = dead;
  }

  public String getName() { // get random name from array
    return this.name;
  }

  public int getMaxHealth() { // max health of enemy depending on your level
    return this.maxHealth;
  }
  public int getXp(){ // gives the amount of xp given to player
    return this.xp;
  }
}