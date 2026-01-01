public class Player extends Entity{ // player character
  private String username = " ";
  private String clase;
  private String claseDelPersonaje = " ";
  private int level;
  private int mana;
  private int maxMana;
  private int damage;
  private int health;
  private int maxHealth;
  private int xp;
  private int xpNextLevel = 10;
  private boolean isAlive = true;

  public Player(String _clase, String name) { // assigns a player class
    this.clase = _clase;
    if (clase.equals("t")) {
      this.username = name;
      this.level = 1;
      this.health = 25;
      this.maxHealth = 25;
      this.damage = 6;
      this.xp = 0;
      this.claseDelPersonaje = "Tank";
    }
    if (clase.equals("m")) {
      this.username = name;
      this.level = 1;
      this.health = 16;
      this.maxHealth = 16;
      this.damage = 8;
      this.xp = 0;
      this.claseDelPersonaje = "Mage";
      this.mana = 20;
      this.maxMana = 20;
    }
    if (clase.equals("w")) {
      this.username = name;
      this.level = 1;
      this.health = 17;
      this.maxHealth = 17;
      this.damage = 7;
      this.xp = 0;
      this.claseDelPersonaje = "Warrior";
    }
  }

  public void stats() { // gives mage stats
    if (claseDelPersonaje.equals("Mage")) {
      System.out.println("\b [Player Stats] \n");
      System.out.println("Name: " + this.username);
      System.out.println("Level: " + this.level);
      System.out.println("Hp: " + this.health + "/" + this.maxHealth);
      System.out.println("Mana: " + this.mana + "/" + this.maxMana);
      System.out.println("Xp: " + this.xp + "/" + this.xpNextLevel);
      System.out.println("Attack: " + this.damage);
    } else {
      // everyone else stats
      System.out.println("\b [Player Stats] \n");
      System.out.println("Name: " + this.username);
      System.out.println("Level: " + this.level);
      System.out.println("Hp: " + this.health + "/" + this.maxHealth);
      System.out.println("Xp: " + this.xp + "/" + this.xpNextLevel);
      System.out.println("Attack: " + this.damage);
    }
  }
  public void CheckNewLevel(){
    if(this.xp >= 10){
      this.level ++;
      this.xp -= 10;
      System.out.println("Congratulations!!! Level Up!!");
      this.health +=2;
      this.maxHealth += 2;
      this.damage +=2;
      this.mana += 2;
      this.maxMana +=2;
    } else {
      System.out.println((10 - xp) + " xp left to reach a new level!");
    }
  }

  public int getLevel() { // gives actual player level
    return this.level;
  }
  
  public int getDamage() { // gives the attack damage of the class
    return this.damage;
  }

  public int getHealth() { // gives the actual hp
    return this.health;
  }

  public void setHealth(int he) { // lower health when gets attack
    this.health = he;
  }

  public boolean getIsAlive() { // current life status
    return this.isAlive;
  }

  public void setIsAlive(boolean dead) { // change false if die
    this.isAlive = dead;
  }

  public String getClase() { // give class that player choose
    return this.claseDelPersonaje;
  }

  public int getMaxHealth() { // gives max health of that class
    return this.maxHealth;
  }
  
  public String getUsername() { // choosed player username
    return this.username;
  }
  public void setXp(int xp){
    this.xp += xp;
  }
  public int getXp(){
    return this.xp;
  }
  
}