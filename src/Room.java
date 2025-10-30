public class Room {
  private boolean fight;
  private String desc;


  public Room(boolean fight, String desc) {
    this.fight = fight;
    this.desc = desc;
  }
  public Room(){
    
  }

  public Room createRoom(Player player, boolean prevEmpty) {
    int num = Main.randomNum();

    if (prevEmpty || num % 2 == 0) {
      boolean fight = true;
      String desc = getRandomDescription();
      return new Room(fight, desc);
    } else {
      boolean fight = false;
      String desc = "is strange... is so quiet, looks like nobody is here, lets move on to the next room";
      return new Room(fight, desc);
    }
  }

  public boolean getFight() {
    return fight;
  }

  public String getDescription() {
    return desc;
  }

  public static String getRandomDescription() { //gives a random description of the room
    int num = Main.Dice();
    switch (num){
      case 1:
        return "looks like a strange jungle with some animals sounds";
      case 2:
        return "looks like a plains with a the sound of a waterfall somewhere";
      case 3:
        return "looks like heaven";
      case 4:
        return "looks like Nether";
      case 5:
        return "seems like a dark cave";
      default:
        return "seems like a common place with 4 walls made of a sturdy rock";
    }
  }
}
