package Weapons;
import java.util.Random;

public class Sword extends Weapon
{
	Random rand = new Random();
	public Sword(int damage, double accuracy) 
	{
		super(damage, .7);
	}

	@Override
	int attack() 
	{
		return rand.nextInt(13);
	}


}
