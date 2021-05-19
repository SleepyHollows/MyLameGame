package Weapons;

public class GreatSword extends Weapon
{

	public GreatSword(int damage, double accuracy) 
	{
		super(damage, accuracy);
	}

	@Override
	int attack() 
	{
		return 5;
	}

}
