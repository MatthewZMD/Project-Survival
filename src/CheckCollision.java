/* [CheckCollision.java]
 * A Small program for leaderboard information
 * @author Matthew & Jim
 */

public class CheckCollision implements Runnable{

  public static double collideTime, attackTime, walkerDiedTime, plantReceivedTime;

  public synchronized void run() {
    while(true){
      if(MainGame.map[(int) MainGame.player.getX()][(int) MainGame.player.getY()]!=0){
          for(int i = 0; i < MainGame.organisms.size(); i++){
              Organism o = MainGame.organisms.get(i);
              if (Math.floor(MainGame.player.getY()) >= o.getX()-0.5 && Math.floor(MainGame.player.getY()) <= o.getX()+0.5 && Math.floor(MainGame.player.getX()) >= o.getY()-0.5 && Math.floor(MainGame.player.getX()) <= o.getY()+0.5) {
                  if (MainGame.map[(int) o.getY()][(int) o.getX()]==2) {
                      if (MainGame.plantRemainTime > 0) {
                          System.out.print("You attacked the Walker at " + o.getX() + "," + o.getY() + "! ");
                          ((Walker) o).updateHealth(-100);
                          System.out.println("Walker remaining health: "+((Walker) o).getHealth());
                          attackTime=3;
                          if(((Walker) o).getHealth()<=0){
                              MainGame.map[(int) o.getY()][(int) o.getX()] = MainGame.map[(int) o.getY()][(int) o.getX()] == 2 ? 0:3;
                              MainGame.organisms.remove(i);
                              System.out.println("Walker died");
                              walkerDiedTime=3;
                          }
                      } else {
                          System.out.println("You collided with a Walker at " + o.getX() + "," + o.getY());
                          collideTime = 3;
                          MainGame.remainTime -= 30;
                      }
                      i = MainGame.organisms.size();
                  }
                  if (MainGame.map[(int) o.getY()][(int) o.getX()]==3) {
                      MainGame.remainTime += 100;
                      MainGame.plantRemainTime += 60;
                      System.out.println("You ate a plant at " + o.getX() + "," + o.getY()+" Player"+MainGame.player.getY()+" "+MainGame.player.getX());
                      MainGame.map[(int) o.getY()][(int) o.getX()] = MainGame.map[(int) o.getY()][(int) o.getX()] == 4 ? 2 : 0;
                      MainGame.organisms.remove(i);
                      plantReceivedTime=3;
                      i = MainGame.organisms.size();
                  }
              }else if(i==MainGame.organisms.size()-1&&MainGame.map[(int) MainGame.player.getX()][(int) MainGame.player.getY()]==3){
                  System.out.println("Fake Plant!");
                  MainGame.map[(int) MainGame.player.getX()][(int) MainGame.player.getY()] = 0;
              }
          }
      }
      for(int i = 0; i < MainGame.organisms.size(); i++){
        Organism o = MainGame.organisms.get(i);
        if (o!=null&&Math.floor(MainGame.player.getY()) >= o.getX()-0.5 && Math.floor(MainGame.player.getY()) <= o.getX()+0.5 && Math.floor(MainGame.player.getX()) >= o.getY()-0.5 && Math.floor(MainGame.player.getX()) <= o.getY()+0.5) {

          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
//                }catch(Exception e){
//                    System.out.println(o);
//                    System.out.println(o.getX());
//                    e.printStackTrace();
//                }

      }
      try{
        //Thread.sleep(10);
        Thread.yield();
      }catch(Exception e) {
        e.printStackTrace();
      }
    }

  }

}