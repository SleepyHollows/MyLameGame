package Weapons;

public class Bow extends Weapon
{
	public Bow(int damage, double accuracy) 
	{
		super(damage, accuracy);
	}

	@Override
	int attack() 
	{
			return (int) ((Math.random()*10)+5);
	}

}
