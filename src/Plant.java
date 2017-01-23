/* [Plant.java]
 * A Small program for Plant settings and information
 * @author Jim & Matthew
 */

public class Plant extends Organism{

  //Declare class variables
  private int health;
  private long countTime;

  /**
   * extended constructor
   * sets the variables in origin class and sets others in this class
   * @param x,y
   * @return void
   */
  Plant(int x, int y,int health){
    super(x, y);
    MainGame.map[y][x] = MainGame.map[y][x]==2 ? 4:3;
    setCountTime(System.nanoTime());
  }

  /**
   * getHealth
   * gets the value of the plant's health
   * @return health
   */
  public int getHealth() {
    return health;
  }

  /**
   * updateHealth
   * adds health into the plant
   * @param addHealth
   */
  public void updateHealth(double addHealth){
    this.health+=addHealth;
  }

  /**
   * getCountTime()
   * returns a time counted
   * @return long
   */
  public long getCountTime() {
    return countTime;
  }

  /**
   *setCountTime
   * sets a time counted
   * @param countTime
   */
  public void setCountTime(long countTime) {
    this.countTime = countTime;
  }
}