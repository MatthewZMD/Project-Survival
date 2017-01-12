/* [Walker.java]
 * A Small program for antagonist settings and information
 * @author Jim
 */

public class Walker extends Creature{
	
	//Declare Variables
	private int gender;
	
	Walker(double x, double y, double dirX, double dirY, double health, int gender) {
		super(x, y, dirX, dirY, health);
		setGender(gender);
	}
	
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	public int getGender(){
		return this.gender;
	}

	public boolean compareCoordinates(Walker one, Walker two){
		if(one.getGender() == two.getGender() && one.getX() == two.getX() && two.getY() == one.getY()){
			return true;
		}else{
			return false;
		}
	}
	
	public void makeBabies(){
		int x,y;
		do{
			x = (int) (Math.random()*Main.map[0].length);
			y = (int) (Math.random()*Main.map.length);
		}while(Main.map[x][y]!=0);
		
		int gender = (int) (Math.random()*2+1);
		new Walker(x, y, -1, 0, 3, gender);
	}
	
}