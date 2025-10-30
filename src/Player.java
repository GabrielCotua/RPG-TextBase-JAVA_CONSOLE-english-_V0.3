public class Player { // player character
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
      username = name;
      level = 1;
      health = 25;
      maxHealth = 25;
      damage = 6;
      xp = 0;
      claseDelPersonaje = "Tank";
    }
    if (clase.equals("m")) {
      username = name;
      level = 1;
      health = 16;
      maxHealth = 16;
      damage = 8;
      xp = 0;
      claseDelPersonaje = "Mage";
      mana = 20;
      maxMana = 20;
    }
    if (clase.equals("w")) {
      username = name;
      level = 1;
      health = 17;
      maxHealth = 17;
      damage = 7;
      xp = 0;
      claseDelPersonaje = "Warrior";
    }
  }

  public void stats() { // gives mage stats
    if (claseDelPersonaje.equals("Mage")) {
      System.out.println("\b [Player Stats] \n");
      System.out.println("Name: " + username);
      System.out.println("Level: " + level);
      System.out.println("Hp: " + health + "/" + maxHealth);
      System.out.println("Mana: " + mana + "/" + maxMana);
      System.out.println("Xp: " + xp + "/" + xpNextLevel);
      System.out.println("Attack: " + damage);
    } else {
      // everyone else stats
      System.out.println("\b [Player Stats] \n");
      System.out.println("Name: " + username);
      System.out.println("Level: " + level);
      System.out.println("Hp: " + health + "/" + maxHealth);
      System.out.println("Xp: " + xp + "/" + xpNextLevel);
      System.out.println("Attack: " + damage);
    }
  }
  public void CheckNewLevel(){
    if(xp >= 10){
      level ++;
      xp -= 10;
      System.out.println("Congratulations!!! Level Up!!");
      health +=2;
      maxHealth += 2;
      damage +=2;
      mana += 2;
      maxMana +=2;
    } else {
      System.out.println((10 - xp) + " xp left to reach a new level!");
    }
  }

  public int getLevel() { // gives actual player level
    return level;
  }
  
  public int getDamage() { // gives the attack damage of the class
    return damage;
  }

  public int getHealth() { // gives the actual hp
    return health;
  }

  public void setHealth(int he) { // lower health when gets attack
    health = he;
  }

  public boolean getIsAlive() { // current life status
    return isAlive;
  }

  public void setIsAlive(boolean dead) { // change false if die
    isAlive = dead;
  }

  public String getClase() { // give class that player choose
    return claseDelPersonaje;
  }

  public int getMaxHealth() { // gives max health of that class
    return maxHealth;
  }
  
  public String getUsername() { // choosed player username
    return username;
  }
  public void setXp(int xp){
    this.xp += xp;
  }
  public int getXp(){
    return xp;
  }
  
}